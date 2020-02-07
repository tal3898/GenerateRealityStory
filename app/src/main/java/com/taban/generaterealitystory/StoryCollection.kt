package com.taban.generaterealitystory

import java.util.*
import kotlin.collections.ArrayList

class StoryCollection {

    var stories = ArrayList(Arrays.asList("I have two fathers. I have been bullied since I was 8 years old, for 4 years! At the age 12, I decided to change school, and never told about my parents. I have always hidden it, and every time someone asked about them I used to change the subject. Only recently I ",
        "My mom died when I was 4 years old. I dont remember anything of her, except the night time, when she was telling me night stories. I dont even remember the stories. But I remember the feeling she made me feel. I remember I felt safe. It was hard to grow with out a mother. My dad had to raise and support 2 children, alone. I used to make it hard for him. I skipped classes, got bad grades... ",
        "My mom died when I was 4 years old. I grew up with my dad and my twin sister. My father was barely home. My mom death was hard for him, so he kept himself busy at work. So it was like to grow up with out my dad too. My sister and I grew up alone. We helped each other, and raised each other. It wasn't easy for us to grow with out our parents."
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