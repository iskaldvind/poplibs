package io.iskaldvind.poplibs.data.storage

import androidx.room.*
import io.iskaldvind.poplibs.data.user.GitHubUser
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface GitHubUserDao {

    @Query("SELECT * FROM users")
    fun getGitHubUsers(): Observable<List<GitHubUser>>

    @Query("SELECT * FROM users WHERE login LIKE :login LIMIT 1")
    fun fetchUserByLogin(login: String): Single<GitHubUser>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun retain(users: List<GitHubUser>): Completable

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun retain(user: GitHubUser): Completable
}