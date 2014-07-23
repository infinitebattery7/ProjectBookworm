package com.wallacestudios.projectbookworm;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebSettings;

public final class WebPanelActivity extends Activity {
	
	private WebView webView;
	private WebSettings webSettings;
	private static String currentURL;
	


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web_panel);
		try
		{
			webView.setBottom(260);
		}
		catch (Exception e)
		{}
		webView = (WebView)findViewById(R.id.webview);
		webSettings = webView.getSettings();
		webSettings.setBuiltInZoomControls(true);
		webSettings.setSupportMultipleWindows(true);
		webSettings.setJavaScriptEnabled(true);
		webView.loadUrl(currentURL);
		
		
	}
	
	public static WebPanelActivity newInstance(String webURL)
	{
		WebPanelActivity webActivity = new WebPanelActivity();
		currentURL = webURL;
		return webActivity;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.web_panel, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
