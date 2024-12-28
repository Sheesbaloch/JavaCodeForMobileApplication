package emailSendingCodeFolder;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.practiceapplication.R;

import javax.mail.MessagingException;

public class SendingEmailUsingJavaMailApi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sending_email_using_java_mail_api);


        EditText editTextTo = findViewById(R.id.editTextTo);
        EditText editTextSubject = findViewById(R.id.editTextSubject);
        EditText editTextMessage = findViewById(R.id.editTextMessage);
        Button buttonSend = findViewById(R.id.buttonSend);


        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String recipient = editTextTo.getText().toString();
                String subject = editTextSubject.getText().toString();
                String message = editTextMessage.getText().toString();

                new Thread(() -> {
                    try{
                        GmailSender sender = new GmailSender("Sheesbaloch007@gmail.com", "123123123");
                        sender.sendMail(recipient, subject, message);
                        runOnUiThread(() -> Toast.makeText(SendingEmailUsingJavaMailApi.this, "Email send Successfully", Toast.LENGTH_SHORT).show());
                    } catch (Exception e) {
                        // Catch other types of exceptions
                        e.printStackTrace();
                        runOnUiThread(() -> {
                            String errorMessage = "Unexpected error occurred: " + e.getMessage();
                            Toast.makeText(SendingEmailUsingJavaMailApi.this, errorMessage, Toast.LENGTH_LONG).show();
                        });
                    }


                }).start();

            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}