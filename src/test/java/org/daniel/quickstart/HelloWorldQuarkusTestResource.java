package org.daniel.quickstart;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

import java.util.HashMap;
import java.util.Map;

public class HelloWorldQuarkusTestResource implements QuarkusTestResourceLifecycleManager {
    @Override
    public Map<String, String> start() {
        System.out.println("Se van a ejecuta los test");
        Map<String, String> conf = new HashMap<>();
        conf.put("greetings.message", "Aloha Test");
        return conf;
    }

    @Override
    public void stop() {
        System.out.println("Ya se han ejecutado los test");
    }
}
