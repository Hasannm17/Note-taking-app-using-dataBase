package com.example.noteur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {
EditText title;
EditText description;
Button cancel;
Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Add Note");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_add_note);

title=findViewById(R.id.editTextTitle);
description=findViewById(R.id.editTextDesc);
cancel=findViewById(R.id.buttonCancel);
save=findViewById(R.id.buttonSave);


cancel.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Toast.makeText(getApplicationContext(), "Nothing saved", Toast.LENGTH_SHORT).show();


    }
});


save.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {



saveNote();


    }
});
    }







    public void saveNote(){

        String noteTitle=title.getText().toString();
        String noteDescription=description.getText().toString();

        Intent i =new Intent();
        i.putExtra("noteTitle",noteTitle);
        i.putExtra("notedescription",noteDescription);
        setResult(RESULT_OK,i);
finish();

    }






}