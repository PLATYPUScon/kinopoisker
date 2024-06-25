package artyomgura.kinopoisker

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import artyomgura.kinopoisker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("AAA", "Main Activity created")


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                (R.id.navigation_popular), (R.id.navigation_favorite) -> binding.navView.visibility = View.GONE
                else -> binding.navView.visibility = View.GONE
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


        setupActionBarWithNavController(navController, appBarConfiguration)
//        binding.buttonPopular.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.navigation_popular, null))
//        binding.buttonFavorite.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.navigation_favorite, null))
    }



    override fun onPause() {
        super.onPause()
        Log.d("AAA", "Main Activity paused")
    }

    override fun onStop() {
        super.onStop()
        Log.d("AAA", "Main Activity stopped")
    }

    override fun onStart() {
        super.onStart()
        Log.d("AAA", "Main Activity started")
    }

    override fun onResume() {
        super.onResume()
        Log.d("AAA", "Main Activity resumed")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("AAA", "Main Activity destroyed")
    }
}