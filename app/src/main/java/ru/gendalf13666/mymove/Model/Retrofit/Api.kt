package ru.gendalf13666.mymove.Model.Retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import ru.gendalf13666.mymove.Model.Data.GetMoviesResponse

interface Api {

    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") api_key: String = "api_key",
        @Query("page") page: Int
    ): Call<GetMoviesResponse>

    @GET("movie/top_rated")
    fun getTopRatedMovies(
        @Query("api_key") api_key: String = "api_key",
        @Query("page") page: Int
    ): Call<GetMoviesResponse>

    @GET("movie/upcoming")
    fun getUpcomingMovies(
        @Query("api_key") apiKey: String = "api_key",
        @Query("page") page: Int
    ): Call<GetMoviesResponse>
}
