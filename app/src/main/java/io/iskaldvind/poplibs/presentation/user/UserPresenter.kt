package io.iskaldvind.poplibs.presentation.user

import io.iskaldvind.poplibs.data.user.IGithubUserRepository
import io.reactivex.disposables.CompositeDisposable
import moxy.MvpPresenter
import io.iskaldvind.poplibs.presentation.GithubUserViewModel.Mapper


class UserPresenter(
    private val login: String,
    private val userRepository: IGithubUserRepository,
    private val schedulers: io.iskaldvind.poplibs.scheduler.Schedulers
) : MvpPresenter<UserView>() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        disposables.add(
            userRepository
                .getUserByLogin(login)
                .map(Mapper::map)
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    viewState::showUser,
                    viewState::showError
                )
        )
    }
}