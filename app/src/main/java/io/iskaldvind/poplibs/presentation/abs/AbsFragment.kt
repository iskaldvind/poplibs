package io.iskaldvind.poplibs.presentation.abs

import android.os.Bundle
import androidx.annotation.LayoutRes
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import io.iskaldvind.poplibs.scheduler.Schedulers
import moxy.MvpAppCompatFragment
import javax.inject.Inject


abstract class AbsFragment(@LayoutRes contentLayoutId: Int = 0) : MvpAppCompatFragment(contentLayoutId), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var schedulers: Schedulers

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }
}