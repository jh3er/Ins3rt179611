package com.insertco.insert;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
    public void intentBackLogin(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

}
