package hr.ferit.lukamajstorovic.orwma_lv5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameView = findViewById<TextView>(R.id.textView)
        val detailsView = findViewById<TextView>(R.id.textView2)
        val button1 = findViewById<Button>(R.id.button)
        val button2 = findViewById<Button>(R.id.button2)

        button1.setOnClickListener {
            val nameText = findViewById<EditText>(R.id.editTextTextPersonName)
            val detailsText = findViewById<EditText>(R.id.editTextTextPersonName2)

            nameView.text = nameText.text
            detailsView.text = detailsText.text
        }

        button2.setOnClickListener {
            val heightView = findViewById<EditText>(R.id.editTextTextPersonName3)
            val weightView = findViewById<EditText>(R.id.editTextTextPersonName4)
            val height = heightView.text.toString().toDouble()
            val weight = weightView.text.toString().toDouble()

            val bmi = calculateBMI(height, weight)
            Toast.makeText(this, bmi.toString(), Toast.LENGTH_LONG).show()
        }
    }

    private fun calculateBMI(height:Double, weight:Double): Double {
        return weight/Math.pow(height, 2.0)
    }
}