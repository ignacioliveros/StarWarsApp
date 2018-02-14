package com.example.ignacio.starswarsapp;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ignacio.starswarsapp.model.People;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Ignacio on 2/13/2018.
 */

public class DataPeopleAdapter extends RecyclerView.Adapter<DataPeopleAdapter.ViewHolder> {

    public static final String PEOPLE_NAME_KEY = "people_name_key";
    private List<People> peopleList;
    private Context context;

    public DataPeopleAdapter(List<People> peopleList, Context context) {
        this.peopleList = peopleList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.list_characters, parent,false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
           final People people= peopleList.get(position);

        AssetManager assetManager = context.getAssets();

        try {
            holder.name.setText(people.getName());
            InputStream stream = assetManager.open(people.getName()+".jpg");
            Drawable d= Drawable.createFromStream(stream,null);
            holder.imageView.setImageDrawable(d);
        } catch (IOException e) {
            e.printStackTrace();
        }

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String name = people.getName();
                Intent intent = new Intent(context,DetailActivity.class);
                intent.putExtra(PEOPLE_NAME_KEY, name);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return peopleList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView name;
        public ImageView imageView;
        public View view;

        public ViewHolder(View itemView) {
            super(itemView);

            name= itemView.findViewById(R.id.nameTextView);
            imageView= itemView.findViewById(R.id.imageView);
            view= itemView;
        }
    }

}
