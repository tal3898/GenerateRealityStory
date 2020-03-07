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


        MobileAds.initialize(this) {}

        // If there are stories saved in the shared preference, load them
        if (ModelPreferencesManager.get<StoryCollection>(StoryCollection.PREFF_NAME) != null) {
            val savedStoryCollection = ModelPreferencesManager.get<StoryCollection>(StoryCollection.PREFF_NAME)!!
            stories = savedStoryCollection
        }


        val externalStoriesLoader = ExternalStoriesLoader(stories)
        externalStoriesLoader.load()

    }
}
