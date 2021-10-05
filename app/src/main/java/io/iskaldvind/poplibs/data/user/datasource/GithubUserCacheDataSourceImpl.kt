package io.iskaldvind.poplibs.data.user.datasource

import io.iskaldvind.poplibs.data.user.GithubUser
import io.reactivex.Single
import java.lang.RuntimeException

class GithubUserCacheDataSourceImpl: GithubUserCacheDataSource {

    private val cache: MutableList<GithubUser> = mutableListOf()

    override fun retain(githubUsers: List<GithubUser>): Single<List<GithubUser>> =
        Single.fromCallable {
            cache.clear()
            cache.addAll(githubUsers)
            cache
        }

    override fun retain(githubUser: GithubUser): Single<GithubUser> =
        Single.fromCallable {
            cache.indexOf(githubUser)
                .takeIf { it != -1 }
                ?.let { cache.removeAt(it); cache.add(githubUser) }
                ?: cache.add(githubUser)
            githubUser
        }

    override fun fetchUsers(): Single<List<GithubUser>> =
        Single.just(cache)

    override fun fetchUserByLogin(login: String): Single<GithubUser> =
        Single.defer {
            cache
                .firstOrNull { it.login.equals(login, true) }
                ?.let { Single.just(it) }
                ?: Single.error(RuntimeException("User not found"))
        }
}