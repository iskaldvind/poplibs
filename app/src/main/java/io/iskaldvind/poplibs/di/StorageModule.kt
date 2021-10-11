package io.iskaldvind.poplibs.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import io.iskaldvind.poplibs.data.storage.GitHubStorage
import javax.inject.Singleton

@Module
class StorageModule {

    @Singleton
    @Provides
    fun provideGitHubStorage(context: Context): GitHubStorage =
        Room
            .databaseBuilder(context, GitHubStorage::class.java, "storage")
            .build()
}