package com.example.yeee.demo;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

// GET https://api.yelp.com/v3/businesses/search

public class searchBusinesses {
    @Id
    public ObjectId _id;

    private String term;
    private String location;
    private double latitude;
    private double longitude;
    private int radius;
    private String categories;
    private String locale;
    private int limit;
    private int offset; // change offset of limited # of restaurants
    private String sort_by;     // ex: best_match, rating, review_count, etc
    private String price;   // $, $$, $$$, $$$$
    private boolean open_now;

    public ObjectId get_id() {
        return _id;
    }
    public void set_id(ObjectId _id) {
        this._id = _id;
    }
    public String getTerm() {
        return term;
    }
    public void setTerm(String term) {
        this.term = term;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public double getLatitude() {
        return latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public int getRadius() {
        return radius;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }
    public String getCategories() {
        return categories;
    }
    public void setCategories(String categories) {
        this.categories = categories;
    }
    public String getLocale() {
        return locale;
    }
    public void setLocale(String locale) {
        this.locale = locale;
    }
    public int getLimit() {
        return limit;
    }
    public void setLimit(int limit) {
        this.limit = limit;
    }
    public int getOffset() {
        return offset;
    }
    public void setOffset(int offset) {
        this.offset = offset;
    }
    public String getSort_by() {
        return sort_by;
    }
    public void setSort_by(String sort_by) {
        this.sort_by = sort_by;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public boolean isOpen_now() {
        return open_now;
    }
    public void setOpen_now(boolean open_now) {
        this.open_now = open_now;
    }

}
