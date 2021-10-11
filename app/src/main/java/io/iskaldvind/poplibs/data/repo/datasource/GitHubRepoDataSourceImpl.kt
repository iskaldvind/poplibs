package io.iskaldvind.poplibs.data.repo.datasource

import io.iskaldvind.poplibs.data.api.GitHubApi
import io.iskaldvind.poplibs.data.repo.GithubRepo
import io.reactivex.Maybe
import io.reactivex.Single
import javax.inject.Inject

class GitHubRepoDataSourceImpl
@Inject constructor(
    private val githubApi: GitHubApi
): GitHubRepoDataSource {

    override fun fetchRepos(url: String): Single<List<GithubRepo>> =
        githubApi
            .fetchUserRepos(url)
            .map { it.sortedBy(GithubRepo::name) }

    override fun fetchRepo(url: String): Maybe<GithubRepo> =
        githubApi
            .fetchUserRepo(url)
            .toMaybe()
}