package io.iskaldvind.poplibs

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen


class AndroidScreens : IScreens {

    override fun users(): Screen = FragmentScreen {
        UsersFragment.newInstance()
    }

    override fun user(user: GithubUser): Screen = FragmentScreen {
        UserFragment.newInstance(user)
    }
}