package artyomgura.kinopoisker.domain.repository

import artyomgura.kinopoisker.data.model.FilmResponseDTO

interface KinopoiskerApiRepository {
    suspend fun getFilmById(id: Int): FilmResponseDTO
}