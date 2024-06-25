package artyomgura.kinopoisker

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import artyomgura.kinopoisker.databinding.ActivityMainBinding
import artyomgura.kinopoisker.ui.objects.AppNavigation

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var appNavigation: AppNavigation


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("AAA", "Main Activity created")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onStart() {
        super.onStart()
        Log.d("AAA", "Main Activity started")

        initFields()
        initFun()
    }


    private fun initFields() {
         appNavigation= AppNavigation(this, binding)
    }
    private fun initFun() {
         appNavigation.create()
    }





    override fun onPause() {
        super.onPause()
        Log.d("AAA", "Main Activity paused")
    }

    override fun onStop() {
        super.onStop()
        Log.d("AAA", "Main Activity stopped")
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