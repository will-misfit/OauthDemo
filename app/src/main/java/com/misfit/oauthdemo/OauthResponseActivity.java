package com.misfit.oauthdemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class OauthResponseActivity extends Activity {

    TextView mUriTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);
        mUriTv = (TextView) findViewById(R.id.tv_uri);

        Uri response = getIntent().getData();
        if (response != null) {
            showResponse(response);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Uri response = getIntent().getData();
        if (response != null) {
            showResponse(response);
        }
    }

    private void showResponse(Uri response) {
        mUriTv.setText(response.toString());
    }
}
