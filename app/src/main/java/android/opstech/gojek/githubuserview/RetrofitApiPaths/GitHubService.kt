package android.opstech.gojek.githubuserview.RetrofitApiPaths

import android.opstech.gojek.githubuserview.Models.GitHubUser
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {
    @GET("/users/{user}")
    fun getUser(@Path("user") userId: String): Single<Response<GitHubUser>>
}
