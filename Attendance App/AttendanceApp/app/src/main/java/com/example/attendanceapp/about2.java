package com.example.attendanceapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class about2 extends AppCompatActivity {
Button mail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about2);
        setContentView(R.layout.activity_about2);
        mail=findViewById(R.id.mail);
        ((View) mail).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"help.attendanceapp@gmail.com"});
                intent.setData(Uri.parse("mailto:"));
                startActivity(intent);
            }
        });
    }
}