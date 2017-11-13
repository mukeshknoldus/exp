package com.knoldus.impl;

/**
 * Created by knoldus on 1/11/17.
 */

import com.knoldus.Movie;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import org.junit.Test;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import static org.junit.Assert.assertEquals;


public class MovieServiceImplTest {
    @Tested
    MovieServiceImpl movieServiceImpl;
    @Injectable
    MovieServiceImplDao movieServiceImplDao;
    
    @Test
    public void testServiceCall() throws Exception {
        final String genere = "comedy";
        new Expectations() {
        
            {
                movieServiceImplDao.getMovie("2");
                returns(CompletableFuture.supplyAsync(() -> Optional.ofNullable(new Movie() {
                    {
                        setGenre("Comedy");
                    }
                })));
            }
        };
        String genre = movieServiceImpl.movie("2").invoke().toCompletableFuture().get();
        assertEquals("this is a Success case", genere.toLowerCase(), genre.toLowerCase());
    }
    
}
