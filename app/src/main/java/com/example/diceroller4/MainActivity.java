package com.example.diceroller4;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;


import java.util.Random;

public class MainActivity extends AppCompatActivity {


    int scoreCount;
    TextView scoreView;

    final String[] questions = {
            "If you could go anywhere in the world, where would you go?",
            "If you were stranded on a desert island, what 3 things what you want to take with you?",
            "If you could eat only one food for the rest of your life, what would it be?",
            "If you won a million pounds, what is the first thing you would buy?",
            "If you could spend the day with one fictional character, who would it be?",
            "If you found a magic lantern and a genie gave you 3 wishes, what would it wish?"

    };

    TextView displayQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        scoreCount = 0;

        scoreView = (TextView) findViewById(R.id.score);
        scoreView.setText("Score: " + scoreCount);

        displayQuestions = findViewById(R.id.displayQuestions);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void buttonOnClick(View v) {

        Button newDicebreaker = (Button) v;
        startActivity(new Intent(getApplicationContext(),Activity2.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);

    }


    public void on_button_click(View view) {

        try {
            EditText editText = (EditText) findViewById(R.id.numberInput);

            String numIn = (editText.getText().toString());
            int numberInt = Integer.parseInt(numIn);

            if ((numberInt < 1) || (numberInt > 6)) {
                throw new IllegalArgumentException("Number must be between 1 and 6");
            }

            TextView tv = this.findViewById(R.id.numberTextView);
            tv.setText("The button has been pressed by the user");

            Random r = new Random();
            int number = r.nextInt((6 - 1) + 1) + 1;

            tv.setText(Integer.toString(number));

            compare(numberInt, number);

        } catch (Exception e) {

            Toast.makeText(MainActivity.this, "Please Enter a Number Above Between 1 and 6! ", Toast.LENGTH_SHORT).show();


        }

    }


    public void compare(int y, int z) {
        if (y == z) {
            Toast.makeText(MainActivity.this, "Congratulations! Numbers match!", Toast.LENGTH_SHORT).show();
            scoreIncrementer();
        } else {
            Toast.makeText(MainActivity.this, "Error! Numbers do not match!", Toast.LENGTH_SHORT).show();
        }
    }





        public void scoreIncrementer ()
        {
            scoreCount++;
            scoreView.setText("Score: " + scoreCount);
        }

        public void dicebreaker_button(View view){
            Random a = new Random();
            displayQuestions.setText(questions[a.nextInt(questions.length)]);


        }

    }


