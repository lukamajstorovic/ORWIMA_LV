package hr.ferit.lukamajstorovic.orwima_lv6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction

class SelectFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_select, container, false)
        val radioGroup = view.findViewById<RadioGroup>(R.id.radioGroup)
        val button = view.findViewById<Button>(R.id.button3)

        button.setOnClickListener {
            val radioButton = view.findViewById<RadioButton>(radioGroup.checkedRadioButtonId)
            val answerFragment = AnswerFragment()
            val bundle = Bundle()
            bundle.putString("BUTTON", radioButton.text.toString())
            answerFragment.arguments = bundle
            val fragmentTransaction: FragmentTransaction? =
                activity?.supportFragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.mainFragment, answerFragment)
            fragmentTransaction?.commit()
        }
        return view
    }
}
