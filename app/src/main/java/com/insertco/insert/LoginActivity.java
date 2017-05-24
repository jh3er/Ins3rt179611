package com.insertco.insert;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.StringDef;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

import static android.R.attr.password;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void intentRegister(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void intentLogin(View view) {
        EditText username = (EditText) findViewById(R.id.editTextUsername);
        EditText password = (EditText) findViewById(R.id.editTextPassword);
        String user = username.getText().toString();
        String pass = password.getText().toString();
        if(user.equals("admin") && pass.equals("adminjr"))
        {
            Intent intent = new Intent(this, homeActivity.class);
            startActivity(intent);
        }

        else
        {
            Snackbar.make(view, "Wrong Username or Password", Snackbar.LENGTH_LONG)
                  .setAction("Action", null).show();
        }

    }


}

    // Validation for email and password

