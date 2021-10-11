package io.iskaldvind.poplibs.presentation.repo

import android.util.Log
import io.iskaldvind.poplibs.data.repo.GitHubRepoRepository
import io.iskaldvind.poplibs.presentation.GitHubRepoViewModel
import io.reactivex.disposables.CompositeDisposable
import moxy.MvpPresenter


class RepoPresenter(
    private val url: String,
    private val repoRepository: GitHubRepoRepository,
    private val schedulers: io.iskaldvind.poplibs.scheduler.Schedulers
) : MvpPresenter<RepoView>() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        Log.d("LOGGER", "URL: $url")
        disposables.add(
            repoRepository
                .getRepo(url)
                .map(GitHubRepoViewModel.Mapper::map)
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    viewState::showRepo,
                    viewState::showError
                )
        )
    }
}