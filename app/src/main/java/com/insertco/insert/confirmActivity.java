package com.insertco.insert;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class confirmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        TextView txtSize = (TextView)findViewById(R.id.textViewSize);
        TextView txtType = (TextView)findViewById(R.id.textViewType);
        TextView txtGsm = (TextView)findViewById(R.id.textViewGSM);
        TextView txtLocation = (TextView)findViewById(R.id.textViewLocation);

        String sizeSelected = getIntent().getExtras().getString("sizeSelected");
        String typeSelected = getIntent().getExtras().getString("typeSelected");
        String gsmSelected = getIntent().getExtras().getString("gsmSelected");
        String locationText = getIntent().getExtras().getString("locationText");
        txtSize.setText(sizeSelected);
        txtType.setText(typeSelected);
        txtGsm.setText(gsmSelected);
        txtLocation.setText(locationText);
    }
    public void intentDone(View view) {
        Intent intent = new Intent(confirmActivity.this, homeActivity.class);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), "Your Order have been Confirmed", Toast.LENGTH_SHORT).show();
    }
}
