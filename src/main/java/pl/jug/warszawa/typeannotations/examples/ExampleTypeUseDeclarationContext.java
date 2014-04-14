package pl.jug.warszawa.typeannotations.examples;

import pl.jug.warszawa.typeannotations.Type;
import pl.jug.warszawa.typeannotations.TypeParameter;
import pl.jug.warszawa.typeannotations.TypeUse;

import java.util.Collections;
import java.util.Map;

@TypeUse
public class ExampleTypeUseDeclarationContext<@TypeUse V extends Number> {
    V value;

    public ExampleTypeUseDeclarationContext(V value) {
        this.value = value;
    }

    public <@TypeUse K> Map<K, V> getSingletonMap(K key) {
        return Collections.singletonMap(key, this.value);
    }

    @TypeUse
    public @interface AnnotationExample {}

    @TypeUse
    public interface InterfaceExample {}

    @TypeUse
    public enum EnumExample {}


}
