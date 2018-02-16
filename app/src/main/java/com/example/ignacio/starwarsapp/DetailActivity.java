package com.example.ignacio.starwarsapp;

import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ignacio.starwarsapp.model.People;

import java.io.IOException;
import java.io.InputStream;

public class DetailActivity extends AppCompatActivity {

    People people;
    ImageView photo;
    TextView name;
    TextView height;
    TextView eyeColor;
    TextView skin;
    TextView hair;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        people = getIntent().getExtras().getParcelable(DataPeopleAdapter.PEOPLE_KEY);

        name = findViewById(R.id.nameTextView);
        name.setText(people.getName());

        height = findViewById(R.id.heightTextView);
        height.setText("Height: "+String.valueOf(people.getHeight()));

        eyeColor =  findViewById(R.id.eyeColorTextView);
        eyeColor.setText("Eye Color: " + people.getEyeColor());

        skin= findViewById(R.id.skinColorTextView);
        skin.setText("Skin Color: " + people.getSkinColor());

        hair = findViewById(R.id.hairColorTextView);
        hair.setText("Hair Color: "+people.getHairColor());

        AssetManager assetManager = getBaseContext().getAssets();
        InputStream stream;
        try {
            stream = assetManager.open(people.getName()+".jpg");
            Drawable d= Drawable.createFromStream(stream,null);
            photo = findViewById(R.id.photoImageView);
            photo.setImageDrawable(d);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
