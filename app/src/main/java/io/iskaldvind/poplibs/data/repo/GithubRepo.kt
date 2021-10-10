package io.iskaldvind.poplibs.data.repo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "repos")
data class GithubRepo(
    @SerializedName("id")
    @ColumnInfo(name = "id")
    @PrimaryKey
    val id: String,
    @SerializedName("owner")
    @ColumnInfo(name = "owner")
    val owner: Owner,
    @SerializedName("url")
    @ColumnInfo(name = "url")
    val url: String,
    @SerializedName("name")
    @ColumnInfo(name = "name")
    val name: String,
    @SerializedName("forks")
    @ColumnInfo(name = "forks")
    val forks: Int
)

data class Owner(
    @SerializedName("repos_url")
    val home: String,
)