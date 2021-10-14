package io.iskaldvind.poplibs.data.repo

import io.iskaldvind.poplibs.data.repo.datasource.GithubRepoCacheDataSource
import io.iskaldvind.poplibs.data.repo.datasource.GithubRepoDataSource
import io.reactivex.Maybe
import io.reactivex.Observable


class GithubRepoRepositoryImpl(
    private val cloud: GithubRepoDataSource,
    private val cache: GithubRepoCacheDataSource
) : IGithubRepoRepository {

    override fun getRepos(url: String) : Observable<List<GithubRepo>> =
        Observable.merge(
            cache.fetchRepos(url).toObservable(),
            cloud.fetchRepos(url).flatMap(cache::retain).toObservable()
        )


    override fun getRepo(url: String): Maybe<GithubRepo> =
        cache.fetchRepo(url)
            .switchIfEmpty(
                cloud.fetchRepo(url)
            )
}