package com.tthings.remote_application.viewModel;

import java.util.ArrayList;

public class CustomRemote {

    private String name = null;
    private String id = null;
    private int row;
    private int col;
    private int frequency = 0;
    private ArrayList<CustomButton> button;

    public CustomRemote() {
        button = new ArrayList<>();
        row = 10;
        col = 3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public ArrayList<CustomButton> getButton() {
        return button;
    }

    public void setButton(ArrayList<CustomButton> button) {
        this.button = button;
    }




}
