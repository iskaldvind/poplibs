package io.iskaldvind.poplibs.di

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.iskaldvind.poplibs.data.repo.GitHubRepoRepository
import io.iskaldvind.poplibs.data.repo.GitHubRepoRepositoryImpl
import io.iskaldvind.poplibs.data.repo.datasource.GitHubRepoCacheDataSource
import io.iskaldvind.poplibs.data.repo.datasource.GitHubRepoCacheDataSourceImpl
import io.iskaldvind.poplibs.data.repo.datasource.GitHubRepoDataSource
import io.iskaldvind.poplibs.data.repo.datasource.GitHubRepoDataSourceImpl
import io.iskaldvind.poplibs.presentation.repo.RepoFragment
import io.iskaldvind.poplibs.presentation.repos.ReposFragment
import javax.inject.Singleton

@Module
interface RepoModule {

    @ContributesAndroidInjector
    fun bindRepoFragment(): RepoFragment

    @ContributesAndroidInjector
    fun bindReposFragment(): ReposFragment

    @Singleton
    @Binds
    fun bindGitHubRepoRepository(gitHubRepoRepositoryImpl: GitHubRepoRepositoryImpl) : GitHubRepoRepository

    @Singleton
    @Binds
    fun bindGitHubRepoDataSource(gitHubRepoDataSourceImpl: GitHubRepoDataSourceImpl) : GitHubRepoDataSource

    @Singleton
    @Binds
    fun bindGitHubRepoCacheDataSource(gitHubRepoCacheDataSourceImpl: GitHubRepoCacheDataSourceImpl) : GitHubRepoCacheDataSource

}