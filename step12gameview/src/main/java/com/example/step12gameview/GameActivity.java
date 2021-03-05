package com.example.step12gameview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {
    //사운드 객체
    Sound sound;
    //사운드의 종류별로 상수 정의하기
    public static final int SOUND_LAZER=1;
    public static final int SOUND_SHOOT=2;
    public static final int SOUND_BIRDDIE=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //GameView 객체를 생성해서
        GameView view = new GameView(this);
        //화면을 GameView 로 모두 채운다
        setContentView(view);
        //사운드 객체를 생성해서 필드에 저장한다다
        sound=new Sound(this);
        //사운드 객체를 GameView 객체에 넣어준다
        view.setSound(sound);


    }

    @Override
    protected void onStart() {
        super.onStart();
        //효과음 미리 로딩하기
        sound.addSound(SOUND_LAZER,R.raw.laser1);
        sound.addSound(SOUND_SHOOT,R.raw.shoot1);
        sound.addSound(SOUND_BIRDDIE,R.raw.birddie);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //자원 해제
        sound.release();
    }
}