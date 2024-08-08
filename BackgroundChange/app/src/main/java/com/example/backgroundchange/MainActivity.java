package com.example.backgroundchange;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private ConstraintLayout mainLayout;
    private Button button;
    private View tectarea;
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
        mainLayout=findViewById(R.id.main);
        button=findViewById(R.id.btn1);
        tectarea=findViewById(R.id.text1);

    }

    public void btn1(View view) {

        mainLayout.setBackgroundColor(Color.parseColor("#a0fb02"));
        tectarea.setBackgroundColor(Color.parseColor("#a0fb02"));
        button.setBackgroundColor(Color.parseColor("#f86d00"));
    }
}