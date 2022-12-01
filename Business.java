package com.snackoverflow.yelproulette;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

 //Kelly, Janet, and Ivan through Liveshare

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Business {
    @JsonProperty("rating")
    public int rating;

    @JsonProperty("price")
    public String price;

    @JsonProperty("phone")
    public String phone;

    @JsonProperty("id")
    public String id;

    @JsonProperty("alias")
    public String alias;

    @JsonProperty("is_closed")
    public boolean is_closed;

    @JsonProperty("review_count")
    public int review_count;

    @JsonProperty("name")
    public String name;

    @JsonProperty("url")
    public String url;

    @JsonProperty("coordinates")
    public int[] coordinates = new int[2];

    @JsonProperty("image_url")
    public String image_url;

    @JsonProperty("location")
    public String[] location = new String[7];

    @JsonProperty("distance")
    public float distance;

    @Override
    public String toString(){
        return
                "Name: " + name + ".\n" +
                "Price: " + price + ".\n" +
                "Rating: " + rating + ".\n";
    }

}
