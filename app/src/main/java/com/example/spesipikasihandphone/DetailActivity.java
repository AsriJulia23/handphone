package com.example.spesipikasihandphone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.camera2.CaptureResult;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.security.Key;

public class DetailActivity extends AppCompatActivity {
    public static String KEY_ACTIVITY;
    private TextView NamaProduk,ram,internalmemory,harga;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        NamaProduk=(TextView)findViewById(R.id.txt_nama_produk);
        ram=(TextView)findViewById(R.id.txt_ram);
        internalmemory=(TextView)findViewById(R.id.txt_internal);
        imageView=(ImageView)findViewById(R.id.imgView1);
        harga=(TextView)findViewById(R.id.txt_harga);

        Intent intent=getIntent();
        Handphone hpnya=(Handphone)intent.getSerializableExtra(KEY_ACTIVITY);
        NamaProduk.setText(hpnya.getNama_produk());
        ram.setText(hpnya.getRam());
        internalmemory.setText(hpnya.getInternal_memory());
        harga.setText(hpnya.getHarga());
        Picasso.with(this).load(hpnya.getPic()).into(imageView);


    }
}
