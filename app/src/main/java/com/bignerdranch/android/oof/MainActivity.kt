package com.bignerdranch.android.oof

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val TAG = "MainActivity"
private const val BASE_URL = "https://api.yelp.com/v3/"
private const val API_KEY = "ZCEuptuxXV-yCcv_CvyhqdtdCndEk-vsucOi64NyIGcpLpmWBSBFpHiVBkTQEUyuItzsCo4pTtXSLhPjx_Cf9B0M4SprqX6zshm1pzPo2giYK3FlghKnsRizeEc9Y3Yx"

class MainActivity : AppCompatActivity() {
    private lateinit var buttonGen : Button
    private lateinit var buttonTemp : Button
    private lateinit var buttonClear : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val restaurants = mutableListOf<YelpRestaurant>()
        val adapter = RestaurantsAdapter(this, restaurants)
        rvRestaurants.adapter = adapter
        rvRestaurants.layoutManager = LinearLayoutManager(this)

        val retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        val yelpService = retrofit.create(YelpService::class.java)

        var inputAddress = ""
        var inputRad = ""

        buttonGen = findViewById(R.id.homeGenerate)
        buttonTemp = findViewById(R.id.homeSpin)
        buttonClear = findViewById(R.id.homeClr)

        buttonGen.setOnClickListener { view : View ->
            inputAddress = editTextTextPostalAddress.text.toString();
            inputRad = edittextrad.text.toString()
            yelpService.searchRestaurants("Bearer $API_KEY","", "$inputRad", "$inputAddress").enqueue(object : Callback<YelpSearchResult> {
                override fun onResponse(call: Call<YelpSearchResult>, response: Response<YelpSearchResult>) {
                    Log.i(TAG, "onResponse $response")
                    val body = response.body()
                    if(body == null) {
                        Log.w(TAG, "Oops! There was an error. Try again.")
                        return
                    }
                    restaurants.addAll(body.restaurants);
                    adapter.notifyDataSetChanged();
                }

                override fun onFailure(call: Call<YelpSearchResult>, t: Throwable) {
                    Log.i(TAG, "onFailure $t")
                }

            })
        }
        buttonClear.setOnClickListener { view : View ->
            restaurants.clear()
            adapter.notifyDataSetChanged()
        }

        buttonTemp.setOnClickListener { view : View ->
            restaurants.clear()
            adapter.notifyDataSetChanged()

            inputAddress = editTextTextPostalAddress.text.toString();
            inputRad = edittextrad.text.toString()
            yelpService.searchRestaurants("Bearer $API_KEY","", "$inputRad", "$inputAddress").enqueue(object : Callback<YelpSearchResult> {
                override fun onResponse(call: Call<YelpSearchResult>, response: Response<YelpSearchResult>) {
                    Log.i(TAG, "onResponse $response")
                    val body = response.body()
                    if(body == null) {
                        Log.w(TAG, "Oops! There was an error. Try again.")
                        return
                    }
                    restaurants.addAll(body.restaurants);
                    val rand = restaurants.shuffled()[0]
                    restaurants.clear()
                    restaurants.add(rand)
                    adapter.notifyDataSetChanged();
                }

                override fun onFailure(call: Call<YelpSearchResult>, t: Throwable) {
                    Log.i(TAG, "onFailure $t")
                }

            })
        }


    }
}