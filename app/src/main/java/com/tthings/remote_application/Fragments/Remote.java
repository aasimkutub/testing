package com.tthings.remote_application.Fragments;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.tthings.remote_application.Adapter.RemoteAdapter;
import com.tthings.remote_application.R;
import com.tthings.remote_application.viewModel.CustomRemote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * A simple {@link Fragment} subclass.
 *
 * create an instance of this fragment.
 */
public class Remote extends Fragment {

    Gson gson = new Gson();
    GridView gv;
    TextView led;


    public Remote() {
        // Required empty public constructor


    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_remote, container, false);

        CustomRemote remote = new CustomRemote();
        String FILE_NAME = "remote_data.txt";
        try {
            BufferedReader bReader = new BufferedReader(new InputStreamReader(getActivity().openFileInput(FILE_NAME)));
            String line;
            StringBuffer text = new StringBuffer();
            while ((line = bReader.readLine()) != null) {
                Log.d("FileHandling remote", "saveRemote: "+line);
                remote = gson.fromJson(line,CustomRemote.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        led = view.findViewById(R.id.led);
        gv = view.findViewById(R.id.remote_grid_view);
        gv.setNumColumns(remote.getCol());
        RemoteAdapter adapter = new RemoteAdapter(remote,getActivity());
        gv.setAdapter(adapter);

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                led.setBackgroundColor(Color.RED);
                led.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        led.setBackgroundColor(Color.TRANSPARENT);
                    }
                },200);
            }
        });


        return view;
    }

    void sendIRValue() {
        //TODO code to send the IR value to the IR blaster


    }

    void ifExtra() {
        //TODO open the bottom sheet


    }

    void ifNumPad() {
        //TODO open the numPad sheet


    }

}
