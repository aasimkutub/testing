package com.tthings.remote_application;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tthings.remote_application.Alert_Dialog.new_button_dialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent obj = new Intent(getApplicationContext(), Remote_display.class);
                startActivity(obj);
            }
        });

        findViewById(R.id.dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new_button_dialog dialog = new new_button_dialog();
                dialog.show(getSupportFragmentManager(), "open dialog");
            }
        });

    }
}
