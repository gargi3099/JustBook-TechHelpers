package com.example.application2;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.application2.R;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
    }

    public void Confirm(View view)
    {
        Intent intent=new Intent(this, com.example.application2.Confirm.class);
        startActivity(intent);
    }
}