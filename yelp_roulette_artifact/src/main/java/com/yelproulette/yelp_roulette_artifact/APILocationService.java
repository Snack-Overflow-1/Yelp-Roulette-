package com.yelproulette.yelp_roulette_artifact;

public class APILocationService extends org.springframework.data.geo.Point {

    public APILocationService(double latitude, double longitude) {
        super(latitude, longitude);
    }

    public double getLongitude() {
        return getY();
    }

    public double getLatitude() {
        return getX();
    }

    /*
     * public void setLongitude() {
     * 
     * }
     * 
     * public void setLatitude(){
     * 
     * }
     */
    public static void main(String[] args) {
    }

}