package com.taban.generaterealitystory

import java.util.*
import kotlin.collections.ArrayList

class StoryCollection {

    var stories = ArrayList(Arrays.asList("I have two fathers. I have been bullied since I was 8 years old, for 4 years! At the age 12, I decided to switch school, and never told about my parents. I have always hidden it, and every time someone asked about them I changed the subject.",
        "My mom died when I was 4 years old. I grew up with my dad and my twin sister. My father was barely home. My mom's death was hard for him, so he kept himself busy at work. So it was like I grew up with out my dad too. My sister and I grew up alone. We helped each other, and raised each other. It wasn't easy for us to grow with out our parents.",
        "I took a surgery to change sex. All my life I felt that I lived in the wrong body.",
        "I'm alcoholic. I can't start a day without  several drinks. It started when my girlfriend left me a year ago, and I took it very hard. I started drinking once a while, and than every morning. It is hard the make the day throw, but I try to work on it. I'm at a support group, which we help each other. I have a message for the audience, never give up.",
        "My wife and I cant make a baby. We tried for more than a year but it never worked. After we made tests, it turned out that we cant, and never will. So we decided to adopt a 7 years old kid, who could not find a loving home. He is the kindest. We gave him home, and love, and a normal happy family. Looking back, Im happy we could not get a baby, and gave a good life for a lonely kid."
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