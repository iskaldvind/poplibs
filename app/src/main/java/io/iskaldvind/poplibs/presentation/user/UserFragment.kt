package io.iskaldvind.poplibs.presentation.user

import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import io.iskaldvind.poplibs.App.Navigation.router
import io.iskaldvind.poplibs.databinding.FragmentUserBinding
import io.iskaldvind.poplibs.R.layout.fragment_user
import io.iskaldvind.poplibs.arguments
import io.iskaldvind.poplibs.data.user.GithubUserRepositoryFactory
import io.iskaldvind.poplibs.presentation.GithubUserViewModel
import io.iskaldvind.poplibs.scheduler.SchedulersFactory
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class UserFragment : MvpAppCompatFragment(fragment_user), UserView {

    companion object {

        private const val LOGIN = "UserFragment.login"

        fun newInstance(login: String) : Fragment = UserFragment().arguments(LOGIN to login)

    }

    private val login: String by lazy {
        arguments?.getString(LOGIN).orEmpty()
    }

    @Suppress("unused")
    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter(
            login,
            GithubUserRepositoryFactory.create(),
            SchedulersFactory.create(),
            router
        )
    }


    private val binding: FragmentUserBinding by viewBinding()


    override fun showUser(user: GithubUserViewModel) {
        binding.login.text = user.login
        binding.login.setOnClickListener { presenter.onUserClick() }
    }

    override fun showError(error: Throwable) {
        Toast.makeText(requireContext(), error.localizedMessage, Toast.LENGTH_SHORT).show()
    }
}