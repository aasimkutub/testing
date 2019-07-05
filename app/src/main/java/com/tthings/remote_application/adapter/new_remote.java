package com.tthings.remote_application.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;

import com.tthings.remote_application.Alert_Dialog.new_button_dialog;
import com.tthings.remote_application.R;

public class new_remote extends BaseAdapter {

    private Context context;
    FragmentManager fragmentManager;

    public new_remote(Context context, FragmentManager fragmentManager) {
        this.context = context;
        this.fragmentManager = fragmentManager;
    }

    @Override
    public int getCount() {
        return 12;
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
        CardView button;

        public viewHolder(View itemView) {

            btnImg = itemView.findViewById(R.id.btn_image);
            btnText = itemView.findViewById(R.id.btn_text);
            button = itemView.findViewById(R.id.button);
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

        /*holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"Btn Clicked " + i ,Toast.LENGTH_SHORT).show();
                new_button_dialog dialog = new new_button_dialog();
                dialog.show(((AppCompatActivity) context).getSupportFragmentManager(), "ADD ICON");
            }
        });
        */
        return row;
    }


}
