package hr.ferit.luka.majstorovic.myapplication

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FakerEndpoints {
    @GET("/api/v1/persons")
    fun getPersons(@Query("_quantity") quantity: Int): Call<ResponseData> // ArrayList<Makeup>

    // /api/v1/persons?_quantity=quantity
}