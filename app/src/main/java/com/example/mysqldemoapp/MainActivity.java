package com.example.mysqldemoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText t1;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = findViewById(R.id.t1);
        textView = findViewById(R.id.tv);

    }

    public void addData(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("datafile",MODE_PRIVATE);
        SharedPreferences.Editor  editor = sharedPreferences.edit();
        editor.putString("username",t1.getText().toString());
        editor.commit();
        t1.setText("");
        Toast.makeText(this,"Added",Toast.LENGTH_SHORT).show();
    }

    public void viewData(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("datafile",MODE_PRIVATE);
        if(sharedPreferences.contains("username")){
            textView.setText(sharedPreferences.getString("username",""));
        }else{
            textView.setText("");
            Toast.makeText(this,"Data not found",Toast.LENGTH_SHORT).show();
        }
    }

    public void deleteData(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("datafile",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if(sharedPreferences.contains("username")){
            editor.remove("username");
            editor.commit();
            textView.setText("");
            Toast.makeText(this,"Deleted successfully",Toast.LENGTH_SHORT).show();
        }

    }
}