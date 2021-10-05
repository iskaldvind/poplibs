package io.iskaldvind.poplibs.data.user

import io.iskaldvind.poplibs.data.user.datasource.GithubUserCacheDataSource
import io.iskaldvind.poplibs.data.user.datasource.GithubUserDataSource
import io.reactivex.Observable
import io.reactivex.Single


class GithubUserRepositoryImpl(
    private val githubUserDataSource: GithubUserDataSource,
    private val githubUserCacheDataSource: GithubUserCacheDataSource
) : IGithubUserRepository {

    override fun getUsers() : Single<List<GithubUser>> =
        githubUserDataSource
            .fetchUsers()

    override fun getUserByLogin(userId: String): Observable<GithubUser> =
        Observable.concat(
            githubUserCacheDataSource
                .fetchUserByLogin(userId)
                .toObservable()
                .onErrorResumeNext(Observable.empty()),
            githubUserDataSource
                .fetchUserByLogin(userId)
                .flatMap(githubUserCacheDataSource::retain)
                .toObservable()
        )
}