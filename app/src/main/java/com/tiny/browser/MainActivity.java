package com.tiny.browser;
import android.app.Activity;
import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
    WebView w;
    EditText u;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        LinearLayout l = new LinearLayout(this);
        l.setOrientation(LinearLayout.VERTICAL);
        u = new EditText(this);
        u.setHint("URL");
        u.setSingleLine(true);
        u.setImeOptions(EditorInfo.IME_ACTION_GO);
        w = new WebView(this);
        w.getSettings().setJavaScriptEnabled(true);
        w.setWebViewClient(new WebViewClient());
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout.LayoutParams wp = new LinearLayout.LayoutParams(-1, 0, 1f);
        l.addView(u, p);
        l.addView(w, wp);
        setContentView(l);
        u.setOnEditorActionListener((v, a, e) -> {
            String s = u.getText().toString();
            if (!s.startsWith("http")) s = "https://" + s;
            w.loadUrl(s);
            return false;
        });
        w.loadUrl("https://google.com");
    }

    @Override
    public void onBackPressed() {
        if (w.canGoBack()) w.goBack();
        else super.onBackPressed();
    }
}
