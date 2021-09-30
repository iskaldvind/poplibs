package io.iskaldvind.poplibs.presentation.user

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter


class UserPresenter(private val login: String, private val router: Router) : MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setLogin(login)
    }
}