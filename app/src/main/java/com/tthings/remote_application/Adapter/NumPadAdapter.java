package com.tthings.remote_application.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tthings.remote_application.ConstValue;
import com.tthings.remote_application.R;

public class NumPadAdapter extends BaseAdapter {


    private Context context;

    class viewHolder {
        TextView name;
        public viewHolder(View itemView) {
            name = itemView.findViewById(R.id.category_name);
        }
    }

    @Override
    public int getCount() {
        return ConstValue.NumberPad.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public NumPadAdapter(Context context) {
        this.context = context;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row  = view;
        viewHolder holder = null;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.numpad_btn, viewGroup, false);
            holder = new viewHolder(row);
            holder.name.setText(ConstValue.NumberPad[i]);
            row.setTag(holder);
        }
        else {
            holder = (viewHolder) row.getTag();
            holder.name.setText(ConstValue.NumberPad[i]);

        }

        return row;
    }
}
