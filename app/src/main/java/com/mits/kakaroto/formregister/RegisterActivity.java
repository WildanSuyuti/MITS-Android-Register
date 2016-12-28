package com.mits.kakaroto.formregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.mits.kakaroto.formregister.model.User;

public class RegisterActivity extends AppCompatActivity {

    private EditText etName, etEmail, etAddress, etPhone, etGender, etPassword;
    public static final String TAG = "TagMainActivity";
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sessionManager = SessionManager.getInstance();
        if (sessionManager.isLoggedin()) openDashboard();
        setContentView(R.layout.activity_register);
        Log.d(TAG, "onCreate is called");

        etName = (EditText) findViewById(R.id.et_name);
        etEmail = (EditText) findViewById(R.id.et_email);
        etAddress = (EditText) findViewById(R.id.et_address);
        etPhone = (EditText) findViewById(R.id.et_phone);
        etGender = (EditText) findViewById(R.id.et_gender);
        etPassword = (EditText) findViewById(R.id.et_password);
    }

    public void submitSave(View view) {

        String name =  etName.getText().toString();
        String email =  etEmail.getText().toString();
        String address = etAddress.getText().toString();
        String phone =  etPhone.getText().toString();
        String gender =  etGender.getText().toString();
        String pass =  etPassword.getText().toString();

        sessionManager.setRegister(new User(name,email,address,phone,gender,pass));
        openDashboard();

    }

    private void openDashboard() {
        startActivity(new Intent(this, DashboardActivity.class));
        finish();
    }

}
