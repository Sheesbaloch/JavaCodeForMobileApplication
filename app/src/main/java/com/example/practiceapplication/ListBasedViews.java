package com.example.practiceapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ListBasedViews extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_based_views);

        Button listView = findViewById(R.id.listView);
        Button spinner = findViewById(R.id.Spinner);
        Button gridview = findViewById(R.id.gridview);
        Button ImageGalleryId = findViewById(R.id.ImageGalleryId);
        Button scrollViewID = findViewById(R.id.ScrollViewId);
        Button SharePreferenceId = findViewById(R.id.SharePreferenceId);

        listView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListBasedViews.this, ListVIewScreen.class);
                startActivity(intent);
            }
        });

        spinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListBasedViews.this, spinnerListScreen.class);
                startActivity(intent);
            }
        });

        gridview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListBasedViews.this, gridviewScreen.class);
                startActivity(intent);
            }
        });

        ImageGalleryId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListBasedViews.this, ImageGalleryView.class);
                startActivity(intent);
            }
        });

        scrollViewID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListBasedViews.this, scrollViewScreen.class);
                startActivity(intent);
            }
        });

        SharePreferenceId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListBasedViews.this, SharedPreferenceScreen.class);
                startActivity(intent);
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}