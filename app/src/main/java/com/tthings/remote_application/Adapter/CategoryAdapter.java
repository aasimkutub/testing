package com.tthings.remote_application.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.tthings.remote_application.ConstValue;
import com.tthings.remote_application.R;

public class CategoryAdapter extends BaseAdapter {

   Context context;

    public CategoryAdapter(Context activity) {
        this.context = activity;
    }

    class viewHolder {
        TextView name;
        public viewHolder(View itemView) {
            name = itemView.findViewById(R.id.category_name);
        }
    }


    @Override
    public int getCount() {
        return ConstValue.CategoryList.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View row  = view;
        viewHolder holder = null;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.category_card, viewGroup, false);
            holder = new viewHolder(row);
            holder.name.setText(ConstValue.CategoryList[i]);
            row.setTag(holder);
        }
        else {
            holder = (viewHolder) row.getTag();
            holder.name.setText(ConstValue.CategoryList[i]);

        }

        return row;

    }
}
