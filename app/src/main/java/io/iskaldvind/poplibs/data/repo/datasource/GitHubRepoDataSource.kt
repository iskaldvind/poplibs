package io.iskaldvind.poplibs.data.repo.datasource

import io.iskaldvind.poplibs.data.repo.GithubRepo
import io.reactivex.Maybe
import io.reactivex.Single

interface GitHubRepoDataSource {

    fun fetchRepos(url: String): Single<List<GithubRepo>>

    fun fetchRepo(url: String): Maybe<GithubRepo>
}