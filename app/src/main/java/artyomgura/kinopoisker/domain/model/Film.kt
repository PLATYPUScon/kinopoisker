package artyomgura.kinopoisker.domain.model

import java.time.Year

data class Film(
    val name: String?,
    val posterUrl: String?,
    val posterUrlPreview: String?,
    val year: Int?,
    val description: String?,
    val genres: ArrayList<Genre>,
    val countries: ArrayList<Country>
)

data class Country(
    val country: String,

)

data class Genre(
    val genre: String,

)

