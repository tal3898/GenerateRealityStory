package com.taban.generaterealitystory

import java.util.*
import kotlin.collections.ArrayList

class StoryCollection {

    var stories = ArrayList(Arrays.asList("I have two fathers. I have been bullied since I was 8 years old, for 4 years! At the age 12, I decided to switch school, and never told about my parents. I have always hidden it, and every time someone asked about them I changed the subject.",
        "My mom died when I was 4 years old. I grew up with my dad and my twin sister. My father was barely home. My mom's death was hard for him, so he kept himself busy at work. So it was like I grew up with out my dad too. My sister and I grew up alone. We helped each other, and raised each other. It wasn't easy for us to grow with out our parents.",
        "I am a transgender. All my life I felt that I lived in the wrong body.",
        "I'm alcoholic. I can't start a day without  several drinks. It started when my girlfriend left me a year ago, and I took it very hard. I started drinking once a while, and than every morning. It is hard the make the day throw, but I try to work on it. I'm at a support group, which we help each other. I have a message for the audience, never give up.",
        "My wife and I cant make a baby. We tried for more than a year but it never worked. After we made tests, it turned out that we cant, and never will. So we decided to adopt a 7 years old kid, who could not find a loving home. He is the kindest. We gave him home, and love, and a normal happy family. Looking back, Im happy we could not get a baby, and gave a good life for a lonely kid.",
        "I lost my best friend a couple years ago. He was 19 years old when it happened. When I got the call from the hospital, I came as fast as I could. He was involved in a car accident. When I came to the hospital, he was unconscious. After a while, he got up for an hour. We talked a lot, and the doctor said he wont gonna make it. We said goodbye for each other, and I stayed with him in his last minutes.",
        "During my life, I was surrounded by people who don't believe in me. I wasn't good at school, there were teachers who told me that I wont succeed in life. And as A kid, it really influence me, and decreased my confidence. When I decided to form a band, everyone told me that the music industry will eat me alive and I don't have a chance. But that time I never listen to them, and never gave up.",
        "I lost my hearing when I was 14 years old. I used to play a piano before the accident. After the accident, it was hard for me to get back to music, and I quit. But I could'nt stop playing, so I started to memorize the notes, by visual tuners etc. and now I enjoy playing the piano like I enjoyed before.",
        "I suffer from anxiety and depression attacks. There are months that I don't leave my house, and stay in bed, and feel that I don't wanna be here anymore. I have a loving family who helps me in those difficult times, and I try to wake up, every morning with a smile.",
        // silly stories
        "I am 7 years old. I may look like 20+ years old, but really, it is 7. I am at second grade, and everyone laugh at me because I look old. The teachers even laugh at me and think I am another teacher. Everyday I come home and cry, and ask for my parents to skip school some days. They tell me I look like a grown up, so I need to act like a grown up. I hate them",
        "I am a TikTok star. Everybody loves me. Everyday, I make about 20 new tik toks. I have a butler which go out for me and by me things, because I cant get out of my house without people want a selfie with me. It is the worse.",
        "I lost all my senses. I cant see, I cant hear, I cant smell, I cant taste, and I cant feel. There is an my brain is used by AI Machine that helps me with day to day tasks. Like speaking, it speaks for me. It helps me to hear. At school, kids used to call me cyborg, and bullied me. It was a hard time for me.",
        "When I was a kid my mom died 7 times. Every time she dies, it is worse that the one before. She is cursed, so once a year she die, and go back to life. Every time she come back to life, the whole family hope the curse go away to someone else. We are afraid that she will die, and will never wake up.",
        "I have one mom and two dads. My mom didn't know who is the father so she married both of them. When I was a kid all my kids laughed at me, and bullied me. I forgot to keep it in secret, so I changed school every year. So I kept telling it, and kept suffering from bulling. So it was hard for me the have friends.",
        "I am from the future. I am 18 years old, and I was born in 2304. In the future there is a time machine, which only people over 18+ can travel in time. It is my first ride and I am very excited. For the first ride I decided to go to your show, and show you what people from the future are capable of.",
        "I am the oldest person alive. I am 212 years old, and look like 20. People dont believe me when I tell them this, but it is true. "


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