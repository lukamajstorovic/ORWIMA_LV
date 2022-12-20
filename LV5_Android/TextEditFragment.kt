package hr.ferit.lukamajstorovic.orwma_lv5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class TextEditFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_text_edit, container, false)
        val button = view.findViewById<Button>(R.id.button)
        val textView = view.findViewById<TextView>(R.id.inputTextView)
        val editText = view.findViewById<EditText>(R.id.editText)
        

        button.setOnClickListener {
            textView.text = editText.text
        }

        return view
    }
}