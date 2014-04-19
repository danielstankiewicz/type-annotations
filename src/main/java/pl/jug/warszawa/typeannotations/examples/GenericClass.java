package pl.jug.warszawa.typeannotations.examples;

import pl.jug.warszawa.typeannotations.TypeParameter;

import java.util.Collections;
import java.util.Map;

public class GenericClass<@TypeParameter("class") V extends Number> {
    public static final String TITLE = "title";
    protected V value;

    public GenericClass(V value) {
        this.value = value;
    }

    public <@TypeParameter("constructor") A> GenericClass(V value, A another) {
        this.value = value;
    }

    public <@TypeParameter("method") K> Map<K, V> getSingletonMap(K key) {
        return Collections.singletonMap(key, this.value);
    }
}
