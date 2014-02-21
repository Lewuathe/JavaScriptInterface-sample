package com.example.JSTest;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        WebView webView = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);

        webView.addJavascriptInterface(new JavaScriptAction(), "JSAction");
        webView.loadUrl("file:///android_asset/jstest.html");
    }

    public class JavaScriptAction {
        @JavascriptInterface
        public void action() {
            Toast.makeText(MyActivity.this, "Called from JavaScript", Toast.LENGTH_LONG).show();
        }
    }


}
