package io.iskaldvind.poplibs

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router

class App : Application() {

    @SuppressLint("StaticFieldLeak")
    object ContextHolder { lateinit var context: Context }

    companion object Navigation {

        private val cicerone: Cicerone<Router> by lazy {
            Cicerone.create()
        }

        val navigatorHolder = cicerone.getNavigatorHolder()

        val router = cicerone.router
    }

    override fun onCreate() {
        super.onCreate()

        ContextHolder.context = applicationContext
    }
}