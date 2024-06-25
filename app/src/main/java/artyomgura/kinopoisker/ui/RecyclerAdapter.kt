package artyomgura.kinopoisker.ui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import artyomgura.kinopoisker.R

class RecyclerAdapter(private val names: List<String>) {

    class SomeItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val largeTextView: TextView = itemView.findViewById(R.id.textViewLarge)
        val smallTextView: TextView = itemView.findViewById(R.id.textViewSmall)
    }
}