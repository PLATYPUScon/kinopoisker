package artyomgura.kinopoisker.ui.screens.popular

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import artyomgura.kinopoisker.data.api.KinopoiskerApiService
import artyomgura.kinopoisker.data.repository.KinopoiskerApiRepositoryImpl
import artyomgura.kinopoisker.domain.usecase.GetFilmByIdUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class PopularViewModel : ViewModel() {

    private val apiService: KinopoiskerApiService = KinopoiskerApiService.create()
    private val kinopoiskerApiRepository = KinopoiskerApiRepositoryImpl(apiService)
    val getFilmByIdUseCase = GetFilmByIdUseCase(kinopoiskerApiRepository)

    private val coroutineExceptionHandler = CoroutineExceptionHandler{ _, throwable ->
        throwable.printStackTrace()
    }

    private val _text = MutableLiveData<String?>()
    val text: LiveData<String?> = _text

    fun getFilmById()  {
        viewModelScope.launch(coroutineExceptionHandler) {
            val res = getFilmByIdUseCase(301)
            _text.postValue(res.name)
        }
    }
}