package com.e2l.www.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String FileName = "myFile";
    Button BtnSave, BtnRead;
    EditText editName;
    TextView readName;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BtnSave = findViewById(R.id.idBtnSave);
        BtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveFile();
            }
        });
        BtnRead = findViewById(R.id.idBtnRead);
        BtnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readFile();
            }
        });

        editName = findViewById(R.id.idName);
        readName= findViewById(R.id.idReadTxt);
    }

    private void readFile(){
        SharedPreferences sharedPref = getSharedPreferences(FileName, Context.MODE_PRIVATE);
        String defaultValue ="DefaultName";
        String name = sharedPref.getString("name",defaultValue);
        readName.setText(name);
        Toast.makeText(this, "Data = " +name, Toast.LENGTH_SHORT).show();

    }


    private  void saveFile (){

        String strName = editName.getText().toString();
        SharedPreferences sharedPref = getSharedPreferences(FileName,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("name" ,strName);
        editor.commit();
        Toast.makeText(this, "Data Saved Successfully", Toast.LENGTH_SHORT).show();

    }
}
