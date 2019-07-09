package com.tthings.remote_application.Alert_Dialog;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.tthings.remote_application.R;

public class ColumnDialog extends DialogFragment {

    private Button save, cancel;
    private RadioGroup colNum;
    public ColumnDialogListener listener;
    private int col;

    public ColumnDialog(int i){
        this.col = i;
        setRadioBtn();
    }

    public interface ColumnDialogListener {

        void sendValues(int id);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (ColumnDialogListener) getTargetFragment();
        } catch (ClassCastException e) {
            Log.d("ColumnDialog Interface", "onAttach: "+e.getMessage() + " *** "+context);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.column_dialog, container, false);

        save = v.findViewById(R.id.col_dialog_button_save);
        cancel = v.findViewById(R.id.col_dialog_button_cancel);
        colNum = v.findViewById(R.id.dialog_numColumns);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Column", "onClick: "+ (colNum.getCheckedRadioButtonId() == R.id.three));

                if ( listener != null) {
                    switch (colNum.getCheckedRadioButtonId()) {
                        case R.id.three :   listener.sendValues(3);
                                            break;

                        case R.id.four :    listener.sendValues(4);
                                            break;

                        case R.id.five :    listener.sendValues(5);
                                            break;
                    }
                } else {
                    Log.d("Column", "onClick: Column or listener is null "+ listener +" "+getContext());
                }

                dismiss();
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

    private void setRadioBtn() {

        if (R.id.three == col) {
            colNum.check(R.id.three);
        }
        else if (R.id.four == col) {
            colNum.check(R.id.four);
        }
        else if (R.id.five == col){
            colNum.check(R.id.five);
        }
        else {

        }
    }


}
