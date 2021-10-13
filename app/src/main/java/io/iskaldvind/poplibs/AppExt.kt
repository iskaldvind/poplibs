package io.iskaldvind.poplibs

import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment


fun Fragment.arguments(vararg arguments: Pair<String, Any>): Fragment {
    this.arguments = bundleOf(*arguments)
    return this
}

fun View.click(click: () -> Unit) = setOnClickListener { click() }