package com.example.quzzeria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class GamePage extends AppCompatActivity
{
    private void setQuestion(String Question)
    {
        AppCompatTextView QuestionBox = findViewById(R.id.GivenQuestion);
        QuestionBox.setText(Question);
    }
    final int[] num = new int[1];
    private void setAnswers(ArrayList<String> Answers)
    {
        ListView ansList = findViewById(R.id.AnsOptions);
        ArrayAdapter<String> options = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Answers);
        ansList.setAdapter(options);



        ansList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                num[0] = i;
                setScore();
                newQuesAns();
            }
        });
    }
    int marks = 0;
    ArrayList<String> getSet;
    QuestionAnswers q1 = new QuestionAnswers();
    ArrayList<String> finishedQuestions = new ArrayList<>();
    @SuppressLint("SetTextI18n")
    private void setScore()
    {
        AppCompatTextView score = findViewById(R.id.Score);

        if (q1.checkAns(getSet.get(num[0] + 1)))
        {
            Toast.makeText(getApplicationContext(), "Pressed", Toast.LENGTH_SHORT).show();
            marks++;
        }


        score.setText(marks+"/10");
    }

    //ArrayList<QuestionAnswers> questionAnswers = new ArrayList<>();
    private void newQuesAns()
    {
        ArrayList<String> ans = new ArrayList<>();

        getSet = q1.answerRandomizer();

        for(String e : finishedQuestions)
        {
            if(e == null || !e.equals(getSet.get(0)))
                setQuestion(getSet.get(0));
            else
            {
                getSet = q1.answerRandomizer();
                setQuestion(getSet.get(0));
            }
        }

        finishedQuestions.add(getSet.get(0));

        for(int i = 1; i<getSet.size(); i++)
        {
            ans.add(getSet.get(i));
        }
        setAnswers(ans);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);

        newQuesAns();



        //setScore(q1.checkAns(getSet.get(setAnswers(ans))));

    }
}