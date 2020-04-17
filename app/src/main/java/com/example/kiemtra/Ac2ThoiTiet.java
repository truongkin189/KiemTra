package com.example.kiemtra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Ac2ThoiTiet extends AppCompatActivity {
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac2_thoi_tiet);
        Intent intent = getIntent();
        ThoiTiet wc = (ThoiTiet) intent.getSerializableExtra("country");
        tvResult = findViewById(R.id.tvResult);
        tvResult.setText("Tên quốc gia: "+ wc.getNameCountry()+"\nNhiệt độ: "+wc.getTemp()+"ºC");
    }
}
