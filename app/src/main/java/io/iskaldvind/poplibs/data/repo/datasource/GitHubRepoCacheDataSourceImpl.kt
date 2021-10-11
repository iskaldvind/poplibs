package io.iskaldvind.poplibs.data.repo.datasource

import io.iskaldvind.poplibs.data.repo.GithubRepo
import io.iskaldvind.poplibs.data.storage.GitHubStorage
import io.reactivex.Maybe
import io.reactivex.Single
import javax.inject.Inject

class GitHubRepoCacheDataSourceImpl
@Inject constructor (
    private val gitHubStorage: GitHubStorage
): GitHubRepoCacheDataSource {

    override fun retain(githubRepos: List<GithubRepo>): Single<List<GithubRepo>> {
        return gitHubStorage
            .getGitHubRepoDao()
            .retain(githubRepos)
            .andThen(
                gitHubStorage
                    .getGitHubRepoDao()
                    .getReposByHome(githubRepos[0].owner.home)
                    .firstOrError()
            )
    }

    override fun retain(githubRepo: GithubRepo): Single<GithubRepo> =
        Single.fromCallable { githubRepo }

    override fun fetchRepos(url: String): Single<List<GithubRepo>> =
        gitHubStorage
            .getGitHubRepoDao()
            .getReposByHome(url)
            .firstOrError()

    override fun fetchRepo(url: String): Maybe<GithubRepo> =
        gitHubStorage
            .getGitHubRepoDao()
            .fetchRepoByUrl(url)
            .toMaybe()
}