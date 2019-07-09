package com.tthings.remote_application.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.tthings.remote_application.R;
import com.tthings.remote_application.viewModel.CustomButton;

import java.util.ArrayList;

public class NewRemoteAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<CustomButton> buttons;


    public NewRemoteAdapter(Context context, ArrayList<CustomButton> button) {
        this.context = context;
        this.buttons = button;

    }

    @Override
    public int getCount() {
        return buttons.size();
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

        ImageView btnImg;
        TextView btnText;

        public viewHolder(View itemView) {

            btnImg = itemView.findViewById(R.id.btn_image);
            btnText = itemView.findViewById(R.id.btn_text);
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
            if (buttons != null) {
                if (buttons.get(i).getKey() == null) {

                }
                else {
                    holder.btnText.setText(buttons.get(i).getKey());
                }
            }
            row.setTag(holder);
        }
        else {
            holder = (viewHolder) row.getTag();
            if (buttons != null) {
                if (buttons.get(i).getKey() == null) {

                }
                else {
                    holder.btnText.setText(buttons.get(i).getKey());
                }
            }
        }

        /*holder.CustomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"Btn Clicked " + i ,Toast.LENGTH_SHORT).show();
                NewButtonDialog dialog = new NewButtonDialog();
                dialog.show(((AppCompatActivity) context).getSupportFragmentManager(), "ADD ICON");
            }
        });
        */
        return row;
    }


}
