package hr.ferit.luka.majstorovic.lv7_task

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MakeupEndpoints {
    @GET("/api/v1/products.json")
    fun getProducts(@Query("brand") brand: String): Call<ArrayList<Makeup>>

    // /api/v1/products.json?brand=brand
}