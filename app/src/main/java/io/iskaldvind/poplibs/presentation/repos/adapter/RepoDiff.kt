package io.iskaldvind.poplibs.presentation.repos.adapter

import androidx.recyclerview.widget.DiffUtil
import io.iskaldvind.poplibs.presentation.GithubRepoViewModel

object RepoDiff : DiffUtil.ItemCallback<GithubRepoViewModel>() {

    private val payload = Any()

    override fun areItemsTheSame(oldItem: GithubRepoViewModel, newItem: GithubRepoViewModel): Boolean {
        return oldItem.url == newItem.url
                && oldItem.title == newItem.title
                && oldItem.forks == newItem.forks
    }

    override fun areContentsTheSame(oldItem: GithubRepoViewModel, newItem: GithubRepoViewModel): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: GithubRepoViewModel, newItem: GithubRepoViewModel) = payload
}