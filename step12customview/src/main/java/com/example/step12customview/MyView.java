package com.example.step12customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class MyView  extends View {
    //색상을 나타내는 상수값을 미리 int[] 에 준비하고
    int[] colors={Color.GREEN, Color.RED,Color.BLUE};
    //인덱스로 사용할 필드
    int index;

    //생성자1
    public MyView(Context context) {
        super(context);
    }
    //생성자2
    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    //View 가 차지하고 있는 화면에 그림그리기
    @Override
    protected void onDraw(Canvas canvas) {
        //Canvas 객체를 이용해서 원하는 작업을 한다
        canvas.drawColor(colors[index]);
        //BitmapFactory 클래스의 static 메소드를 이용해서 이미지 로딩
        //Bitmap type으로 만들기
        Bitmap image= BitmapFactory.decodeResource(getResources(),R.drawable.austria);
        //Bitmap 의 크기를 변환하기
        Bitmap scaledImage=Bitmap.createScaledBitmap(image,200,200,false);
        //Canvas 객체를 이용해서 이미지의 좌상단의 좌표를 지정하고 그린다.
        canvas.drawBitmap(scaledImage,100,100,null);
        //글자를 출력하기 위한 Paint 객체
        Paint textP=new Paint();
        textP.setColor(Color.YELLOW);
        textP.setTextSize(100);
        canvas.drawText("안녕!",100,100,textP);
    }
    //View 에 터치 이벤트가 발생했을 때 호출되는 메소드
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        index ++;
        if(index==3){
            index=0;
        }
        //화면 갱신하기
        invalidate();
        return super.onTouchEvent(event);
    }
}
