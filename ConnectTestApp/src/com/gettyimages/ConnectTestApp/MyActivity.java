package com.gettyimages.ConnectTestApp;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.gettyimages.connectsdk.ConnectSdk;
import com.gettyimages.connectsdk.SdkException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyActivity extends Activity {

    private String apiKey = "Getty API Key";
    private String apiSecret = "Getty API Secret";
    private String userName = "";
    private String userPassword = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void onSearchClick(View view)
    {
        TextView searchView = (TextView) findViewById(R.id.searchTerm);
        String searchTerm = searchView.getText().toString();

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("Searching...");

        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        imageView.setImageBitmap(null);

        new SearchTask().execute(searchTerm);
    }

    private class SearchTask extends AsyncTask<String, Void, String>
    {
        private Bitmap firstBitmap;

        @Override
        protected String doInBackground(String... searchTerm) {
            String result;
            try {
                ConnectSdk connectSdk = new ConnectSdk(apiKey, apiSecret);
                result = connectSdk.Search().Images().Creative().WithPhrase(searchTerm[0]).WithPage(10).ExecuteAsync();

                try {
                    JSONObject json = (JSONObject) new JSONObject(result);

                    JSONArray images = json.getJSONArray("images");

                    JSONObject image = images.getJSONObject(0);

                    JSONArray displaySizes = image.getJSONArray("display_sizes");

                    JSONObject displaySize = displaySizes.getJSONObject(0);

                    String firstImageUri = displaySize.getString("uri");

                    firstBitmap = getBitmapFromURL(firstImageUri);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                //result = connectSdk.Images().WithId("92823652").WithId("92822221").WithId("OneNotFound").WithField("artist").WithField("license_model").ExecuteAsync();
                //result = connectSdk.Download().WithId("92822221").ExecuteAsync();
            } catch (SdkException e) {
                result = e.getMessage();
            }
            catch (Exception e) {
                result = e.toString();
            }
            return result;
        }

        @Override
        protected void onPostExecute(String result)
        {
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText(result);

            ImageView imageView = (ImageView)findViewById(R.id.imageView);
            imageView.setImageBitmap(firstBitmap);
        }

        public Bitmap getBitmapFromURL(String src) {
            try {
                URL url = new URL(src);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream input = connection.getInputStream();
                Bitmap myBitmap = BitmapFactory.decodeStream(input);
                return myBitmap;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

    }
}
