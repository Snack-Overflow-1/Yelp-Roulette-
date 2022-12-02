package com.bignerdranch.android.oof

import com.google.gson.annotations.SerializedName
import java.net.URL

data class YelpSearchResult (
    @SerializedName("total") val total : Int,
    @SerializedName("businesses") val restaurants : List<YelpRestaurant>,
        )

data class YelpRestaurant (
    @SerializedName("name") val name : String,
    @SerializedName("categories") val category : List<YelpCategory>,
    @SerializedName("is_closed") val open : Boolean,
    @SerializedName("image_url") val imgUrl : String,
    @SerializedName("location") val location : YelpLocation,
    @SerializedName("phone") val phone : String,
    @SerializedName("price") val price : String,
    @SerializedName("rating") val rating : Double,
    @SerializedName("url") val url : String,
    @SerializedName("distance") val distances : Double,
    @SerializedName("review_count") val review : Int
        ) {
    fun displayDistance() : String {
        val dist = "%.2f".format(distances)
        return "$dist meters"
    }
}
// can add the rest of user objects like location, price, types of food here

data class YelpCategory (
    val title : String
        )

data class YelpLocation (
    @SerializedName("address1") val address : String
        )