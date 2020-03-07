package com.taban.generaterealitystory

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import android.text.method.ScrollingMovementMethod
import com.google.android.gms.ads.*
import com.google.gson.GsonBuilder


class MainActivity : AppCompatActivity() {

    var stories:StoryCollection = StoryCollection()
    var isShowingAdClick = 1
    var showingAdClicksInterval = 2
    lateinit var mInterstitialAd: InterstitialAd



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ModelPreferencesManager.with(this)

        storyTxt.setMovementMethod(ScrollingMovementMethod())

        MobileAds.initialize(this) {}







        // If there are stories saved in the shared preference
        if (ModelPreferencesManager.get<StoryCollection>(StoryCollection.PREFF_NAME) != null) {
            val savedStoryCollection = ModelPreferencesManager.get<StoryCollection>(StoryCollection.PREFF_NAME)!!
            stories = savedStoryCollection
        }


        val externalStoriesLoader = ExternalStoriesLoader(stories)
        externalStoriesLoader.load()


        // fullad
        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = "ca-app-pub-3940256099942544/1033173712"


        // banner ad
        val mAdView = adView
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        mAdView.adListener = object: AdListener() {
            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            override fun onAdFailedToLoad(errorCode : Int) {
                // Code to be executed when an ad request fails.
            }

            override fun onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            override fun onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            override fun onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        }
    }

    fun showRandomStory(view: View) {
        var storyTextView:TextView = storyTxt
        var newStory:String = stories.getStory()
        storyTextView.setText(newStory)

        if ((isShowingAdClick++)% showingAdClicksInterval == 0) {
            mInterstitialAd.loadAd(AdRequest.Builder().build())
            mInterstitialAd.show()
        }
    }
}
