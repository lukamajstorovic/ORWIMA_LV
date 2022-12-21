package hr.ferit.luka.majstorovic.lv7_task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.productList)

        val searchButton = findViewById<Button>(R.id.searchButton)

        .setOnClickListener {
            val searchBar = findViewById<EditText>(R.id.searchBar)
            val brand = searchBar.text.toString()
            val service = ServiceBuilder.buildService(MakeupEndpoints::class.java)
            val call = service.getProducts(brand)

            call.enqueue(
                object : Callback<ArrayList<Makeup>> {
                    override fun onResponse(
                        call: Call<ArrayList<Makeup>>,
                        response: Response<ArrayList<Makeup>>
                    ) {
                        if (response.isSuccessful) {
                            recyclerView.apply {
                                layoutManager = LinearLayoutManager(this@MainActivity)
                                adapter = MakeupRecycleAdapter(response.body()!!)
                            }
                        }
                    }

                    override fun onFailure(call: Call<ArrayList<Makeup>>, t: Throwable) {
                        Log.e("MainActivity", t.message.toString())
                    }
                }
            )
        }
    }
}
