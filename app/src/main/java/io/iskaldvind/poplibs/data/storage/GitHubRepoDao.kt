package io.iskaldvind.poplibs.data.storage

import androidx.room.*
import io.iskaldvind.poplibs.data.repo.GithubRepo
import io.iskaldvind.poplibs.data.repo.Owner
import io.iskaldvind.poplibs.data.user.GithubUser
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface GitHubRepoDao {

    @Query("SELECT * FROM repos WHERE owner LIKE :home")
    fun getReposByHome(home: String): Observable<List<GithubRepo>>

    @Query("SELECT * FROM repos WHERE url LIKE :url LIMIT 1")
    fun fetchRepoByUrl(url: String): Single<GithubRepo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun retain(repos: List<GithubRepo>): Completable

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun retain(repo: GithubRepo): Completable
}