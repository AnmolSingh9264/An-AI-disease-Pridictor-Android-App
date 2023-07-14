package com.anmol.aidiseasepridictor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;
import com.chaquo.python.android.PyApplication;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.rgb(255,255,255));
        getSupportActionBar().hide();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                |View.SYSTEM_UI_FLAG_IMMERSIVE|View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        setContentView(R.layout.activity_main);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                ConstraintLayout layout=findViewById(R.id.child);
                layout.setVisibility(View.GONE);
                FragmentManager manager=getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.mainlayout,new Home()).addToBackStack(null).commit();
            }
        },3000);
       /* if (! Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
            Python python=Python.getInstance();
            PyObject object=python.getModule("multiple disease pred");
            Object object2=new Object();
            String s=object.callAttr("diab_prediction_f","6","148","72","35","0","33.6","0.627","50").toString();
            Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
         //   text.setText("output "+s);
        }*/
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}