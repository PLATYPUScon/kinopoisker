package artyomgura.kinopoisker.data.model

import com.google.gson.annotations.SerializedName

data class FilmsListResponseDTO(
    @SerializedName("pagesCount") var pagesCount: Int? = null,
    @SerializedName("films") var films: ArrayList<FilmByTopResponseDTO> = arrayListOf()
)

data class FilmByTopResponseDTO(
    @SerializedName("filmId") var filmId: Int? = null,
    @SerializedName("nameRu") var nameRu: String? = null,
    @SerializedName("nameEn") var nameEn: String? = null,
    @SerializedName("year") var year: Int? = null,
    @SerializedName("filmLength") var filmLength: String? = null,
    @SerializedName("countries") var countries: ArrayList<Countries> = arrayListOf(),
    @SerializedName("genres") var genres: ArrayList<Genres> = arrayListOf(),
    @SerializedName("rating") var rating: String? = null,
    @SerializedName("ratingVoteCount") var ratingVoteCount: Int? = null,
    @SerializedName("posterUrl") var posterUrl: String? = null,
    @SerializedName("posterUrlPreview") var posterUrlPreview: String? = null,
    @SerializedName("ratingChange") var ratingChange: String? = null,
    @SerializedName("isRatingUp") var isRatingUp: String? = null,
    @SerializedName("isAfisha") var isAfisha: Int? = null

)