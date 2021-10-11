package io.iskaldvind.poplibs.presentation.repo

import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import io.iskaldvind.poplibs.R
import io.iskaldvind.poplibs.arguments
import io.iskaldvind.poplibs.data.repo.GitHubRepoRepository
import io.iskaldvind.poplibs.databinding.FragmentRepoBinding
import io.iskaldvind.poplibs.presentation.GitHubRepoViewModel
import io.iskaldvind.poplibs.presentation.abs.AbsFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject


class RepoFragment : AbsFragment(R.layout.fragment_repo), RepoView {

    companion object {

        private const val URL = "RepoFragment.url"

        fun newInstance(url: String) : Fragment = RepoFragment()
            .arguments(URL to url)

    }

    @Inject
    lateinit var gitHubRepoRepository: GitHubRepoRepository

    private val url: String by lazy {
        arguments?.getString(URL).orEmpty()
    }

    @Suppress("unused")
    private val presenter: RepoPresenter by moxyPresenter {
        RepoPresenter(
            url,
            gitHubRepoRepository,
            schedulers
        )
    }


    private val binding: FragmentRepoBinding by viewBinding()


    override fun showRepo(repo: GitHubRepoViewModel) {
        with(binding) {
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