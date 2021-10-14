package io.iskaldvind.poplibs.data.repo

import io.iskaldvind.poplibs.data.repo.datasource.GithubRepoCacheDataSourceFactory
import io.iskaldvind.poplibs.data.repo.datasource.GithubRepoDataSourceFactory


object GithubRepoRepositoryFactory {

    private val githubRepoRepository: IGithubRepoRepository by lazy {
        GithubRepoRepositoryImpl(
            GithubRepoDataSourceFactory.create(),
            GithubRepoCacheDataSourceFactory.create()
        )
    }

    fun create(): IGithubRepoRepository = githubRepoRepository
}