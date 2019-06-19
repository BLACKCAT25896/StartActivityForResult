package com.example.safr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        setTitle("Activity 2");

        Intent intent = getIntent();
        final int number1 = intent.getIntExtra("number1",0);
        final int number2 = intent.getIntExtra("number2",0);

        TextView textViewNumbers = findViewById(R.id.text_View_Numbers);
        textViewNumbers.setText("Numbers: " + number1 +"," + number2);

        Button add = findViewById(R.id.add);
        Button sub = findViewById(R.id.sub);
        Button mul = findViewById(R.id.mul);
        Button div = findViewById(R.id.div);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int result = number1 + number2;
                Intent resultIntent = new Intent();

                resultIntent.putExtra("result", result);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });



        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = number1 - number2;
                Intent resultIntent = new Intent();

                resultIntent.putExtra("result", result);
                setResult(RESULT_OK, resultIntent);
                finish();

            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = number1 * number2;
                Intent resultIntent = new Intent();

                resultIntent.putExtra("result", result);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = number1 / number2;
                Intent resultIntent = new Intent();

                resultIntent.putExtra("result", result);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });


    }
}
