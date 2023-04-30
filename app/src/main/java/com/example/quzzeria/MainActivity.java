package com.example.quzzeria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
    private void selectButton(AppCompatButton selectedButton)
    {
        String text = String.valueOf(selectedButton.getText());

        switch (text)
        {
            case "Start New" : {

                selectedButton.setOnClickListener(new View.OnClickListener()
                {
                    final AppCompatEditText name = findViewById(R.id.nameOfThePlayer);
                    @Override
                    public void onClick(View view)
                    {
                        name.setVisibility(View.VISIBLE);

                        Intent gamePage = new Intent(MainActivity.this, GamePage.class);
                        gamePage.putExtra("name", name.getText());
                    }
                });

            }

            case "LeaderBoard" : {

            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}