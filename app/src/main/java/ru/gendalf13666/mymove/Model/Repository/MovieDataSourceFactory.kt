package ru.gendalf13666.mymove.Model.Repository

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import io.reactivex.disposables.CompositeDisposable
import ru.gendalf13666.mymove.Model.Data.Movie
import ru.gendalf13666.mymove.Model.Retrofit.TheMovieDBInterface

class MovieDataSourceFactory(private val apiService: TheMovieDBInterface, private val compositeDisposable: CompositeDisposable) :
    DataSource.Factory<Int, Movie>() {

    val moviesLiveDataSource = MutableLiveData<MovieDataSource>()

    override fun create(): DataSource<Int, Movie> {
        val movieDataSource = MovieDataSource(apiService, compositeDisposable)

        moviesLiveDataSource.postValue(movieDataSource)
        return movieDataSource
    }
}
