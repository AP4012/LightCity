package org.example;

import java.util.Objects;

public class Land  extends Property implements Cityinterface{

    public String kind;
    public boolean status_for_use;

    public Land(int id, String title, String ownerID, String description, float value, float coordinate, boolean status, String kind, boolean status_for_use) {
        super(id, title, ownerID, description, value, coordinate, status);


        if (Objects.equals(kind, "farming")){
            status_for_use=false;
        }
        this.kind = kind;
        this.status_for_use = status_for_use;
        this.id++;
    }

    public void use(Land land){

        if (Objects.equals(land.kind, "farming")){
            land.status_for_use=false;
        }

    }


    public void  Land_to_Home (Land land){

        if (land.isStatus_for_use()){
            //home=new Home();
            //remove land of id=......
            //add home with id of that land
        }

    }
    public void  Land_to_Bank (Land land){
        if (land.isStatus_for_use()) {
            //home=new Home();
            //remove land of id=......
            //add home with id of that land
        }
    }
    public void  Land_to_Factory (Land land){
            if (land.isStatus_for_use()) {
                //home=new Home();
                //remove land of id=......
                //add home with id of that land
            }
    }
    public void  Land_to_Restaurant (Land land){
        if (land.isStatus_for_use()) {
            //home=new Home();
            //remove land of id=......
            //add home with id of that land
        }
    }
    public void  Land_to_Supermarket (Land land){
        if (land.isStatus_for_use()) {
            //home=new Home();
            //remove land of id=......
            //add home with id of that land
        }
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public boolean isStatus_for_use() {
        return status_for_use;
    }

    public void setStatus_for_use(boolean status_for_use) {
        this.status_for_use = status_for_use;
    }

    @Override
    public String toString() {
        return "Land{" +
                "kind='" + kind + '\'' +
                ", status_for_use=" + status_for_use +
                ", title='" + title + '\'' +
                ", owner-username=" + ownerusername +
                ", description='" + description + '\'' +
                ", value=" + value +
                ", coordinate=" + coordinate +
                ", status=" + status +
                '}';
    }

    @Override
    public void menu() {

    }

    @Override
    public void buy() {

    }

    @Override
    public void sell() {

    }

    public Land(){

    }
    public void UseProperty(String username) {

    }


}
