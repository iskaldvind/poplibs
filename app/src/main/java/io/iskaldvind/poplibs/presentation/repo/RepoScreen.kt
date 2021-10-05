package io.iskaldvind.poplibs.presentation.repo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import io.iskaldvind.poplibs.presentation.user.UserFragment

class RepoScreen(private val url: String) : FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
        RepoFragment.newInstance(url)

}