package com.example.safr;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText num1;
    private EditText num2;
    private TextView res;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Start_Activity_For_Result");

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        res = findViewById(R.id.res);
        next = findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(num1.getText().toString().equals("") || num2.getText().toString().equals("")){


                    Toast.makeText(MainActivity.this, "input number please", Toast.LENGTH_SHORT).show();

                }
                else {

                    int number1 = Integer.parseInt(num1.getText().toString());

                    int number2 = Integer.parseInt(num2.getText().toString());



                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                    intent.putExtra("number1", number1);
                    intent.putExtra("number2",number2);

                    startActivityForResult(intent, 1);


                }




            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==  1){
            if(resultCode == RESULT_OK)
            {
                int result = data.getIntExtra("result", 0);
                res.setText("Result is : " + result);
            }
            if(resultCode == RESULT_CANCELED){
                res.setText("Nothing Selected");
            }
        }
    }
}
