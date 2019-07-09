package com.tthings.remote_application.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.tthings.remote_application.Adapter.NewRemoteAdapter;
import com.tthings.remote_application.Alert_Dialog.ColumnDialog;
import com.tthings.remote_application.Alert_Dialog.NewButtonDialog;
import com.tthings.remote_application.R;
import com.tthings.remote_application.viewModel.CustomButton;
import com.tthings.remote_application.viewModel.CustomRemote;

public class NewRemote extends Fragment implements ColumnDialog.ColumnDialogListener, NewButtonDialog.NewButtonListener {



    private Context context;
    private Button cancel, next, column;
    private GridView gv;
    private CustomRemote remote;
    private NewRemoteAdapter adapter;
    private int btnNum;
    private ColumnDialog dialog;
    private NewButtonDialog btnDialog;

    public NewRemote(Context context, CustomRemote new_remote_obj) {
        this.context = context;
        this.remote = new_remote_obj;
        init(remote.getCol(),remote.getRow());
        btnDialog = new NewButtonDialog();
    }

    private void init(int col, int row) {

        remote.getButton().clear();
        for (int i = 0; i < col*row; i++ )
            remote.getButton().add(new CustomButton());
        dialog = new ColumnDialog(remote.getCol());
    }

    public NewRemote() {
    }

    public static NewRemote newInstance() {
        return new NewRemote();
    }

    View v;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_new_remote_layout, container, false);
        gv = v.findViewById(R.id.newRemoteLayoutGridView);
        next = v.findViewById(R.id.new_remote_next);
        cancel = v.findViewById(R.id.new_remote_cancel);
        column = v.findViewById(R.id.new_remote_col);

        gv.setNumColumns(((0 == remote.getCol()) ? 3 : remote.getCol()));
        //gv.setStretchMode(GridView.NO_STRETCH);
        adapter = new NewRemoteAdapter(getActivity(), remote.getButton());
        gv.setAdapter(adapter);

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String msg = "Btn Clicked " + i;
                btnNum = i;
                Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
                if (remote.getButton().get(i).getKey() != null) {
                    btnDialog.name = remote.getButton().get(i).getKey();
                }
                btnDialog.setTargetFragment(NewRemote.this,2);
                btnDialog.show(getFragmentManager(), "open dialog");


            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RemoteRead remote_read = new RemoteRead(remote);
                getFragmentManager().beginTransaction().replace(R.id.fragmentHolder, remote_read).addToBackStack("Fragment New Layout").commit();
            }
        });

        column.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                dialog.setTargetFragment(NewRemote.this,2);

                dialog.show(getFragmentManager(), "Read Column Value");




            }
        });

        cancel.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });





        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void sendValues(int id) {

        Log.d("ColumnDialogListener", "sendValues: I reached here successfully " + id);
        if (remote.getCol() != id) {
            remote.setCol(id);
            init(remote.getCol(), remote.getRow());
            adapter.notifyDataSetChanged();
            gv.setNumColumns(remote.getCol());
            gv.setAdapter(adapter);
        }


    }

    @Override
    public void sendData(String name, int icon) {
        Log.d("NewButtonListener", "sendData: Data Received "+name+" *** "+ icon + " for the btn "+btnNum);
        remote.getButton().get(btnNum).setKey(name);
        adapter.notifyDataSetChanged();
    }
}