package android.opstech.gojek.githubuserview.Dagger

import android.opstech.gojek.githubuserview.RetrofitApiPaths.GitHubService
import dagger.Component

@Component(modules = arrayOf(NetworkModule::class))
interface NetworkComponent {
    fun getGitHubService(): GitHubService
}
