package com.nmj.bind.bindingtestserver.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.util.Random;

public class MyLocalService extends Service {
    // Binder given to clients
    private final IBinder mBinder = new LocalBinder();
    // Random number generator
    private final Random mGenerator = new Random();

    public MyLocalService() {
        Log.i("nmj7", "MyLocalService create");
    }

    /**
     * Class used for the client Binder.  Because we know this service always
     * runs in the same process as its clients, we don't need to deal with IPC.
     */
    public class LocalBinder extends Binder {
        public MyLocalService getService() {
            // Return this instance of MyLocalService so clients can call public methods
            return MyLocalService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    /** method for clients */
    public int getRandomNumber() {
        Log.i("nmj7", "MyLocalService call getRandomNumber..");
        return mGenerator.nextInt(100);
    }
}