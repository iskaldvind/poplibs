package io.iskaldvind.poplibs.presentation.user

import io.iskaldvind.poplibs.presentation.ScreenView
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType


@StateStrategyType(SingleStateStrategy::class)
interface UserView : ScreenView {

    fun setLogin(text: String)

}