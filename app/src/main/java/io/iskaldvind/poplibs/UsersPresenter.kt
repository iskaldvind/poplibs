package io.iskaldvind.poplibs

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter


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
            usersRepo.getUsers()
                .firstOrNull {
                    it.login == itemView.getLogin()
                }?.let {
                    router.navigateTo( screens.user(it) )
                }
        }
    }


    private fun loadData() {
        val users = usersRepo.getUsers()
        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }


    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}