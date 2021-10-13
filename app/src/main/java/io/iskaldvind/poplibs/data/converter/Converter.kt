package io.iskaldvind.poplibs.data.converter

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.MainThreadDisposable
import java.io.BufferedOutputStream
import java.io.File
import java.io.FileOutputStream
import java.lang.RuntimeException
import java.util.concurrent.Executors
import kotlin.random.Random

class Converter (private val context: Context, private val uri: Uri) : Single<Uri>() {

    override fun subscribeActual(observer: SingleObserver<in Uri>) {
        val listener = Listener(uri, observer, context)
        observer.onSubscribe(listener)
        listener.convert()
    }

    private class Listener(
        private val uri: Uri,
        private val observer: SingleObserver<in Uri>,
        private val context: Context
    ) : MainThreadDisposable(), Runnable {

        private val tempFile = File.createTempFile("temp", null)
        private val task by lazy {
            Executors
                .newSingleThreadExecutor()
                .submit(this)
        }

        fun convert() { task }

        override fun run() {
            try {
                BufferedOutputStream(FileOutputStream(tempFile)).use {
                    MediaStore.Images.Media.getBitmap(context.contentResolver, uri)
                        .compress(Bitmap.CompressFormat.PNG, 100, it)
                }
                if (!isDisposed && !task.isDone ) {
                    observer.onSuccess(uri)
                }
            } catch (error: Throwable) {
                observer.onError(error)
            } finally {
                if (tempFile.exists()) tempFile.delete()
            }
    }

        override fun onDispose() {
            if (!isDisposed && !task.isDone) {
                task.cancel(true)
                if (tempFile.exists()) tempFile.delete()
            }
        }

    }
}