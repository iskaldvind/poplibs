package io.iskaldvind.poplibs.presentation.repo

import android.util.Log
import io.iskaldvind.poplibs.data.repo.IGithubRepoRepository
import io.iskaldvind.poplibs.presentation.GithubRepoViewModel
import io.reactivex.disposables.CompositeDisposable
import moxy.MvpPresenter


class RepoPresenter(
    private val url: String,
    private val repoRepository: IGithubRepoRepository,
    private val schedulers: io.iskaldvind.poplibs.scheduler.Schedulers
) : MvpPresenter<RepoView>() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        disposables.add(
            repoRepository
                .getRepo(url)
                .map(GithubRepoViewModel.Mapper::map)
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    viewState::showRepo,
                    viewState::showError
                )
        )
    }
}