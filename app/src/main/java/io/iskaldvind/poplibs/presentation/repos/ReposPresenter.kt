package io.iskaldvind.poplibs.presentation.repos

import com.github.terrakok.cicerone.Router
import io.iskaldvind.poplibs.data.repo.GitHubRepoRepository
import io.iskaldvind.poplibs.presentation.GitHubRepoViewModel
import io.iskaldvind.poplibs.presentation.repo.RepoScreen
import io.iskaldvind.poplibs.scheduler.Schedulers
import io.reactivex.disposables.CompositeDisposable
import moxy.MvpPresenter

class ReposPresenter(
    private val reposRepo: GitHubRepoRepository,
    private val router: Router,
    private val schedulers: Schedulers,
    private val url: String
) : MvpPresenter<ReposView>() {


    private val disposables = CompositeDisposable()


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        disposables.add(
            reposRepo
                .getRepos(url)
                .observeOn(schedulers.background())
                .map { repos -> repos.map(GitHubRepoViewModel.Mapper::map) }
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(viewState::showRepos, viewState::showError)
        )
    }


    fun displayRepo(repo: GitHubRepoViewModel) {
        router.navigateTo(RepoScreen(repo.url))
    }


    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }
}