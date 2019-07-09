package com.tthings.remote_application.Alert_Dialog;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.tthings.remote_application.R;

public class NewButtonDialog extends DialogFragment {

    public interface NewButtonListener {
        void sendData(String name, int icon);
    }

    private NewButtonListener listener;

    private Button expand_btn;
    private ListView icon_list;
    private EditText editText;
    public String name;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (NewButtonListener) getTargetFragment();
        } catch (ClassCastException e) {
            Log.d("NewButtonDialog", "onAttach: "+e.getMessage());
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (name != null) {
            editText.setText(name);
            name = "";
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.new_button_dialog, container, false);
        editText = view.findViewById(R.id.dialog_button_name);
        view.findViewById(R.id.dialog_button_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
            }
        });

        view.findViewById(R.id.dialog_button_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listener.sendData(editText.getText().toString(), 0);
                editText.setText("");
                getDialog().dismiss();
                name = "";
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
