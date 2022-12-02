package com.snackoverflow.yelproulette;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Restaurant {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "radius")
    private int radius;

    @Column(name = "price")
    private String price;

    @Column(name = "open_now")
    private boolean openNow;

    // getter, setters, contructors
    public Restaurant(){
        id = "";
        name = "";
        address = "";
        radius = 0;
        price = "";
        openNow = false;
    }
    public Restaurant(String address, int radius, String price, boolean openNow){
        this.address = address;
        this.radius = radius;
        this.price = price;
        this.openNow = openNow;
    }

    public void setID(String id){this.id = id;}
    public void setName(String name){this.name = name;}
    public void setAddress(String address){this.address = address;}
    public void setRadius(int radius){this.radius = radius;}
    public void setPrice(String price){this.price = price;}
    public void setOpenNow(boolean openNow){this.openNow = openNow;}


    public String getID(){return id;}
    public String getName(){return name;}
    public String getAddress(){return address;}
    public int getRadius(){return radius;}
    public String getPrice(){return price;}
    public boolean getOpenNow(){return openNow;}
}