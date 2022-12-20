package hr.ferit.lukamajstorovic.orwma_lv8_lm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity(), PersonRecyclerAdapter.ContentListener {
    private lateinit var recyclerAdapter: PersonRecyclerAdapter
    private val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.personList)
        db.collection("persons")
            .get()
            .addOnSuccessListener {
                val items: ArrayList<Person> = ArrayList()
                for (data in it.documents) {
                    val person = data.toObject(Person::class.java)
                    if (person != null) {
                        person.id = data.id
                        items.add(person)
                    }
                }
                recyclerAdapter = PersonRecyclerAdapter(items, this@MainActivity)
                recyclerView.apply {
                    layoutManager = LinearLayoutManager(this@MainActivity)
                    adapter = recyclerAdapter
                }
            }
        val textImageUrl = findViewById<EditText>(R.id.textImageUrl)
        val textPersonName = findViewById<EditText>(R.id.textPersonName)
        val textPersonDescription = findViewById<EditText>(R.id.textPersonDescription)
        val saveBtn = findViewById<Button>(R.id.saveButton)

        val item = Person(
            id = "",
            imageUrl = textImageUrl.text.toString(),
            name = textPersonName.text.toString(),
            description = textPersonDescription.text.toString(),
        )

        saveBtn.setOnClickListener {
            recyclerAdapter.addItem(item)
            db.collection("persons").add(item).addOnSuccessListener {
                item.id = it.id
            }
        }
    }

    override fun onItemButtonClick(index: Int, item: Person, clickType: ItemButtonClick) {
        if (clickType == ItemButtonClick.EDIT) {
            db.collection("persons").document(item.id).set(item)
        } else if (clickType == ItemButtonClick.REMOVE) {
            recyclerAdapter.removeItem(index)
            db.collection("persons").document(item.id).delete()
        }
    }
}