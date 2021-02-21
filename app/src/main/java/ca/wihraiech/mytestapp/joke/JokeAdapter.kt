package ca.wihraiech.mytestapp.joke

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import ca.wihraiech.mytestapp.api.model.dto.JokeDto
import ca.wihraiech.mytestapp.databinding.ItemJokeBinding
import kotlinx.android.synthetic.main.item_joke.view.*

class JokeAdapter(
    private val jokeItemClickListener: JokeItemListener
) :
    PagingDataAdapter<JokeDto, JokeViewHolder>(DataDifferntiator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {

        return JokeViewHolder(
            ItemJokeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
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