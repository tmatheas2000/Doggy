package com.matheas.doggy.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Dogs {

    private List<Dog> listOfDogs;

    public Dogs(){
        this.listOfDogs = new ArrayList<>();
    }

    public Dogs(List<Dog> dogs){
        this.listOfDogs = dogs;
    }

    public Dog atPosition(int position) {
        return this.listOfDogs.get(position);
    }

    public String getDogNameAtPosition(int position){
        return this.atPosition(position).getName();
    }
    public String getDogImageAtPosition(int position){
        return this.atPosition(position).getImage();
    }

    public String getDogOriginAtPosition(int position){
        return this.atPosition(position).getOrigin();
    }

    public String getDogBreedForAtPosition(int position){
        return this.atPosition(position).getBreedFor();
    }
    public String getDogBreedGroupAtPosition(int position){
        return this.atPosition(position).getBreedGroup();
    }

    public String getDogLifeSpanAtPosition(int position){
        return this.atPosition(position).getLifeSpan();
    }


    public int getDogsCount() {
        return listOfDogs.size();
    }
}
