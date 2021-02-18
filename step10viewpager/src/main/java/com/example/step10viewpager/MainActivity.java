package com.example.step10viewpager;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.step10viewpager.ui.main.SectionsPagerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //res/layout/activity_main.xml 문서를 전개해서 화면 구성하기
        setContentView(R.layout.activity_main);

        List<String> newsList=new ArrayList<>();
        newsList.add("비대면 수업이 연장 되었어요ㅜㅜ");
        newsList.add("아이패드를 주문했어요");
        newsList.add("와이프가 산 주식이 상장패지 위기에요ㅜㅜ");

        //ViewPager에 Framgment 를 공급할 아답타 객체 생성
        SectionsPagerAdapter sectionsPagerAdapter =
                new SectionsPagerAdapter(newsList, getSupportFragmentManager());
        //ViewPager 의 참조값 얻어와서 아답타 연결하기
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        //상단 tab 의 참조값 얻어와서
        TabLayout tabs=findViewById(R.id.tabs);
        //상단 tab에 ViewPager 연결하기
        tabs.setupWithViewPager(ViewPager);

        //우하단에 떠있는 버튼의 참조값 얻어와서
        FloatingActionButton fab = findViewById(R.id.fab);
        //클릭 리스너 등록하기
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}