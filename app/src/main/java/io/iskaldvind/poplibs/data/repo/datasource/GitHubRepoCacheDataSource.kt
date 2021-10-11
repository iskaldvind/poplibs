package io.iskaldvind.poplibs.data.repo.datasource

import io.iskaldvind.poplibs.data.repo.GithubRepo
import io.reactivex.Single

interface GitHubRepoCacheDataSource : GitHubRepoDataSource {

    fun retain(githubRepos: List<GithubRepo>): Single<List<GithubRepo>>

    fun retain(githubRepo: GithubRepo): Single<GithubRepo>
}