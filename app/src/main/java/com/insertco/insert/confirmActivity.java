package com.insertco.insert;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class confirmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
    }
    public void intentDone(View view) {
        // Do something in response to button
        Intent intent = new Intent(confirmActivity.this, homeActivity.class);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), "Your Order have been Confirmed", Toast.LENGTH_SHORT).show();
    }
}
