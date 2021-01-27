package com.example.cryptotrack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {

    //---------------Initializing validation
    EditText reg_user, reg_email, reg_pass;
    Button button_reg;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        //-----------------Assigning Variables
        final EditText reg_user = (EditText) findViewById(R.id.reg_user);
        final EditText reg_email = (EditText) findViewById(R.id.reg_email);
        final EditText reg_pass = (EditText) findViewById(R.id.reg_pass);
        Button button_reg = (Button) findViewById(R.id.button_reg);

        button_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //-----------------Button Click
                String reg_user2 = reg_user.getText().toString();
                String reg_email2 = reg_email.getText().toString();
                String reg_pass2 = reg_pass.getText().toString();

                if (Validation.isCredentialsValid(reg_user2) && Validation.isCredentialsValid(reg_pass2) && Validation.isCredentialsValid(reg_email2)) {
                    Toast.makeText(RegistrationActivity.this, "Registration Succesfull", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    reg_user.setError(getResources().getString(R.string.log_invalid_cred_message));
                    reg_user.requestFocus();
                }
            }
        });
    }
}
