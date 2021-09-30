package io.iskaldvind.poplibs.presentation.users

import io.iskaldvind.poplibs.presentation.GithubUserViewModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

interface UsersView : MvpView {

    @SingleState
    fun showUsers(users: List<GithubUserViewModel>)

    @SingleState
    fun showError(err: Throwable)
}