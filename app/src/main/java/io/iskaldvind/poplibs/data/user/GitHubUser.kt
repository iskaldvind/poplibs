package io.iskaldvind.poplibs.data.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "users")
data class GitHubUser(
    @SerializedName("id")
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,
    @SerializedName("login")
    @ColumnInfo(name = "login")
    val login: String,
    @SerializedName("repos_url")
    @ColumnInfo(name = "reposUrl")
    val reposUrl: String,
    @SerializedName("avatar_url")
    @ColumnInfo(name = "avatar")
    val avatar: String
)

