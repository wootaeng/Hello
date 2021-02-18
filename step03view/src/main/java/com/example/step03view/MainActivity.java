package com.example.step03view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 액티비티가 활성화 될 때 호출되는 메소드드
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // res/layout/activity_main.xml 문서를 전개해서 화면 구성하기
       /*
            레이아웃 리소스 아이디를 전달하면 자동으로 UI 객체들이 생성되고
            생성된 UI 가 화면을 구성하게 된다.
            이 예제에서는 ConstainLayout, EditTextm Button, TextView 객체가 생성이 되어서
            화면 구성을 하게 된다.
        */
        setContentView(R.layout.activity_main);
    }

    //전송 버튼을 눌렀을 때 호출되는 메소드
    //View는 모든 Ui 의 부모타입
    public void sendClicked(View v){
        //1.EditText 에 입력한 문자열을 읽어온다.
        EditText a=findViewById(R.id.inputText);
        String msg=a.getText().toString();
        //2. Toast 에 읽어온 문자열을 띄운다.
        //액티비티의 메소드 안에서 Context type 이 필요하면 this 를 전달하면 된다.
        //toast는 .show까지 해줘야 뜬다
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
        TextView tv=findViewById(R.id.textPrint);
        tv.setText(msg);
        //java의 다양성, this의 다양한 참조값
//        Object t1=this;
//        MainActivity t2=this;
//        AppCompatActivity t3=this;
//        Context t4=this;
//        CharSequence t1="abcd" //String = CharSequence
        //삭제하는 방법
        a.setText("");

    }
}