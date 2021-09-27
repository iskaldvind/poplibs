package io.iskaldvind.poplibs

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observable.fromIterable
import io.reactivex.rxjava3.core.Single
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


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        usersListPresenter.itemClickListener = { itemView ->
            usersRepo
                .getUsers()
                .toObservable()
                .concatMap { users -> fromIterable(users as Iterable<GithubUser>) }
                .filter { user -> user.login == itemView.getLogin() }
                .subscribe { router.navigateTo( screens.user(it) )}
        }
    }


    private fun loadData() {
        usersRepo
            .getUsers()
            .subscribe(::handleUsers)
    }


    private fun handleUsers(users: List<GithubUser>) {
        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }


    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}