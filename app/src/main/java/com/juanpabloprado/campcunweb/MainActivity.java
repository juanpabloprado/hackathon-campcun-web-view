package com.juanpabloprado.campcunweb;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends Activity {

    protected String mUrl = "http://tu-desarrollo.com/apps/camp-cun-view/public_html/";

    @InjectView(R.id.webView) WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_web_view);
        ButterKnife.inject(this);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        mWebView.setWebChromeClient(new WebChromeClient());
        mWebView.loadUrl(mUrl);
    }

}
