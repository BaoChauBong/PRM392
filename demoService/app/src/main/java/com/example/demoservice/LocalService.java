package com.example.demoservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Date;

public class LocalService extends Service {

    IBinder myBinder = new MyLocalBinder();

    public LocalService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myBinder;
    }

    public String getCurrentTime(){
        return new Date().toString();
    }

    class MyLocalBinder extends Binder {
        LocalService getService(){
          return LocalService.this;
        }
    }

}