package io.iskaldvind.poplibs.data.repo.datasource

import io.iskaldvind.poplibs.data.api.GitHubApiFactory
import io.iskaldvind.poplibs.data.storage.GitHubStorageFactory

object GithubRepoCacheDataSourceFactory {

    fun create(): GithubRepoCacheDataSource =
        GithubRepoCacheDataSourceImpl(
            GitHubStorageFactory.create()
        )
}