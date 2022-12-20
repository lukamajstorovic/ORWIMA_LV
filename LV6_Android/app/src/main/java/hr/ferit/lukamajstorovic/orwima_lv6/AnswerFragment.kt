package hr.ferit.lukamajstorovic.orwima_lv6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction

class AnswerFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_answer, container, false)

        val button = view.findViewById<Button>(R.id.button)

        button.setOnClickListener {
            val fragmentTransaction: FragmentTransaction? =
                activity?.supportFragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.mainFragment, SelectFragment())
            fragmentTransaction?.commit()
        }

        val answerText = view.findViewById<TextView>(R.id.textView2)

        answerText.text = arguments?.getString("BUTTON").toString()

        return view
    }
}