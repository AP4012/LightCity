package org.example;

import java.util.ArrayList;

public class City {

    protected static double output;
    protected static Avatar mayor;
    protected ArrayList<Avatar> avatars = new ArrayList<>();
    protected ArrayList<Bank>  banks= new ArrayList<>();
    protected ArrayList<Boutique> boutiques = new ArrayList<>();
    protected ArrayList<Land> lands = new ArrayList<>();
    protected ArrayList<Home> homes = new ArrayList<>();
    protected ArrayList<Restaurant> restaurants = new ArrayList<>();
    protected ArrayList<Supermarket> supermarkets = new ArrayList<>();
    protected ArrayList<Factory> factories = new ArrayList<>();
    protected ArrayList<Clinic> clinics = new ArrayList<>();
    protected ArrayList<Property> properties= new ArrayList<>();

    public double getOutput() {
        return output;
    }

    public void setOutput(double output) {
        this.output = output;
    }

    public Avatar getMayor() {
        return mayor;
    }

    public void setMayor(Avatar mayor) {
        this.mayor = mayor;
    }

    public ArrayList<Avatar> getAvatars() {
        return avatars;
    }

    public void setAvatars(ArrayList<Avatar> avatars) {
        this.avatars = avatars;
    }

    public ArrayList<Bank> getBanks() {
        return banks;
    }

    public void setBanks(ArrayList<Bank> banks) {
        this.banks = banks;
    }

    public ArrayList<Boutique> getBoutiques() {
        return boutiques;
    }

    public void setBoutiques(ArrayList<Boutique> boutiques) {
        this.boutiques = boutiques;
    }

    public ArrayList<Land> getLands() {
        return lands;
    }

    public void setLands(ArrayList<Land> lands) {
        this.lands = lands;
    }

    public ArrayList<Home> getHomes() {
        return homes;
    }

    public void setHomes(ArrayList<Home> homes) {
        this.homes = homes;
    }

    public ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(ArrayList<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public ArrayList<Supermarket> getSupermarkets() {
        return supermarkets;
    }

    public void setSupermarkets(ArrayList<Supermarket> supermarkets) {
        this.supermarkets = supermarkets;
    }

    public ArrayList<Factory> getFactories() {
        return factories;
    }

    public void setFactories(ArrayList<Factory> factories) {
        this.factories = factories;
    }

    public ArrayList<Clinic> getClinics() {
        return clinics;
    }

    public void setClinics(ArrayList<Clinic> clinics) {
        this.clinics = clinics;
    }

    public void setProperties(ArrayList<Property> properties) {
        this.properties = properties;
    }

    public ArrayList<Property> getProperties() {
        return properties;
    }
}
