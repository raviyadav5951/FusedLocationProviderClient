package com.askfortricks.fusedlocationproviderclient;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    private final Handler handler = new Handler();
    private boolean isNetworkLocation, isGPSLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash_activity);
        StartAnimations();

        LocationManager mListener = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if(mListener != null){
            isGPSLocation = mListener.isProviderEnabled(LocationManager.GPS_PROVIDER);
            isNetworkLocation = mListener.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
            Log.e("gps, network", String.valueOf(isGPSLocation + "," + isNetworkLocation));
        }
        handler.postDelayed(new Runnable(){
            @Override
            public void run() {
                if(isGPSLocation){
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    intent.putExtra("provider", LocationManager.GPS_PROVIDER);
                    startActivity(intent);
                    finish();
                }else if(isNetworkLocation){
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    intent.putExtra("provider", LocationManager.NETWORK_PROVIDER);
                    startActivity(intent);
                    finish();
                }else{
                    //Device location is not set
                    PermissionUtils.LocationSettingDialog.newInstance().show(getSupportFragmentManager(), "Setting");
                }
            }
        }, 1500);
    }

    private void StartAnimations() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        LinearLayout l= findViewById(R.id.lin_lay);
        l.clearAnimation();
        l.startAnimation(anim);

        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();
        TextView tv = findViewById(R.id.logo);
        tv.clearAnimation();
        tv.startAnimation(anim);

    }

    @Override
    protected void onRestart(){
        super.onRestart();
        startActivity(new Intent(this, SplashActivity.class));
        finish();
    }
}
