package com.example.bus_time_table;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class Web extends AppCompatActivity {

    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        webview=findViewById(R.id.webview);

        String str=getIntent().getStringExtra("uri");


        webview.getSettings().getJavaScriptEnabled();
        webview.loadUrl(str);


    }
}