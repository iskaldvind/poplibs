package io.iskaldvind.poplibs.data.user

import io.reactivex.rxjava3.core.Observable


interface IGithubUserRepository {

    fun getUsers(): Observable<List<GithubUser>>
}