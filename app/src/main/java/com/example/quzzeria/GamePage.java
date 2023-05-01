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
    int isPressed = 0;
    private void setQuestion(String Question)
    {
        AppCompatTextView QuestionBox = findViewById(R.id.GivenQuestion);
        QuestionBox.setText(Question);
    }

    private int setAnswers(ArrayList<String> Answers)
    {
        ListView ansList = findViewById(R.id.AnsOptions);
        ArrayAdapter<String> options = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Answers);
        ansList.setAdapter(options);

        final int[] num = new int[1];

        ansList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                num[0] = i;
                Toast.makeText(getApplicationContext(), "Pressed", Toast.LENGTH_SHORT).show();
                isPressed++;
            }
        });

        return num[0];
    }
    int marks = 0;
    @SuppressLint("SetTextI18n")
    private void setScore(boolean ans)
    {
        AppCompatTextView score = findViewById(R.id.Score);

        if(ans)
            marks++;

        score.setText(marks+"/10");
    }
    private void setNewQuestions()
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);
        QuestionAnswers q1 = new QuestionAnswers();
        ArrayList<String> getSet;
        ArrayList<QuestionAnswers> questionAnswers = new ArrayList<>();


        getSet = q1.answerRandomizer();

        setQuestion(getSet.get(0));

        ArrayList<String> ans = new ArrayList<>();

        for(int i = 1; i<getSet.size(); i++)
        {
            ans.add(getSet.get(i));
        }


        setScore(q1.checkAns(getSet.get(setAnswers(ans))));


    }
}