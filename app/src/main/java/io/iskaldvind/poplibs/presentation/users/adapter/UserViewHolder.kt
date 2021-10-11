package io.iskaldvind.poplibs.presentation.users.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import by.kirich1409.viewbindingdelegate.viewBinding
import io.iskaldvind.poplibs.databinding.FragmentUserBinding
import io.iskaldvind.poplibs.presentation.GitHubUserViewModel
import io.iskaldvind.poplibs.presentation.users.adapter.UsersAdapter.Delegate
import io.iskaldvind.poplibs.click
import io.iskaldvind.poplibs.setStartDrawableCircleImageFromUri


class UserViewHolder(view: View): ViewHolder(view) {

    private val binding: FragmentUserBinding by viewBinding()

    fun bind(user: GitHubUserViewModel, delegate: Delegate?) {
        with(binding) {
            login.setStartDrawableCircleImageFromUri(user.avatar)
            login.text = user.login
            root.click { delegate?.onUserPicked(user) }
        }
    }
}