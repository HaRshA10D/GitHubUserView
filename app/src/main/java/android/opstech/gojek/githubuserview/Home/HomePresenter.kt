package android.opstech.gojek.githubuserview.Home

import android.opstech.gojek.githubuserview.RetrofitApiPaths.GitHubService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomePresenter(private val homeView: HomeContract) {

    @Inject
    lateinit var gitHubService: GitHubService

    init {
        homeView.initializeViews()
    }

    fun fetchAndSetUserData(userID: String) {
        homeView.searchPerforming()
        gitHubService.getUser(userID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (it.body() != null) {
                        homeView.setProfilePic(it.body()!!.avatarURL)
                        homeView.setProfileName(it.body()!!.userName)
                        if (it.body()?.bio != null && it.body()?.location != null) {
                            homeView.setBioAndLocation(it.body()!!.bio, it.body()!!.location)
                        }
                        homeView.searchCompleted()
                    }
                }, {

                })
    }

}
