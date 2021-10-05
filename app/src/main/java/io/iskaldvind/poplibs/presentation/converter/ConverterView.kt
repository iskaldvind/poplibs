package io.iskaldvind.poplibs.presentation.converter

import android.net.Uri
import io.iskaldvind.poplibs.presentation.ScreenView
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType
import moxy.viewstate.strategy.alias.SingleState

@StateStrategyType(SingleStateStrategy::class)
interface ConverterView : ScreenView {

    @SingleState
    fun showButton()

    @SingleState
    fun showLoading()

    @SingleState
    fun showPath()

    @SingleState
    fun showSuccess()

    @SingleState
    fun hideAll()
}