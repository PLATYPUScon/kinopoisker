package artyomgura.kinopoisker.ui.screens.favorite

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import artyomgura.kinopoisker.databinding.FragmentFavoriteBinding

class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val favoriteViewModel =
            ViewModelProvider(this).get(FavoriteViewModel::class.java)

        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textFavorite
        favoriteViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        Log.d("AAA", "favorite fragment view created")

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

        Log.d("AAA", "favorite fragment view destroyed")
    }

    override fun onPause() {
        super.onPause()
        Log.d("AAA", "favorite fragment paused")
    }

    override fun onStop() {
        super.onStop()
        Log.d("AAA", "favorite fragment stopped")
    }

    override fun onStart() {
        super.onStart()
        Log.d("AAA", "favorite fragment started")
    }

    override fun onResume() {
        super.onResume()
        Log.d("AAA", "favorite fragment resumed")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("AAA", "favorite fragment destroyed")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("AAA", "favorite fragment attached")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("AAA", "favorite fragment's activity created")
    }

}