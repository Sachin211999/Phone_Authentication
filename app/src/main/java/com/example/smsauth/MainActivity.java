package com.example.smsauth;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.hbb20.CountryCodePicker;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
FirebaseAuth mAuth;
EditText phone,code;
Button send;
CountryCodePicker countryCodePicker;
String phonenumber;
private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phone=(EditText)findViewById(R.id.editTexPhone);
        //code=(EditText)findViewById(R.id.editTextCode);
        send=(Button)findViewById(R.id.send);
        countryCodePicker=(CountryCodePicker)findViewById(R.id.ccp);
        countryCodePicker.registerCarrierNumberEditText(phone);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(phone.getText().toString())){
                    Toast.makeText(MainActivity.this, "Enter No ....", Toast.LENGTH_SHORT).show();
                }
                else if(phone.getText().toString().replace(" ","").length()!=10){
                    Toast.makeText(MainActivity.this, "Enter Correct No ...", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(MainActivity.this,Verificationactivity.class);
                    intent.putExtra("phone",countryCodePicker.getFullNumberWithPlus().replace(" ",""));
                    startActivity(intent);
                }
            }
        });
    }
}
