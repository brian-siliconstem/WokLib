package com.siliconstem.wok.woklib;

import android.app.ActionBar;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {

    protected boolean showToast=false;
    protected boolean logAll=true;
    protected boolean hideSoftKeys=true;
    protected boolean hideStatusBar=true;
    protected boolean hideActionBar=true;
    protected String logTag;
    protected String className;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        logTag=getApplicationName();
        className=this.getClass().getName() + ":";
        if(hideActionBar)hideActionBar();
        setContentView(R.layout.activity_base);

        l();
    }



    public void onStart()
    {
        super.onStart();
        l();
    }
    public void onRestart()
    {
        super.onRestart();
        l();
    }
    public void onResume()
    {
        super.onResume();
        l();
        if(hideStatusBar)hideStatusBar();
        if(hideSoftKeys) hideSoftKeys();
    }
    public void onPause()
    {
        super.onPause();
        l();
    }
    public void onStop()
    {
        super.onStop();
        l();
    }
    public void onDestroy()
    {
        super.onDestroy();
        l();
    }
    protected void hideStatusBar(){
        l();
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    protected void hideSoftKeys(){
        l();
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION| View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }
    protected void hideActionBar(){
        l();
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
    }

    public void l(){
        l("");
    }
    public void l(String message){
        int depth=1;
        if (message.length()==0){
            depth++;
        }else{
            message=":"+message;
        }
        String fullMessage=className+Util.getMethodName(depth)+message;
        log(fullMessage);
        toast(fullMessage);
    }
    public void log(String message){
        if(logAll)Log.v(logTag, message);
    }

    /**
     * Display a Toast mesage
     * @param message message to display in Toast
     */
    public void toast(String message){
        if (showToast) Toast.makeText(this.getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    /**
     * Get the name of the application
     * @return the name of the Application
     */
    public String getApplicationName() {
        Context context=this.getApplicationContext();
        int stringId = context.getApplicationInfo().labelRes;
        return context.getString(stringId);
    }
}

