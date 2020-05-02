package com.example.cuteanimalquote;
import android.content.Context;
// import com.android.volley.*; need to add volley to out library

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
//mgarbus2 ericxu2
public class MainActivity extends AppCompatActivity {
    ImageView animalPicture;
    TextView quote;
    TextView instructions;
    Button taphere;

    //the plan: cute animal and a meme quote maybe? And then have it read aloud?
    // Perhaps we could have some nice music playing in the background too. https://developers.deezer.com/login?redirect=/api
    //Options: https://random.dog/, https://aws.random.cat/view/89,
    //Other ideas: Movie reccomender
    //Random book from libgen http://garbage.world/posts/libgen/



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        taphere = findViewById(R.id.tapHerePleaseWork); // why doesnt this work?????????????????????????????/ it works now???
        // we need a quote box
        instructions = findViewById(R.id.instruction);
        animalPicture = findViewById(R.id.pictureAnimal);

    }
}
