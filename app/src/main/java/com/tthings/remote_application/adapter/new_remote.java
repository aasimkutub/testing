package com.tthings.remote_application.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.tthings.remote_application.R;

public class new_remote extends BaseAdapter {

    private Context context;

    @Override
    public int getCount() {
        return 12;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    public new_remote(Context context) {
        this.context = context;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    class viewHolder {

        public viewHolder(View itemView) {

        }
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {



        View row  = view;
        viewHolder holder = null;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.remote_button, viewGroup, false);
            holder = new viewHolder(row);
            row.setTag(holder);
        }
        else {
            holder = (viewHolder) row.getTag();
        }

        return row;
    }


}
