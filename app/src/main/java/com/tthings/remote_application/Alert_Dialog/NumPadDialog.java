package com.tthings.remote_application.Alert_Dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tthings.remote_application.Adapter.NumPadAdapter;
import com.tthings.remote_application.R;

public class NumPadDialog extends BottomSheetDialogFragment {

    GridView gv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.numpad,container,false);
        gv = v.findViewById(R.id.gv_numPad);
        NumPadAdapter adapter = new NumPadAdapter(getActivity());
        gv.setNumColumns(3);
        gv.setAdapter(adapter);


        return v;
    }
}
