package io.iskaldvind.poplibs.data.user

import io.reactivex.Maybe
import io.reactivex.Observable

interface IGithubUserRepository {

    fun getUsers(): Observable<List<GithubUser>>

    fun getUserByLogin(userId: String): Maybe<GithubUser>
}