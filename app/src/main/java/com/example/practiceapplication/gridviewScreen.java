package com.example.practiceapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class gridviewScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_gridview_screen);

        GridView GridviewId = findViewById(R.id.GridViewId);

        String[] items = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5","Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        GridviewId.setAdapter(adapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}