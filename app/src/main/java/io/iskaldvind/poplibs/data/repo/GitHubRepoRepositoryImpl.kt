package io.iskaldvind.poplibs.data.repo

import io.iskaldvind.poplibs.data.repo.datasource.GitHubRepoCacheDataSource
import io.iskaldvind.poplibs.data.repo.datasource.GitHubRepoDataSource
import io.reactivex.Maybe
import io.reactivex.Observable
import javax.inject.Inject


class GitHubRepoRepositoryImpl
@Inject constructor (
    private val cloud: GitHubRepoDataSource,
    private val cache: GitHubRepoCacheDataSource
) : GitHubRepoRepository {

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