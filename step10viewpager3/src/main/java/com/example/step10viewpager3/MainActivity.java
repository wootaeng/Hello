package com.example.step10viewpager3;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.step10viewpager3.ui.main.SectionsPagerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //아답타에 연결할 모델 객체 생성
        List<CountryDto>countries=new ArrayList<>();
        //셈플데이터
        countries.add(new CountryDto(R.drawable.austria, "오스트리아", "..."));
        countries.add(new CountryDto(R.drawable.belgium, "벨기에", "..."));
        countries.add(new CountryDto(R.drawable.brazil, "브라질", "..."));
        countries.add(new CountryDto(R.drawable.france, "프랑스", "..."));
        countries.add(new CountryDto(R.drawable.germany, "독일", "..."));
        countries.add(new CountryDto(R.drawable.greece, "그리스", "..."));
        countries.add(new CountryDto(R.drawable.israel, "이스라엘", "..."));
        countries.add(new CountryDto(R.drawable.italy, "이탈리아", "..."));
        countries.add(new CountryDto(R.drawable.japan, "일본", "..."));
        countries.add(new CountryDto(R.drawable.korea, "대한민국", "..."));
        countries.add(new CountryDto(R.drawable.poland, "폴란드", "..."));
        countries.add(new CountryDto(R.drawable.spain, "스페인", "..."));
        countries.add(new CountryDto(R.drawable.usa, "미국", "..."));
        //아답타 생성하면서 생성자의 인자로 List 와 FragmentManager 객체 전달하기

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(countries, getSupportFragmentManager());
        //ViewPager 의 참조값 얻어와서 아답타 연결하기
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        //상단 텝의 참조값을 얻어와서 ViewPager 를 연결한다
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        //상단텝이 스크롤 될 수 있도록
        tabs.setTabMode(TabLayout.MODE_SCROLLABLE);

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}