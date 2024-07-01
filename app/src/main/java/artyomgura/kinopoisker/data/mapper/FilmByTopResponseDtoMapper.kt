package artyomgura.kinopoisker.data.mapper

import artyomgura.kinopoisker.data.model.FilmByTopResponseDTO
import artyomgura.kinopoisker.domain.model.Country
import artyomgura.kinopoisker.domain.model.Film
import artyomgura.kinopoisker.domain.model.Genre

fun FilmByTopResponseDTO.toFilm(): Film {
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
        description = "without description",
        genres = tmpGenres,
        countries = tmpCountries,

        )
}
