package io.iskaldvind.poplibs.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import io.iskaldvind.poplibs.data.repo.GithubRepo
import io.iskaldvind.poplibs.data.user.GitHubUser

@Database(exportSchema = false, entities = [GitHubUser::class, GithubRepo::class], version = 2)
@TypeConverters(TypeConverter::class)
abstract class GitHubStorage : RoomDatabase() {

    abstract fun getGitHubUserDao(): GitHubUserDao

    abstract fun getGitHubRepoDao(): GitHubRepoDao
}