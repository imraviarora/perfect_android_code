package com.example.ravi.perfect;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebView;

public class Ivrguruwebview extends Activity {
    WebView webViewforivr;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ivrguruwebview);
        webViewforivr=findViewById(R.id.webViewforivr);
        webViewforivr.loadUrl("http://ivr.ivrguru.com/");
    }
}
