package io.iskaldvind.poplibs.data.user.datasource

import io.iskaldvind.poplibs.data.user.GithubUser
import io.reactivex.Maybe
import io.reactivex.Single

interface GithubUserCacheDataSource : GithubUserDataSource {

    fun retain(githubUsers: List<GithubUser>): Single<List<GithubUser>>

    fun retain(githubUser: GithubUser): Single<GithubUser>
}