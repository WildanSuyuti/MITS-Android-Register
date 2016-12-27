package com.mits.kakaroto.formregister;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    public static final String TAG = "TagMainActivity";
    public static final String ISLOGGEDIN = "isloggedin";
    private String sharedEmail, sharedPassword;
    private EditText etEmailLogin, etPassLogin;

    private String defaultEmail = "e", defaultpass = "p";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences(RegisterActivity.AUTH_PREFERENCES, MODE_PRIVATE);
        setContentView(R.layout.activity_login);

        etEmailLogin = (EditText) findViewById(R.id.et_emailLogin);
        etPassLogin = (EditText) findViewById(R.id.et_passLogin);

        sharedEmail = sharedPreferences.getString(RegisterActivity.NAME, "");
        sharedPassword = sharedPreferences.getString(RegisterActivity.PASSWORD, "");

        boolean isLoggedIn = sharedPreferences.getBoolean(ISLOGGEDIN, false);
        Log.d("isloggedin", String.valueOf(isLoggedIn));
        if (isLoggedIn) openDashboard();

    }


    public void submitSignIn(View view) {
        String email = etEmailLogin.getText().toString();
        String pass = etPassLogin.getText().toString();

        if (email.equalsIgnoreCase(sharedEmail) && pass.equalsIgnoreCase(sharedPassword)) {
            Toast.makeText(LoginActivity.this, "Login success", Toast.LENGTH_SHORT).show();
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(ISLOGGEDIN, true);
            editor.apply();
            openDashboard();
        } else {
            Toast.makeText(LoginActivity.this, "Email or password is invalid", Toast.LENGTH_SHORT).show();
        }

    }

    public void submitSignUp(View view) {
        startActivity(new Intent(this, RegisterActivity.class));
    }

    public void openDashboard() {
        startActivity(new Intent(this, DashboardActivity.class));
        finish();
    }


}
