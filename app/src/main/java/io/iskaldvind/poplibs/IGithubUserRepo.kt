package io.iskaldvind.poplibs

import io.reactivex.rxjava3.core.Single

interface IGithubUserRepo {

    fun getUsers(): Single<List<GithubUser>>
}