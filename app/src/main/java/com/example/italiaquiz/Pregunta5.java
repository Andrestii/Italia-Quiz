package com.example.italiaquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Pregunta5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pregunta5);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        RadioButton radioButton9 = findViewById(R.id.radioButton9);
        RadioButton radioButton10 = findViewById(R.id.radioButton10);
        RadioButton radioButton11 = findViewById(R.id.radioButton11);
        RadioButton radioButton12 = findViewById(R.id.radioButton12);

        Button button = findViewById(R.id.buttonSubmit5);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedText = "Null";

                if(radioButton9.isChecked())
                    selectedText = radioButton9.getText().toString();
                else if(radioButton10.isChecked())
                    selectedText = radioButton10.getText().toString();
                else if(radioButton11.isChecked())
                    selectedText = radioButton11.getText().toString();
                else if(radioButton12.isChecked())
                    selectedText = radioButton12.getText().toString();

                if(selectedText.equals("Verde, blanco y rojo")){
                    Toast.makeText(Pregunta5.this,"Correct", Toast.LENGTH_LONG).show();
                    Intent intent = getIntent();
                    int points = intent.getIntExtra("myPoints",0);
                    Intent myIntent = new Intent(Pregunta5.this, Final.class);
                    points+=3;
                    myIntent.putExtra("myPoints", points);
                    startActivity(myIntent);
                } else if(selectedText.equals("Null")){
                    Toast.makeText(Pregunta5.this,"Select something bro", Toast.LENGTH_LONG).show();
                } else{
                    Toast.makeText(Pregunta5.this,"Incorrect", Toast.LENGTH_LONG).show();
                    Intent intent = getIntent();
                    int points = intent.getIntExtra("myPoints",0);
                    String page = "5";

                    Intent myIntent = new Intent(Pregunta5.this, RespuestaNo.class);
                    points-=2;
                    myIntent.putExtra("myPoints", points);
                    myIntent.putExtra("myPage", page);
                    startActivity(myIntent);
                }
            }
        });
    }
}