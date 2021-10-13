package io.iskaldvind.poplibs.data.user

object GithubUserRepositoryFactory {

    fun create(): IGithubUserRepository = GithubUserRepositoryImpl()
}