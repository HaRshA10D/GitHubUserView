package android.opstech.gojek.githubuserview.Home

interface HomeContract {
    fun setProfilePic(imageUrl: String)
    fun setProfileName(name: String)
    fun setBioAndLocation(bio: String, location: String)
    fun searchPerforming()
    fun searchCompleted()
}