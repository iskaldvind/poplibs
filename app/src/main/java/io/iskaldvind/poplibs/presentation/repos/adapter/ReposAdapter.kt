package io.iskaldvind.poplibs.presentation.repos.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import io.iskaldvind.poplibs.R
import io.iskaldvind.poplibs.presentation.GitHubRepoViewModel


class ReposAdapter(private val delegate: Delegate?): ListAdapter<GitHubRepoViewModel, RepoViewHolder>(
    RepoDiff
) {

    interface Delegate {
        fun onRepoPicked(repo: GitHubRepoViewModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        return RepoViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_repo, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.bind(getItem(position), delegate)
    }
}