package io.iskaldvind.poplibs

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observable.fromIterable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter
import java.util.*


class UsersPresenter(private val usersRepo: GithubUsersRepo, private val router: Router, private val screens: IScreens) : MvpPresenter<UsersView>() {


    class UserListPresenter : IUserListPresenter {

        val users = mutableListOf<GithubUser>()

        override var itemClickListener: ((UserItemView) -> Unit)? = null

        override fun getCount(): Int = users.size

        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }
    }


    val usersListPresenter = UserListPresenter()

    private val disposables = CompositeDisposable()


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        usersListPresenter.itemClickListener = {
            router.navigateTo( screens.user(it.getLogin()) )
        }
    }


    private fun loadData() {
        disposables.add(
            usersRepo
                .getUsers()
                .subscribe(::handleUsers, viewState::showError)
        )
    }


    private fun handleUsers(users: List<GithubUser>) {
        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }


    fun backPressed(): Boolean {
        router.exit()
        return true
    }


    override fun destroyView(view: UsersView?) {
        super.destroyView(view)
        disposables.dispose()
    }
}