package io.iskaldvind.poplibs.presentation.repo

import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import io.iskaldvind.poplibs.R
import io.iskaldvind.poplibs.arguments
import io.iskaldvind.poplibs.data.repo.GithubRepoRepositoryFactory
import io.iskaldvind.poplibs.databinding.FragmentRepoBinding
import io.iskaldvind.poplibs.presentation.GithubRepoViewModel
import io.iskaldvind.poplibs.scheduler.SchedulersFactory
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class RepoFragment : MvpAppCompatFragment(R.layout.fragment_repo), RepoView {

    companion object {

        private const val URL = "RepoFragment.url"

        fun newInstance(url: String) : Fragment = RepoFragment()
            .arguments(URL to url)

    }

    private val url: String by lazy {
        arguments?.getString(URL).orEmpty()
    }

    @Suppress("unused")
    private val presenter: RepoPresenter by moxyPresenter {
        RepoPresenter(
            url,
            GithubRepoRepositoryFactory.create(),
            SchedulersFactory.create())
    }


    private val binding: FragmentRepoBinding by viewBinding()


    override fun showRepo(repo: GithubRepoViewModel) {
        with(binding) {
            owner.text = repo.owner
            title.text = repo.title
            url.text = repo.url
            val forksText = "Forks: ${repo.forks}"
            forks.text = forksText
        }
    }

    override fun showError(error: Throwable) {
        Toast.makeText(requireContext(), error.localizedMessage, Toast.LENGTH_SHORT).show()
    }
}