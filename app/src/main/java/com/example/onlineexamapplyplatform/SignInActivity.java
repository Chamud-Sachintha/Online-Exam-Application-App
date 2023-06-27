package com.example.onlineexamapplyplatform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onlineexamapplyplatform.dto.Member;
import com.example.onlineexamapplyplatform.service.AuthService;

public class SignInActivity extends AppCompatActivity {

    private AuthService authService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }

    public void checkLoginDetails(View view) throws Exception {
        Member memberDTO = new Member();
        EditText userEmail = (EditText)findViewById(R.id.emailAddress);
        EditText password = (EditText) findViewById(R.id.password);

        memberDTO.setMemberEmail(userEmail.getText().toString());
        memberDTO.setPassword(password.getText().toString());

        if(authService.checkMemberLoginCredentials(memberDTO) == true) {
            this.showToast(this, "Login Successfully.");
        } else {
            this.showToast(this, "Invalid username or password");
        }
    }

    public void showToast(Context context, String msg){
        Toast.makeText(context,msg, Toast.LENGTH_LONG).show();
    }
}