package io.iskaldvind.poplibs.data.api

import io.iskaldvind.poplibs.data.repo.GithubRepo
import io.iskaldvind.poplibs.data.user.GithubUser
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface GitHubApi {

    @GET("/users")
    fun fetchUsers(): Single<List<GithubUser>>

    @GET("/users/{username}")
    fun fetchUserByLogin(
        @Path("username") login: String
    ): Single<GithubUser>

    @GET
    fun fetchUserRepos(
        @Url reposUrl: String
    ): Single<List<GithubRepo>>

    @GET
    fun fetchUserRepo(
        @Url repoUrl: String
    ): Single<GithubRepo>
}