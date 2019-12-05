package com.example.myappthread;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageDownloader  extends AsyncTask<String, Integer, Bitmap> {
    private Activity activity;

    public ImageDownloader(FragmentActivity myActivity) {
        activity = myActivity;
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        Log.i("onPostExecute", "in doInBackground");
        publishProgress(1);
        try {
            Log.i("IMAGEDOWNLOADER", strings[0]);
            URL url = new URL(strings[0]);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            if (con.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new Exception("Failed to connect");
            }
            InputStream is = con.getInputStream();
            publishProgress(0);
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            is.close();
            return bitmap;
        } catch (Exception e) {
            Log.e("Image", "Failed to load image", e);
            Log.e("error", e.getMessage());
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {

        TextView tv = (TextView) activity.findViewById(R.id.tv_loading);
        if (values[0] == 1) {
            tv.setText("Loading...");
        } else {
            tv.setText("");
        }
    }

    @Override
    protected void onPostExecute(Bitmap img) {
        Log.i("IMAGEDOWNLOADER", "IN onPostExecute");
        ImageView iv = (ImageView) activity.findViewById(R.id.remote_image);
        Log.i("hello5", "hello5");
        if (iv != null && img != null) {
            Log.i("hello6", "hello6");
            iv.setImageBitmap(img);
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
}



