package com.taban.generaterealitystory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import android.text.method.ScrollingMovementMethod
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.util.Log
import com.google.android.gms.ads.*
import org.json.JSONArray
import org.json.JSONObject
import org.xml.sax.Parser
import java.lang.Exception
import java.net.URL


class MainActivity : AppCompatActivity() {

    var stories:StoryCollection = StoryCollection()
    var isShowingAdClick = 1
    var showingAdClicksInterval = 2
    lateinit var mInterstitialAd: InterstitialAd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        storyTxt.setMovementMethod(ScrollingMovementMethod())

        MobileAds.initialize(this) {}

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
