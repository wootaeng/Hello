package com.example.step19webview2;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView=findViewById(R.id.webView);
        //WebView 설정 객체 얻어오기
        WebSettings ws=webView.getSettings();
        //javascript 해석가능하도록 설정
        ws.setJavaScriptEnabled(true);
        //WebView 클라이언트 객체를 생성해서 넣어주기
        webView.setWebViewClient(new WebViewClient());
        EditText inputUrl=findViewById(R.id.inputUrl);
        Button moveBtn=findViewById(R.id.moveBtn);
        moveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUrl=inputUrl.getText().toString().trim();
                webView.loadUrl(strUrl);
            }
        });
    }
}