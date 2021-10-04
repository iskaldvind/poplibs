package io.iskaldvind.poplibs.data.user

import io.reactivex.Maybe
import io.reactivex.Single


interface IGithubUserRepository {

    fun getUsers(): Single<List<GithubUser>>

    fun getUserByLogin(userId: String): Maybe<GithubUser>
}