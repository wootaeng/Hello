package com.example.step13brodcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/*
    [ BrodcastReceiver 를 만드는 방법 ]

    1. BrodcastReceiver 추상 클래스를 상속 받아서 만든다
    2. onReceive() 메소드를 오버라이딩 해서 방송 수신이 되었을때 원하는 작업을 한다
    3. AndroidManifest.xml 문서에 등록을 해야 동작을 한다
    4. Activity 혹은 Service 에서 방송수신자 객체를 생성해서 등록
 */
public class MyReceiver extends BroadcastReceiver {
    //특정 방송이 수신되면 MyReceiver 객체가 생성이 되고 onReceive() 메소드가 호출된다
    @Override
    public void onReceive(Context context, Intent intent) {

        //메소드의 인자로는 Context 객체와 Intent 객체가 전달된다.
        //Intent 객체는 이 방송수신자 객체가 활성화 될때 전달 된 Intent 객체이다
        Toast.makeText(context,"방송이 수신되었네?",Toast.LENGTH_SHORT).show();
        Log.e("MyReceiver","방송이 수신되었네?");

        //비행기 모드가 활성화되었는지 여부
        boolean isActivated=intent.getBooleanExtra("state",false);

        //인자로 전달된 Context 는 해당 방송수신자 객체를 직접 등록한 액티비티 혹은 서비스의 참조값이다
        MainActivity activity=(MainActivity)context;
        activity.setMessage("비행기 모드 :"+isActivated);

    }
}
