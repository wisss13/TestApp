package ca.wihraiech.mytestapp.joke

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import ca.wihraiech.mytestapp.R
import ca.wihraiech.mytestapp.api.model.dto.JokeDto
import kotlinx.android.synthetic.main.item_joke.view.*

class JokeAdapter(
    private val jokeItemClickListener: JokeItemListener
) :
    PagingDataAdapter<JokeDto, JokeViewHolder>(DataDifferntiator) {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): JokeViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_joke, viewGroup, false)

        return JokeViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: JokeViewHolder, position: Int) {

        viewHolder.itemView.apply {
            viewHolder.itemView.typeTextView.text = getItem(position)?.type
            viewHolder.itemView.setupTextView.text = getItem(position)?.setup
            viewHolder.itemView.punchlineTextView.text = getItem(position)?.punchline

            setOnClickListener {
                jokeItemClickListener.onClick(getItem(position))
            }
        }
    }

    object DataDifferntiator : DiffUtil.ItemCallback<JokeDto>() {

        override fun areItemsTheSame(oldItem: JokeDto, newItem: JokeDto): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: JokeDto, newItem: JokeDto): Boolean {
            return oldItem == newItem
        }
    }

}