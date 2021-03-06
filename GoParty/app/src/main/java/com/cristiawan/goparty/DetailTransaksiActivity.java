package com.cristiawan.goparty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailTransaksiActivity extends AppCompatActivity {

    TextView textView,textview2,textView3;
    ImageView imageview2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_transaction);

        setToolbar();



            load();
            textView.setText(getIntent().getStringExtra("NamaBarang"));
            textview2.setText(""+getIntent().getIntExtra("Jumlah",0));
            textView3.setText(getIntent().getStringExtra("Harga"));
        Glide.with(DetailTransaksiActivity.this)
                .load("" + getIntent().getStringExtra("imageView2"))
                .apply(new RequestOptions().override(2000,1000))
                .into(imageview2);


    }

    private void setToolbar() {
        Toolbar appbar = findViewById(R.id.customToolbar);
        setSupportActionBar(appbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        TextView tvTitle = findViewById(R.id.tvToolbar);
        tvTitle.setText("Detail");

        ImageView ivBack = findViewById(R.id.btnBack);
        ivBack.setOnClickListener(v -> finish());



    }
    public void load(){
        textView = findViewById(R.id.textView);
        textview2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        imageview2 = findViewById(R.id.imgDetail);
    }


    public void btn(View view) {
        Button btnRent = findViewById(R.id.btnRent);
            Intent intent = new Intent(this, RentActivity.class);
            startActivity(intent);

    }
}
