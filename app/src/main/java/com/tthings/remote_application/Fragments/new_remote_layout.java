package com.tthings.remote_application.Fragments;

import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.tthings.remote_application.Alert_Dialog.new_button_dialog;
import com.tthings.remote_application.MainActivity;
import com.tthings.remote_application.R;
import com.tthings.remote_application.adapter.new_remote;
import com.tthings.remote_application.viewModel.NewRemoteLayoutViewModel;

public class new_remote_layout extends Fragment {

    private NewRemoteLayoutViewModel mViewModel;

    Context context;

    public new_remote_layout(Context context) {
        this.context = context;
    }

    public new_remote_layout() {
    }

    public static new_remote_layout newInstance() {
        return new new_remote_layout();
    }

    View v;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.new_remote_layout_fragment, container, false);
        /*RecyclerView recyclerView = v.findViewById(R.id.newRemote_rv);
        RecyclerView.Adapter adapter = new new_remote(getContext());
        recyclerView.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 3);

        recyclerView.setLayoutManager(layoutManager);*/

        GridView gv = v.findViewById(R.id.newRemoteLayoutGridView);
        gv.setNumColumns(4);
       //gv.setStretchMode(GridView.STRETCH_SPACING);
        new_remote adapter = new new_remote(getActivity(), getFragmentManager());
        gv.setAdapter(adapter);

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String msg = "Btn Clicked " + i;
                Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
                new_button_dialog dialog = new new_button_dialog();
                if(getFragmentManager() != null)
                    dialog.show(getFragmentManager(), "ADD ICON");
            }
        });





        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(NewRemoteLayoutViewModel.class);
        // TODO: Use the ViewModel
    }

}
