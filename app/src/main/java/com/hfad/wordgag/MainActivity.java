package com.hfad.wordgag;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.Random;
import android.widget.Toast;
import android.content.pm.ActivityInfo;
//http://www.colorcombos.com/color-schemes/60/ColorCombo60.html

public class MainActivity extends AppCompatActivity {

    ArrayList<Integer> used = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // Prevents screen rotation
    }

    public void onSubmit(View v) {
        EditText noun = (EditText) findViewById(R.id.noun);
        String getNoun = noun.getText().toString().toLowerCase().trim();
        EditText verb = (EditText) findViewById(R.id.verb);
        String getVerb = verb.getText().toString().toLowerCase().trim();
        EditText adjective = (EditText) findViewById(R.id.adjective);
        String getAdjective = adjective.getText().toString().toLowerCase().trim();

        // This checks to make sure that all the fields have been properly filled in.
        if(getNoun.isEmpty() || getVerb.isEmpty() || getAdjective.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Fill in all fields!", Toast.LENGTH_LONG).show();
        }
        else if(!getVerb.substring(getVerb.length() - 3).equals("ing") && getVerb.length() >= 3) {
            Toast.makeText(getApplicationContext(), "Enter a verb ending in -ing!", Toast.LENGTH_LONG).show();
        }
        else {
            Random rand = new Random();
            int n = rand.nextInt(8); // Gives n such that 0 <= n < 8

            boolean isUsed = false;
            boolean keepGoing = true;

            // This checks whether a character has already been used.
            // This is to prevent constant repeats of the same character thus spawning a new character each time.
            // Once all characters have been used, the ArrayList is cleared and starts over again.
            if(used != null && used.size() == 8) {
                used.clear();
                used.add(n);
            }
            else if(used != null && used.size() < 8) {
                while (keepGoing) {
                    for (int temp : used) {
                        if (temp == n) {
                            isUsed = true;
                        }
                    }

                    if (isUsed) {
                        n = rand.nextInt(8);
                        isUsed = false;
                    }
                    else {
                        used.add(n);
                        keepGoing = false;
                    }
                }
            }

            //Intent is used to pass the words and the randomly generated number to the second activity.
            Intent intent = new Intent(this, SecondActivity.class);
            Bundle extras = new Bundle();
            extras.putString("EXTRA_NOUN", getNoun);
            extras.putString("EXTRA_VERB", getVerb);
            extras.putString("EXTRA_ADJECTIVE", getAdjective);
            extras.putInt("n", n);
            intent.putExtras(extras);
            startActivity(intent);
        }
    }

    public void onClear(View v) {
        EditText noun = (EditText) findViewById(R.id.noun);
        EditText verb = (EditText) findViewById(R.id.verb);
        EditText adjective = (EditText) findViewById(R.id.adjective);

        noun.getText().clear();
        verb.getText().clear();
        adjective.getText().clear();
    }
}