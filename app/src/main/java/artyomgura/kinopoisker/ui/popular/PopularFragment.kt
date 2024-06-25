package artyomgura.kinopoisker.ui.popular

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import artyomgura.kinopoisker.databinding.FragmentPopularBinding

class PopularFragment : Fragment() {

    private var _binding: FragmentPopularBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val popularViewModel =
            ViewModelProvider(this).get(PopularViewModel::class.java)

        _binding = FragmentPopularBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textPopular
        popularViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

//        val recyclerView: RecyclerView = binding.recyclerFilms


        Log.d("AAA", "popular fragment view created")

        return root
    }

    override fun onResume() {
        super.onResume()
        Log.d("AAA", "popular fragment resumed")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

        Log.d("AAA", "popular fragment view destroyed")
    }

    override fun onPause() {
        super.onPause()
        Log.d("AAA", "popular fragment paused")
    }

    override fun onStop() {
        super.onStop()
        Log.d("AAA", "popular fragment stopped")
    }

    override fun onStart() {
        super.onStart()
        Log.d("AAA", "popular fragment started")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("AAA", "popular fragment destroyed")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("AAA", "popular fragment attached")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("AAA", "popular fragment's activity created")
    }

}