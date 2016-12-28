package com.mits.kakaroto.formregister;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private EditText etUpdateName, etUpdateEmail, etUpdateAddress, etUpdatePhone, etUpdateGender, etUpdatePass;
    private String name, email, address, phone, gender, password;
    public static final int RESULT_UPDATE=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences(RegisterActivity.AUTH_PREFERENCES, MODE_PRIVATE);

        setContentView(R.layout.activity_update);
        etUpdateName = (EditText) findViewById(R.id.et_updateName);
        etUpdateEmail = (EditText) findViewById(R.id.et_updateEmail);
        etUpdateAddress = (EditText) findViewById(R.id.et_updateAddress);
        etUpdatePhone = (EditText) findViewById(R.id.et_updatePhone);
        etUpdateGender = (EditText) findViewById(R.id.et_updateGender);
        etUpdatePass = (EditText) findViewById(R.id.et_updatePassword);

        name = sharedPreferences.getString(RegisterActivity.NAME, "");
        email = sharedPreferences.getString(RegisterActivity.EMAIL, "");
        address = sharedPreferences.getString(RegisterActivity.ADDRESS, "");
        phone = sharedPreferences.getString(RegisterActivity.PHONE, "");
        gender = sharedPreferences.getString(RegisterActivity.GENDER, "");
        password = sharedPreferences.getString(RegisterActivity.PASSWORD, "");

        etUpdateName.setText(name);
        etUpdateEmail.setText(email);
        etUpdateAddress.setText(address);
        etUpdatePhone.setText(phone);
        etUpdateGender.setText(gender);
        etUpdatePass.setText(password);

    }

    public void submitSaveUpdate(View view){
        String updateName, updateEmail, updateAddress, updatePhone, updateGender, updatePass;
        updateName = etUpdateName.getText().toString();
        updateEmail = etUpdateEmail.getText().toString();
        updateAddress = etUpdateAddress.getText().toString();
        updatePhone = etUpdatePhone.getText().toString();
        updateGender = etUpdateGender.getText().toString();
        updatePass = etUpdatePass.getText().toString();

        Intent intent = new Intent();
        intent.putExtra(RegisterActivity.NAME, updateName);
        intent.putExtra(RegisterActivity.EMAIL, updateEmail);
        intent.putExtra(RegisterActivity.ADDRESS, updateAddress);
        intent.putExtra(RegisterActivity.PHONE, updatePhone);
        intent.putExtra(RegisterActivity.GENDER, updateGender);
        intent.putExtra(RegisterActivity.PASSWORD, updatePass);
        setResult(RESULT_UPDATE, intent);
        finish();
    }




}
