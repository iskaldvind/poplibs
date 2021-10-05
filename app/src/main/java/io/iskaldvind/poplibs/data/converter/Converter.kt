package io.iskaldvind.poplibs.data.converter

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import java.io.BufferedOutputStream
import java.io.File
import java.io.FileOutputStream
import java.lang.RuntimeException
import kotlin.random.Random

class Converter (private val context: Context) {

    fun convert(uri: Uri): Boolean {
        Thread.sleep(Random.nextLong(1000))
        val tempFile = File.createTempFile("temp", null)
        try {
            BufferedOutputStream(FileOutputStream(tempFile)).use {
                MediaStore.Images.Media.getBitmap(context.contentResolver, uri)
                    .compress(Bitmap.CompressFormat.PNG, 100, it)
            }
        } catch (e: RuntimeException) {
            return false
        } finally {
            tempFile
                .takeIf(File::exists)
                ?.let(File::delete)
        }
        return true
    }
}