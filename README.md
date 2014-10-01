# Getty Images Connect SDK 

Seamlessly integrate Getty Images' expansive digital content, powerful search technology, and rich metadata into your publishing tools, products and services!

- Search for images from our extensive creative and editorial catalogs.
- Get image metadata.
- Download files using your Getty Images products (e.g., Editorial subscriptions, Easy Access, Thinkstock Subscriptions, and Image Packs).

## Assumptions
* You have the latest Android Sdk installed.
* You have IntelliJ IDEA >= 13 installed.
* You have "Getty Test" credentials from http://api.gettyimages.com

## IntelliJ Installation
Import the module into your project
```
File | Import Module...
Point to the ConnectSdk folder
Click on Next, Next, Next, Next, Reuse, then click Finish
```
Add the module dependency to your application
````
File | Project Structure...
Click on Modules
Click on your main application
Click on the Dependencies tab
Click on the + to add a Module Dependency to your main application
Click OK
````

## Usage
Add a TextView control to your activity.
```
   <TextView
            android:id="@+id/textView"
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:text="Hello World, MyActivity"
            />
```
Add the following code to your activity.
```
import com.gettyimages.connectsdk.ConnectSdk;

public class MyActivity extends Activity {

    private String apiKey = "Connect API Key";
    private String apiSecret = "Connect API Secret";
	...
    String result;

	ConnectSdk connectSdk = new ConnectSdk(apiKey, apiSecret);
	result = connectSdk.Search().Images().Creative().WithPhrase("dog").WithPage(10).ExecuteAsync();
	
	TextView textView = (TextView) findViewById(R.id.textView);
    textView.setText(result);
	...
```
Update the AndroidManifest.xml to include internet permissions.
```
 <uses-permission android:name="android.permission.INTERNET"/>
```

## FAQ
* If you get an error running the test application make sure that you are using your Getty Key and Secret in the code.
## Contributing

1. Fork it ( https://github.com/[my-github-username]/ConnectSdk/fork )
2. Create your feature branch (`git checkout -b my-new-feature`)
3. Commit your changes (`git commit -am 'Add some feature'`)
4. Push to the branch (`git push origin my-new-feature`)
5. Create a new Pull Request
