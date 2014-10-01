package com.gettyimages.ConnectTestApp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.gettyimages.connectsdk.ConnectSdk;
import com.gettyimages.connectsdk.SdkException;

public class MyActivity extends Activity {

    private String apiKey = "Getty API Key";
    private String apiSecret = "Getty API Secret";
    private String userName = "";
    private String userPassword = "";

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        String result;

        try {
            ConnectSdk connectSdk = new ConnectSdk(apiKey, apiSecret);
            //result = connectSdk.Search().Images().Creative().WithPhrase("dog").WithPage(10).ExecuteAsync();
            //result = connectSdk.Images().WithId("92823652").WithId("92822221").WithId("OneNotFound").WithField("artist").WithField("license_model").ExecuteAsync();
            result = connectSdk.Download().WithId("92822221").ExecuteAsync();
        } catch (SdkException e) {
            result = e.getMessage();
        }

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(result);
    }
}
