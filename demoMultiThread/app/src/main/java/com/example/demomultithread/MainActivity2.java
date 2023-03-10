package com.example.demomultithread;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity2 extends AppCompatActivity {

    TextView tv;
    ImageView img;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv = findViewById(R.id.textView);
        img = findViewById(R.id.imageView);
        progressBar = findViewById(R.id.progressBar);
    }

    public void onStart(View view) {

//        MyAsynctask asynctask = new MyAsynctask();
//        asynctask.execute(url);
        progressBar.setVisibility(View.INVISIBLE);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                // doInbackground here
                Bitmap bitmap = null;
                String url_str = "data:image/jpeg;base64,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";
                try {
                    URL url = new URL(url_str);
                    HttpURLConnection connection = null;
                    connection = (HttpURLConnection) url.openConnection();

                    InputStream inputStream = connection.getInputStream();
                    bitmap = BitmapFactory.decodeStream(inputStream);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //TODO: postExecute here - handlerMessage
                        img.setVisibility(View.INVISIBLE);
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });
        t.start();
    }


    public class MyAsynctask extends AsyncTask<String, String, Bitmap>{
        @Override
        protected Bitmap doInBackground(String... strings) {
            Bitmap b = null;
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream inputStream = connection.getInputStream();
                b = BitmapFactory.decodeStream(inputStream);
                return b;
            } catch (Exception e){

            } return b;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            img.setVisibility(View.INVISIBLE);
            progressBar.setVisibility(View.INVISIBLE);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            img.setVisibility(View.INVISIBLE);
            img.setImageBitmap(bitmap);
            progressBar.setVisibility(View.INVISIBLE);
        }
    }
}