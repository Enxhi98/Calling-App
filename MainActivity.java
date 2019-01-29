package com.example.enxhikaziu.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Declaring variables
    Button btnOne;
    Button btnTwo;
    Button btnThree;
    Button btnFour;
    Button btnFive;
    Button btnSix;
    Button btnSeven;
    Button btnEight;
    Button btnNine;
    Button btnStar;
    Button btnZero;
    Button btnHash;
    Button btnDelete;
    Button btnDial;
    Button btnContacts;

    EditText input;


    //Overrided method which defines what layout is used for this specific activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOne = findViewById(R.id.buttonOne);
        btnTwo = findViewById(R.id.buttonTwo);
        btnThree = findViewById(R.id.buttonThree);
        btnFour = findViewById(R.id.buttonFour);
        btnFive = findViewById(R.id.buttonFive);
        btnSix = findViewById(R.id.buttonSix);
        btnSeven = findViewById(R.id.buttonSeven);
        btnEight = findViewById(R.id.buttonEight);
        btnNine = findViewById(R.id.buttonNine);
        btnStar = findViewById(R.id.buttonStar);
        btnZero = findViewById(R.id.buttonZero);
        btnHash = findViewById(R.id.buttonHash);
        btnDelete = findViewById(R.id.buttonDelete);
        btnDial = findViewById(R.id.buttonDial);
        btnContacts = findViewById(R.id.buttonContacts);

        input = findViewById(R.id.editText);
    }

    //Following methods make the numbers visible on the input field after the user presses the keypad
    public void one(View v) {
        onButtonClick(btnOne, input, "1");
    }

    public void two(View v) {
        onButtonClick(btnTwo, input, "2");
    }

    public void three(View v) {
        onButtonClick(btnThree, input, "3");
    }

    public void four(View v) {
        onButtonClick(btnFour, input, "4");
    }

    public void five(View v) {
        onButtonClick(btnFive, input, "5");
    }

    public void six(View v) {
        onButtonClick(btnSix, input, "6");
    }

    public void seven(View v) {
        onButtonClick(btnSeven, input, "7");
    }

    public void eight(View v) {
        onButtonClick(btnEight, input, "8");
    }

    public void nine(View v) {
        onButtonClick(btnNine, input, "9");
    }

    public void star(View v) {
        onButtonClick(btnStar, input, "*");
    }

    public void zero(View v) {
        onButtonClick(btnZero, input, "0");
    }

    public void hash(View v) {
        onButtonClick(btnHash, input, "#");
    }

    //Deletes whatever the user has typed
    public void onDelete(View v) {
        input.setText("");
    }

    //Starts a dialling page depending on its "if" condition
    public void onDial(View v) {
        //If the length of input is more and less than 11, an error message will appear, asking the user to type a valid number
        if (input.getText().length() > 11 || input.getText().length() < 11) {
            Toast.makeText(this, "Please Enter A Valid Number", Toast.LENGTH_SHORT).show();
        }
        //If the number is correct the dialling page will appear
        else {

            Intent intent = new Intent(MainActivity.this, calling.class);
            startActivity(intent);

        }
    }

    //When pressed displays the contacts list
    public void displayContacts(View v) {
        Intent intent = new Intent(MainActivity.this, AddContact.class);
        startActivity(intent);
    }


    public void onButtonClick(Button button, EditText inputNumber, String number) {
        String cache = input.getText().toString();
        inputNumber.setText(cache + number);

    }

}


