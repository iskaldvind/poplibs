package io.iskaldvind.poplibs.presentation.repos

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import io.iskaldvind.poplibs.R
import io.iskaldvind.poplibs.arguments
import io.iskaldvind.poplibs.data.repo.GitHubRepoRepository
import io.iskaldvind.poplibs.databinding.FragmentReposBinding
import io.iskaldvind.poplibs.presentation.GitHubRepoViewModel
import io.iskaldvind.poplibs.presentation.abs.AbsFragment
import io.iskaldvind.poplibs.presentation.repos.adapter.ReposAdapter
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class ReposFragment : AbsFragment(R.layout.fragment_repos), ReposView, ReposAdapter.Delegate {

    companion object {
        private const val URL: String = "ReposFragment.url"

        fun newInstance(url: String) : Fragment =
            ReposFragment().arguments(URL to url)
    }

    @Inject
    lateinit var gitHubRepoRepository: GitHubRepoRepository

    private val presenter: ReposPresenter by moxyPresenter {
        ReposPresenter(
            gitHubRepoRepository,
            router,
            schedulers,
            url
        )
    }

    private val adapter = ReposAdapter(delegate = this)

    private val binding: FragmentReposBinding by viewBinding()

    private val url: String by lazy {
        arguments?.getString(URL).orEmpty()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.repos.adapter = adapter
    }

    override fun showRepos(repos: List<GitHubRepoViewModel>) {
        adapter.submitList(repos)
    }

    override fun showError(err: Throwable) {
        Toast.makeText(requireContext(), err.localizedMessage, Toast.LENGTH_SHORT).show()
    }

    override fun onRepoPicked(repo: GitHubRepoViewModel) {
        presenter.displayRepo(repo)
    }
}