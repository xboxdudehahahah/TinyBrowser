package com.tiny.browser;
import android.app.*;import android.content.*;import android.os.*;import android.view.*;import android.webkit.*;import android.widget.*;
public class MainActivity extends Activity{
public void onCreate(Bundle b){super.onCreate(b);
LinearLayout l=new LinearLayout(this);l.setOrientation(1);
EditText u=new EditText(this);
WebView w=new WebView(this);w.getSettings().setJavaScriptEnabled(true);w.setWebViewClient(new WebViewClient());
l.addView(u,new LinearLayout.LayoutParams(-1,-2));
l.addView(w,new LinearLayout.LayoutParams(-1,0,1));
setContentView(l);
u.setOnEditorActionListener((v,a,e)->{String s=u.getText().toString();w.loadUrl(s.startsWith("http")?s:"https://"+s);return false;});}}
