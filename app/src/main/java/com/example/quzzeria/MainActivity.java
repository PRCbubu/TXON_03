package com.example.quzzeria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity
{
    private void MakeToast(String msg)
    {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
    private void selectButton(AppCompatButton selectedButton)
    {

        if (selectedButton.getId() == R.id.StartNew)
        {
            final AppCompatEditText name = findViewById(R.id.nameOfThePlayer);
            final AppCompatButton enter = findViewById(R.id.Enter);
            name.setVisibility(View.VISIBLE);
            enter.setVisibility(View.VISIBLE);

            enter.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    try
                    {
                        String temp = name.getText().toString();
                        if(temp.isEmpty())
                            MakeToast("Enter name");
                        else
                        {
                            Intent gamePage = new Intent(MainActivity.this, GamePage.class);
                            MainActivity.this.startActivity(gamePage);
                            gamePage.putExtra("Name", name.getText());
                        }
                    }
                    catch (NullPointerException e)
                    {
                        MakeToast(""+e);
                    }

                }
            });
        }
        else if (selectedButton.getId() == R.id.ScoreBoard)
        {
            Intent ScorePage = new Intent(MainActivity.this, ScoreBoard.class);
            MainActivity.this.startActivity(ScorePage);
        }
        else
        {
            Intent SettingsPage = new Intent(MainActivity.this, Settings.class);
            MainActivity.this.startActivity(SettingsPage);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<AppCompatButton> menuButtons = new ArrayList<>();

        menuButtons.add(findViewById(R.id.StartNew));
        menuButtons.add(findViewById(R.id.ScoreBoard));
        menuButtons.add(findViewById(R.id.Settings));

        for(AppCompatButton selectedButton : menuButtons)
        {
            selectedButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    selectButton(selectedButton);
                }
            });
        }

    }
}