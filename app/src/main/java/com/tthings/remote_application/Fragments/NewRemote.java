package com.tthings.remote_application.Fragments;

import android.content.Context;
import android.graphics.Color;
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
import com.tthings.remote_application.ConstValue;
import com.tthings.remote_application.R;
import com.tthings.remote_application.viewModel.CustomButton;
import com.tthings.remote_application.viewModel.CustomRemote;

public class NewRemote extends Fragment implements ColumnDialog.ColumnDialogListener, NewButtonDialog.NewButtonListener {



    private Context context;
    private Button cancel, next, column, extraBtn;
    private GridView gv;
    private CustomRemote remote;
    private NewRemoteAdapter adapter;
    private int btnNum;
    private ColumnDialog dialog;
    private NewButtonDialog btnDialog;
    private boolean isNextClickable;

    public NewRemote(Context context, CustomRemote new_remote_obj) {
        this.context = context;
        this.remote = new_remote_obj;
        init(remote.getCol(),remote.getRow());
        btnDialog = new NewButtonDialog();
        isNextClickable = false;
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
        extraBtn = v.findViewById(R.id.new_remote_extra_btn);

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
                    if (isNextClickable) {
                        RemoteRead remote_read = new RemoteRead(remote);
                        getFragmentManager().beginTransaction().replace(R.id.fragmentHolder, remote_read).addToBackStack("Fragment New Layout").commit();
                    }
                }
            });


        column.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                dialog.setTargetFragment(NewRemote.this,2);

                dialog.show(getFragmentManager(), "Read Column Value");


            }
        });

        extraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"add new btn in BottomSheet",Toast.LENGTH_SHORT).show();
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
        isNextClickable = isContainButton();
        setNext(isNextClickable);
    }


    private boolean isContainButton() {

        for (int i = 0; i < remote.getButton().size(); i++) {
            if (remote.getButton().get(i).getKey() != null && !(remote.getButton().get(i).getKey().equals(""))) {
                return true;
            }
        }

        return false;

    }

    private void setNext(boolean isNextClickable) {

        if (isNextClickable) {

            next.setTextColor(Color.parseColor("#ff0099cc"));
            next.setClickable(true);

        }
        else {
            next.setTextColor(Color.parseColor("#8C9494"));
            next.setClickable(false);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
       setNext(isContainButton());
    }


    void checkCategory() {
        //TODO code based on the category of the remote display the layout


    }

    void midButtonSwap() {
        //TODO code to change the middle button based on the type of the remote


    }

    void getRemoteDataObject() {
        //TODO return the object based on the type


    }

    void openDialog(String value) {
        //TODO code to differentiate the normal button and the NUMPAD and EXTRA key word in the value
        if (value == null) {
            //TODO code to open the new button dialog


        }

        else if (value.equals(ConstValue.EXTRA_BUTTON)){
            //TODO code to open the bottom sheet


        }
        else if (value.equals(ConstValue.NUMER_PAD)) {
            //TODO code to open the numPad in bottom sheet


        }

    }


}