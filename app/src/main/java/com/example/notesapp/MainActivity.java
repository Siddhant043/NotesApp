package com.example.notesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static ArrayList<String> notes = new ArrayList<>();
    static ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView); // creating a list view
        notes.add("Example Note");
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, notes); // creating a layout view adapter and passing the array
        listView.setAdapter(arrayAdapter); //linking the list view with our adapter
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // setting when an item is clicked
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), NoteEditActivity.class); // we create an intent and call nodeEdit activity
                intent.putExtra("noteId", position); // we pass the noteId to the position
                startActivity(intent); //starting the activity when a item is clicked

            }
        });
    }
}