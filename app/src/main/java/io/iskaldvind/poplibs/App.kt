package io.iskaldvind.poplibs

import com.github.terrakok.cicerone.Cicerone
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.iskaldvind.poplibs.di.DaggerAppComponent
import io.iskaldvind.poplibs.scheduler.DefaultSchedulers

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out App> =
        DaggerAppComponent
            .builder()
            .withContext(applicationContext)
            .apply {
                val cicerone = Cicerone.create()
                withRouter(cicerone.router)
                withNavigatorHolder(cicerone.getNavigatorHolder())
            }
            .withSchedulers(DefaultSchedulers())
            .build()
}