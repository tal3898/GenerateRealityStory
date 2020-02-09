package com.taban.generaterealitystory

import java.util.*
import kotlin.collections.ArrayList

class StoryCollection {

    var stories = ArrayList(Arrays.asList("I have two fathers. I have been bullied since I was 8 years old, for 4 years! At the age 12, I decided to change school, and never told about my parents. I have always hidden it, and every time someone asked about them I used to change the subject. Only recently I ",
        "My mom died when I was 4 years old. I grew up with my dad and my twin sister. My father was barely home. My mom death was hard for him, so he kept himself busy at work. So it was like to grow up with out my dad too. My sister and I grew up alone. We helped each other, and raised each other. It wasn't easy for us to grow with out our parents.",
        "I took a surgery to change sex. All my life I felt I lived in the wrong body.",
        "I'm alcoholic. I can't start a day without  several drinks. It started when my girlfriend left me a year ago, and I took it very hard. I started drinking every day, and than every morning. It is hard the make the day throw, butI try to work on it. I'm at a support group, which we help each other, and it helps. I have a message for the audience, never give up."
        ))

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