package io.iskaldvind.poplibs.presentation.users

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import io.iskaldvind.poplibs.App.Navigation.router
import io.iskaldvind.poplibs.data.user.GithubUserRepositoryFactory
import io.iskaldvind.poplibs.databinding.FragmentUsersBinding
import io.iskaldvind.poplibs.presentation.GithubUserViewModel
import io.iskaldvind.poplibs.presentation.users.adapter.UsersAdapter
import io.iskaldvind.poplibs.arguments
import io.iskaldvind.poplibs.R.layout.fragment_users
import io.iskaldvind.poplibs.scheduler.SchedulersFactory
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class UsersFragment : MvpAppCompatFragment(fragment_users), UsersView, UsersAdapter.Delegate {

    companion object {
        fun newInstance() : Fragment = UsersFragment().arguments()
    }

    private val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter( GithubUserRepositoryFactory.create(),
            router,
            SchedulersFactory.create()
        ) }
    private val adapter = UsersAdapter(delegate = this)

    private val binding: FragmentUsersBinding by viewBinding()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.users.adapter = adapter
    }


    override fun showUsers(users: List<GithubUserViewModel>) {
        adapter.submitList(users)
    }


    override fun showError(err: Throwable) {
        Toast.makeText(requireContext(), err.localizedMessage, Toast.LENGTH_SHORT).show()
    }


    override fun onUserPicked(user: GithubUserViewModel) {
        presenter.displayUser(user)
    }
}