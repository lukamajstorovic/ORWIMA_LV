package hr.ferit.lukamajstorovic.orwma_lv5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    private lateinit var imageFragment: ImageFragment
    private lateinit var textEditFragment: TextEditFragment
    private var isSwitched: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setup()
        findViewById<Button>(R.id.button3).setOnClickListener {
            isSwitched = !isSwitched
            switchFrags()
        }

        findViewById<Button>(R.id.button2).setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }

    fun setup() {
        imageFragment = ImageFragment()
        textEditFragment = TextEditFragment()

        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, textEditFragment)
        fragmentTransaction.replace(R.id.fragmentContainerView2, imageFragment)
        fragmentTransaction.commit()
    }

    fun switchFrags() {
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        imageFragment = ImageFragment()
        textEditFragment = TextEditFragment()

        if(isSwitched) {
            fragmentTransaction.replace(R.id.fragmentContainerView, imageFragment)
            fragmentTransaction.replace(R.id.fragmentContainerView2, textEditFragment)
            fragmentTransaction.commit()
        }
        else {
            fragmentTransaction.replace(R.id.fragmentContainerView, textEditFragment)
            fragmentTransaction.replace(R.id.fragmentContainerView2, imageFragment)
            fragmentTransaction.commit()
        }
    }
}