package com.taban.generaterealitystory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var stories:StoryCollection = StoryCollection()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showRandomStory(view: View) {
        var storyTextView:TextView = storyTxt
        var newStory:String = stories.getStory()
        storyTextView.setText(newStory)
    }
}
