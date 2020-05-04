package com.example.cuteanimalquote;
import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.volley.*; //lets just get everything
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.*; // for later;
//mgarbus2 ericxu2
public class MainActivity extends AppCompatActivity {
    ImageView animalPicture;
    TextView quote;
    TextView instructions;
    Button taphere;
    private String messageToShow;


    //quotes: https://fortunecookie.docs.apiary.io/#reference/cookie/list-all-fortunes?console=1
    //For background music: https://www.tutorialspoint.com/how-to-play-background-music-in-android-app
    //



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        taphere = findViewById(R.id.tapHerePleaseWork);
        // we need a quote box and also a credits box
        instructions = findViewById(R.id.instruction);
        animalPicture = findViewById(R.id.pictureAnimal);
        quote = findViewById(R.id.FortuneText);
        quote.setVisibility(View.VISIBLE);
        animalPicture.setVisibility(View.VISIBLE);
    }

    public void runApi() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String dogUrl = "https://api.thedogapi.com/v1/images/search";
        String apiKey = "06bd0cd7-415f-45f3-848c-0919a7b195af";
        try {
            new Header("x-api-key", apiKey);
            JsonObjectRequest dogRequestAPI = new JsonObjectRequest(Request.Method.GET, dogUrl, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                String doggie = response.get("id").toString();
                                System.out.println(doggie);
                                Log.d("program", "working");
                                // get photo with some program


                            } catch (JSONException e) {
                                Log.e("program", "json exception");
                                System.out.println("oops we got an exception");
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyerror) {
                    Log.d("program", "volley error occured");
                    return;
                }
            });
            //requestQueue.add(dogRequestAPI);
        } catch (Exception e) {
            System.out.println("Header/API key error? IDK");
        }
        try {
            // Here goes fortune code
            // http://yerkee.com/api
            String fortuneUrl = "http://yerkee.com/api/fortune/";
            JsonObjectRequest fortuneRequest = new JsonObjectRequest(Request.Method.GET, fortuneUrl, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                JSONObject fortune = response.getJSONObject("fortune");
                                String message = fortune.getString("fortune");
                                System.out.println(message);
                                messageToShow = message;
                                Log.d("program", "working");
                                // where am i supposed to display the message of the fortune??


                            } catch (JSONException e) {
                                Log.e("program", "json exception");
                                System.out.println("oops we got an exception");
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyerror) {
                    Log.d("program", "volley error occured");
                    return;
                }
            });
            requestQueue.add(fortuneRequest);

            //I don't know what this thing does^
            //Do you know how to display the message after you get the request from the API?

            //http://fortunecookieapi.herokuapp.com/#fortunes-fortune-get for the fortune
            //Perhaps we can store an array of past fortunes and skip ones we have gotten before? Maybe too ambitions
            //for dogs: https://api.thedogapi.com/v1/images/search seems to already do the trick, we just need to visit it each time we want a new dog.
            //background music:
        } catch (Exception e) {
            System.out.print("Whoa, this is a big error");
        }
    }
    public void showEverything(android.view.View view) {
        runApi();
        TextView textViewFortune = findViewById(R.id.FortuneText);
        textViewFortune.setText(messageToShow);
        textViewFortune.setVisibility(View.VISIBLE);
    }
}
