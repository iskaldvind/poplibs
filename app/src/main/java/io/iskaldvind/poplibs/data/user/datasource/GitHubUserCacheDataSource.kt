package io.iskaldvind.poplibs.data.user.datasource

import io.iskaldvind.poplibs.data.user.GitHubUser
import io.reactivex.Single

interface GitHubUserCacheDataSource : GitHubUserDataSource {

    fun retain(gitHubUsers: List<GitHubUser>): Single<List<GitHubUser>>

    fun retain(gitHubUser: GitHubUser): Single<GitHubUser>
}