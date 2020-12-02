package ca.wihraiech.mytestapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupNavigationArchitectureComponent()
    }

    private fun setupNavigationArchitectureComponent() {
        val navController = findNavController(R.id.nav_host_fragment)
        val graph = navController.graph
        graph.startDestination = R.id.splashFragment
        navController.graph = graph
    }
}
