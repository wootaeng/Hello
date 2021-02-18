package com.example.step09fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
/*
    [ Fragment 만드는 방법 ]
    1. Fragment 클래스를 상속 받는다.
    2. 프래그먼트의 Layout xml 문서를 만든다
    3. onCreatView() 메소드를 오버라이딩한다
 */

public class GuraFragment extends Fragment implements View.OnClickListener{
    //필요한 필드 정의하기
    TextView textView;
    //int 타입 필드는 선언만 해도 0으로 기본 들어간다
    int cnt;

    //프레그먼트가 관리할 화면 View 를 만들어서 리턴해줘야한다,
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //인자로 전달되는 레이아웃 전개자 객체를 이용해서 View 를 만들어서
        View view=inflater.inflate(R.layout.fragment_gura, container);
        //만든 View 에서 TextView 의 참조값을 얻어온다
        textView=view.findViewById(R.id.textView);
        textView.setOnClickListener(this);
        //리턴해준다
        return view;
    }


    @Override
    public void onClick(View v) {
        //v 에는 이벤트가 발생한 참조값이 들어온다 textView == v
        boolean result = textView == v;
        cnt++;
        // 1 + "" => ""이 문자열이기에 1을 문자열로 연결해준다. 그래서 출력가능
        textView.setText(cnt+"");
        //int 는 resid 를 요구 resid는 res/ 내에서 찾게된다. 그렇기에 문자열로 변경해줘야한다
        //textView.setText((Integer.toString(cnt)));
//        //View type 을 TextView 로 casting 해서 textView == v 지만 바로 사용할수없기에 casting
//        TextView t=(TextView)v;
//        //setText() 메소드 호출하기
//        t.setText("click했네?");
        //textView.setText(R.string.msg);

        //만일 count 가 10의 배수라면 '현재 나를 관리하는' 액티비티에 해당 정보를 알려보자

        //프레그먼트를 관리하는 액티비티의 참조값을 부모 type으로 얻어오기
        FragmentActivity fa=getActivity();
        //액티비티가 GuraFragmentListener type 이 맞는지(인터페이스를 구현)
        if (fa instanceof GuraFragmentListener && cnt%10 == 0){
            GuraFragmentListener ma2=(GuraFragmentListener)fa;
            ma2.wow(cnt+" 번 입력했습니다. ");
        }
    }

    //리셋하는 메소드
    public void reset(){
        cnt =0;
        textView.setText("0");
    }

    //이 프레그먼트를 사용하는 액티비티가 구현해야 하는 메소드
    public interface GuraFragmentListener{
        public void wow(String msg);
    }
}
