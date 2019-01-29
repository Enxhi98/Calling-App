package com.example.enxhikaziu.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

//This class displays the details of each contact
public class ContactDetails extends Activity {
    //Declaration of variables
    Contacts ContactDetails;
    private String mContactName, mContactNumber, mContactCompany;
    TextView details_name, details_number, details_company;
    Button backButton;
    Button buttonCall1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_details);


        backButton = (Button) findViewById(R.id.backButton);

        details_name = (TextView) findViewById(R.id.details_name);
        details_number = (TextView) findViewById(R.id.details_number);
        details_company = (TextView) findViewById(R.id.details_company);

        //Creating a new intent that will be used to retrieve contacts details
        Intent intent9 = new Intent();
        intent9 = getIntent();
        ContactDetails = (Contacts) intent9.getSerializableExtra("details");


        //Linking variables to parameters from "Contacts" class methods
        mContactNumber = ContactDetails.getNumber();
        mContactName = ContactDetails.getName();
        mContactCompany = ContactDetails.getCompany();


        details_name.setText(mContactName);

        details_number.setText(mContactNumber);
        details_company.setText(mContactCompany);


        //Button takes the user back to the previous stage
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    //Button takes the user to the dialling page
    public void onDial1(View v) {
        Intent intent = new Intent(ContactDetails.this, calling.class);
        startActivity(intent);
    }
}
