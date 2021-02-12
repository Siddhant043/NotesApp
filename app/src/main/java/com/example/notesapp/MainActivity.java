package com.example.notesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { // linking menu with menu inflater
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) { //what to do when someone selects the items
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case R.id.settings:
                Log.i("Item selected", "Settings");
                return true;
            case R.id.help:
                Log.i("Item selected", "Help");
                return true;
            default:
                return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.notesapp", Context.MODE_PRIVATE);
//        ArrayList<String> friends = new ArrayList<>();
//        friends.add("Nick");
//        friends.add("Jones");
//        friends.add("Angela");
//        try {
//            sharedPreferences.edit().putString("friends", ObjectSerializer.serialize(friends)).apply();
//            Log.i("Serialized String", sharedPreferences.getString("friends","")); //doing serialization
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        ArrayList<String> newFriends = new ArrayList<>();
//        try {
//            newFriends = (ArrayList<String>) ObjectSerializer.deserialize(sharedPreferences.getString("friends", ObjectSerializer.serialize(new ArrayList<String>())));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        Log.i("New Friends", newFriends.toString()); //deserialization process

//        sharedPreferences.edit().putString("username", "siddhant").apply();
//        String username  = sharedPreferences.getString("username", "");
//        Log.i("Value", username);
    }
}