package io.iskaldvind.poplibs.di

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.iskaldvind.poplibs.data.user.GitHubUserRepositoryImpl
import io.iskaldvind.poplibs.data.user.GitHubUserRepository
import io.iskaldvind.poplibs.data.user.datasource.GitHubUserCacheDataSource
import io.iskaldvind.poplibs.data.user.datasource.GitHubUserCacheDataSourceImpl
import io.iskaldvind.poplibs.data.user.datasource.GitHubUserDataSource
import io.iskaldvind.poplibs.data.user.datasource.GitHubUserDataSourceImpl
import io.iskaldvind.poplibs.presentation.user.UserFragment
import io.iskaldvind.poplibs.presentation.users.UsersFragment
import javax.inject.Singleton

@Module
interface UserModule {

    @ContributesAndroidInjector
    fun bindUserFragment(): UserFragment

    @ContributesAndroidInjector
    fun bindUsersFragment(): UsersFragment

    @Singleton
    @Binds
    fun bindGitHubUserRepository(gitHubUserRepositoryImpl: GitHubUserRepositoryImpl) : GitHubUserRepository

    @Singleton
    @Binds
    fun bindGitHubUserDataSource(gitHubUserDataSourceImpl: GitHubUserDataSourceImpl) : GitHubUserDataSource

    @Singleton
    @Binds
    fun bindGitHubUserCacheDataSource(gitHubUserCacheDataSourceImpl: GitHubUserCacheDataSourceImpl) : GitHubUserCacheDataSource

}