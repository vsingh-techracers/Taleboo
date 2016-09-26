package com.example.vinay.taleebo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.vinay.taleebo.homePage.AppMainActivity;

public class LoginActivity extends AppCompatActivity {

    Button signIn, signinGoogle;
    TextView signupText,term2,username,password,forgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (TextView)findViewById(R.id.usernametext);
        //Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/RobotoCondensed-Regular.ttf");
        //username.setTypeface(custom_font);
        forgotPassword=(TextView)findViewById(R.id.forgotPassword);
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(LoginActivity.this,HomeActivity.class);
                startActivity(i);
            }
        });
        signIn=(Button)findViewById(R.id.signin);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(LoginActivity.this,AppMainActivity.class);
                startActivity(i);
            }
        });
        signinGoogle = (Button) findViewById(R.id.signinGoogle);
        signinGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(LoginActivity.this,HomeActivity.class);
                startActivity(i);
            }
        });
        signupText = (TextView)findViewById(R.id.signupText);
        signupText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(LoginActivity.this,HomeActivity.class);
                startActivity(i);
            }
        });
        term2 = (TextView)findViewById(R.id.term2);
        term2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(LoginActivity.this,HomeActivity.class);
                startActivity(i);
            }
        });
    }
}
