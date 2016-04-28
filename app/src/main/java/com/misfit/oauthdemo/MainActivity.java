package com.misfit.oauthdemo;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final static String OAUTH_LINK = "shine://authorize?response_type=token&app_id=" + BuildConfig.APP_KEY + "&secret_hash=" + BuildConfig.SECRET_HASH;

    TextView mAppKeyTv;
    TextView mSecretHashTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAppKeyTv = (TextView) findViewById(R.id.tv_app_key);
        mSecretHashTv = (TextView) findViewById(R.id.tv_secret_hash);

        mAppKeyTv.setText(BuildConfig.APP_KEY);
        mSecretHashTv.setText(BuildConfig.SECRET_HASH);
    }


    public void onClicked(View v) {
        Uri requestUri = Uri.parse(OAUTH_LINK);
        Intent intent = new Intent(Intent.ACTION_VIEW, requestUri);
        Log.i("misifit", "url=" + requestUri.toString());
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, 0);
        boolean isIntentSafe = activities.size() > 0;

        // Start an activity if it's safe
        if (isIntentSafe) {
            startActivity(intent);
        } else {
            //FIXME:Can't find supported misfit app, pls do some workaround here
            Toast.makeText(this, "Can't find correspond activity", Toast.LENGTH_SHORT);
        }
    }
}
