package ru.gendalf13666.mymove.Model.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import io.reactivex.disposables.CompositeDisposable
import ru.gendalf13666.mymove.Model.Retrofit.POST_PER_PAGE
import ru.gendalf13666.mymove.Model.Retrofit.TheMovieDBInterface
import ru.gendalf13666.mymove.Model.Repository.MovieDataSource
import ru.gendalf13666.mymove.Model.Repository.MovieDataSourceFactory
import ru.gendalf13666.mymove.Model.Repository.NetworkState
import ru.gendalf13666.mymove.Model.Data.Movie

class MoviePagedListRepository(private val apiService: TheMovieDBInterface) {

    lateinit var moviePagedList: LiveData<PagedList<Movie>>
    lateinit var moviesDataSourceFactory: MovieDataSourceFactory

    fun fetchLiveMoviePagedList(compositeDisposable: CompositeDisposable): LiveData<PagedList<Movie>> {
        moviesDataSourceFactory = MovieDataSourceFactory(apiService, compositeDisposable)

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(POST_PER_PAGE)
            .build()

        moviePagedList = LivePagedListBuilder(moviesDataSourceFactory, config).build()

        return moviePagedList
    }

    fun getNetworkState(): LiveData<NetworkState> {
        return Transformations.switchMap<MovieDataSource, NetworkState>(
            moviesDataSourceFactory.moviesLiveDataSource, MovieDataSource::networkState
        )
    }
}
