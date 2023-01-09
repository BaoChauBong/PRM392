package com.example.demobroadcast;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String mess = "";
        if (intent.getAction().contains(Intent.ACTION_BATTERY_LOW)){
            mess = "Pin yeu, hay cam sac de khong bi ngat quang";
        } else if (intent.getAction().contains(MainActivity.ACTION_CUSTOM_BROADCAST)){
            mess = intent.getStringExtra("data");
        }

        AlertDialog dialog = new AlertDialog.Builder(context)
                .setTitle("Thong bao !")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setMessage(mess)
                .create();
        dialog.show();
    }
}