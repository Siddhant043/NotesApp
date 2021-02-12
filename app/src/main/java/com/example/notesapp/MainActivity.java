package com.example.notesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.notesapp", Context.MODE_PRIVATE);
        ArrayList<String> friends = new ArrayList<>();
        friends.add("Nick");
        friends.add("Jones");
        friends.add("Angela");
        try {
            sharedPreferences.edit().putString("friends", ObjectSerializer.serialize(friends)).apply();
            Log.i("Serialized String", sharedPreferences.getString("friends","")); //doing serialization
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<String> newFriends = new ArrayList<>();
        try {
            newFriends = (ArrayList<String>) ObjectSerializer.deserialize(sharedPreferences.getString("friends", ObjectSerializer.serialize(new ArrayList<String>())));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.i("New Friends", newFriends.toString()); //deserialization process

//        sharedPreferences.edit().putString("username", "siddhant").apply();
//        String username  = sharedPreferences.getString("username", "");
//        Log.i("Value", username);
    }
}