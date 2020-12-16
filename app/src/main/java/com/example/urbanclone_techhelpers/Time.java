package com.example.application2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.application2.DateTime;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class Time extends AppCompatActivity {
    com.example.application2.DateTime dateTime=new DateTime();
    FirebaseAuth authf = FirebaseAuth.getInstance();
    DatabaseReference FFR;
    Button btn10,btn1130,btn1,btn230,btn4,btn530;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        btn10 = (Button) findViewById(R.id.button10);
        btn1130 = (Button) findViewById(R.id.button1130);
        btn1 = (Button) findViewById(R.id.button1);
        btn230 = (Button) findViewById(R.id.button230);
        btn4 = (Button) findViewById(R.id.button4);
        btn530 = (Button) findViewById(R.id.button530);
    }

    public void ChooseDate(View view) {
        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH);
        final int day=calendar.get(Calendar.DAY_OF_MONTH);
        final Button cdbtn=(Button)findViewById(R.id.button8);
        DatePickerDialog datePickerDialog=new DatePickerDialog(Time.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String date = dayOfMonth + "/" + month + "/" + year;
                dateTime.setDate(date);
                cdbtn.setText(date);
            }
        },year,month,day);
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        datePickerDialog.show();
    }

    public void DateTime(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("techemail", MODE_PRIVATE);
        final String value = sharedPreferences.getString("value","");
        String email = authf.getCurrentUser().getEmail().toString();
        FFR = FirebaseDatabase.getInstance().getReference().child("Bookings");
        dateTime.setEmail(email);
        dateTime.setTechemail(value);
        FFR.push().setValue(dateTime)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Bundle bundle=new Bundle();
                            bundle.putString("DATE",dateTime.getDate());
                            bundle.putString("TIME",dateTime.getTime());
                            Intent intent=new Intent(com.example.application2.Time.this, com.example.application2.Confirm.class);
                            intent.putExtras(bundle);
                            startActivity(intent);
                            finish();
                        }
                        else {
                            Toast.makeText(getBaseContext(), "Choose valid date and time", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    public void FiveThirty(View view) {
        String time="5:30 PM";
        btn530.setBackgroundDrawable(getResources().getDrawable(R.drawable.buttoncolor));
        dateTime.setTime(time);

    }

    public void Four(View view) {
        String time="4:00 PM";
        btn4.setBackgroundDrawable(getResources().getDrawable(R.drawable.buttoncolor));
        dateTime.setTime(time);
    }

    public void TwoThirty(View view) {
        String time="2:30 PM";
        btn230.setBackgroundDrawable(getResources().getDrawable(R.drawable.buttoncolor));
        dateTime.setTime(time);
    }

    public void One(View view) {
        String time="1:00 PM";
        btn1.setBackgroundDrawable(getResources().getDrawable(R.drawable.buttoncolor));
        dateTime.setTime(time);
    }

    public void ElevenThirty(View view) {
        String time="11:30 AM";
        btn1130.setBackgroundDrawable(getResources().getDrawable(R.drawable.buttoncolor));
        dateTime.setTime(time);
    }

    public void Ten(View view) {
        String time="10:00 AM";
        btn10.setBackgroundDrawable(getResources().getDrawable(R.drawable.buttoncolor));
        dateTime.setTime(time);
    }

}
