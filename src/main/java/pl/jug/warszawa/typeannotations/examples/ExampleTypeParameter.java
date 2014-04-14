package pl.jug.warszawa.typeannotations.examples;

import pl.jug.warszawa.typeannotations.TypeParameter;

import java.util.Collections;
import java.util.Map;

public class ExampleTypeParameter<@TypeParameter V extends Number> {
    V value;

    public ExampleTypeParameter(V value) {
        this.value = value;
    }

    public <@TypeParameter K> Map<K, V> getSingletonMap(K key) {
        return Collections.singletonMap(key, this.value);
    }

}
