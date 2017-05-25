package com.insertco.insert;

import android.app.Notification;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


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
    Random rand = new Random();
    int verifCode = rand.nextInt(10000 - 1000) + 1000;
    String verif = String.valueOf(verifCode);
    public void intentDone(View view) {
        final Intent intent = new Intent(confirmActivity.this, homeActivity.class);
        NotificationCompat.Builder notificationBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(confirmActivity.this)
                .setSmallIcon(R.drawable.print)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                .setContentTitle("Insert Verification Code")
                .setContentText(verif);
        notificationBuilder.setDefaults(
                Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(confirmActivity.this);
        notificationManager.notify(1, notificationBuilder.build());

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(confirmActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.dialog_verification, null);
        final EditText editTextVerif = (EditText) mView.findViewById(R.id.etVerif);
        Button buttonVerif = (Button) mView.findViewById(R.id.btnVerif);


        mBuilder.setView(mView);
        final AlertDialog dialog = mBuilder.create();
        dialog.show();
        buttonVerif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editTextVerif.getText().toString().isEmpty()){
                    Toast.makeText(confirmActivity.this,"Please insert the Verification Code",Toast.LENGTH_SHORT).show();
                }
                else if(!editTextVerif.getText().toString().equals(verif)){
                    Toast.makeText(confirmActivity.this,"Wrong Verification Code",Toast.LENGTH_SHORT).show();
                }
                else{
                    dialog.dismiss();
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Your Order have been Confirmed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
