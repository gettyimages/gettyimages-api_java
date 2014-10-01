package com.gettyimages.ConnectTestApp;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.gettyimages.connectsdk.ConnectSdk;
import com.gettyimages.connectsdk.SdkException;

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
        new SearchTask().execute(searchTerm);
    }

    private class SearchTask extends AsyncTask<String, Void, String>
    {
        @Override
        protected String doInBackground(String... searchTerm) {
            String result;
            try {
                ConnectSdk connectSdk = new ConnectSdk(apiKey, apiSecret);
                result = connectSdk.Search().Images().Creative().WithPhrase(searchTerm[0]).WithPage(10).ExecuteAsync();
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
        }
    }
}
