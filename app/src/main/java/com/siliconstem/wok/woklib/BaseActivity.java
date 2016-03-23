package com.siliconstem.wok.woklib;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {

    private boolean showToast=true;
    private boolean logAll=true;
    private String logTag;
    private String className;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);


        logTag=getApplicationName();
        className=this.getClass().getName()+":";
        l(className+Util.getMethodName());
    }



    public void onStart()
    {
        super.onStart();
        l(className+Util.getMethodName());

    }
    public void onRestart()
    {
        super.onRestart();
        l(className+Util.getMethodName());

    }
    public void onResume()
    {
        super.onResume();
        l(className+Util.getMethodName());

    }
    public void onPause()
    {
        super.onPause();
        l(className+Util.getMethodName());

    }
    public void onStop()
    {
        super.onStop();
        l(className+Util.getMethodName());

    }
    public void onDestroy()
    {
        super.onDestroy();
        l(className+Util.getMethodName());

    }


    public void l(String message){
        log(message);
        toast(message);
    }
    public void log(String message){
        if(logAll)Log.v(logTag, message);
    }
    public void toast(String message){
        if (showToast) Toast.makeText(this.getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
    public String getApplicationName() {
        Context context=this.getApplicationContext();
        int stringId = context.getApplicationInfo().labelRes;
        return context.getString(stringId);
    }
}

