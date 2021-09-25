package io.iskaldvind.poplibs

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter


class UserPresenter(private val userModel: GithubUser, private val router: Router) : MvpPresenter<UserView>() {


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setLogin(userModel.login)
    }


    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}