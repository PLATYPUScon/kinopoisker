package artyomgura.kinopoisker.ui.screens.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import artyomgura.kinopoisker.data.api.KinopoiskerApiService
import artyomgura.kinopoisker.data.repository.KinopoiskerApiRepositoryImpl
import artyomgura.kinopoisker.domain.usecase.GetTopFilmsUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class FavoriteViewModel : ViewModel() {

    private val apiService: KinopoiskerApiService = KinopoiskerApiService.create()
    private val kinopoiskerApiRepository = KinopoiskerApiRepositoryImpl(apiService)
    val getTopFilmsUseCase = GetTopFilmsUseCase(kinopoiskerApiRepository)



    private val _title = MutableLiveData<String?>()
    private val _genre = MutableLiveData<String?>()
    private val _posterUrl = MutableLiveData<String?>()
    val title: LiveData<String?> = _title
    val genre: LiveData<String?> = _genre
    val posterUrl: LiveData<String?> = _posterUrl


    private val coroutineExceptionHandler = CoroutineExceptionHandler{ _, throwable ->
        throwable.printStackTrace()
    }
    fun getTopFilms()  {
        viewModelScope.launch(coroutineExceptionHandler) {
            val res = getTopFilmsUseCase()

            _title.postValue(res[0].name)
            _genre.postValue("${res[0].genres[0].genre}(${res[0].year})")
            _posterUrl.postValue(res[0].posterUrlPreview)
        }
    }
}