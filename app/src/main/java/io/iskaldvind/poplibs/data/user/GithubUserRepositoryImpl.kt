package io.iskaldvind.poplibs.data.user

import io.iskaldvind.poplibs.data.user.datasource.GithubUserDataSource
import io.reactivex.Maybe
import io.reactivex.Single


class GithubUserRepositoryImpl(
    private val githubUserDataSource: GithubUserDataSource
) : IGithubUserRepository {

    override fun getUsers() : Single<List<GithubUser>> =
        githubUserDataSource
            .fetchUsers()

    override fun getUserByLogin(userId: String): Maybe<GithubUser> =
        githubUserDataSource
            .fetchUsers()
            .flatMapMaybe { users ->
                users
                    .firstOrNull { user -> user.login.contentEquals(userId, ignoreCase = true) }
                    ?.let { user -> Maybe.just(user) }
                    ?: Maybe.empty()
            }
}