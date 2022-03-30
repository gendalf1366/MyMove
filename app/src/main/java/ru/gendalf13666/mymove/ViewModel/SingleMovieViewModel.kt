package ru.gendalf13666.mymove.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import ru.gendalf13666.mymove.Model.Data.MovieDetails
import ru.gendalf13666.mymove.Model.Repository.MovieDetailsRepository
import ru.gendalf13666.mymove.Model.Repository.NetworkState

class SingleMovieViewModel(private val movieRepository: MovieDetailsRepository, movieId: Int) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    val movieDetails: LiveData<MovieDetails> by lazy {
        movieRepository.fetchSingleMovieDetails(compositeDisposable, movieId)
    }

    val networkState: LiveData<NetworkState> by lazy {
        movieRepository.getMovieDetailsNetworkState()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}
