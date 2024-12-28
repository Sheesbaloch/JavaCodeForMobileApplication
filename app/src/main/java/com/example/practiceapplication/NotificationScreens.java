package com.example.practiceapplication;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NotificationScreens extends AppCompatActivity {

    private static final int notificationID = 1;
    private static final String CHANNEL_ID = "Default_channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_notification_screens);

        Button ToastNotification = findViewById(R.id.ToastNotification);
        Button StatusBar = findViewById(R.id.StatusBar);
        Button DialogNotification = findViewById(R.id.DialogNotification);

        createNotificationChannel();



        ToastNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NotificationScreens.this, "Added a new Toast Notification", Toast.LENGTH_SHORT).show();
            }
        });

        StatusBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(NotificationScreens.this, CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Notification Alert, Click Me!")
                .setContentText("Hi, This is Android Notificaiton Details!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
                if(notificationManager != null){
                    notificationManager.notify(notificationID, mBuilder.build());
                }

            }
        });

        DialogNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            showDialogNotification();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "Default Channel",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            channel.setDescription("This is the default notification channel.");
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            if(notificationManager !=null){
                notificationManager.createNotificationChannel(channel);
            }
        }
    }

    private void showDialogNotification(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Dialog Notification");
        builder.setMessage("This is a simple DialogBox Notification. Would you like to continue?");
        builder.setIcon(R.drawable.ic_launcher_foreground);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}