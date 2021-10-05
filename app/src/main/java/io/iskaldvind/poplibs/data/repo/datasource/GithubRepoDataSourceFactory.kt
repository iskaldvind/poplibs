package io.iskaldvind.poplibs.data.repo.datasource

import io.iskaldvind.poplibs.data.api.GitHubApiFactory

object GithubRepoDataSourceFactory {

    fun create(): GithubRepoDataSource =
        GithubRepoDataSourceImpl(GitHubApiFactory.create())
}