package io.iskaldvind.poplibs.presentation.user

import com.github.terrakok.cicerone.Router
import io.iskaldvind.poplibs.data.user.IGithubUserRepository
import io.reactivex.disposables.CompositeDisposable
import moxy.MvpPresenter
import io.iskaldvind.poplibs.presentation.GithubUserViewModel.Mapper
import io.iskaldvind.poplibs.presentation.repos.ReposScreen


class UserPresenter(
    private val login: String,
    private val userRepository: IGithubUserRepository,
    private val schedulers: io.iskaldvind.poplibs.scheduler.Schedulers,
    private val router: Router
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

    fun onUserClick() {
        disposables.add(
            userRepository
                .getUserByLogin(login)
                .map { it.repos_url }
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    this::showRepos,
                    viewState::showError
                )
        )
    }


    private fun showRepos(url: String) {
        router.navigateTo(ReposScreen(url))
    }


    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }
}