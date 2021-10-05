package io.iskaldvind.poplibs.data.repo.datasource

import io.iskaldvind.poplibs.data.api.GitHubApiFactory

object GithubRepoCacheDataSourceFactory {

    fun create(): GithubRepoCacheDataSource =
        GithubRepoCacheDataSourceImpl()
}