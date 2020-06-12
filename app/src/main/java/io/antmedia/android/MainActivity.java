package io.antmedia.android;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


import com.airbnb.deeplinkdispatch.DeepLink;

import io.antmedia.android.liveVideoBroadcaster.*;
import io.antmedia.android.liveVideoPlayer.LiveVideoPlayerActivity;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

@DeepLink("http://example.com/deepLink/")
public class MainActivity extends AppCompatActivity {

    /**
     * PLEASE WRITE RTMP BASE URL of the your RTMP SERVER.
     */
    //public static final String RTMP_BASE_URL = "rtmp://10.10.31.87/LiveApp/";
    public static final String RTMP_BASE_URL =  "rtmp://ec2-34-232-76-94.compute-1.amazonaws.com/LiveApp/";
    public  String preDefined = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(io.antmedia.android.liveVideoBroadcaster.R.layout.activity_main);
        // ATTENTION: This was auto-generated to handle app links.
        Intent intent = getIntent();
        String action = intent.getAction();
        Uri data = intent.getData();
        if (data != null && data.isHierarchical()) {
            Log.i("MyApp", "Received link click on URL: " + intent.getDataString());
            preDefined = intent.getDataString().replaceFirst(".*/(\\w+).*","$1");
            Intent i = new Intent(this, LiveVideoPlayerActivity.class);
            i.putExtra("preDefinedURI",preDefined);
            startActivity(i);
        }
        // ATTENTION: This was auto-generated to handle app links.
        Intent appLinkIntent = getIntent();
        String appLinkAction = appLinkIntent.getAction();
        Uri appLinkData = appLinkIntent.getData();
    }

    public void openVideoBroadcaster(View view) {
        Intent i = new Intent(this, LiveVideoBroadcasterActivity.class);
        startActivity(i);
    }

    public void openVideoPlayer(View view) {
        Intent i = new Intent(this, LiveVideoPlayerActivity.class);
        startActivity(i);
    }
}
