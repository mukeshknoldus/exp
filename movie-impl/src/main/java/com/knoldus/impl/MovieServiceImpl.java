package com.knoldus.impl;

import akka.NotUsed;
import com.knoldus.Movie;
import com.knoldus.MovieService;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import javax.inject.Inject;
import java.util.Optional;
import java.util.concurrent.CompletionStage;

public class MovieServiceImpl implements MovieService {
    
    
    private final MovieServiceImplDao movieServiceImplDao;
    
    @Inject
    public MovieServiceImpl(MovieServiceImplDao movieServiceImplDao) {
        this.movieServiceImplDao = movieServiceImplDao;
    }
    
    public ServiceCall<NotUsed, String> movie(String id) {
        return request -> {
            CompletionStage<Optional<Movie>> movieFuture =
                    movieServiceImplDao.getMovie(id);
            return movieFuture.thenApply(movie ->
                    movie.get().getGenre()
            );
        };
    }
}

