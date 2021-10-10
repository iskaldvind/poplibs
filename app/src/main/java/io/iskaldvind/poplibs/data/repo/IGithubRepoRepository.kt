package io.iskaldvind.poplibs.data.repo

import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single


interface IGithubRepoRepository {

    fun getRepos(url: String): Observable<List<GithubRepo>>

    fun getRepo(url: String): Maybe<GithubRepo>
}