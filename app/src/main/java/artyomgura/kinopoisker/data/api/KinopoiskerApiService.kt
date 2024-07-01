package artyomgura.kinopoisker.data.api

import artyomgura.kinopoisker.data.model.FilmByTopResponseDTO
import artyomgura.kinopoisker.data.model.FilmResponseDTO
import artyomgura.kinopoisker.data.model.FilmsListResponseDTO
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query


interface KinopoiskerApiService {
    @GET("/api/v2.2/films/{id}")
    suspend fun getFilmById(@Path("id") id: Int): FilmResponseDTO

    @GET("/api/v2.2/films/top")
    suspend fun getTopFilms(@Query("type") type: String = "TOP_100_POPULAR_FILMS"): FilmsListResponseDTO

    companion object Factory {
        fun create(): KinopoiskerApiService {
            val BASE_URL = "https://kinopoiskapiunofficial.tech"

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(HeaderInterceptor())
                .build()

            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()

            return retrofit.create(KinopoiskerApiService::class.java)
        }
    }

    class HeaderInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val originalRequest: Request = chain.request()
            val newRequest: Request = originalRequest.newBuilder()
                .header("X-API-KEY", "e30ffed0-76ab-4dd6-b41f-4c9da2b2735b")
                .build()
            return chain.proceed(newRequest)
        }
    }
}