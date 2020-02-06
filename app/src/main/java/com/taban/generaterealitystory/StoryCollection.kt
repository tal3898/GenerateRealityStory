package com.taban.generaterealitystory

import java.util.*
import kotlin.collections.ArrayList

class StoryCollection {

    var stories = ArrayList(Arrays.asList("I have two fathers. Since I was 10 my kids made fun of me. at the age 12, I decided to change school, and never told about my parents. I have always hidden it, and every time someone asked about them I used to change the subject. Only recently I ",
        "b",
        "c",
        "d",
        "e",
        "f",
        "g",
        "h"))

    init {
        shuffle()
    }

    fun shuffle() {
        var shuffledStories = ArrayList<String>()
        var randomInt = Random()

        while (!stories.isEmpty()) {
            var randomStoryIndex = randomInt.nextInt(stories.size)
            var randomStory = stories.get(randomStoryIndex)
            shuffledStories.add(randomStory)
            stories.removeAt(randomStoryIndex)
        }

        stories = shuffledStories
    }

    /**
     * The method poll the first story from the list, and put it in the end
     */
    fun getStory() : String {
        var story = stories.get(0)
        stories.removeAt(0)
        stories.add(story)

        return story
    }
}