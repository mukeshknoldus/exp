package com.knoldus.impl;

import com.knoldus.Movie;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 * Created by knoldus on 1/11/17.
 */
public class MovieServiceImplDao {
    public CompletionStage<Optional<Movie>> getMovie(String id) {
        return CompletableFuture.supplyAsync(() -> Optional.ofNullable(
                new Movie() {
                    {
                        setId(id);
                        setName("PK");
                        setGenre("Comedy");
                    }
                }));
    }
}
