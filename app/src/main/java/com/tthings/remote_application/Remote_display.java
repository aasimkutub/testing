package com.tthings.remote_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.tthings.remote_application.Fragments.new_remote_layout;

public class Remote_display extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remotedisplay);

        new_remote_layout remote_layout = new new_remote_layout(this);


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentHolder, remote_layout).commit();

        //getSupportFragmentManager().beginTransaction().replace(R.id.fragmentHolder, new new_remote_layout()).commit();
    }
}
