package io.iskaldvind.poplibs

import io.reactivex.rxjava3.core.Single

class GithubUsersRepo : IGithubUserRepo {
    private val users = listOf(
        GithubUser("login1"),
        GithubUser("login2"),
        GithubUser("login3"),
        GithubUser("login4"),
        GithubUser("login5")
    )

    override fun getUsers() : Single<List<GithubUser>> =
        Single.just(users)
}