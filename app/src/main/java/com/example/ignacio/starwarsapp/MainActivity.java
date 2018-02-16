package com.example.ignacio.starwarsapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.ignacio.starwarsapp.model.People;
import com.example.ignacio.starwarsapp.model.PeopleResponse;
import com.example.ignacio.starwarsapp.services.ApiCallService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

     public static final String TAG= "MainActivity";

    List<People> peopleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        requestData();

    }

    private void requestData(){
        ApiCallService service = ApiCallService.retrofit.create(ApiCallService.class);
        Call<PeopleResponse> call = service.getCharactersResponse();

        call.enqueue(new Callback<PeopleResponse>() {
            @Override
            public void onResponse(Call<PeopleResponse> call, Response<PeopleResponse> response) {
               peopleList = response.body().getResults();
               DisplayView();
            }

            @Override
            public void onFailure(Call<PeopleResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext() ,t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void DisplayView() {
        DataPeopleAdapter adapter = new DataPeopleAdapter(peopleList, this);
        RecyclerView recyclerView = findViewById(R.id.rvPeople);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(){

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

              boolean  isBottomReached = !recyclerView.canScrollVertically(1);
                Log.i( TAG, "isBottomReached: "+ String.valueOf(isBottomReached) );
            }

        });
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
}
