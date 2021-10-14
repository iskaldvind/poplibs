package io.iskaldvind.poplibs.data.user

import io.iskaldvind.poplibs.data.user.datasource.GithubUserCacheDataSource
import io.iskaldvind.poplibs.data.user.datasource.GithubUserDataSource
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single


class GithubUserRepositoryImpl(
    private val cloud: GithubUserDataSource,
    private val cache: GithubUserCacheDataSource
) : IGithubUserRepository {

    override fun getUsers() : Observable<List<GithubUser>> =
       Observable.merge(
           cache.fetchUsers().toObservable(),
           cloud.fetchUsers().flatMap(cache::retain).toObservable()
       )

    override fun getUserByLogin(userId: String): Maybe<GithubUser> =
        cache.fetchUserByLogin(userId)
            .switchIfEmpty(
                cloud.fetchUserByLogin(userId)
            )
}