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

public class Pregunta4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pregunta4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        RadioButton radioButton5 = findViewById(R.id.radioButton5);
        RadioButton radioButton6 = findViewById(R.id.radioButton6);
        RadioButton radioButton7 = findViewById(R.id.radioButton7);
        RadioButton radioButton8 = findViewById(R.id.radioButton8);

        Button button = findViewById(R.id.buttonSubmit4);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedText = "Null";

                if(radioButton5.isChecked())
                    selectedText = radioButton5.getText().toString();
                else if(radioButton6.isChecked())
                    selectedText = radioButton6.getText().toString();
                else if(radioButton7.isChecked())
                    selectedText = radioButton7.getText().toString();
                else if(radioButton8.isChecked())
                    selectedText = radioButton8.getText().toString();

                if(selectedText.equals("Florencia")){
                    Toast.makeText(Pregunta4.this,"Correct", Toast.LENGTH_LONG).show();
                    Intent intent = getIntent();
                    int points = intent.getIntExtra("myPoints",0);
                    Intent myIntent = new Intent(Pregunta4.this, Pregunta5.class);
                    points+=3;
                    myIntent.putExtra("myPoints", points);
                    startActivity(myIntent);
                } else if(selectedText.equals("Null")){
                    Toast.makeText(Pregunta4.this,"Select something bro", Toast.LENGTH_LONG).show();
                } else{
                    Toast.makeText(Pregunta4.this,"Incorrect", Toast.LENGTH_LONG).show();
                    Intent intent = getIntent();
                    int points = intent.getIntExtra("myPoints",0);
                    String page = "4";

                    Intent myIntent = new Intent(Pregunta4.this, RespuestaNo.class);
                    points-=2;
                    myIntent.putExtra("myPoints", points);
                    myIntent.putExtra("myPage", page);
                    startActivity(myIntent);
                }
            }
        });
    }
}