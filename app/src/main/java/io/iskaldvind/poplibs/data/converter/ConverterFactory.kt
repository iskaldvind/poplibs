package io.iskaldvind.poplibs.data.converter

import android.content.Context

object ConverterFactory {

    fun create(context: Context): Converter = Converter(context)
}