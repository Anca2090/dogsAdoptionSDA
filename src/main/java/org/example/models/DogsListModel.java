package org.example.models;

import org.example.entities.DogsEntity;

import java.util.List;

public class DogsListModel {

    private List<DogsEntity> dogsList;

    public DogsListModel() {
    }

    public List<DogsEntity> getDogsList() {
        return dogsList;
    }

    public void setDogsList(List<DogsEntity> dogsList) {
        this.dogsList = dogsList;
    }
}
