package com.mits.kakaroto.formregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mits.kakaroto.formregister.model.User;

public class DashboardActivity extends AppCompatActivity {
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sessionManager = SessionManager.getInstance();
        setContentView(R.layout.activity_dashbord);

    }

    @Override
    protected void onResume() {
        super.onResume();
        String result = "";
        TextView tvUser = (TextView) findViewById(R.id.tv_user);

        User user = sessionManager.getUser();
        result = " Name : " + user.getName() + "\n Email : " + user.getEmail() + "\n Address : " +
                user.getAddress() + "\n Phone : " + user.getPhone() + "\n" +
                " Gender : " + user.getGender() + "\n Password : " + user.getPassword();

        tvUser.setText(result);
    }

    public void submitLogout(View view) {
        sessionManager.clear();
        finish();
    }

    public void submitUpdate(View view) {
        startActivity(new Intent(this, UpdateActivity.class));

    }

}
