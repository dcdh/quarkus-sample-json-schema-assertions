package org.acme.getting.started;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    public static class Hello {

        private final String message;

        public Hello(final String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Hello hello() {
        return new Hello("hello");
    }
}