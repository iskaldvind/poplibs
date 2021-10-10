package io.iskaldvind.poplibs.data.user.datasource

import io.iskaldvind.poplibs.data.storage.GitHubStorageFactory

object GithubUserCacheDataSourceFactory {

    fun create(): GithubUserCacheDataSource =
        GithubUserCacheDataSourceImpl(
            GitHubStorageFactory.create()
        )
}