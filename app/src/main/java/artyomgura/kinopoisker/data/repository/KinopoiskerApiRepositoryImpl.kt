package artyomgura.kinopoisker.data.repository

import artyomgura.kinopoisker.data.api.KinopoiskerApiService
import artyomgura.kinopoisker.data.mapper.toFilm
import artyomgura.kinopoisker.data.model.FilmResponseDTO
import artyomgura.kinopoisker.domain.model.Film
import artyomgura.kinopoisker.domain.repository.KinopoiskerApiRepository

class KinopoiskerApiRepositoryImpl(
    private val kinopoiskerApiService: KinopoiskerApiService
) : KinopoiskerApiRepository {

    override suspend fun getFilmById(id: Int): Film {
        return kinopoiskerApiService.getFilmById(id).toFilm()
    }

    override suspend fun getTopFilms(): List<Film> {
        return kinopoiskerApiService.getTopFilms().films.map { it.toFilm()}
    }

}