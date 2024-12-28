package com.example.practiceapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import googleMapsFolder.GoogleMapScreen;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_screen);

        Button listBasedview = findViewById(R.id.listBasedView);
        Button ImplecitIntent = findViewById(R.id.ImplecitIntent);
        Button NotificationsId = findViewById(R.id.NotificationsId);
        Button ServiceId = findViewById(R.id.ServiceId);
        Button GestureId = findViewById(R.id.GestureId);
        Button SendSmsId = findViewById(R.id.SendSmsId);
        Button SendSmsUsingIntentWithBuldinApp = findViewById(R.id.SendSmsUsingIntentWithBuldinApp);
        Button EmailSendingId = findViewById(R.id.EmailSendingId);
        Button GoogleMapsId = findViewById(R.id.GoogleMapsId);


        listBasedview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, ListBasedViews.class);
                startActivity(intent);
            }
        });

        ImplecitIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://chatgpt.com/c/67691c54-ddfc-8009-a312-02d455da9b36"));
                startActivity(intent);
            }
        });

        NotificationsId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, NotificationScreens.class);
                startActivity(intent);
            }
        });

        ServiceId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, ServiceScreen.class);
                startActivity(intent);
            }
        });

        GestureId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, GestureScreens.class);
                startActivity(intent);
            }
        });

        SendSmsId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, sendSmsScreen.class);
                startActivity(intent);
            }
        });

        SendSmsUsingIntentWithBuldinApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, sendSmsUsingIntentBuiltinMessagingApp.class);
                startActivity(intent);
            }
        });

        EmailSendingId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, EmailSendingScreen.class);
                startActivity(intent);
            }
        });

        GoogleMapsId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, GoogleMapScreen.class);
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