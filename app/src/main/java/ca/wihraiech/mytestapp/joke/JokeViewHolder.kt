package ca.wihraiech.mytestapp.joke

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ca.wihraiech.mytestapp.databinding.ItemJokeBinding
import kotlinx.android.synthetic.main.item_joke.view.*

/**
 * Provide a reference to the type of views that you are using
 * (joke ViewHolder).
 */
class JokeViewHolder(binding: ItemJokeBinding) : RecyclerView.ViewHolder(binding.root) {
    val typeTextView: TextView = binding.typeTextView
    val setupTextView: TextView = binding.setupTextView
    val punchlineTextView: TextView = binding.punchlineTextView
}