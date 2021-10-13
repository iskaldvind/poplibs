package io.iskaldvind.poplibs.presentation.user

import io.iskaldvind.poplibs.presentation.GithubUserViewModel
import io.iskaldvind.poplibs.presentation.ScreenView
import moxy.MvpAppCompatActivity
import moxy.MvpView
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType
import moxy.viewstate.strategy.alias.SingleState


@StateStrategyType(SingleStateStrategy::class)
interface UserView : MvpView {

    @SingleState
    fun showUser(user: GithubUserViewModel)

    @SingleState
    fun showError(err: Throwable)
}