package com.example.demonotifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.RemoteInput;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String channelId = "myChannel";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        Bundle b = RemoteInput.getResultsFromIntent(intent);

        if (b != null){
            String message = b.getString("remote_massage");
            ((TextView) findViewById(R.id.textView)).setText(message);
        }
    }

    public void onSendNotification(View view){
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 1000, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        RemoteInput.Builder build = new RemoteInput.Builder("mess_from_notifi");
        RemoteInput remoteInput = build.setLabel("input your message").build();

        NotificationCompat.Action action = new NotificationCompat.Action.Builder(android.R.drawable.ic_dialog_alert, "Reply",
                pendingIntent).addRemoteInput(remoteInput).build();

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channelId);
        builder.setSmallIcon(android.R.drawable.ic_dialog_alert)
                .setContentTitle("Thong bao tu he thong")
                .setContentText("Server se bao tri vao ngay 13")
                .setContentIntent(pendingIntent);

        Notification notification = builder.build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId, "category 1", NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(channel);
        }
        notificationManager.notify(1, notification);
    }
}