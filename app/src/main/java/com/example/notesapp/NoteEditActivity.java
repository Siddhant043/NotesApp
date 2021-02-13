package com.example.notesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class NoteEditActivity extends AppCompatActivity {
    int noteId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_edit);

        EditText editText = findViewById(R.id.editText);
        Intent intent = getIntent(); // getting the passed activity
        noteId = intent.getIntExtra("noteId", -1); //getting the nodeId value out of it
        if(noteId != -1){
            editText.setText(MainActivity.notes.get(noteId)); // passing the position of the tapped item to access particular location string in array
        } else{
            MainActivity.notes.add("");
            noteId = MainActivity.notes.size() - 1;
        }
        editText.addTextChangedListener(new TextWatcher() { // used to update the text on list when the text inside it is changed
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                MainActivity.notes.set(noteId, String.valueOf(s)); // here the text is changed of a particular noteId
                MainActivity.arrayAdapter.notifyDataSetChanged(); // here we notify it back to change
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}