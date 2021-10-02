package io.iskaldvind.poplibs.presentation.user

import io.iskaldvind.poplibs.data.user.IGithubUserRepository
import io.reactivex.disposables.CompositeDisposable
import moxy.MvpPresenter
import io.iskaldvind.poplibs.presentation.GithubUserViewModel.Mapper


class UserPresenter(
    private val login: String,
    private val userRepository: IGithubUserRepository
) : MvpPresenter<UserView>() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        disposables.add(
            userRepository
                .getUserByLogin(login)
                .map(Mapper::map)
                .subscribe(
                    viewState::showUser,
                    viewState::showError
                )
        )
    }
}