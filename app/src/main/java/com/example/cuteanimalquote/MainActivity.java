package com.example.cuteanimalquote;
import android.content.Context;
//import com.android.volley.*; //need to add volley to out library
import com.android.volley.*; // ????

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import org.json.*; // for later;
//mgarbus2 ericxu2
public class MainActivity extends AppCompatActivity {
    ImageView animalPicture;
    TextView quote;
    TextView instructions;
    Button taphere;

    //the plan: cute animal and a meme quote maybe? And then have it read aloud?
    // Perhaps we could have some nice music playing in the background too. https://developers.deezer.com/login?redirect=/api
    //quotes: https://fortunecookie.docs.apiary.io/#reference/cookie/list-all-fortunes?console=1
    //For background music: https://www.tutorialspoint.com/how-to-play-background-music-in-android-app
    //



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        taphere = findViewById(R.id.tapHerePleaseWork); // why doesnt this work?????????????????????????????/ it works now???
        // we need a quote box
        instructions = findViewById(R.id.instruction);
        animalPicture = findViewById(R.id.pictureAnimal);

    }

    public void runApi() {
        //http://fortunecookieapi.herokuapp.com/#fortunes-fortune-get for the fortune
        //Perhaps we can store an array of past fortunes and skip ones we have gotten before? Maybe too ambitions
        //for dogs: https://api.thedogapi.com/v1/images/search seems to already do the trick, we just need to visit it each time we want a new dog.
        //background music:
    }
}
