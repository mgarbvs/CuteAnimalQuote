package com.example.cuteanimalquote;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.volley.*;
import com.android.volley.toolbox.*;

import org.json.*;
//mgarbus2 ericxu2
public class MainActivity extends AppCompatActivity {
    ImageView animalPicture;
    TextView quote;
    TextView instructions;
    int initialNumber;
    private String messageToShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instructions = findViewById(R.id.instruction);
        animalPicture = findViewById(R.id.pictureAnimal);
        quote = findViewById(R.id.FortuneText);
        quote.setText("");
        Button taphere = findViewById(R.id.tapHerePleaseWork);
        initialNumber = 0;
        taphere.setOnClickListener(unused -> {
            runApi();
        });
    }
    void runApi() {
        RequestQueue queue = Volley.newRequestQueue(this);
        //String url = "https://api.thedogapi.com/v1/images/search";
        String url;
        boolean dog;
        String apiCall;
        if (initialNumber % 2 == 0) {
            url = "https://dog.ceo/api/breeds/image/random";
            dog = true;
            apiCall = "message";
            initialNumber = -1;
        } else {
            url = "https://randomfox.ca/floof/?ref=apilist.fun";
            dog = false;
            apiCall = "image";
            initialNumber++;
        }
        //https://randomfox.ca/floof/?ref=apilist.fun
        //String apiKey = "06bd0cd7-415f-45f3-848c-0919a7b195af";
        try {
            //new Header("x-api-key", apiKey);
            JsonObjectRequest dogRequestAPI = new JsonObjectRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Log.d("program", "working");
                            try {
                                //JSONObject id = response
                                if (dog == false) {

                                }
                                String newUrl = response.get(apiCall).toString();
                                Picasso.get().load(newUrl).resize(600,500).centerCrop().into(animalPicture);
                                Log.d("program", "working");
                            } catch (JSONException e) {
                                Log.e("program", "json exception");
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyerror) {
                    Log.d("program", "volley error occured" + volleyerror.toString());
                    return;
                }
            });
            queue.add(dogRequestAPI);
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
                                //JSONObject fortune = response.getJSONObject("fortune");
                                String message = response.get("fortune").toString();
                                System.out.println(message);
                                messageToShow = message;
                                quote.setText(message);
                                System.out.println(message);
                                Log.d("program", "working");
                                // where am i supposed to display the message of the fortune??

                            } catch (JSONException e) {
                                Log.e("program", "json exception");
                                System.out.println("JSON Exception with the quote!" + e.toString());
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyerror) {
                    Log.d("program", "volley error occured");
                    return;
                }
            });
            queue.add(fortuneRequest);
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
}
