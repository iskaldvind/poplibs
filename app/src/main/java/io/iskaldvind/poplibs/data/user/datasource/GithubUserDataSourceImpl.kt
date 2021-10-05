package io.iskaldvind.poplibs.data.user.datasource

import io.iskaldvind.poplibs.data.api.GitHubApi
import io.iskaldvind.poplibs.data.user.GithubUser
import io.reactivex.Single

class GithubUserDataSourceImpl(
    private val githubApi: GitHubApi
): GithubUserDataSource {

    override fun fetchUsers(): Single<List<GithubUser>> =
        githubApi
            .fetchUsers()
            .map { it.sortedBy(GithubUser::login) }

    override fun fetchUserByLogin(login: String): Single<GithubUser> =
        githubApi
            .fetchUserByLogin(login)
}