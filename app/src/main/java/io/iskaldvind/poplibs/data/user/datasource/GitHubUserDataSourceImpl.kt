package io.iskaldvind.poplibs.data.user.datasource

import io.iskaldvind.poplibs.data.api.GitHubApi
import io.iskaldvind.poplibs.data.user.GitHubUser
import io.reactivex.Maybe
import io.reactivex.Single
import javax.inject.Inject

class GitHubUserDataSourceImpl
@Inject constructor(
    private val githubApi: GitHubApi
): GitHubUserDataSource {

    override fun fetchUsers(): Single<List<GitHubUser>> =
        githubApi
            .fetchUsers()
            .map { it.sortedBy(GitHubUser::login) }

    override fun fetchUserByLogin(login: String): Maybe<GitHubUser> =
        githubApi
            .fetchUserByLogin(login)
            .toMaybe()
}