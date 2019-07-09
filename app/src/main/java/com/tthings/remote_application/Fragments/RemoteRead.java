package com.tthings.remote_application.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.tthings.remote_application.Alert_Dialog.SaveRemoteDialog;
import com.tthings.remote_application.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 *
 * create an instance of this fragment.
 */
public class RemoteRead extends Fragment {

    Button back,read,save;


    public RemoteRead() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_remote_read, container, false);

        back = v.findViewById(R.id.remote_read_back);
        read = v.findViewById(R.id.remote_read_read);
        save = v.findViewById(R.id.remote_read_save);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getBaseContext(), "write Read code", Toast.LENGTH_SHORT).show();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getBaseContext(), "open dialog to read name", Toast.LENGTH_SHORT).show();
                SaveRemoteDialog dialog = new SaveRemoteDialog();
                dialog.show(getFragmentManager(), "Save Remote Dialog");
            }
        });

        return v;
    }




}
