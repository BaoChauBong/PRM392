package com.example.demoservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
    }

    // started service
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("service_Log", "service is running ...");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.d("service_Log", "started service never go here");
        throw new UnsupportedOperationException("Not yet implemented");
    }
}