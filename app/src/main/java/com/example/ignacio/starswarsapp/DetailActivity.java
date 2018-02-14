package com.example.ignacio.starswarsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String name = getIntent().getExtras().getString(DataPeopleAdapter.PEOPLE_NAME_KEY);
        Toast.makeText(this,"Name: "+name,Toast.LENGTH_LONG).show();
    }
}
