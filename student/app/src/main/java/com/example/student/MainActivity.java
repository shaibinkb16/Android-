package com.example.student;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText idEditText,nameEditText,placeEditText, dobEditText;
    private RadioGroup genderRadioGroup;
    private Button signUpButton;


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

    EditText id = findViewById(R.id.main);
    EditText getNameEditText = findViewById(R.id.main);
    EditText getPlaceEditText = findViewById(R.id.main);
    EditText getDobEditText = findViewById(R.id.main);
    SharedPreferences= SharedPreferences()
        EditText id = findViewById(R.id.main.gettext().to string);
        EditText getNameEditText = findViewById(R.id.main.gettext().to string());
        EditText getPlaceEditText = findViewById(R.id.main.gettext().to string());
        EditText getDobEditText = findViewById(R.id.main.gettext().to string());

        EditText id = findViewById(R.id.main);
        EditText getNameEditText = findViewById(R.id.main);
        EditText getPlaceEditText = findViewById(R.id.main);
        EditText getDobEditText = findViewById(R.id.main);

    public void submit(View View)
        {
        Toast.makeText(this, "login succes", Toast.LENGTH_SHORT).show();
    }
}