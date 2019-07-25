package com.tthings.remote_application.Adapter;

import android.accessibilityservice.AccessibilityService;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tthings.remote_application.MainActivity;
import com.tthings.remote_application.R;
import com.tthings.remote_application.viewModel.CustomRemote;

import java.util.ArrayList;

public class ListRemoteAdapter extends BaseAdapter {

    ArrayList<CustomRemote> temp;
    private Context context;

    public ListRemoteAdapter(ArrayList<CustomRemote> temp, Context context) {
        this.temp = temp;
        this.context = context;
    }

    @Override
    public int getCount() {
        return temp.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    class viewHolder {

        TextView remote_name;
        TextView IRB_name;

        viewHolder(View view) {
            remote_name = view.findViewById(R.id.list_remote_name);
            IRB_name = view.findViewById(R.id.list_IRB_name);

        }
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.remote_name_list,viewGroup,false);
        viewHolder holder = new viewHolder(view);
        holder.IRB_name.setText(temp.get(i).getIRB());
        holder.remote_name.setText(temp.get(i).getName());

        return view;
    }
}
