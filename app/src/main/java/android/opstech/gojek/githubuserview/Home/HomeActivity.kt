package android.opstech.gojek.githubuserview.Home

import android.opstech.gojek.githubuserview.Dagger.DaggerNetworkComponent
import android.opstech.gojek.githubuserview.Dagger.NetworkModule
import android.opstech.gojek.githubuserview.R
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide

class HomeActivity : AppCompatActivity(), HomeContract {
    override fun setProfilePic(imageUrl: String) {
        val userImage = findViewById<ImageView>(R.id.userProfileImage)
        Glide.with(userImage).load(imageUrl).into(userImage)
    }

    override fun setProfileName(name: String) {

    }

    override fun setBioAndLocation(bio: String, location: String) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val networkComponent = DaggerNetworkComponent.builder()
                .networkModule(NetworkModule())
                .build()

        val homePresenter = HomePresenter(this)
        networkComponent.inject(homePresenter)

        homePresenter.fetchAndSetUserData("harsha10d")
    }
}
