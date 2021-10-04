package io.iskaldvind.poplibs.data.user

import io.iskaldvind.poplibs.data.user.datasource.GithubUserDataSourceFactory

object GithubUserRepositoryFactory {

    fun create(): IGithubUserRepository =
        GithubUserRepositoryImpl(GithubUserDataSourceFactory.create())
}