package pl.jug.warszawa.typeannotations.examples;

import static org.junit.Assert.*;

import org.junit.Test;
import pl.jug.warszawa.typeannotations.TypeUse;

public class DeclarationContextTest {
    @Test
    public void testGetClassTypeUse() {
        TypeUse annotation = DeclarationContext.class.getAnnotation(TypeUse.class);
        assertNotNull(annotation);
        assertEquals("class", annotation.value());
    }

    @Test
    public void testGetAnnotationTypeUse() {
        TypeUse annotation = DeclarationContext.AnnotationExample.class.getAnnotation(TypeUse.class);
        assertNotNull(annotation);
        assertEquals("annotation", annotation.value());
    }

    @Test
    public void testGetInterfaceTypeUse() {
        TypeUse annotation = DeclarationContext.InterfaceExample.class.getAnnotation(TypeUse.class);
        assertNotNull(annotation);
        assertEquals("interface", annotation.value());
    }

    @Test
    public void testGetEnumTypeUse() {
        TypeUse annotation = DeclarationContext.EnumExample.class.getAnnotation(TypeUse.class);
        assertNotNull(annotation);
        assertEquals("enum", annotation.value());
    }
}
