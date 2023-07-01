package com.example.onlineexamapplyplatform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onlineexamapplyplatform.dto.Member;
import com.example.onlineexamapplyplatform.service.AuthService;

public class MainActivity extends AppCompatActivity {

    Button registerBtn;
    EditText userNameTxt, emailAddressTxt, passwordTxt, passwordConfTxt;

    AuthService authService = new AuthService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerBtn = findViewById(R.id.registerBtn);

        userNameTxt = findViewById(R.id.usernameTxt);
        emailAddressTxt = findViewById(R.id.emailTxt);
        passwordTxt = findViewById(R.id.passwordTxt);
        passwordConfTxt = findViewById(R.id.confPassTxt);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Member member;

                if (userNameTxt.getText().toString() != null && emailAddressTxt.getText().toString() != null && passwordTxt.getText().toString() != null) {
                    if (passwordTxt.getText().toString().equals(passwordConfTxt.getText().toString())) {
                        member = new Member(userNameTxt.getText().toString(), emailAddressTxt.getText().toString(), passwordTxt.getText().toString());

                        if (authService.registerNewMemberDetails(member, MainActivity.this) == true) {
                            showToast(MainActivity.this, "Member Registered Successfully.");

                            userNameTxt.setText("");
                            emailAddressTxt.setText("");
                            passwordTxt.setText("");
                            passwordConfTxt.setText("");

                            Intent loginActivity = new Intent(MainActivity.this, SignInActivity.class);
                            startActivity(loginActivity);

                        } else {
                            showToast(MainActivity.this, "There is an Error Occured.");
                        }
                    } else {
                        showToast(MainActivity.this, "Password Not Mathced.");
                    }
                } else {
                    showToast(MainActivity.this, "Please Enter All Fields.");
                }
            }
        });
    }

    public void goToSigninActivity (View view){
        Intent intent = new Intent (this, SignInActivity.class);
        startActivity(intent);
    }

    public void showToast(Context context, String msg){
        Toast.makeText(context,msg, Toast.LENGTH_LONG).show();
    }
}