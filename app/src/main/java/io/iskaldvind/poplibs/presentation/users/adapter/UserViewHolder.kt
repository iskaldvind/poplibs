package io.iskaldvind.poplibs.presentation.users.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import by.kirich1409.viewbindingdelegate.viewBinding
import io.iskaldvind.poplibs.databinding.FragmentUserBinding
import io.iskaldvind.poplibs.presentation.GithubUserViewModel
import io.iskaldvind.poplibs.presentation.users.adapter.UsersAdapter.Delegate
import io.iskaldvind.poplibs.click


class UserViewHolder(view: View): ViewHolder(view) {

    private val binding: FragmentUserBinding by viewBinding()

    fun bind(user: GithubUserViewModel, delegate: Delegate?) {
        with(binding) {
            login.text = user.login
            root.click { delegate?.onUserPicked(user) }
        }
    }
}