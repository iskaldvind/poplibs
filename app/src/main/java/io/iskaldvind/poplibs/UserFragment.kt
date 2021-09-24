package io.iskaldvind.poplibs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.iskaldvind.poplibs.databinding.FragmentUserBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment : MvpAppCompatFragment(), UserView, BackButtonListener {

    private var user: GithubUser = GithubUser("")

    companion object {
        fun newInstance(user: GithubUser) : UserFragment {
            val fragment = UserFragment()
            val args = Bundle()
            args.putParcelable("user", user)
            fragment.arguments = args
            return fragment
        }
    }

    val presenter: UserPresenter by moxyPresenter { UserPresenter(user, App.instance.router) }

    private var _binding: FragmentUserBinding? = null
    private val binding: FragmentUserBinding
        get(): FragmentUserBinding = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentUserBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            user = it.getParcelable("user") ?: GithubUser("")
        }
        presenter
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