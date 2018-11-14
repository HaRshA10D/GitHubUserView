package android.opstech.gojek.githubuserview.Home

import android.opstech.gojek.githubuserview.Dagger.DaggerNetworkComponent
import android.opstech.gojek.githubuserview.Dagger.NetworkModule
import android.opstech.gojek.githubuserview.R
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.bumptech.glide.Glide

class HomeActivity : AppCompatActivity(), HomeContract {

    private lateinit var userImage: ImageView
    private lateinit var searchButton: Button
    private lateinit var userIdInput: EditText
    private lateinit var homePresenter: HomePresenter

    override fun setProfilePic(imageUrl: String) {
        userImage = findViewById(R.id.userProfileImage)
        Glide.with(userImage).load(imageUrl).into(userImage)
        searchButton.text = getString(R.string.search)
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

        homePresenter = HomePresenter(this)
        networkComponent.inject(homePresenter)

        searchButton = findViewById(R.id.searchUserButton)
        userIdInput = findViewById(R.id.userIdField)
        listenToSearchButton()
    }

    private fun listenToSearchButton() {
        searchButton.setOnClickListener {
            searchButton.text = getString(R.string.loading_string)
            homePresenter.fetchAndSetUserData(userIdInput.text.toString())
        }
    }
}
