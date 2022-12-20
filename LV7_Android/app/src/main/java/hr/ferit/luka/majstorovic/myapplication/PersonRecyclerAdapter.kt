package hr.ferit.luka.majstorovic.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PersonRecyclerAdapter(val items: ArrayList<Person>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PersonViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.recycler_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is PersonViewHolder -> {
                holder.bind(items[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class PersonViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        private val personImage = view.findViewById<ImageView>(R.id.personImage)
        private val personName = view.findViewById<TextView>(R.id.personName)
        private val personBirthday = view.findViewById<TextView>(R.id.personBirthday)
        private val personAddress = view.findViewById<TextView>(R.id.personAddress)

        fun bind(person: Person) {
            Glide.with(view.context).load(person.image).into(personImage)
            personName.text = "${person.firstname} ${person.lastname}"
            personBirthday.text = person.birthday
            personAddress.text = person.address.street
        }
    }
}