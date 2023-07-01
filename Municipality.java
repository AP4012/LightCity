package org.example.defualtSystem;

import org.example.interfaces.MunicipalityInterface;
import org.example.models.Property;

import java.util.ArrayList;

public class Municipality implements MunicipalityInterface {
    private ArrayList<Property> properties;

    public  Municipality(){
        generateProperties();
    }

    private void generateProperties() {
//        Create an algorithm for generating properties for city
    }

    @Override
    public Property buyProperty() {
        return null;
    }

    @Override
    public void sellProperty(Property property) {

    }

    @Override
    public void showProperties() {

    }
}
