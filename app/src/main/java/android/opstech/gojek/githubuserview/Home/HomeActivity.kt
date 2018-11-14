package android.opstech.gojek.githubuserview.Home

import android.opstech.gojek.githubuserview.Dagger.DaggerNetworkComponent
import android.opstech.gojek.githubuserview.Dagger.NetworkModule
import android.opstech.gojek.githubuserview.R
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class HomeActivity : AppCompatActivity(), HomeContract {

    private lateinit var userImage: ImageView
    private lateinit var searchButton: Button
    private lateinit var userIdInput: EditText
    private lateinit var profileName: TextView
    private lateinit var profileLocation: TextView
    private lateinit var profileBio: TextView
    private lateinit var homePresenter: HomePresenter

    override fun setProfilePic(imageUrl: String) {
        userImage = findViewById(R.id.userProfileImage)
        Glide.with(userImage).load(imageUrl).into(userImage)
    }

    override fun setProfileName(name: String) {
        profileName.text = name
    }

    override fun setBioAndLocation(bio: String, location: String) {
        profileBio.text = bio
        profileLocation.text = location
    }

    override fun searchPerforming() {
        searchButton.text = getString(R.string.loading_string)
        searchButton.isEnabled = false
    }

    override fun searchCompleted() {
        searchButton.text = getString(R.string.search)
        searchButton.isEnabled = true
    }

    override fun initializeViews() {
        searchButton = findViewById(R.id.searchUserButton)
        userIdInput = findViewById(R.id.userIdField)
        profileName = findViewById(R.id.profileName)
        profileLocation = findViewById(R.id.profileLocation)
        profileBio = findViewById(R.id.profileBio)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val networkComponent = DaggerNetworkComponent.builder()
                .networkModule(NetworkModule())
                .build()

        homePresenter = HomePresenter(this)
        networkComponent.inject(homePresenter)

        listenToSearchButton()
    }

    private fun listenToSearchButton() {
        searchButton.setOnClickListener {
            homePresenter.fetchAndSetUserData(userIdInput.text.toString())
        }
    }
}
