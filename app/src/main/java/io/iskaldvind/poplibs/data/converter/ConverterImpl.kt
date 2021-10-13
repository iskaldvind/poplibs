package io.iskaldvind.poplibs.data.converter

import android.content.Context
import android.net.Uri

class ConverterImpl(private val context: Context) : IConverter {

    override fun convert(uri: Uri) = Converter(context, uri)
}