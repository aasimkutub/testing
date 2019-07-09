package com.tthings.remote_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import com.tthings.remote_application.Fragments.NewRemote;
import com.tthings.remote_application.Fragments.Remote;
import com.tthings.remote_application.viewModel.CustomRemote;

public class Remote_display extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remotedisplay);
        Bundle b =  getIntent().getExtras();
        int id;

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        if (b != null) {
            id = b.getInt("id");

            Log.d("Remote Fragment", "the value received " + id);
            Remote remote_layout = new Remote();
            transaction.replace(R.id.fragmentHolder, remote_layout).commit();
        }
        else {

            CustomRemote new_remote_obj = new CustomRemote();

            Log.d("Remote Fragment", "You clicked for new Remote " );
            NewRemote remote_layout = new NewRemote(this, new_remote_obj);
            transaction.replace(R.id.fragmentHolder, remote_layout).commit();
        }


        //getSupportFragmentManager().beginTransaction().replace(R.id.fragmentHolder, new NewRemoteAdapter()).commit();
    }
}
