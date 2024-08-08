package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText num1,num2,result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        num1=(EditText)findViewById(R.id.number1);
        num2=(EditText)findViewById(R.id.number2);
        result=(EditText)findViewById(R.id.result);

        
    }
    public void btn1(View view) {
        int a1=Integer.parseInt(String.valueOf(num1.getText()));
        int a2=Integer.parseInt(String.valueOf(num2.getText()));
        int sum=a1+a2;
        result.setText(String.valueOf(sum));
    }

    public void btn2(View view) {
        int a1=Integer.parseInt(String.valueOf(num1.getText()));
        int a2=Integer.parseInt(String.valueOf(num2.getText()));
        int sum=a1-a2;
        result.setText(String.valueOf(sum));}

    public void btn3(View view) {
        int a1=Integer.parseInt(String.valueOf(num1.getText()));
        int a2=Integer.parseInt(String.valueOf(num2.getText()));
        int sum=a1/ a2;
        result.setText(String.valueOf(sum));
    }

    public void btn4(View view) {
        int a1=Integer.parseInt(String.valueOf(num1.getText()));
        int a2=Integer.parseInt(String.valueOf(num2.getText()));
        int sum=a1*a2;
        result.setText(String.valueOf(sum));
    }
}