package com.juanpabloprado.campcunweb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends ActionBarActivity {

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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_share) {
            share();
        }

        return super.onOptionsItemSelected(item);
    }

    private void share() {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, mUrl);
        startActivity(Intent.createChooser(shareIntent, getString(R.string.share_chooser_title)));
    }
}
