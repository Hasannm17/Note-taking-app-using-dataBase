package com.example.noteur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    EditText title;
    EditText description;
    Button cancel;
    Button save;
    int noteid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("EditNote");

        setContentView(R.layout.activity_update);
        title=findViewById(R.id.editTextTitleUpdate);
        description=findViewById(R.id.editTextDescUpdate);
        cancel=findViewById(R.id.buttonCancelUpdate);
        save=findViewById(R.id.buttonSaveUpdate);
getData();

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Nothing Updated", Toast.LENGTH_SHORT).show();


            }
        });


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                UpdateNote();



            }});





    }

    private void UpdateNote() {

String titlelast=title.getText().toString();
String descriptionLast=description.getText().toString();
Intent intent=new Intent();
intent.putExtra("titleLast",titlelast);
intent.putExtra("descriptionlast",descriptionLast);
if(noteid != -1){

    intent.putExtra("noteId", noteid);
    setResult(RESULT_OK,intent);
    finish();

}


    }
    public void getData(){

        Intent i=getIntent();
 noteid =i.getIntExtra("id",-1);
    String notetitle=    i.getStringExtra("title");
      String notedescription=   i.getStringExtra("description");


      title.setText(notetitle);
      description.setText(notedescription);
    }


}
