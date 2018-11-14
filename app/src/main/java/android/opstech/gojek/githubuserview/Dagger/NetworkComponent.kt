package android.opstech.gojek.githubuserview.Dagger

import android.opstech.gojek.githubuserview.Home.HomePresenter
import android.opstech.gojek.githubuserview.RetrofitApiPaths.GitHubService
import dagger.Component

@Component(modules = [(NetworkModule::class)])
interface NetworkComponent {
    fun getGitHubService(): GitHubService
    fun inject(homePresenter: HomePresenter)
}
