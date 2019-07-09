package com.tthings.remote_application.Alert_Dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.tthings.remote_application.R;

public class SaveRemoteDialog extends DialogFragment {

    public interface SaveRemoteDialogListener {
        void saveRemote(String name);
    }


    SaveRemoteDialogListener listener;

    private Button cancel, save;
    private EditText remoteName;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.save_remote_dialog, container, false);
        save = v.findViewById(R.id.dialog_button_save);
        cancel = v.findViewById(R.id.dialog_button_cancel);
        remoteName = v.findViewById(R.id.dialog_button_name);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "append CustomRemote data", Toast.LENGTH_SHORT).show();
               listener.saveRemote(remoteName.getText().toString());
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (SaveRemoteDialogListener) getTargetFragment();

    }
}
