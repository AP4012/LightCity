package org.example.models;

public class Food {

    private String title;
    private final float water;
    private final float food;

    public boolean available = true;

    public Food(String title,float food,float water) {
        this.food = food;
        this.water = water;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getWater() {
        return water;
    }

    public float getFood() {
        return food;
    }
}
