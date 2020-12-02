package ca.wihraiech.mytestapp.joke

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_joke.view.*

/**
 * Provide a reference to the type of views that you are using
 * (joke ViewHolder).
 */
class JokeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val typeTextView: TextView = itemView.typeTextView
    val setupTextView: TextView = itemView.setupTextView
    val punchlineTextView: TextView = itemView.punchlineTextView
}