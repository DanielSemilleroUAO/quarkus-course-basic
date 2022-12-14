package org.daniel.quickstart;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingsService {

    @ConfigProperty(name = "greetings.message")
    String msg;

    public String toUpperCase(){
        return msg.toUpperCase();
    }
}
