package io.iskaldvind.poplibs.data.storage

import androidx.room.*
import io.iskaldvind.poplibs.data.user.GithubUser
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface GitHubUserDao {

    @Query("SELECT * FROM users")
    fun getGitHubUsers(): Observable<List<GithubUser>>

    @Query("SELECT * FROM users WHERE login LIKE :login LIMIT 1")
    fun fetchUserByLogin(login: String): Single<GithubUser>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun retain(users: List<GithubUser>): Completable

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun retain(user: GithubUser): Completable
}