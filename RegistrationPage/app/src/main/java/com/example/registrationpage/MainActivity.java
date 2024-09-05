package com.example.registrationpage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText firstNameEditText, lastNameEditText, emailEditText, phoneEditText, passwordEditText, dobEditText;
    private RadioGroup genderRadioGroup;
    private Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        firstNameEditText = findViewById(R.id.firstName);
        lastNameEditText = findViewById(R.id.lastName);
        emailEditText = findViewById(R.id.email);
        phoneEditText = findViewById(R.id.phone);
        passwordEditText = findViewById(R.id.password);
        dobEditText = findViewById(R.id.dob);
        genderRadioGroup = findViewById(R.id.radioGroup2);
        signUpButton = findViewById(R.id.button);

        signUpButton.setOnClickListener(v -> {
            if (validateInputs()) {
                saveData();
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }

    private boolean validateInputs() {
        String firstName = firstNameEditText.getText().toString().trim();
        String lastName = lastNameEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String phone = phoneEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String dob = dobEditText.getText().toString().trim();

        if (TextUtils.isEmpty(firstName)) {
            showToast("First Name is required");
            return false;
        }
        if (TextUtils.isEmpty(lastName)) {
            showToast("Last Name is required");
            return false;
        }
        int selectedId = genderRadioGroup.getCheckedRadioButtonId();
        if (selectedId == -1) {
            showToast("Gender is required");
            return false;
        }
        if (TextUtils.isEmpty(email) || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            showToast("Valid Email is required");
            return false;
        }
        if (TextUtils.isEmpty(phone) || phone.length() < 10) {
            showToast("Valid Phone Number is required");
            return false;
        }
        if (TextUtils.isEmpty(password)) {
            showToast("Password is required");
            return false;
        }
        if (TextUtils.isEmpty(dob)) {
            showToast("Date of Birth is required");
            return false;
        }

        return true;
    }

    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("UserDetails", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String firstName = firstNameEditText.getText().toString().trim();
        String lastName = lastNameEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String phone = phoneEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String dob = dobEditText.getText().toString().trim();

        int selectedId = genderRadioGroup.getCheckedRadioButtonId();
        RadioButton selectedGenderRadioButton = findViewById(selectedId);
        String gender = selectedGenderRadioButton.getText().toString();

        editor.putString("FirstName", firstName);
        editor.putString("LastName", lastName);
        editor.putString("Email", email);
        editor.putString("Phone", phone);
        editor.putString("Password", password);
        editor.putString("DOB", dob);
        editor.putString("Gender", gender);

        editor.apply();

        Log.d("MainActivity", "Data saved successfully"); // Log message for debugging
    }

    private void showToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
