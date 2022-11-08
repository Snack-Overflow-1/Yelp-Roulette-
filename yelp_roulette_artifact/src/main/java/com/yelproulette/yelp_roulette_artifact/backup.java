package com.yelproulette.yelp_roulette_artifact;

import java.io.IOException;
// import java.util.*;

// import org.jsoup.Jsoup;
// import org.jsoup.nodes.Document;
// import org.jsoup.nodes.Element;
// import org.jsoup.select.Elements;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class backup {
        public static void main(String[] args) throws IOException, InterruptedException {
                APILocationService location = new APILocationService(0, 0);
                double latitude = location.getLatitude();
                double longtitude = location.getLongitude();
                double radius = 0;

                // latitude = 33.989819;
                // longtitude = -117.732582;
                radius = 32000;
                String API_URL = "https://restaurants-api.p.rapidapi.com/restaurants?latitude=" + latitude
                                + "&longitude=" + longtitude
                                + "&radius=" + radius;

                HttpRequest request = HttpRequest.newBuilder()
                                .uri(URI.create(
                                                API_URL))
                                .header("X-RapidAPI-Key", "4f7b8ae1e0msh9323086362af02fp19cd88jsnd600a97d3493")
                                .header("X-RapidAPI-Host", "restaurants-api.p.rapidapi.com")
                                .method("GET", HttpRequest.BodyPublishers.noBody())
                                .build();
                HttpResponse<String> response = HttpClient.newHttpClient().send(request,
                                HttpResponse.BodyHandlers.ofString());
                System.out.println(response.body());
        }

}
