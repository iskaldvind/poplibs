package io.iskaldvind.poplibs.data.user

import io.iskaldvind.poplibs.data.user.datasource.GithubUserCacheDataSourceFactory
import io.iskaldvind.poplibs.data.user.datasource.GithubUserDataSourceFactory

object GithubUserRepositoryFactory {

    private val githubUserRepository: IGithubUserRepository by lazy {
        GithubUserRepositoryImpl(
            GithubUserDataSourceFactory.create(),
            GithubUserCacheDataSourceFactory.create()
        )
    }

    fun create(): IGithubUserRepository = githubUserRepository
}