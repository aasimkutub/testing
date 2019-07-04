package com.tthings.remote_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Remote_display extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remotedisplay);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentHolder, new new_remote_layout()).commit();
    }
}
