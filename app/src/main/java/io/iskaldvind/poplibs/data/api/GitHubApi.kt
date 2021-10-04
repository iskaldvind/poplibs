package io.iskaldvind.poplibs.data.api

import io.iskaldvind.poplibs.data.user.GithubUser
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApi {

    @GET("/users")
    fun fetchUsers(): Single<List<GithubUser>>

    @GET("/users/{username}")
    fun fetchUserByLogin(@Path("username") login: String): Single<GithubUser>
}