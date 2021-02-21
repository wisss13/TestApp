package ca.wihraiech.mytestapp.user

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ca.wihraiech.mytestapp.api.model.dto.UserDto
import ca.wihraiech.mytestapp.databinding.ItemJokeBinding
import kotlinx.android.synthetic.main.item_joke.view.*

class UserAdapter(
//    private val jokeItemClickListener: JokeItemListener
    private val userItemClickListener: UserItemListener
) :
    PagingDataAdapter<UserDto, UserAdapter.UserViewHolder>(DataDifferntiator) {

    inner class UserViewHolder(private val binding: ItemJokeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val pos = bindingAdapterPosition
                if (pos != RecyclerView.NO_POSITION) {
                    getItem(pos)?.let {
                        userItemClickListener.onClick(it)
                    }
                }
            }
        }

        fun bind(user: UserDto) {
            binding.apply {
                typeTextView.text = user.userId.toString()
                setupTextView.text = user.title
                punchlineTextView.text = user.body
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            ItemJokeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(viewHolder: UserViewHolder, position: Int) {

        val user = getItem(position)
        user?.let { viewHolder.bind(it) }
    }

    object DataDifferntiator : DiffUtil.ItemCallback<UserDto>() {

        override fun areItemsTheSame(oldItem: UserDto, newItem: UserDto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UserDto, newItem: UserDto): Boolean {
            return oldItem == newItem
        }
    }

}