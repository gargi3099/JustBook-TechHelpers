package com.example.application2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Confirm extends AppCompatActivity {
    com.example.application2.DateTime dateTime=new com.example.application2.DateTime();
    FirebaseAuth authf = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        Intent intent=getIntent();
        Bundle extras =  intent.getExtras();
        String date = extras.getString("DATE");
        String time = extras.getString("TIME");
        dateTime.setDate(date);
        dateTime.setTime(time);
        TextView viewTextD = (TextView) findViewById(R.id.textView_date);
        TextView viewTextT = (TextView) findViewById(R.id.textView_time);
        viewTextD.setText("Date : "+date);
        viewTextT.setText("Time : "+time);
    }

    public void Booked(View view)
    {
        /*SharedPreferences sharedPreferences = getSharedPreferences("techemail", MODE_PRIVATE);
        final String value = sharedPreferences.getString("value","");
        String email = authf.getCurrentUser().getEmail().toString();*/
        Bundle bundle=new Bundle();
        bundle.putString("DATE",dateTime.getDate());
        bundle.putString("TIME",dateTime.getTime());
        Intent intent=new Intent(this, com.example.application2.Booked.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void Online(View view) {
        Bundle bundle=new Bundle();
        bundle.putString("DATE",dateTime.getDate());
        bundle.putString("TIME",dateTime.getTime());
        Intent intent=new Intent(this, com.example.application2.OnlinePay.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}