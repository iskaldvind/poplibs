package io.iskaldvind.poplibs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import io.iskaldvind.poplibs.databinding.FragmentUserBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment : MvpAppCompatFragment(), UserView, BackButtonListener {

    companion object {

        private const val LOGIN = "UserFragment.login"

        fun newInstance(login: String) : UserFragment {
            val fragment = UserFragment()
            fragment.arguments = bundleOf(LOGIN to login)
            return fragment
        }
    }

    private val login: String by lazy {
        arguments?.getString(LOGIN) ?: ""
    }

    private val presenter: UserPresenter by moxyPresenter { UserPresenter(login, App.instance.router) }

    private var _binding: FragmentUserBinding? = null
    private val binding: FragmentUserBinding
        get(): FragmentUserBinding = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentUserBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun setLogin(text: String) {
        binding.login.text = text
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun backPressed() = presenter.backPressed()
}