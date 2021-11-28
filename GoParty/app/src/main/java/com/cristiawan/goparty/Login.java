package com.cristiawan.goparty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cristiawan.goparty.Model.LoginRequest;
import com.cristiawan.goparty.Model.LoginResponse;
import com.cristiawan.goparty.Rest.ApiClient;
import com.cristiawan.goparty.Rest.ApiInterface;
import com.cristiawan.goparty.ui.home.HomeFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    EditText username,password;
    Button btnlogin;
    ApiInterface userInterface;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.edtUsernameLogin);
        password = findViewById(R.id.edtPasswordLogin);
        btnlogin = findViewById(R.id.btnLogin);
        userInterface = ApiClient.getClient().create(ApiInterface.class);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(username.getText().toString())){
                    username.setError("Username harus diisi");
                    username.requestFocus();
                }else if (TextUtils.isEmpty(password.getText().toString())){
                    password.setError("Password harus diisi");
                    password.requestFocus();
                }else{
                    login();
                }

            }
        });
    }

    public void login(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(username.getText().toString());
        loginRequest.setPassword(password.getText().toString());
        Call<LoginResponse> call = userInterface.loginuser(loginRequest);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.body() == null){
                    Toast.makeText(Login.this, "Password kurang dari 6", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(Login.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, Beranda.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(Login.this, "Password kurang dari 6", Toast.LENGTH_SHORT).show();
                Log.e("Retrofit", t.toString());
            }
        });
    }

    public void SignUp(View view) {
        Intent intent = new Intent(Login.this, Register.class);
        startActivity(intent);
    }

    public void btnlogin(View view) {
        Intent intent = new Intent(Login.this, Beranda.class);
        startActivity(intent);
    }


    public void LupaPass(View view) {
        Intent intent = new Intent(Login.this, LupaPasword.class);
        startActivity(intent);
    }
}