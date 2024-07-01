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
import artyomgura.kinopoisker.R
import artyomgura.kinopoisker.databinding.FragmentFavoriteBinding
import com.squareup.picasso.Picasso

class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        val root: View = binding.root

        Log.d("AAA", "favorite fragment view created")

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val favoriteViewModel =
            ViewModelProvider(this).get(FavoriteViewModel::class.java)


        favoriteViewModel.genre.observe(viewLifecycleOwner) {
            binding.filmGenreAndYear.text = it
        }
        favoriteViewModel.title.observe(viewLifecycleOwner) {
            binding.filmTitle.text = it
        }
        favoriteViewModel.posterUrl.observe(viewLifecycleOwner) {
            val imageAddress = it
            Picasso.get().load(imageAddress).into(binding.filmPosterIcon)
        }

        favoriteViewModel.getTopFilms()
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