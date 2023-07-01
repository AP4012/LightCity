package org.example.models;

public class Liquid {
    private final float liquid;

    public boolean available =true;

    public Liquid(float liquid) {
        this.liquid = liquid;
    }

    public float getLiquid() {
        return liquid;
    }

}
