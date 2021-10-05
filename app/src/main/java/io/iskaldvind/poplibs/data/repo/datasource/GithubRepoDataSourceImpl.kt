package io.iskaldvind.poplibs.data.repo.datasource

import io.iskaldvind.poplibs.data.api.GitHubApi
import io.iskaldvind.poplibs.data.repo.GithubRepo
import io.reactivex.Single

class GithubRepoDataSourceImpl(
    private val githubApi: GitHubApi
): GithubRepoDataSource {

    override fun fetchRepos(url: String): Single<List<GithubRepo>> =
        githubApi
            .fetchUserRepos(url)
            .map { it.sortedBy(GithubRepo::name) }

    override fun fetchRepo(url: String): Single<GithubRepo> =
        githubApi
            .fetchUserRepo(url)
}