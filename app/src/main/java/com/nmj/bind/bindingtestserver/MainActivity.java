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
    }

    public void aaa() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.nmj.bind.bindingtestserver",
                "com.nmj.bind.bindingtestserver.service.MyIntentService"));
        ComponentName res = startService(intent);
        Log.i("nmj7", "res : " + res);
    }
}
