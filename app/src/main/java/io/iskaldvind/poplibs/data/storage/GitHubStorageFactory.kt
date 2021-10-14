package io.iskaldvind.poplibs.data.storage

import androidx.room.Room
import io.iskaldvind.poplibs.App.ContextHolder.context

object GitHubStorageFactory {

    private val inMemoryGitHubStorage: GitHubStorage by lazy {
        Room.inMemoryDatabaseBuilder(context, GitHubStorage::class.java)
            .fallbackToDestructiveMigration()
            .build()
    }

    private val databaseGitHubStorage: GitHubStorage by lazy {
        Room.databaseBuilder(context, GitHubStorage::class.java, "github.db")
            .build()
    }

    fun create(): GitHubStorage = databaseGitHubStorage
}