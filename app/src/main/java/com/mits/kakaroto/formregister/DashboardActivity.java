package com.mits.kakaroto.formregister;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private String name, email, address, phone, gender, password, data="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashbord);

        sharedPreferences = getSharedPreferences(RegisterActivity.AUTH_PREFERENCES, MODE_PRIVATE);

        name = sharedPreferences.getString(RegisterActivity.NAME, "");
        email = sharedPreferences.getString(RegisterActivity.EMAIL, "");
        address = sharedPreferences.getString(RegisterActivity.ADDRESS, "");
        phone = sharedPreferences.getString(RegisterActivity.PHONE, "");
        gender = sharedPreferences.getString(RegisterActivity.GENDER, "");
        password = sharedPreferences.getString(RegisterActivity.PASSWORD, "");

        TextView tvUser = (TextView) findViewById(R.id.tv_user);

        data ="Name : "+ name+"\n Email : "+email+"\n Address : "+address+"\n Phone : "+phone+"\n"+
                "Gender : "+gender+"\n Password : "+password;

        tvUser.setText(String.format("email %s, pass : %s", email, password));
    }

    public void submitLogout(View view) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(RegisterActivity.EMAIL);
        editor.remove(RegisterActivity.PASSWORD);
        editor.clear();
        editor.apply();
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}
