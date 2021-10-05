package io.iskaldvind.poplibs.data.repo

import android.util.Log
import io.iskaldvind.poplibs.data.repo.datasource.GithubRepoCacheDataSource
import io.iskaldvind.poplibs.data.repo.datasource.GithubRepoDataSource
import io.reactivex.Observable
import io.reactivex.Single


class GithubRepoRepositoryImpl(
    private val githubRepoDataSource: GithubRepoDataSource,
    private val githubRepoCacheDataSource: GithubRepoCacheDataSource
) : IGithubRepoRepository {

    override fun getRepos(url: String) : Single<List<GithubRepo>> =
        githubRepoDataSource
            .fetchRepos(url)

    override fun getRepo(url: String): Observable<GithubRepo> {
        Log.d("!!! !!!", ">> $url")
        return Observable.concat(
            githubRepoCacheDataSource
                .fetchRepo(url)
                .toObservable()
                .onErrorResumeNext(Observable.empty()),
            githubRepoDataSource
                .fetchRepo(url)
                .flatMap(githubRepoCacheDataSource::retain)
                .toObservable()
        )
    }
}