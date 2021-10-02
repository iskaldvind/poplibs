package io.iskaldvind.poplibs.data.user

import io.reactivex.Observable
import io.reactivex.Single
import java.lang.RuntimeException


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


    override fun getUserByLogin(userId: String): Single<GithubUser> =
        users.firstOrNull { user -> user.login.contentEquals(userId, ignoreCase = true) }
            ?.let { user -> Single.just(user) }
            ?: Single.error(RuntimeException("User not found"))
}