package io.iskaldvind.poplibs.presentation

import io.iskaldvind.poplibs.data.repo.GithubRepo


data class GitHubRepoViewModel (
    val url: String,
    val title: String,
    val forks: Int
) {
    object Mapper {

        fun map(repo: GithubRepo) = GitHubRepoViewModel(repo.url, repo.name, repo.forks)
    }
}