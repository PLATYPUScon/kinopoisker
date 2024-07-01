package artyomgura.kinopoisker.domain.usecase

import artyomgura.kinopoisker.domain.model.Film
import artyomgura.kinopoisker.domain.repository.KinopoiskerApiRepository

class GetTopFilmsUseCase(
    private val repository: KinopoiskerApiRepository
) {
    suspend operator fun invoke(): List<Film>{
        return repository.getTopFilms()
    }
}