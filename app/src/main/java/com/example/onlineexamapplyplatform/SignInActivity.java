package com.example.onlineexamapplyplatform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }

    public void checkLoginDetails(View view) {
        EditText userEmail = (EditText)findViewById(R.id.emailAddress);
        EditText password = (EditText) findViewById(R.id.password);

        String emailAddress = userEmail.getText().toString();
        String passwordInput = password.getText().toString();

        if (emailAddress.equals("test@gmail.com") && passwordInput.equals("123")) {
            this.showToast(this, "Login Successfully.");
        } else {
            this.showToast(this, "Useremail or Password Invalid.");
        }
    }

    public void showToast(Context context, String msg){
        Toast.makeText(context,msg, Toast.LENGTH_LONG).show();
    }
}