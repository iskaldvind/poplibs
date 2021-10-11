package io.iskaldvind.poplibs.presentation.repos.adapter

import androidx.recyclerview.widget.DiffUtil
import io.iskaldvind.poplibs.presentation.GitHubRepoViewModel

object RepoDiff : DiffUtil.ItemCallback<GitHubRepoViewModel>() {

    private val payload = Any()

    override fun areItemsTheSame(oldItem: GitHubRepoViewModel, newItem: GitHubRepoViewModel): Boolean {
        return oldItem.url == newItem.url
                && oldItem.title == newItem.title
                && oldItem.forks == newItem.forks
    }

    override fun areContentsTheSame(oldItem: GitHubRepoViewModel, newItem: GitHubRepoViewModel): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: GitHubRepoViewModel, newItem: GitHubRepoViewModel) = payload
}