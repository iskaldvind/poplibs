package io.iskaldvind.poplibs.data.user.datasource

import io.iskaldvind.poplibs.data.storage.GitHubStorage
import io.iskaldvind.poplibs.data.user.GitHubUser
import io.reactivex.Maybe
import io.reactivex.Single
import javax.inject.Inject

class GitHubUserCacheDataSourceImpl
@Inject constructor(
    private val gitHubStorage: GitHubStorage
): GitHubUserCacheDataSource {

    override fun retain(gitHubUsers: List<GitHubUser>): Single<List<GitHubUser>> =
        gitHubStorage
            .getGitHubUserDao()
            .retain(gitHubUsers)
            .andThen(
                gitHubStorage
                    .getGitHubUserDao()
                    .getGitHubUsers()
                    .firstOrError()
            )

    override fun retain(gitHubUser: GitHubUser): Single<GitHubUser> =
       Single.fromCallable { gitHubUser }

    override fun fetchUsers(): Single<List<GitHubUser>> =
        gitHubStorage
            .getGitHubUserDao()
            .getGitHubUsers()
            .firstOrError()

    override fun fetchUserByLogin(login: String): Maybe<GitHubUser> =
        gitHubStorage
            .getGitHubUserDao()
            .fetchUserByLogin(login)
            .toMaybe()
}