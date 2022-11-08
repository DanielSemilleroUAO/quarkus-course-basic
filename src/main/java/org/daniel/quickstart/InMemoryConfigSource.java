package org.daniel.quickstart;

import org.eclipse.microprofile.config.spi.ConfigSource;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class InMemoryConfigSource implements ConfigSource {

    private Map<String, String> prop = new HashMap<>();

    public InMemoryConfigSource(){
        this.prop.put("greetings.message", "Memory Hello");
    }

    @Override
    public int getOrdinal() {
        return 900;
    }

    @Override
    public Map<String, String> getProperties() {
        return prop;
    }

    @Override
    public Set<String> getPropertyNames() {
        return prop.keySet();
    }


    @Override
    public String getValue(String s) {
        return prop.get(s);
    }

    @Override
    public String getName() {
        return "InMemoryConfigSource";
    }
}
