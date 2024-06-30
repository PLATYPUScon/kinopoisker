package artyomgura.kinopoisker.data.mapper

import artyomgura.kinopoisker.data.model.FilmResponseDTO
import artyomgura.kinopoisker.domain.model.Country
import artyomgura.kinopoisker.domain.model.Film
import artyomgura.kinopoisker.domain.model.Genre

fun FilmResponseDTO.toFilm(): Film{
    val tmpGenres = ArrayList<Genre>()
    val tmpCountries = ArrayList<Country>()

    genres.forEach {
        tmpGenres.add(Genre(it.genre!!))
    }
    countries.forEach {
        tmpCountries.add(Country(it.country!!))
    }

    return Film(
        name = nameRu,
        posterUrl = posterUrl,
        posterUrlPreview = posterUrlPreview,
        year = year,
        description = description,
        genres = tmpGenres,
        countries = tmpCountries,

    )
}