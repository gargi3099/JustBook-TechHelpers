package com.example.application2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OnlinePay extends AppCompatActivity {
    com.example.application2.DateTime dateTime=new com.example.application2.DateTime();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_pay);
        Intent intent=getIntent();
        Bundle extras =  intent.getExtras();
        String date = extras.getString("DATE");
        String time = extras.getString("TIME");
        dateTime.setDate(date);
        dateTime.setTime(time);
    }

    public void OnlinePay(View view) {
        Bundle bundle=new Bundle();
        bundle.putString("DATE",dateTime.getDate());
        bundle.putString("TIME",dateTime.getTime());
        Intent intent=new Intent(this, com.example.application2.Booked.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}