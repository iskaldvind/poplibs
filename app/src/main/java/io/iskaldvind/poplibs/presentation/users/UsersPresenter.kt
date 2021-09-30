package io.iskaldvind.poplibs.presentation.users

import com.github.terrakok.cicerone.Router
import io.iskaldvind.poplibs.data.user.IGithubUserRepository
import io.iskaldvind.poplibs.presentation.GithubUserViewModel
import io.iskaldvind.poplibs.presentation.user.UserScreen
import io.iskaldvind.poplibs.presentation.GithubUserViewModel.Mapper
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter


class UsersPresenter(private val usersRepo: IGithubUserRepository, private val router: Router) : MvpPresenter<UsersView>() {


    private val disposables = CompositeDisposable()


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()
    }


    private fun loadData() {
        disposables.add(
            usersRepo
                .getUsers()
                .map { users -> users.map(Mapper::map) }
                .subscribe(viewState::showUsers, viewState::showError)
        )
    }


    fun displayUser(user: GithubUserViewModel) {
        router.navigateTo(UserScreen(user.login))
    }


    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }
}