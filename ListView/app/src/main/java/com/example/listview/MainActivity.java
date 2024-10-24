package com.example.listview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    TextView tv;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Receiving data from intent
        tv = findViewById(R.id.recvdinpt);
        String msg = getIntent().getStringExtra("mykey");
        if (msg != null) {
            tv.setText("Welcome " + msg);
        }

        // Setting up ListView with data
        lv = findViewById(R.id.listview);
        String[] courses = {"MCA", "MBA", "BBA", "BCA"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, courses);
        lv.setAdapter(adapter);

        // Attach listener to ListView
        lv.setOnItemClickListener(this);
    }

    // Handling item clicks
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String selectedCourse = (String) parent.getItemAtPosition(position);
        Toast.makeText(this, "You selected: " + selectedCourse, Toast.LENGTH_SHORT).show();
    }
}