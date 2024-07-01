package artyomgura.kinopoisker.ui.objects

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
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
//                    binding.buttonPopular.setBackgroundColor(ContextCompat.getColor(activity, R.color.cyan))
                    binding.buttonFavorite.background.alpha = 130
                    binding.buttonPopular.background.alpha = 255
                    showNavButtonsFavoritePopular()
                }
                (R.id.navigation_favorite) -> {
                    binding.buttonPopular.background.alpha = 130
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

        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
//        setupActionBarWithNavController(activity, navController, appBarConfiguration)
//        binding.buttonPopular.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.navigation_popular, null))
//        binding.buttonFavorite.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.navigation_favorite, null))
    }
    private fun showNavButtonsFavoritePopular() {
        binding.navButtons.visibility = View.VISIBLE
    }
    private fun hideNavButtonsFavoritePopular() {
        binding.navButtons.visibility = View.GONE
    }
}