package io.iskaldvind.poplibs.presentation.repo

import io.iskaldvind.poplibs.presentation.GitHubRepoViewModel
import io.iskaldvind.poplibs.presentation.ScreenView
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType
import moxy.viewstate.strategy.alias.SingleState

@StateStrategyType(SingleStateStrategy::class)
interface RepoView : ScreenView {

    @SingleState
    fun showRepo(repo: GitHubRepoViewModel)
}