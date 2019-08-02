package com.tthings.remote_application.Fragments;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tthings.remote_application.Adapter.NewRemoteAdapter;
import com.tthings.remote_application.Adapter.ReadRemoteAdapter;
import com.tthings.remote_application.Alert_Dialog.SaveRemoteDialog;
import com.tthings.remote_application.ConstValue;
import com.tthings.remote_application.R;
import com.tthings.remote_application.viewModel.CustomRemote;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 *
 * create an instance of this fragment.
 */
public class RemoteRead extends Fragment implements SaveRemoteDialog.SaveRemoteDialogListener {

    private Button back,read,save;
    private GridView gv;
    private SaveRemoteDialog dialog = new SaveRemoteDialog();
    private CustomRemote remote;


    public RemoteRead(CustomRemote remote) {
        // Required empty public constructor
        this.remote = remote;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_remote_read, container, false);

        back = v.findViewById(R.id.remote_read_back);
        read = v.findViewById(R.id.remote_read_read);
        save = v.findViewById(R.id.remote_read_save);
        gv = v.findViewById(R.id.remote_read_grid_view);
        gv.setNumColumns(((0 == remote.getCol()) ? 3 : remote.getCol()));
        //gv.setStretchMode(GridView.NO_STRETCH);
        ReadRemoteAdapter adapter = new ReadRemoteAdapter(getActivity(), remote.getButton());
        gv.setAdapter(adapter);
        gv.setBackgroundColor(Color.TRANSPARENT);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getBaseContext(), "write Read code", Toast.LENGTH_SHORT).show();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getBaseContext(), "open dialog to read name", Toast.LENGTH_SHORT).show();

                dialog.setTargetFragment(RemoteRead.this,3);
                dialog.show(getFragmentManager(), "Save Remote Dialog");
            }
        });

        return v;
    }


    @Override
    public void saveRemote(String name) {
        Log.d("SaveRemoteListener", "saveRemote: Data received "+name);
        remote.setName(name);
        Gson gson = new Gson();
        String remote_string = gson.toJson(remote);
        Log.d("Remote JSON", "saveRemote: "+remote_string);
        CustomRemote temp = new CustomRemote();
        temp = gson.fromJson(remote_string, CustomRemote.class);
        String temp_str = gson.toJson(temp);
        temp_str = temp_str + "\n";
        Log.d("Remote JSON", "saveRemote: "+temp_str);

        /*File DIR_NAME = new File(getActivity().getFilesDir()+ConstValue.RemoteDir);
        String FILE_NAME = name+ConstValue.FileExtension;
        boolean result  = DIR_NAME.mkdirs();
        Log.d("FileUpdate", "saveRemote: Path is created "+result);

        try {
            FileOutputStream fos = getActivity().openFileOutput(FILE_NAME, Context.MODE_APPEND);
            fos.write(temp_str.getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            BufferedReader bReader = new BufferedReader(new InputStreamReader(getActivity().openFileInput(FILE_NAME)));
            String line;
            StringBuffer text = new StringBuffer();
            while ((line = bReader.readLine()) != null) {
                Log.d("FileHandling", "saveRemote: "+line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/


        File file = getFile(name);
        writeOnToFile(file, remote_string);
        checkDataWrite(file);

        getActivity().finish();
    }

    private void checkDataWrite(File file) {

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader reader = new BufferedReader(fileReader);
        String valTempRead = "hello world!!";
        try {
            while((valTempRead = reader.readLine()) != null) {
                Log.d("ReadingFile", "onCreate: " + valTempRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeOnToFile(File file, String remoteJson) {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write(remoteJson);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStreamWriter.close();
            fileOutputStream.close();
            Log.d("FileDataInsert", "onCreate: Date Inserted Successfully "+file);
        }catch(FileNotFoundException ex)
        {
            Log.e("writeData", ex.getMessage(), ex);
        }catch(IOException ex)
        {
            Log.e("writeRead", ex.getMessage(), ex);
        }
    }

   /* Method to check for file exist or not
    if exist return the reference if not create new file and return the reference        */

    private File getFile(String remoteName) {
        try {
            File DIR_NAME = new File(getActivity().getFilesDir()+File.separator+ConstValue.RemoteDir+ (remote.getIRB() == null ?"":remote.getIRB()));
            if (DIR_NAME.isDirectory()) {

            }
            else {
                DIR_NAME.mkdirs();

            }
            File file = new File(DIR_NAME,(remoteName+ConstValue.FileExtension));
            file.createNewFile();
            return file;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    void checkOnSaveIsAllButtonRead() {
        //TODO check for all the buttons are read before saving and notify the user


    }

    void read() {
        //TODO code to read the IR value for a Button


    }

    void checkButtonValue() {
        //TODO code to check weather the button value is initialized to the read value or not


    }

}
