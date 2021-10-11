package io.iskaldvind.poplibs.presentation.users.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import io.iskaldvind.poplibs.R.layout.fragment_user
import io.iskaldvind.poplibs.presentation.GitHubUserViewModel

class UsersAdapter(private val delegate: Delegate?): ListAdapter<GitHubUserViewModel, UserViewHolder>(UserDiff) {

    interface Delegate {
        fun onUserPicked(user: GitHubUserViewModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(fragment_user, parent, false)
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position), delegate)
    }
}