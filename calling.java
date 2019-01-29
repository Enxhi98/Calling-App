package com.example.enxhikaziu.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//Simple "calling" class that displays a dialling page alongside with an "End Call" button
public class calling extends Activity {

    Button btnEndCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calling);
        btnEndCall = findViewById(R.id.buttonEndCall);
    }

    //Takes the user to the main page
    public void endCall(View v){
        Intent intent = new Intent(calling.this, MainActivity.class);
        startActivity(intent);
    }
}