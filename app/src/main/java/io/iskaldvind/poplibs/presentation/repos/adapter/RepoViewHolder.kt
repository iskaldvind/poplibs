package io.iskaldvind.poplibs.presentation.repos.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import io.iskaldvind.poplibs.click
import io.iskaldvind.poplibs.databinding.ItemRepoBinding
import io.iskaldvind.poplibs.presentation.GithubRepoViewModel


class RepoViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding: ItemRepoBinding by viewBinding()

    fun bind(repo: GithubRepoViewModel, delegate: ReposAdapter.Delegate?) {
        with(binding) {
            title.text = repo.title
            root.click { delegate?.onRepoPicked(repo) }
        }
    }
}