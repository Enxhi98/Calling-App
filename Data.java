package com.example.enxhikaziu.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

//This class retrieves the user input
public class Data extends Activity {
    //Declaration of variables
    EditText editName, editNumber, editCompany;
    Button save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data);
        //Input fields
        editName = (EditText) findViewById(R.id.editName);
        editCompany = (EditText) findViewById(R.id.editCompany);
        editNumber = (EditText) findViewById(R.id.editNumber);

        //Button "Save"
        save = (Button) findViewById(R.id.save);

        //Button listener; creates a new intent which stores the information into a whole string of the "Contacts" class of a "contact" object
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contacts contacts = new Contacts(editName.getText().toString(),
                        editCompany.getText().toString(), editNumber.getText().toString());

                Intent intent5 = new Intent(Data.this, MainActivity.class);

                intent5.putExtra("data", contacts);
                setResult(2, intent5);

                finish();
            }

        });

    }

}
