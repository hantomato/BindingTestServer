package com.nmj.bind.bindingtestserver;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * service를 사용한 바인딩 테스트.
 *
 * case 1. 다른 앱에서 이 앱의 서비스 실행
 *      -> BindingTestClient 앱이 이 앱의 MyIntentService 호출함
 *
 * case 2. 같은 앱 내에서 Bind 사용해서 서비스와 통신
 *      -> MyLocalService
 *
 * case 3. Messenger 사용.
 *      -> ActivityMessenger, MessengerService
 *      -> http://android-kr.tistory.com/283#Messenger
 *
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button)findViewById(R.id.button1)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aaa();
            }
        });
        ((Button)findViewById(R.id.button2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BindingActivity.class));
            }
        });
        ((Button)findViewById(R.id.button3)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ActivityMessenger.class));
            }
        });
        ((Button)findViewById(R.id.button4)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(MainActivity.this);
//                i.setAction("com.nmj.bind.bindingtestserver.service.MyIntentService");
//                i.setPackage("com.nmj.bind.bindingtestserver");
////                i.setPackage("com.nmj.bind.bindingtestserver");
////                i.setPackage("com.nmj.bind.bindingtestserver");
////                boolean bb = bindService(i, mConnection, Context.BIND_AUTO_CREATE);
//
//                // 성공
//                // Intent i = new Intent(MainActivity.this, CountService.class);
//                boolean bb = getApplicationContext().bindService(i, mConnection, Context.BIND_AUTO_CREATE);
//                Log.i("nmj7", "bindService ret : " + bb);

            }
        });
        ((Button)findViewById(R.id.button5)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void aaa() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.nmj.bind.bindingtestserver",
                "com.nmj.bind.bindingtestserver.service.MyIntentService"));
        ComponentName res = startService(intent);
        Log.i("nmj7", "res : " + res);
    }

    private ServiceConnection mConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className, IBinder service) {
            Log.i("nmj7", "mConnection.onServiceConnected");
            // This is called when the connection with the service has been
            // established, giving us the object we can use to
            // interact with the service.  We are communicating with the
            // service using a Messenger, so here we get a client-side
            // representation of that from the raw IBinder object.
//            mService = new Messenger(service);
//            IRemoteService.Stub.asInterface(service);

//            mBinder = ICountService.Stub.asInterface(service);
        }

        public void onServiceDisconnected(ComponentName className) {
            Log.i("nmj7", "mConnection.onServiceDisconnected");
            // This is called when the connection with the service has been
            // unexpectedly disconnected -- that is, its process crashed.
//            mService = null;
        }
    };
}
