package io.iskaldvind.poplibs.presentation

import io.iskaldvind.poplibs.data.repo.GithubRepo


data class GithubRepoViewModel (
    val url: String,
    val title: String,
    val forks: Int
) {
    object Mapper {

        fun map(repo: GithubRepo) = GithubRepoViewModel(repo.url, repo.name, repo.forks)
    }
}