package android.opstech.gojek.githubuserview.Home

import android.opstech.gojek.githubuserview.R
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class HomeActivity : AppCompatActivity(), HomeContract {
    override fun setProfilePic(imageUrl: String) {

    }

    override fun setProfileName(name: String) {

    }

    override fun setBioAndLocation(bio: String, location: String) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }
}
