package com.insertco.insert;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class addActivity extends AppCompatActivity {

    Spinner spinnerSize;
    Spinner spinnerType;
    Spinner spinnerGsm;

    ArrayAdapter<CharSequence> adapterSize;
    ArrayAdapter<CharSequence> adapterType;
    ArrayAdapter<CharSequence> adapterGsm;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        spinnerSize = (Spinner)findViewById(R.id.spinnerPaperSize);
        adapterSize = ArrayAdapter.createFromResource(this,R.array.Size_Array,android.R.layout.simple_spinner_item);
        adapterSize.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSize.setAdapter(adapterSize);


        spinnerType = (Spinner)findViewById(R.id.spinnerPaperType);
        adapterType = ArrayAdapter.createFromResource(this,R.array.Type_Array,android.R.layout.simple_spinner_item);
        adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerType.setAdapter(adapterType);

        spinnerGsm = (Spinner)findViewById(R.id.spinnerGSM);
        adapterGsm = ArrayAdapter.createFromResource(this,R.array.GSM_Array,android.R.layout.simple_spinner_item);
        adapterGsm.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGsm.setAdapter(adapterGsm);

        spinnerSize.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerGsm.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public void intentConfirm(View view) {
        // Do something in response to button
        Intent intent = new Intent(addActivity.this, confirmActivity.class);
        startActivity(intent);
    }
}

