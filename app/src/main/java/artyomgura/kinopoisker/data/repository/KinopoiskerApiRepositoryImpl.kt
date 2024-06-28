package artyomgura.kinopoisker.data.repository

import artyomgura.kinopoisker.data.api.KinopoiskerApiService
import artyomgura.kinopoisker.data.model.FilmResponseDTO
import artyomgura.kinopoisker.domain.repository.KinopoiskerApiRepository

class KinopoiskerApiRepositoryImpl(
    private val kinopoiskerApiService: KinopoiskerApiService
) : KinopoiskerApiRepository {
    override suspend fun getFilmById(id: Int): FilmResponseDTO {
        return kinopoiskerApiService.getFilmById(id)
    }

}