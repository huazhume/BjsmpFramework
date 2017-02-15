package com.lenservice.bjmspqqmf.Interface.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.lenservice.bjmspqqmf.R;

/**
 * Created by len on 16/12/27.
 */

public class QFLauncherScreenActvity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        //跳转mainActivity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(QFLauncherScreenActvity.this, QFLoginActivity.class);
                mainIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                QFLauncherScreenActvity.this.startActivity(mainIntent);
                QFLauncherScreenActvity.this.finish();
            }
        },2000);
    }
}

