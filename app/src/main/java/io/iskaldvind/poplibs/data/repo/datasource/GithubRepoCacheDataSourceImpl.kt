package io.iskaldvind.poplibs.data.repo.datasource

import io.iskaldvind.poplibs.data.repo.GithubRepo
import io.iskaldvind.poplibs.data.user.GithubUser
import io.reactivex.Single
import java.lang.RuntimeException

class GithubRepoCacheDataSourceImpl: GithubRepoCacheDataSource {

    private val cache: MutableList<GithubRepo> = mutableListOf()

    override fun retain(githubRepos: List<GithubRepo>): Single<List<GithubRepo>> =
        Single.fromCallable {
            cache.clear()
            cache.addAll(githubRepos)
            cache
        }

    override fun retain(githubRepo: GithubRepo): Single<GithubRepo> =
        Single.fromCallable {
            cache.indexOf(githubRepo)
                .takeIf { it != -1 }
                ?.let { cache.removeAt(it); cache.add(githubRepo) }
                ?: cache.add(githubRepo)
            githubRepo
        }

    override fun fetchRepos(url: String): Single<List<GithubRepo>> =
        Single.just(cache)

    override fun fetchRepo(url: String): Single<GithubRepo> =
        Single.defer {
            cache
                .firstOrNull { it.url.equals(url, true) }
                ?.let { Single.just(it) }
                ?: Single.error(RuntimeException("User not found"))
        }
}