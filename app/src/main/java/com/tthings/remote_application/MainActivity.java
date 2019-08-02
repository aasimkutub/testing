package com.tthings.remote_application;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.GridView;

import com.google.gson.Gson;
import com.tthings.remote_application.Adapter.ListRemoteAdapter;
import com.tthings.remote_application.Alert_Dialog.NumPadDialog;
import com.tthings.remote_application.viewModel.CustomRemote;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<CustomRemote> temp = new ArrayList<>();
    CustomRemote remote = new CustomRemote();
    Gson gson = new Gson();
    GridView gv;
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
                Intent obj = new Intent(getApplicationContext(), Remote_display.class);
                obj.putExtra("id", 1);
                startActivity(obj);
            }
        });

        findViewById(R.id.categoryBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent obj = new Intent(getApplicationContext(), Remote_display.class);
                obj.putExtra("id", 2);
                startActivity(obj);
            }
        });


        final ListRemoteAdapter adapter = new ListRemoteAdapter(temp, this);
        gv = findViewById(R.id.list);
        gv.setAdapter(adapter);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                String FILE_NAME = "remote_data.txt";
                try {
                    FileOutputStream fos = openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
                    fos.write(gson.toJson(temp.get(i)).getBytes());
                    fos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent obj = new Intent(getApplicationContext(), Remote_display.class);
                obj.putExtra("id", 01);
                startActivity(obj);


            }
        });

        findViewById(R.id.bottom_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumPadDialog dialog = new NumPadDialog();
                dialog.show(getSupportFragmentManager(),"bottom");
            }
        });

        findViewById(R.id.data_check).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    BufferedReader bReader = new BufferedReader(new InputStreamReader(openFileInput("remote.txt")));
                    String line;
                    StringBuffer text = new StringBuffer();
                    temp.clear();
                    while ((line = bReader.readLine()) != null) {
                        Log.d("FileHandling", "saveRemote: "+line);
                        remote = gson.fromJson(line, CustomRemote.class);
                        if (!temp.contains(remote)) {
                            temp.add(remote);
                            adapter.notifyDataSetChanged();
                        }


                    }
                    Log.d("Gson", "onClick: "+gson.toJson(temp));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        findViewById(R.id.clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream fos = openFileOutput("remote.txt", Context.MODE_PRIVATE);
                    fos.write("".getBytes());
                    fos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                temp.clear();
                adapter.notifyDataSetChanged();
            }
        });


    }

    void readFiles() {
        //TODO code to read all the files in the respective folder


    }

    void openRemote() {
        //TODO code to open a respective remote based on the user choose from the list fetched by the readFiles()


    }

    void newRemote() {
        //TODO send Value to open the category fragment and invoke this method in the FAB


    }

}
