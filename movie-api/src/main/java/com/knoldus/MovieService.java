package com.knoldus;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.restCall;
import static com.lightbend.lagom.javadsl.api.transport.Method.GET;

public interface MovieService extends Service {
    ServiceCall<NotUsed, String> movie(String id);
    
    @Override
    default Descriptor descriptor() {
        
        return named("movie").withCalls(
                restCall(GET, "/api/movie/:id", this::movie)
        ).withAutoAcl(true);
    }
}
