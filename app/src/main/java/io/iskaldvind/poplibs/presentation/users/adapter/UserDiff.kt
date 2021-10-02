package io.iskaldvind.poplibs.presentation.users.adapter

import androidx.recyclerview.widget.DiffUtil
import io.iskaldvind.poplibs.presentation.GithubUserViewModel

object UserDiff : DiffUtil.ItemCallback<GithubUserViewModel>() {

    private val payload = Any()

    override fun areItemsTheSame(oldItem: GithubUserViewModel, newItem: GithubUserViewModel): Boolean {
        return oldItem.login == newItem.login
    }

    override fun areContentsTheSame(oldItem: GithubUserViewModel, newItem: GithubUserViewModel): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: GithubUserViewModel, newItem: GithubUserViewModel) = payload
}