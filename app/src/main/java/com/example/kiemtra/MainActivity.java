package com.example.kiemtra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    Button btnAdd, btnView;
    ThoiTietAdapter adapter;
    List<ThoiTiet> lstData;
    EditText etName, etTemp;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addData();
        addControl();
        addEvent();
        intent = new Intent(this, Ac2ThoiTiet.class);
    }
    private void addEvent() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etName.getText().toString().trim().isEmpty() || etTemp.getText().toString().trim().isEmpty()) return;
                lstData.add(new ThoiTiet(etName.getText().toString(), Integer.parseInt(etTemp.getText().toString())));
                adapter.notifyDataSetChanged();
            }
        });
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThoiTiet wc = lstData.get(0);
                for(int i = 0; i < lstData.size(); i++){
                    if(wc.getTemp() > lstData.get(i).getTemp()){
                        wc = lstData.get(i);
                    }
                }
                intent.putExtra("country", wc);
                startActivity(intent);
            }
        });
    }

    private void addData() {
        lstData = new ArrayList<ThoiTiet>();
        lstData.add(new ThoiTiet("Viet Nam", 29));
        lstData.add(new ThoiTiet("Lon Don", 5));
        lstData.add(new ThoiTiet("New York", 32));
    }

    private void addControl() {
        listView = findViewById(R.id.lvView);
        btnAdd = findViewById(R.id.btnAdd);
        btnView = findViewById(R.id.btnView);
        etName = findViewById(R.id.etNameCountry);
        etTemp = findViewById(R.id.etTemp);
        adapter = new ThoiTietAdapter(R.layout.item, lstData, MainActivity.this);
        listView.setAdapter(adapter);
    }
}
