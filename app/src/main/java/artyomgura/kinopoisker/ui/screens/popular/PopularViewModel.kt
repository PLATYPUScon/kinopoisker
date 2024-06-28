package artyomgura.kinopoisker.ui.screens.popular

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import artyomgura.kinopoisker.data.api.KinopoiskerApiService
import artyomgura.kinopoisker.data.repository.KinopoiskerApiRepositoryImpl
import artyomgura.kinopoisker.domain.usecase.GetFilmByIdUseCase
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class PopularViewModel : ViewModel() {


    val apiService: KinopoiskerApiService = KinopoiskerApiService.create()
    val kinopoiskerApiRepository = KinopoiskerApiRepositoryImpl(apiService)

    val getFilmByIdUseCase = GetFilmByIdUseCase(kinopoiskerApiRepository)

    private val _text = MutableLiveData<String?>()
    val text: LiveData<String?> = _text

    fun getFilmById()  {
        viewModelScope.launch {
//            val res = apiService.getFilmById(301)
//            val res = getFilmByIdUseCase(301)
            _text.postValue("пупок")
        }
    }
}