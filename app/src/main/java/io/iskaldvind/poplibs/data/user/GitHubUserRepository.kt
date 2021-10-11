package io.iskaldvind.poplibs.data.user

import io.reactivex.Maybe
import io.reactivex.Observable

interface GitHubUserRepository {

    fun getUsers(): Observable<List<GitHubUser>>

    fun getUserByLogin(userId: String): Maybe<GitHubUser>
}