package ca.wihraiech.mytestapp.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import ca.wihraiech.mytestapp.R
import ca.wihraiech.mytestapp.api.model.dto.JokeDto
import ca.wihraiech.mytestapp.joke.JokeAdapter
import ca.wihraiech.mytestapp.joke.JokeItemListener
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val homeViewModel by viewModel<HomeViewModel>()
    lateinit var jokeAdapter: JokeAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        updateList()

    }

    private fun setupRecyclerView() {
        jokeAdapter = JokeAdapter(buildJokeItemListener())

        jokeRecyclerview?.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = jokeAdapter
        }

        jokeAdapter.addLoadStateListener { loadState ->
            if (loadState.refresh is LoadState.Loading ||
                loadState.append is LoadState.Loading
            ) {
                progressBarLayout?.visibility = View.VISIBLE
            } else {
                progressBarLayout?.visibility = View.GONE
            }

            val errorState = when {
                loadState.append is LoadState.Error -> loadState.append as LoadState.Error
                loadState.prepend is LoadState.Error ->  loadState.prepend as LoadState.Error
                loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
                else -> null
            }
            errorState?.let {
                Toast.makeText(context, it.error.toString(), Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun buildJokeItemListener(): JokeItemListener {
        return object : JokeItemListener {
            override fun onClick(jokeDto: JokeDto?) {
                val action = HomeFragmentDirections.actionNavigationToJokeDetails(
                    type = jokeDto?.type,
                    setup = jokeDto?.setup,
                    punchline = jokeDto?.punchline
                )
                findNavController().navigate(action)
            }
        }
    }

    private fun updateList() {
        lifecycleScope.launch {
            homeViewModel.listData.observe(viewLifecycleOwner, Observer { pagingData ->
                jokeAdapter.submitData(lifecycle, pagingData)
            })
        }
    }
}