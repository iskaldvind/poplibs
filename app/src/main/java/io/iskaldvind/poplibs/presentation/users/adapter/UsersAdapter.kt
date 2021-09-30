package io.iskaldvind.poplibs.presentation.users.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import io.iskaldvind.poplibs.R.layout.fragment_user
import io.iskaldvind.poplibs.presentation.GithubUserViewModel

class UsersAdapter(private val delegate: Delegate?): ListAdapter<GithubUserViewModel, UserViewHolder>(UserDiff) {

    interface Delegate {
        fun onUserPicked(user: GithubUserViewModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        Log.d("CREATE", "HIT")
        return UserViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(fragment_user, parent, false)
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        Log.d("ON BIND", "HIT")
        holder.bind(getItem(position), delegate)
    }
}