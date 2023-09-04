package com.matheas.doggy.domain.model;

public class Dog {
    private int id;
    private String name;
    private String breedFor;
    private String breedGroup;
    private String lifeSpan;
    private String origin;
    private String image;

    public Dog() {
    }

    public Dog(int id, String name, String breedFor, String breedGroup, String lifeSpan, String origin, String image) {
        this.id = id;
        this.name = name;
        this.breedFor = breedFor;
        this.breedGroup = breedGroup;
        this.lifeSpan = lifeSpan;
        this.origin = origin;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreedFor() {
        return breedFor;
    }

    public void setBreedFor(String breedFor) {
        this.breedFor = breedFor;
    }

    public String getBreedGroup() {
        return breedGroup;
    }

    public void setBreedGroup(String breedGroup) {
        this.breedGroup = breedGroup;
    }

    public String getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(String lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
