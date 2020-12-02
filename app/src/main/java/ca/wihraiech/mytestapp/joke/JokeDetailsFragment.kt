package ca.wihraiech.mytestapp.joke

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ca.wihraiech.mytestapp.R
import ca.wihraiech.mytestapp.common.loadUrl
import ca.wihraiech.mytestapp.common.loadUrl2
import kotlinx.android.synthetic.main.fragment_joke_details.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class JokeDetailsFragment : Fragment() {


    companion object {
        const val JOKE_IMAGE_URL = "https://picsum.photos/300/200"
    }

    private val jokeDetailsViewModel by viewModel<JokedetailsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_joke_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        updateView()
    }

    private fun updateView() {
        arguments?.let {
            typeTextView.text = JokeDetailsFragmentArgs.fromBundle(it).type
            setupTextView.text = JokeDetailsFragmentArgs.fromBundle(it).setup
            punchlineTextView.text = JokeDetailsFragmentArgs.fromBundle(it).punchline
        }
        jokeImageView.loadUrl(JOKE_IMAGE_URL)

    }
}