package io.iskaldvind.poplibs.data.user.datasource

import io.iskaldvind.poplibs.data.api.GitHubApiFactory

object GithubUserCacheDataSourceFactory {

    fun create(): GithubUserCacheDataSource =
        GithubUserCacheDataSourceImpl()
}