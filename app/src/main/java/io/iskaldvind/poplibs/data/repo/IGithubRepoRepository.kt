package io.iskaldvind.poplibs.data.repo

import io.reactivex.Observable
import io.reactivex.Single


interface IGithubRepoRepository {

    fun getRepos(url: String): Single<List<GithubRepo>>

    fun getRepo(url: String): Observable<GithubRepo>
}