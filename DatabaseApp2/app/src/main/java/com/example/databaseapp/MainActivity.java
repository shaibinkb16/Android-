package com.example.databaseapp;

import android.database.Cursor;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText Name, Mark, Surname;
    TextView DataV;
    MyDatabase database = new MyDatabase(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Name = findViewById(R.id.ed1);
        Mark = findViewById(R.id.ed3);
        Surname = findViewById(R.id.ed2);
        DataV = findViewById(R.id.textView);

        DataV.setMovementMethod(new ScrollingMovementMethod());


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void SaveData(View view) {
        String firstName = Name.getText().toString().trim();
        String lastName = Surname.getText().toString().trim();
        String markStr = Mark.getText().toString().trim();

        if (firstName.isEmpty() || lastName.isEmpty() || markStr.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            int mark = Integer.parseInt(markStr);
            Boolean result = database.insertdata(firstName, mark, lastName);
            if (result) {
                Toast.makeText(getApplicationContext(), "Data inserted Successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Data insertion failed", Toast.LENGTH_SHORT).show();
            }
        } catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), "Invalid input for mark", Toast.LENGTH_SHORT).show();
        }
    }

    public void read(View view) {
        Cursor res = database.getAllData();
        StringBuffer stringBuffer = new StringBuffer();
        if (res != null && res.getCount() > 0) {
            while (res.moveToNext()) {
                stringBuffer.append("Id: ").append(res.getString(0)).append("\n");
                stringBuffer.append("Name: ").append(res.getString(1)).append("\n");
                stringBuffer.append("Surname: ").append(res.getString(2)).append("\n");
                stringBuffer.append("Marks: ").append(res.getString(3)).append("\n");
            }
            DataV.setText(stringBuffer.toString());
            res.close();  // Close the cursor to avoid memory leaks
            Toast.makeText(getApplicationContext(), "Data Retrieved Successfully", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "No Data Found", Toast.LENGTH_SHORT).show();
        }
    }

    public void update(View view) {
        String firstName = Name.getText().toString().trim();
        String lastName = Surname.getText().toString().trim();
        String markStr = Mark.getText().toString().trim();

        if (firstName.isEmpty() || lastName.isEmpty() || markStr.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            int mark = Integer.parseInt(markStr);
            Boolean result = database.updateData(firstName, mark, lastName);
            if (result) {
                Toast.makeText(getApplicationContext(), "Data updated Successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "No Rows Affected", Toast.LENGTH_SHORT).show();
            }
        } catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), "Invalid input for mark", Toast.LENGTH_SHORT).show();
        }
    }

    public void delete(View view) {
        String firstName = Name.getText().toString().trim();
        if (firstName.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter a name to delete", Toast.LENGTH_SHORT).show();
            return;
        }

        int result = database.deletedata(firstName);
        if (result > 0) {
            Toast.makeText(getApplicationContext(), "Row(s) deleted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "No Rows Affected", Toast.LENGTH_SHORT).show();
        }
    }
}
