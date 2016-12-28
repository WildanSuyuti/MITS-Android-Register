package com.mits.kakaroto.formregister;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    private EditText etName, etEmail, etAddress, etPhone, etGender, etPassword;
    public static final String TAG = "TagMainActivity";
    public static final String AUTH_PREFERENCES = "auth_preferences";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String ADDRESS = "address";
    public static final String PHONE = "phone";
    public static final String GENDER = "gender";
    public static final String PASSWORD = "password";
    public static final String ISLOGGEDIN = "isloggedin";

    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences = getSharedPreferences(AUTH_PREFERENCES, MODE_PRIVATE);
        boolean isLoggedIn = sharedPreferences.getBoolean(ISLOGGEDIN, false);
        Log.d("isloggedin", String.valueOf(isLoggedIn));
        if (isLoggedIn) openDashboard();
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
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(NAME, etName.getText().toString());
        editor.putString(EMAIL, etEmail.getText().toString());
        editor.putString(ADDRESS, etAddress.getText().toString());
        editor.putString(PHONE, etPhone.getText().toString());
        editor.putString(GENDER, etGender.getText().toString());
        editor.putString(PASSWORD, etPassword.getText().toString());
        editor.putBoolean(ISLOGGEDIN, true);
        editor.apply();
        openDashboard();
    }

    private void openDashboard() {
        startActivity(new Intent(this, DashboardActivity.class));
        finish();
    }

}
