package hr.ferit.luka.majstorovic.lv7_task

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MakeupRecycleAdapter(val items: ArrayList<Makeup>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            return ProductViewHolder(
                LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.recycler_item, parent, false)
            )
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            when(holder) {
                is ProductViewHolder -> {
                    holder.bind(items[position])
                }
            }
        }

        override fun getItemCount(): Int {
            return items.size
        }

        class ProductViewHolder(val view: View): RecyclerView.ViewHolder(view) {
            private val productImage = view.findViewById<ImageView>(R.id.productImage)
            private val productName = view.findViewById<TextView>(R.id.productName)
            private val productPrice = view.findViewById<TextView>(R.id.productPrice)
            private val productRating = view.findViewById<TextView>(R.id.productRating)
            private val productDescription = view.findViewById<TextView>(R.id.productDescription)

            fun bind(product: Makeup) {
                Glide.with(view.context).load(product.image_link).into(productImage)
                productName.text = product.name
                productPrice.text = product.name
                productRating.text = product.rating
                productDescription.text = product.description
            }
        }
}