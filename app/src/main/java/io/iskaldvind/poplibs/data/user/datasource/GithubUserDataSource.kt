package io.iskaldvind.poplibs.data.user.datasource

import io.iskaldvind.poplibs.data.user.GithubUser
import io.reactivex.Single

interface GithubUserDataSource {

    fun fetchUsers(): Single<List<GithubUser>>
}