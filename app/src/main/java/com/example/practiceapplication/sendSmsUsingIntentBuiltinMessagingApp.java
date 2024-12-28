package com.example.practiceapplication;

import static android.text.TextUtils.isEmpty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class sendSmsUsingIntentBuiltinMessagingApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_send_sms_using_intent_builtin_messaging_app);



        EditText editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        EditText editTextMessage = findViewById(R.id.editTextMessage);
        Button ButtonSendSms = findViewById(R.id.buttonSendSms);


        ButtonSendSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = editTextPhoneNumber.getText().toString();
                String message = editTextMessage.getText().toString();

                if(!phoneNumber.isEmpty() && !message.isEmpty()){
                    openMessagingApp(phoneNumber, message);
                }
            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    private void openMessagingApp(String phoneNumber, String message){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(android.net.Uri.parse("sms: "+ phoneNumber));
        intent.putExtra("sms_body ", message);
        startActivity(intent);
    }


}