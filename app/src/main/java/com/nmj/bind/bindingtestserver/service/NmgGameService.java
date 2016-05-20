package com.nmj.bind.bindingtestserver.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.nmj.bind.bindingtestserver.INmgGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NmgGameService extends Service {

    List<String> mGameList = Arrays.asList("포켓몬스터","삼국지","문명5");
    public NmgGameService() {
        Log.d("nmj7", "NmgGameService create");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("nmj7", "NmgGameService.onBind called");
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("nmj7", "NmgGameService.onUnbind called");
        return super.onUnbind(intent);
    }

    INmgGame.Stub mBinder = new INmgGame.Stub() {
        @Override
        public List<String> getGameList() throws RemoteException {
            return mGameList;
        }

        @Override
        public int getGameCount() throws RemoteException {
            return mGameList.size();
        }
    };
}
