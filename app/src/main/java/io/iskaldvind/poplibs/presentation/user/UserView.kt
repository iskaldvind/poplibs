package io.iskaldvind.poplibs.presentation.user

import io.iskaldvind.poplibs.presentation.GithubUserViewModel
import io.iskaldvind.poplibs.presentation.ScreenView
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType
import moxy.viewstate.strategy.alias.SingleState


@StateStrategyType(SingleStateStrategy::class)
interface UserView : ScreenView {

    @SingleState
    fun showUser(user: GithubUserViewModel)
}