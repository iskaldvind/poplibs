package io.iskaldvind.poplibs.di

import android.content.Context
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import io.iskaldvind.poplibs.App
import io.iskaldvind.poplibs.scheduler.Schedulers
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    MainModule::class,
    UserModule::class,
    RepoModule::class,
    StorageModule::class,
    GitHubApiModule::class
])
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun withContext(context: Context): Builder

        @BindsInstance
        fun withSchedulers(schedulers: Schedulers): Builder

        @BindsInstance
        fun withRouter(router: Router): Builder

        @BindsInstance
        fun withNavigatorHolder(navigatorHolder: NavigatorHolder): Builder

        fun build(): AppComponent
    }

}