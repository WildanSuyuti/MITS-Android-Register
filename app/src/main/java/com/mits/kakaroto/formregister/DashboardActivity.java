package com.mits.kakaroto.formregister;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private String name, email, address, phone, gender, password, result = "";
    private TextView tvUser;

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

        tvUser = (TextView) findViewById(R.id.tv_user);

        result = "Name : " + name + "\n Email : " + email + "\n Address : " + address + "\n Phone : " + phone + "\n" +
                "Gender : " + gender + "\n Password : " + password;

        tvUser.setText(result);
    }

    public void submitLogout(View view) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        startActivity(new Intent(this, RegisterActivity.class));
        finish();
    }

    public void submitUpdate(View view) {
        Intent intent = new Intent(this, UpdateActivity.class);
        startActivityForResult(intent, UpdateActivity.RESULT_UPDATE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            if (resultCode == UpdateActivity.RESULT_UPDATE) {

                String name = data.getStringExtra(RegisterActivity.NAME);
                String email = data.getStringExtra(RegisterActivity.EMAIL);
                String address = data.getStringExtra(RegisterActivity.ADDRESS);
                String phone = data.getStringExtra(RegisterActivity.PHONE);
                String gender = data.getStringExtra(RegisterActivity.GENDER);
                String pass = data.getStringExtra(RegisterActivity.PASSWORD);

                result = "Name : " + name + "\n Email : " + email + "\n Address : " + address + "\n Phone : " + phone + "\n" +
                        "Gender : " + gender + "\n Password : " + pass;
                tvUser.setText(result);

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(RegisterActivity.NAME, name);
                editor.putString(RegisterActivity.EMAIL, email);
                editor.putString(RegisterActivity.ADDRESS, address);
                editor.putString(RegisterActivity.PHONE, phone);
                editor.putString(RegisterActivity.GENDER, gender);
                editor.putString(RegisterActivity.PASSWORD, pass);
                editor.apply();

            }

    }

}
