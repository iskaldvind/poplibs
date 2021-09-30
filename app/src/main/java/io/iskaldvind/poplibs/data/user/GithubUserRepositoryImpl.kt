package io.iskaldvind.poplibs.data.user

import io.reactivex.rxjava3.core.Observable

class GithubUserRepositoryImpl : IGithubUserRepository {

    private val users = listOf(
        GithubUser("login1"),
        GithubUser("login2"),
        GithubUser("login3"),
        GithubUser("login4"),
        GithubUser("login5")
    )

    override fun getUsers() : Observable<List<GithubUser>> =
        Observable.just(users)
}