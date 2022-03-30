package ru.gendalf13666.mymove.Model.Retrofit

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.gendalf13666.mymove.Model.Data.MovieDetails
import ru.gendalf13666.mymove.Model.Data.MovieResponse

interface TheMovieDBInterface {

    @GET("movie/popular")
    fun getPopularMovie(@Query("page") page: Int): Single<MovieResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") id: Int): Single<MovieDetails>
}
