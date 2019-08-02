package com.tthings.remote_application.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Switch;

import com.tthings.remote_application.Adapter.CategoryAdapter;
import com.tthings.remote_application.ConstValue;
import com.tthings.remote_application.R;


public class Category extends Fragment {

    GridView gv;

    public Category() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.fragment_category, container, false);
       gv = v.findViewById(R.id.gv_category);
        CategoryAdapter adpater = new CategoryAdapter(getActivity());
        gv.setAdapter(adpater);
        gv.setNumColumns(2);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (ConstValue.CategoryList[i].equals("Custom")) {
                    //TODO Write code for opening customLayout fragment


                }
                else {
                    //TODO Write code to open the fixed layout based on the user input
                    switch (i) {
                        case 0 ://TODO write code to open the AV System JSON


                                break;

                        case 1 ://TODO code for DVD JSON


                                break;

                        case 2 ://TODO code for FAN JSON


                                break;

                        case 3 ://TODO code for Projector JSON


                                break;

                        case 4 ://TODO code for TV JSON


                                break;

                        default:
                                Log.d("Category", "onItemClick: value Recieved from Category fragment = "+ConstValue.CategoryList[i]);
                                break;
                    }

                }
            }
        });


        return v;
    }

}
