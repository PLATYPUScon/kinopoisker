package artyomgura.kinopoisker.ui.popular

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PopularViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Это Популярные"
    }
    val text: LiveData<String> = _text
}