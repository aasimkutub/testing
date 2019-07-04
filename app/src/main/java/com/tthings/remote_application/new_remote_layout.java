package com.tthings.remote_application;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.tthings.remote_application.adapter.new_remote;
import com.tthings.remote_application.viewModel.NewRemoteLayoutViewModel;

public class new_remote_layout extends Fragment {

    private NewRemoteLayoutViewModel mViewModel;

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
        gv.setAdapter(new new_remote(getContext()));



        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(NewRemoteLayoutViewModel.class);
        // TODO: Use the ViewModel
    }

}
