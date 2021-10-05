package io.iskaldvind.poplibs.data.repo.datasource

import io.iskaldvind.poplibs.data.repo.GithubRepo
import io.reactivex.Single

interface GithubRepoDataSource {

    fun fetchRepos(url: String): Single<List<GithubRepo>>

    fun fetchRepo(url: String): Single<GithubRepo>
}