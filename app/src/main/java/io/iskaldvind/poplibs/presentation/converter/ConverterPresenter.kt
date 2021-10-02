package io.iskaldvind.poplibs.presentation.converter

import android.net.Uri
import android.util.Log
import io.iskaldvind.poplibs.data.converter.Converter
import io.iskaldvind.poplibs.scheduler.Schedulers
import io.reactivex.Completable
import io.reactivex.disposables.CompositeDisposable
import moxy.MvpPresenter
import java.lang.RuntimeException


class ConverterPresenter(
    private val schedulers: Schedulers,
    private val converter: Converter
) : MvpPresenter<ConverterView>() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        viewState.hideAll()
    }


    fun load(uri: Uri) {
        viewState.showLoading()
        disposables.add(
            Completable
                .create { emitter ->
                    convert(uri).let {
                        if (it) {
                            emitter.onComplete()
                        } else {
                            emitter.onError(RuntimeException("Error"))
                        }
                    }
                }
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.io())
                .subscribe(
                    viewState::showSuccess,
                    viewState::showError
                )
        )
    }


    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }


    private fun convert(uri: Uri) = converter.convert(uri)
}