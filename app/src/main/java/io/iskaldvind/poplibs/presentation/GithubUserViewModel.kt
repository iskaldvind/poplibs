package io.iskaldvind.poplibs.presentation

import io.iskaldvind.poplibs.data.user.GithubUser

data class GithubUserViewModel (
    val login: String,
    val avatar: String
) {
    object Mapper {

        fun map(user: GithubUser) = GithubUserViewModel(
            user.login,
            user.avatar
        )
    }
}