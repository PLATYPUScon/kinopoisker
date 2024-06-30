package artyomgura.kinopoisker.domain.repository

import artyomgura.kinopoisker.data.model.FilmResponseDTO
import artyomgura.kinopoisker.domain.model.Film

interface KinopoiskerApiRepository {
    suspend fun getFilmById(id: Int): Film

}