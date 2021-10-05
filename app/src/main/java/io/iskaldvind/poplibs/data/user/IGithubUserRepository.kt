package io.iskaldvind.poplibs.data.user

import io.reactivex.Observable
import io.reactivex.Single


interface IGithubUserRepository {

    fun getUsers(): Single<List<GithubUser>>

    fun getUserByLogin(userId: String): Observable<GithubUser>
}