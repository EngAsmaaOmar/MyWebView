package com.example.omar.mywebview;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    WebView browser ;
    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        browser = (WebView)findViewById(R.id.webview);
        browser.loadUrl("https://www.youtube.com");
       browser.setWebViewClient(new  mybrowser());

       browser.getSettings().setLoadsImagesAutomatically(true);
       browser.getSettings().setJavaScriptEnabled(true);
       browser.setScrollBarStyle(View.ACCESSIBILITY_LIVE_REGION_ASSERTIVE);

    }

    public void bunext(View view) {
        browser.goForward();
    }

    public void buback(View view) {
        browser.goBack();
    }

    public void bugo(View view) {
        EditText txt = (EditText)findViewById(R.id.txtUrl);
        browser.loadUrl(txt.getText().toString());
    }
     private class mybrowser extends WebViewClient{
        public boolean shouldOverrideurlloading(WebView view , String url ){
            view.loadUrl(url);
            return true ;
        }

     }
}
