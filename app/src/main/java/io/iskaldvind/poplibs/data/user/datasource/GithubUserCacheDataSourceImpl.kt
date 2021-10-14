package io.iskaldvind.poplibs.data.user.datasource

import io.iskaldvind.poplibs.data.storage.GitHubStorage
import io.iskaldvind.poplibs.data.user.GithubUser
import io.reactivex.Maybe
import io.reactivex.Single

class GithubUserCacheDataSourceImpl(
    private val gitHubStorage: GitHubStorage
): GithubUserCacheDataSource {

    override fun retain(githubUsers: List<GithubUser>): Single<List<GithubUser>> =
        gitHubStorage
            .getGitHubUserDao()
            .retain(githubUsers)
            .andThen(
                gitHubStorage
                    .getGitHubUserDao()
                    .getGitHubUsers()
                    .firstOrError()
            )

    override fun retain(githubUser: GithubUser): Single<GithubUser> =
       Single.fromCallable { githubUser }

    override fun fetchUsers(): Single<List<GithubUser>> =
        gitHubStorage
            .getGitHubUserDao()
            .getGitHubUsers()
            .firstOrError()

    override fun fetchUserByLogin(login: String): Maybe<GithubUser> =
        gitHubStorage
            .getGitHubUserDao()
            .fetchUserByLogin(login)
            .toMaybe()
}