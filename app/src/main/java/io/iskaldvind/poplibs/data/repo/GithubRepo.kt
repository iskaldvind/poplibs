package io.iskaldvind.poplibs.data.repo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubRepo(
    val owner: Owner,
    val url: String,
    val name: String,
    val forks: Int
) : Parcelable

@Parcelize
data class Owner(
    val login: String
) : Parcelable