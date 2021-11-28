package com.cristiawan.goparty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import in.aabhasjindal.otptextview.OTPListener;
import in.aabhasjindal.otptextview.OtpTextView;

public class LupaPasword extends AppCompatActivity {
    private OtpTextView otpTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lupa_password);

        otpTextView = findViewById(R.id.otpview);
        otpTextView.setOtpListener(new OTPListener() {
            @Override
            public void onInteractionListener() {

            }

            public void BtnRegis(View view) {
                Intent intent = new Intent(LupaPasword.this, Login.class);
                startActivity(intent);
            }

            public void btnlogin(View view) {
                Intent intent = new Intent(LupaPasword.this, Login.class);
                startActivity(intent);
            }

            public void LupaPass(View view) {
                Intent intent = new Intent(LupaPasword.this, Login.class);
                startActivity(intent);
            }

            @Override
            public void onOTPComplete(String otp) {
                if (otp.equals("12345")) {
                    otpTextView.showSuccess();
                    Toast.makeText(LupaPasword.this, "Kode Verifikasi BENAR" + otp, Toast.LENGTH_LONG).show();
                } else {
                    otpTextView.showError();
                    Toast.makeText(LupaPasword.this, "Kode Verifikasi salah" + otp, Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}
