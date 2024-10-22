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

public class Pregunta1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pregunta1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RadioButton radioButton1 = findViewById(R.id.radioButton1);
        RadioButton radioButton2 = findViewById(R.id.radioButton2);
        RadioButton radioButton3 = findViewById(R.id.radioButton3);
        RadioButton radioButton4 = findViewById(R.id.radioButton4);

        Button button = findViewById(R.id.buttonSubmit4);
        button.setOnClickListener(new View.OnClickListener() {
            int points = 0;
            String page = "1";

            @Override
            public void onClick(View view) {
                String selectedText = "Null";

                if(radioButton1.isChecked())
                    selectedText = radioButton1.getText().toString();
                else if(radioButton2.isChecked())
                    selectedText = radioButton2.getText().toString();
                else if(radioButton3.isChecked())
                    selectedText = radioButton3.getText().toString();
                else if(radioButton4.isChecked())
                    selectedText = radioButton4.getText().toString();

                if(selectedText.equals("Roma")){
                    Toast.makeText(Pregunta1.this,"Correcto", Toast.LENGTH_LONG).show();
                    Intent myIntent = new Intent(Pregunta1.this, Pregunta2.class);
                    points+=3;
                    myIntent.putExtra("myPoints", points);
                    startActivity(myIntent);
                } else if(selectedText.equals("Null")){
                    Toast.makeText(Pregunta1.this,"Seleccione algo", Toast.LENGTH_LONG).show();
                } else{
                    Toast.makeText(Pregunta1.this,"Incorrecto", Toast.LENGTH_LONG).show();
                    Intent myIntent = new Intent(Pregunta1.this, RespuestaNo.class);
                    points-=2;
                    myIntent.putExtra("myPoints", points);
                    myIntent.putExtra("myPage", page);
                    startActivity(myIntent);
                }
            }
        });
    }
}