package io.iskaldvind.poplibs.presentation.repos

import io.iskaldvind.poplibs.presentation.GitHubRepoViewModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

interface ReposView : MvpView {

    @SingleState
    fun showRepos(repos: List<GitHubRepoViewModel>)

    @SingleState
    fun showError(err: Throwable)
}