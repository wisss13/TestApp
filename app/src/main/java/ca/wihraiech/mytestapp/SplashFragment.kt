package ca.wihraiech.mytestapp

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ca.wihraiech.mytestapp.fragments.SplashFragmentDirections

class SplashFragment : Fragment() {

    companion object {
        const val SPLASH_DURATION: Long = 2000
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        handleAppForeground()
    }

    private fun handleAppForeground() {
        Handler().postDelayed({
            navigateToHome()
        }, SPLASH_DURATION)
    }

    private fun navigateToHome() {
        val action =
            SplashFragmentDirections.actionNavigationHomeFromSplash()
        findNavController().navigate(action)
    }
}