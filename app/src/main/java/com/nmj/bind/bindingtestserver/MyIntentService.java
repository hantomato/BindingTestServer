package com.nmj.bind.bindingtestserver;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.IBinder;
import android.util.Log;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_PLAY_MUSIC = "com.nmj.bind.bindingtest.action.PLAY_MUSIC";
    private static final String ACTION_STOP_MUSIC = "com.nmj.bind.bindingtest.action.STOP_MUSIC";

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "com.nmj.bind.bindingtest.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "com.nmj.bind.bindingtest.extra.PARAM2";

    public MyIntentService() {
        super("MyIntentService");

        Log.i("nmj7", "MyIntentService()");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionPlayMusic(Context context, String param1, String param2) {
        Log.i("nmj7", "MyIntentService.startActionPlayMusic");
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(ACTION_PLAY_MUSIC);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionStopMusic(Context context, String param1, String param2) {
        Log.i("nmj7", "MyIntentService.startActionStopMusic");
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(ACTION_STOP_MUSIC);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i("nmj7", "MyIntentService.onHandleIntent() : package " + getPackageName());
        if (intent != null) {
            final String action = intent.getAction();
            Log.i("nmj7", "MyIntentService.onHandleIntent() : action " + action);
            if (ACTION_PLAY_MUSIC.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionPlayMusic(param1, param2);
            } else if (ACTION_STOP_MUSIC.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionStopMusic(param1, param2);
            }
        }


        synchronized (this) {
            try {
                wait(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Log.i("nmj7", "MyIntentService.onHandleIntent() : end");

    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionPlayMusic(String param1, String param2) {
        // TODO: Handle action Foo
        Log.i("nmj7", "MyIntentService.handleActionPlayMusic process...");
//        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionStopMusic(String param1, String param2) {
        // TODO: Handle action Baz
        Log.i("nmj7", "MyIntentService.handleActionStopMusic process...");
//        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("nmj7", "MyIntentService.onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("nmj7", "MyIntentService.onDestroy");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i("nmj7", "MyIntentService.onBind");
        return super.onBind(intent);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("nmj7", "MyIntentService.onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.i("nmj7", "MyIntentService.onRebind");
    }
}
