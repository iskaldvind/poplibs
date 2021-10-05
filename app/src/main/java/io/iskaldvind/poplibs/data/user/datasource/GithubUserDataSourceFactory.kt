package io.iskaldvind.poplibs.data.user.datasource

import io.iskaldvind.poplibs.data.api.GitHubApiFactory

object GithubUserDataSourceFactory {

    fun create(): GithubUserDataSource =
        GithubUserDataSourceImpl(GitHubApiFactory.create())
}