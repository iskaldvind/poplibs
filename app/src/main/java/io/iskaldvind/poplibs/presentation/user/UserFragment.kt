package io.iskaldvind.poplibs.presentation.user

import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import io.iskaldvind.poplibs.databinding.FragmentUserBinding
import io.iskaldvind.poplibs.R.layout.fragment_user
import io.iskaldvind.poplibs.arguments
import io.iskaldvind.poplibs.data.user.GitHubUserRepository
import io.iskaldvind.poplibs.presentation.GitHubUserViewModel
import io.iskaldvind.poplibs.presentation.abs.AbsFragment
import io.iskaldvind.poplibs.setStartDrawableCircleImageFromUri
import moxy.ktx.moxyPresenter
import javax.inject.Inject


class UserFragment : AbsFragment(fragment_user), UserView {

    companion object {

        private const val LOGIN = "UserFragment.login"

        fun newInstance(login: String) : Fragment = UserFragment().arguments(LOGIN to login)

    }

    @Inject
    lateinit var gitHubUserRepository: GitHubUserRepository

    private val login: String by lazy {
        arguments?.getString(LOGIN).orEmpty()
    }

    @Suppress("unused")
    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter(
            login,
            gitHubUserRepository,
            schedulers,
            router
        )
    }

    private val binding: FragmentUserBinding by viewBinding()

    override fun showUser(user: GitHubUserViewModel) {
        with(binding) {
            login.setStartDrawableCircleImageFromUri(user.avatar)
            login.text = user.login
            login.setOnClickListener { presenter.onUserClick() }
        }
    }

    override fun showError(error: Throwable) {
        Toast.makeText(requireContext(), error.localizedMessage, Toast.LENGTH_SHORT).show()
    }
}