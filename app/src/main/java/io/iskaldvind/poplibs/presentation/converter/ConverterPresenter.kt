package io.iskaldvind.poplibs.presentation.converter

import android.net.Uri
import io.iskaldvind.poplibs.data.converter.IConverter
import io.iskaldvind.poplibs.scheduler.Schedulers
import io.reactivex.disposables.CompositeDisposable
import moxy.MvpPresenter


class ConverterPresenter(
    private val schedulers: Schedulers,
    private val converter: IConverter
) : MvpPresenter<ConverterView>() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        viewState.hideAll()
    }


    fun load(uri: Uri) {
        viewState.showLoading()
        disposables.add(
            converter.convert(uri)
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.io())
                .subscribe(
                    { viewState.showSuccess() },
                    viewState::showError
                )
        )
    }


    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }
}