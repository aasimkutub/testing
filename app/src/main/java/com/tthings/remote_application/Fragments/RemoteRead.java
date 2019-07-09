package com.tthings.remote_application.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.tthings.remote_application.Adapter.NewRemoteAdapter;
import com.tthings.remote_application.Alert_Dialog.SaveRemoteDialog;
import com.tthings.remote_application.R;
import com.tthings.remote_application.viewModel.CustomRemote;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 *
 * create an instance of this fragment.
 */
public class RemoteRead extends Fragment implements SaveRemoteDialog.SaveRemoteDialogListener {

    private Button back,read,save;
    private GridView gv;
    private SaveRemoteDialog dialog = new SaveRemoteDialog();
    private CustomRemote remote;


    public RemoteRead(CustomRemote remote) {
        // Required empty public constructor
        this.remote = remote;
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
        gv = v.findViewById(R.id.remote_read_grid_view);
        gv.setNumColumns(((0 == remote.getCol()) ? 3 : remote.getCol()));
        //gv.setStretchMode(GridView.NO_STRETCH);
        NewRemoteAdapter adapter = new NewRemoteAdapter(getActivity(), remote.getButton());
        gv.setAdapter(adapter);


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

                dialog.setTargetFragment(RemoteRead.this,3);
                dialog.show(getFragmentManager(), "Save Remote Dialog");
            }
        });

        return v;
    }


    @Override
    public void saveRemote(String name) {
        Log.d("SaveRemoteListener", "saveRemote: Data received "+name);
        getActivity().finish();
    }
}
