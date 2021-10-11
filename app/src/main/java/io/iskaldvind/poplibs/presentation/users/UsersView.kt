package io.iskaldvind.poplibs.presentation.users

import io.iskaldvind.poplibs.presentation.GitHubUserViewModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

interface UsersView : MvpView {

    @SingleState
    fun showUsers(users: List<GitHubUserViewModel>)

    @SingleState
    fun showError(err: Throwable)
}