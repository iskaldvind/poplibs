package io.iskaldvind.poplibs.data.user.datasource

import io.iskaldvind.poplibs.data.user.GitHubUser
import io.reactivex.Maybe
import io.reactivex.Single

interface GitHubUserDataSource {

    fun fetchUsers(): Single<List<GitHubUser>>

    fun fetchUserByLogin(login: String): Maybe<GitHubUser>
}