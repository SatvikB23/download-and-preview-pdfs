package com.example.android.download;

import android.app.ActionBar;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class Preview extends AppCompatActivity {
    String link;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preview);
        Bundle extras = getIntent().getExtras();
        link = extras.getString("link");
        String doc = "<iframe src='http://docs.google.com/gview?embedded=true&url="+link+"' width='100%' height='100%' style='border: none;'></iframe>";
        WebView wv = (WebView) findViewById(R.id.webView);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.getSettings().setAllowFileAccess(true);
        wv.loadUrl(doc);
        wv.loadData( doc, "text/html",  "UTF-8");
        final Button button2 = findViewById(R.id.button_download);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Download();
            }


        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // todo: goto back activity from here

                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void Download() {


        DownloadManager downloadManager=(DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri= Uri.parse(link);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        Long reference = downloadManager.enqueue(request);
    }
}
