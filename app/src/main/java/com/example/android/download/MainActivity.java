package com.example.android.download;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tv1 = (TextView)findViewById(R.id.first_tv);
        tv1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Preview("http://kmmc.in/wp-content/uploads/2014/01/lesson2.pdf"); // Code here executes on main thread after user presses button
            }
        });

        final TextView tv2 = (TextView)findViewById(R.id.second_tv);
        tv2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Preview("https://www.adelaide.edu.au/learning/teaching/development/docdesign/guides/docDesign_KeepPDFsmall.pdf"); // Code here executes on main thread after user presses button
            }
        });

        final TextView tv3 = (TextView)findViewById(R.id.third_tv);
        tv3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Preview("http://www.africau.edu/images/default/sample.pdf"); // Code here executes on main thread after user presses button
            }
        });

    }


    public void Preview(String website) {  //this is the downloader method

        Intent intent = new Intent(this, Preview.class);
        intent.putExtra("link",website);
        finish();
        startActivity(intent);

    }


}



