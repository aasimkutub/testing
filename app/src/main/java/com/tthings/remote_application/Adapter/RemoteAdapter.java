package com.tthings.remote_application.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.tthings.remote_application.R;
import com.tthings.remote_application.viewModel.CustomButton;
import com.tthings.remote_application.viewModel.CustomRemote;

import java.util.ArrayList;

public class RemoteAdapter extends BaseAdapter {

    CustomRemote remote;
    private ArrayList<CustomButton> buttons;
    private Context context;
    private int count;
    public RemoteAdapter(CustomRemote remote, Context context) {

        this.remote = remote;
        this.context = context;
        buttons = remote.getButton();
        lastBtn();
    }


    @Override
    public int getCount() {
        return count + 1;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    class viewHolder {

        ImageView btnImg;
        TextView btnText;
        CardView button;

        viewHolder(View itemView) {

            btnImg = itemView.findViewById(R.id.btn_image);
            btnText = itemView.findViewById(R.id.btn_text);
            button = itemView.findViewById(R.id.button);
        }
    }

    @Override
    public boolean isEnabled(int position) {


        if (buttons.get(position).getKey() != null)
            return true;


        return false;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {



        View row  = view;
        viewHolder holder = null;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.remote_button, viewGroup, false);
            holder = new viewHolder(row);
            if (buttons != null) {
                if (buttons.get(i).getKey() == null) {
                    holder.btnText.setText(null);
                    holder.button.setBackgroundColor(Color.TRANSPARENT);
                    holder.button.setVisibility(View.INVISIBLE);


                }
                else {
                    holder.btnText.setText(buttons.get(i).getKey());
                    holder.button.setVisibility(View.VISIBLE);
                    holder.button.setBackgroundColor(Color.parseColor("#DD4D1B"));
                }
            }
            row.setTag(holder);
        }
        else {
            holder = (RemoteAdapter.viewHolder) row.getTag();
            if (buttons != null) {
                if (buttons.get(i).getKey() == null) {
                    holder.btnText.setText(null);
                    holder.button.setBackgroundColor(Color.TRANSPARENT);

                    holder.button.setVisibility(View.INVISIBLE);

                }
                else {
                    holder.btnText.setText(buttons.get(i).getKey());
                    holder.button.setVisibility(View.VISIBLE);
                    holder.button.setBackgroundColor(Color.parseColor("#DD4D1B"));
                }
            }
        }

        return row;
    }

    private void lastBtn() {

        for (int i = 0; i < buttons.size(); i++) {
            if (buttons.get(i).getKey() != null) {
                count = i;
            }
        }
    }
}
