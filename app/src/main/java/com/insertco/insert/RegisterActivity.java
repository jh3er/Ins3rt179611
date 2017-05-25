package com.insertco.insert;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
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
        String user = ((EditText) findViewById(R.id.editTextUsernameRegis)).getText().toString();
        String Email = ((EditText) findViewById(R.id.editTextEmailRegis)).getText().toString();
        String password = ((EditText) findViewById(R.id.editTextPasswordRegis)).getText().toString();
        String confirmpass = ((EditText) findViewById(R.id.editTextConPasswordRegis)).getText().toString();

        if(user.isEmpty()) {
            Snackbar.make(view, "Please Fill your Username", Snackbar.LENGTH_LONG).setAction("Action", null).show();
        }
        else if(user.length()<5){
            Snackbar.make(view, "Username Min. have 5 Characters", Snackbar.LENGTH_LONG).setAction("Action", null).show();
        }
        else if(!isValidEmail(Email)){
            Snackbar.make(view, "Invalid Email", Snackbar.LENGTH_LONG).setAction("Action", null).show();
        }
        else if(!password.equals(confirmpass)){
            Snackbar.make(view, "Password does not match the Confirm Password", Snackbar.LENGTH_LONG).setAction("Action", null).show();
        }
        else {
            Intent intent = new Intent(this, WelcomeActivity.class);
            startActivity(intent);
        }
    }

    public final static boolean isValidEmail(CharSequence target) {
        if (TextUtils.isEmpty(target)) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
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
