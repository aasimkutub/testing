package com.tthings.remote_application.Alert_Dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.DialogFragment;

import com.tthings.remote_application.R;

public class NewButtonDialog extends DialogFragment {

    private Button expand_btn;
    private ListView icon_list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.new_button_dialog, container, false);

        view.findViewById(R.id.dialog_button_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
            }
        });

        view.findViewById(R.id.dialog_button_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
            }
        });
        icon_list = view.findViewById(R.id.dialog_icon_list);
        expand_btn = view.findViewById(R.id.icon_list_expand_button);
        expand_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expand_btn.setVisibility(View.GONE);
                icon_list.setVisibility(View.VISIBLE);
            }
        });

        return view;
    }

   /* @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view;

        view = inflater.inflate(R.layout.NewButtonDialog, null);
        builder.setView(view);
        return builder.create();


    }*/

   /*
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.NewButtonDialog, null);

        builder.setView(view);
        builder.setTitle("New Remote");
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });


        return builder.create();
    }
    */
}
