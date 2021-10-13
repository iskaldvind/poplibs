package io.iskaldvind.poplibs.data.converter

import android.net.Uri
import io.reactivex.Single

interface IConverter {

    fun convert(uri: Uri): Single<Uri>
}