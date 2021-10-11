package io.iskaldvind.poplibs.presentation.users.adapter

import androidx.recyclerview.widget.DiffUtil
import io.iskaldvind.poplibs.presentation.GitHubUserViewModel

object UserDiff : DiffUtil.ItemCallback<GitHubUserViewModel>() {

    private val payload = Any()

    override fun areItemsTheSame(oldItem: GitHubUserViewModel, newItem: GitHubUserViewModel): Boolean {
        return oldItem.login == newItem.login
    }

    override fun areContentsTheSame(oldItem: GitHubUserViewModel, newItem: GitHubUserViewModel): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: GitHubUserViewModel, newItem: GitHubUserViewModel) = payload
}