package artyomgura.kinopoisker.domain.usecase

import artyomgura.kinopoisker.data.model.FilmResponseDTO
import artyomgura.kinopoisker.domain.model.Film
import artyomgura.kinopoisker.domain.repository.KinopoiskerApiRepository

class GetFilmByIdUseCase(
    private val repository: KinopoiskerApiRepository
) {
    suspend operator fun invoke(id: Int): Film {
        return repository.getFilmById(id)
    }
}