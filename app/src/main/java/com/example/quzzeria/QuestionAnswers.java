package com.example.quzzeria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class QuestionAnswers
{
    private String ans;
    private String getQuestion(int num)
    {
        HashMap<Integer, String> questionBank = new HashMap<>();
        questionBank.put(1, "What is the name of the anime series about a group of high school students who use their newly acquired superpowers to battle evil?");
        questionBank.put(2, "In which anime do the characters attend a school for assassins, where they must kill their classmates to graduate?");
        questionBank.put(3, "What is the name of the anime series about a young boy who gains the ability to see supernatural creatures after a near-death experience?");
        questionBank.put(4, "In which anime series do the characters explore a world where humans and supernatural beings coexist, while solving various supernatural cases?");
        questionBank.put(5, "What is the name of the anime series about a high school student who gains the ability to time travel and tries to change his past mistakes?");
        questionBank.put(6, "In which anime do the characters use a virtual reality MMORPG to escape their mundane lives, only to find themselves trapped inside the game?");
        questionBank.put(7, "What is the name of the anime series about a young girl who joins a group of soldiers fighting against giant humanoid creatures that threaten humanity?");
        questionBank.put(8, "In which anime series do the characters attend a school for exorcists, where they battle demons and other supernatural beings?");
        questionBank.put(9, "What is the name of the anime series about a group of people who are reincarnated into a fantasy world and must defeat the demon king to return home?");
        questionBank.put(10, "In which anime series do the characters use a special notebook that can kill anyone whose name is written in it, leading to a cat-and-mouse game between a high school student and a mysterious detective?");

        return questionBank.get(num);
    }

    private String getAnswer(int num)
    {
        HashMap<Integer, String> answerKey = new HashMap<>();

        answerKey.put(1, "My Hero Academia");
        answerKey.put(2, "Assassination Classroom");
        answerKey.put(3, "Natsume's Book of Friends");
        answerKey.put(4, "Bungo Stray Dogs");
        answerKey.put(5, "Erased");
        answerKey.put(6, "Sword Art Online");
        answerKey.put(7, "Attack on Titan");
        answerKey.put(8, "Blue Exorcist");
        answerKey.put(9, "Re:Zero − Starting Life in Another World");
        answerKey.put(10, "Death Note");

        return answerKey.get(num);
    }
    public ArrayList<String> answerRandomizer()
    {
        Random q_num = new Random();
        int a = q_num.nextInt(10)+1;

        ArrayList<String> set = new ArrayList<>();

        set.add(getQuestion(a));
        set.add(getAnswer(a));
        set.add(getAnswer(q_num.nextInt(10)+1));
        set.add(getAnswer(q_num.nextInt(10)+1));
        set.add(getAnswer(q_num.nextInt(10)+1));

        ans = getAnswer(a);

        return set;
    }

    public boolean checkAns(String Ans)
    {
        return ans.equals(Ans);
    }
}
