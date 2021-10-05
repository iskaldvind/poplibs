package io.iskaldvind.poplibs.presentation.repos

import io.iskaldvind.poplibs.presentation.GithubRepoViewModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

interface ReposView : MvpView {

    @SingleState
    fun showRepos(repos: List<GithubRepoViewModel>)

    @SingleState
    fun showError(err: Throwable)
}