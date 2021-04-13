package com.example.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editTextTitle;
    private EditText editTextMessage;
    private Button buttonChannel1;
    private Button buttonChannel2;

    private NotificationHelper mNotificationHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTitle = findViewById(R.id.edittext_title);
        editTextMessage = findViewById(R.id.edittext_message);
        buttonChannel1 = findViewById(R.id.button_channel1);
        buttonChannel2 = findViewById(R.id.button_channel2);

        mNotificationHelper = new NotificationHelper(this);

        buttonChannel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendOnChannel1(editTextTitle.getText().toString(), editTextMessage.getText().toString());
            }
        });

        buttonChannel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendOnChannel2(editTextTitle.getText().toString(), editTextMessage.getText().toString());
            }
        });
     }

     public void sendOnChannel1(String title, String message) {
         NotificationCompat.Builder nb = mNotificationHelper.getChannel1Notification(title, message);
         mNotificationHelper.getManager().notify(1, nb.build());
     }

     public void sendOnChannel2(String title, String message) {
         NotificationCompat.Builder nb = mNotificationHelper.getChannel2Notification(title, message);
         mNotificationHelper.getManager().notify(2, nb.build());
     }
}