package com.tthings.remote_application.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tthings.remote_application.R;

/**
 * A simple {@link Fragment} subclass.
 *
 * create an instance of this fragment.
 */
public class Remote extends Fragment {




    public Remote() {
        // Required empty public constructor
    }


    public static Remote newInstance(String param1, String param2) {
        Remote fragment = new Remote();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_remote, container, false);
    }


}
