package com.nmj.bind.bindingtestserver.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.nmj.bind.bindingtestserver.ICountService;

public class CountService extends Service {
    public CountService() {
        Log.i("nmj7", "CountService create");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i("nmj7", "CountService onBind");
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("nmj7", "CountService onDestroy");

    }

    ICountService.Stub mBinder = new ICountService.Stub() {
        @Override
        public int getCurNumber() throws RemoteException {
            Log.i("nmj7", "CountService mBinder getCurNumber");
            return 7;
        }

        @Override
        public int sum(int a, int b) throws RemoteException {
            Log.i("nmj7", "CountService mBinder sum");
            return a + b;
        }

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {
            Log.i("nmj7", "CountService mBinder basicTypes");

        }
    };

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("nmj7", "CountService onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("nmj7", "CountService onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }
}
