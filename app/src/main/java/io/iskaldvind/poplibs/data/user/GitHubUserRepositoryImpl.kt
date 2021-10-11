package io.iskaldvind.poplibs.data.user

import io.iskaldvind.poplibs.data.user.datasource.GitHubUserCacheDataSource
import io.iskaldvind.poplibs.data.user.datasource.GitHubUserDataSource
import io.reactivex.Maybe
import io.reactivex.Observable
import javax.inject.Inject


class GitHubUserRepositoryImpl
@Inject constructor(
    private val cloud: GitHubUserDataSource,
    private val cache: GitHubUserCacheDataSource
) : GitHubUserRepository {

    override fun getUsers() : Observable<List<GitHubUser>> =
       Observable.merge(
           cache.fetchUsers().toObservable(),
           cloud.fetchUsers().flatMap(cache::retain).toObservable()
       )

    override fun getUserByLogin(userId: String): Maybe<GitHubUser> =
        cache.fetchUserByLogin(userId)
            .switchIfEmpty(
                cloud.fetchUserByLogin(userId)
            )
}