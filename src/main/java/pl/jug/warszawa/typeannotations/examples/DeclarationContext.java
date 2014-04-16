package pl.jug.warszawa.typeannotations.examples;

import pl.jug.warszawa.typeannotations.Type;
import pl.jug.warszawa.typeannotations.TypeParameter;
import pl.jug.warszawa.typeannotations.TypeUse;

import java.util.Collections;
import java.util.Map;

@TypeUse("class")
public class DeclarationContext<@TypeUse("type parameter") V extends Number> {
    V value;

    public DeclarationContext(V value) {
        this.value = value;
    }

    public <@TypeUse("type parameter") K> Map<K, V> getSingletonMap(K key) {
        return Collections.singletonMap(key, this.value);
    }

    @TypeUse("annotation")
    public @interface AnnotationExample {}

    @TypeUse("interface")
    public interface InterfaceExample {}

    @TypeUse("enum")
    public enum EnumExample {}
}
