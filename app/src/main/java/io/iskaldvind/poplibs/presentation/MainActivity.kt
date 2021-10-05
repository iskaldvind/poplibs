package io.iskaldvind.poplibs.presentation

import android.os.Bundle
import com.github.terrakok.cicerone.androidx.AppNavigator
import io.iskaldvind.poplibs.App.Navigation.navigatorHolder
import io.iskaldvind.poplibs.App.Navigation.router
import io.iskaldvind.poplibs.presentation.converter.ConverterScreen
import io.iskaldvind.poplibs.presentation.users.UsersScreen
import moxy.MvpAppCompatActivity


class MainActivity : MvpAppCompatActivity() {

    private val navigator = AppNavigator(this, android.R.id.content)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        savedInstanceState ?: router.newRootScreen(UsersScreen)
    }


    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }


    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }
}