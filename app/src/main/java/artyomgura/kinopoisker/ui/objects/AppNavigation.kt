package artyomgura.kinopoisker.ui.objects

import android.content.res.Resources
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import artyomgura.kinopoisker.R
import artyomgura.kinopoisker.databinding.ActivityMainBinding

class AppNavigation(private val activity: AppCompatActivity, private val binding: ActivityMainBinding) {
    private lateinit var navController: NavController

    fun create() {
        initNavigation()
    }

    private fun initNavigation() {
        navController = findNavController(activity, R.id.nav_host_fragment_activity_main)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                (R.id.navigation_popular) -> {
                    binding.buttonPopular.background.alpha = 255
                    binding.buttonFavorite.background.alpha = 80
                    showNavButtonsFavoritePopular()
                }
                (R.id.navigation_favorite) -> {
                    binding.buttonPopular.background.alpha = 80
                    binding.buttonFavorite.background.alpha = 255
                    showNavButtonsFavoritePopular()
                }
                else -> hideNavButtonsFavoritePopular()
            }
        }


        binding.buttonPopular.setOnClickListener {
            navController.navigate(R.id.navigation_popular)
        }
        binding.buttonFavorite.setOnClickListener {
            navController.navigate(R.id.navigation_favorite)
        }


        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_popular, R.id.navigation_favorite
            )
        )

        setupActionBarWithNavController(activity, navController, appBarConfiguration)
//        binding.buttonPopular.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.navigation_popular, null))
//        binding.buttonFavorite.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.navigation_favorite, null))
    }
    private fun showNavButtonsFavoritePopular() {
        binding.navView.visibility = View.VISIBLE
    }
    private fun hideNavButtonsFavoritePopular() {
        binding.navView.visibility = View.GONE
    }
}