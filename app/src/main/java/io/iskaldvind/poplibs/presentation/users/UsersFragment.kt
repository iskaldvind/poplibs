package io.iskaldvind.poplibs.presentation.users

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import io.iskaldvind.poplibs.databinding.FragmentUsersBinding
import io.iskaldvind.poplibs.presentation.GitHubUserViewModel
import io.iskaldvind.poplibs.presentation.users.adapter.UsersAdapter
import io.iskaldvind.poplibs.arguments
import io.iskaldvind.poplibs.R.layout.fragment_users
import io.iskaldvind.poplibs.data.user.GitHubUserRepository
import io.iskaldvind.poplibs.presentation.abs.AbsFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject


class UsersFragment : AbsFragment(fragment_users), UsersView, UsersAdapter.Delegate {

    companion object {
        fun newInstance() : Fragment = UsersFragment().arguments()
    }

    @Inject
    lateinit var gitHubUserRepository: GitHubUserRepository

    private val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter(
            gitHubUserRepository,
            router,
            schedulers
        )
    }

    private val adapter = UsersAdapter(delegate = this)

    private val binding: FragmentUsersBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.users.adapter = adapter
    }

    override fun showUsers(users: List<GitHubUserViewModel>) {
        adapter.submitList(users)
    }

    override fun showError(err: Throwable) {
        Toast.makeText(requireContext(), err.localizedMessage, Toast.LENGTH_SHORT).show()
    }

    override fun onUserPicked(user: GitHubUserViewModel) {
        presenter.displayUser(user)
    }
}