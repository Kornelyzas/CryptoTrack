package com.example.cryptotrack;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //---------------Initializing validation
    EditText log_user, log_pass;
    Button button_log;
    CheckBox rememberMeCheckBox;
    TextView reg_link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //-----------------Assigning Variables
        final EditText log_user = (EditText) findViewById(R.id.log_user);
        final EditText log_pass = (EditText) findViewById(R.id.log_pass);
        Button button_log = (Button) findViewById(R.id.button_log);
        final CheckBox rememberMeCheckBox = (CheckBox) findViewById(R.id.rememberMeCheckBox);
        TextView reg_link = (TextView) findViewById(R.id.reg_link);

//        final User user = new User(MainActivity.this);
//
//        rememberMeCheckBox.setChecked(user.isRememberedForLogin());
//
//        if (rememberMeCheckBox.isChecked()) {
//            log_user.setText(user.getUsernameForLogin(), TextView.BufferType.EDITABLE);
//            log_pass.setText(user.getPasswordForLogin(), TextView.BufferType.EDITABLE);
//        } else {
//            log_user.setText("", TextView.BufferType.EDITABLE);
//            log_pass.setText("", TextView.BufferType.EDITABLE);
//        }

        button_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //-----------------Button Click
                String log_user2 = log_user.getText().toString();
                String log_pass2 = log_pass.getText().toString();
                if (Validation.isCredentialsValid(log_user2) && Validation.isCredentialsValid(log_pass2)) {
                    Toast.makeText(MainActivity.this, "Logged In Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                    startActivity(intent);
                } else {
                    log_user.setError(getResources().getString(R.string.log_invalid_cred_message));
                    log_user.requestFocus();
                }
            }
        });

        reg_link.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }
}