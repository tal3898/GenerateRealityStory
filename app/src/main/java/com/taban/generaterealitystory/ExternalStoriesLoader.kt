package com.taban.generaterealitystory

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import org.json.JSONArray
import java.lang.Exception
import java.net.URL
import java.util.concurrent.CopyOnWriteArrayList

class ExternalStoriesLoader(val originalStoriesCollection: StoryCollection) {


    @RequiresApi(Build.VERSION_CODES.N)
    fun load() {
        val thread = Thread(Runnable {
            try {
                val apiResponse = URL("https://tal3898.github.io/GenerateRealityStory/").readText()
                Log.i(Globals.LOG_TAG, "the resopnse from external data : " + apiResponse)

                val storiesAsJson = JSONArray(apiResponse)

                val storiesAsList = CopyOnWriteArrayList<String>()
                for (i in 0 until storiesAsJson.length()) {
                    storiesAsList.add(storiesAsJson.getString(i))
                }

                val externalStories = StoryCollection(storiesAsList)
                originalStoriesCollection.push(externalStories)

                originalStoriesCollection.removeDuplicates()

                ModelPreferencesManager.put(originalStoriesCollection, StoryCollection.PREFF_NAME)
            } catch (e: Exception) {
                Log.e(Globals.LOG_TAG, "Could not load external stories", e)
            }
        })
        thread.start()
    }
}