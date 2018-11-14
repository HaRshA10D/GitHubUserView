package android.opstech.gojek.githubuserview.Models

import com.google.gson.annotations.SerializedName

data class GitHubUser(
        @SerializedName("login") val loginId: String,
        @SerializedName("avatar_url") val avatarURL: String,
        @SerializedName("name") val userName: String,
        @SerializedName("location") val location: String,
        @SerializedName("bio") val bio: String,
        @SerializedName("public_repos") val repoCount: String
)
