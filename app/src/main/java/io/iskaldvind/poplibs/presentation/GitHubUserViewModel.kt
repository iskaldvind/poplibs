package io.iskaldvind.poplibs.presentation

import io.iskaldvind.poplibs.data.user.GitHubUser

data class GitHubUserViewModel (
    val login: String,
    val avatar: String
) {
    object Mapper {

        fun map(user: GitHubUser) = GitHubUserViewModel(
            user.login,
            user.avatar
        )
    }
}