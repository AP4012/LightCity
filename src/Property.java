package org.example;

import java.util.ArrayList;

public class Property {


    protected  int id;
    protected String title;
    protected String ownerusername;
    protected String description;
    protected float value;
    protected float coordinate;
    protected boolean status;

    public Property(int id,String title,String ownerusername,String description,float value,float coordinate,boolean status){

        this.id =id;
        this.title=title;
        this.ownerusername=ownerusername;
        this.description=description;
        this.value=value;
        this.coordinate=coordinate;
        this.status=status;

    }
    public Property(){

    }

    //public

    public static Object FindProperty(int id) {
        Bank bank = null;
        Boutique boutique = null;
        Clinic clinic = null;
        Factory factory = null;
        Home home = null;
        Land land = null;
        Restaurant restaurant = null;
        Supermarket supermarket = null;
        for (Bank b : Game.city.getBanks()) {
            if (b.getId() == id) {
                return b;
            }
        }
        for (Boutique b : Game.city.getBoutiques()) {
            if (b.getId() == id) {
                return b;
            }
        }

        for (Home h : Game.city.getHomes()) {
            if (h.getId() == id) {
                return h;
            }
        }

        for (Restaurant r : Game.city.getRestaurants()) {
            if (r.getId() == id) {
                return r;
            }
        }

        for (Supermarket s : Game.city.getSupermarkets()) {
            if (s.getId() == id) {
                return s;
            }
        }

        for (Land l : Game.city.getLands()) {
            if (l.getId() == id) {
                return l;
            }
        }
        for (Clinic c : Game.city.getClinics()) {
            if (c.getId() == id) {
                return c;
            }
        }
        for (Factory f : Game.city.getFactories()) {
            if (f.getId() == id) {
                return f;
            }
        }
        return null;
    }

    public  int getId() {
        return id;
    }

    public  void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOwnerusername() {
        return ownerusername;
    }

    public void setOwnerID(String ownerusername) {
        this.ownerusername = ownerusername;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(float coordinate) {
        this.coordinate = coordinate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Property{" +
                "id='" + id + '\'' +
                "title='" + title + '\'' +
                ", owner-username=" + ownerusername +
                ", description='" + description + '\'' +
                ", value=" + value +
                ", coordinate=" + coordinate +
                ", status=" + status +
                '}';
    }


}
