package com.insertco.insert;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        TransparentNotifBar();
    }
    public void intentBackLogin(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void intentGetStart(View view){

        String Email = ((EditText) findViewById(R.id.editTextEmailRegis)).getText().toString();
        String password = ((EditText) findViewById(R.id.editTextPasswordRegis)).getText().toString();
        String confirmpass = ((EditText) findViewById(R.id.editTextConPasswordRegis)).getText().toString();
        String user = ((EditText) findViewById(R.id.editTextUsernameRegis)).getText().toString();
        if(validation(user , Email , password , confirmpass) == true)
        {
            Intent intent = new Intent(this, WelcomeActivity.class);
            startActivity(intent);
        }
        else
        {
            Snackbar.make(view, "make sure password and confirm password are matched", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    }

    private boolean validation(String username , String email , String pass , String confPass){
        if(username.length() < 5)
        {
            return false;
        }
        else if(!email.contains("@"))
        {
            return false ;
        }
        else if(!pass.equals(confPass))
        {
            return false ;
        }
        else
        {
            return true ;
        }
    }

    public void TransparentNotifBar(){
//        harus minimal dari API 21 -> Lolipop
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

}
