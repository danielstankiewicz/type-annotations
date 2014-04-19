package pl.jug.warszawa.typeannotations.examples;

import org.junit.Test;
import pl.jug.warszawa.typeannotations.Field;
import pl.jug.warszawa.typeannotations.TypeUse;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class TypeContextTest {
    @Test
    public void testTypeUseOnFieldVsDeclarationContext() throws NoSuchFieldException {
        java.lang.reflect.Field field = TypeContext.class.getDeclaredField("value");
        assertNotNull(field);
        Field fieldAnnotation = field.getDeclaredAnnotation(Field.class);
        assertNotNull(fieldAnnotation);
        TypeUse typeUseAnnotation = field.getDeclaredAnnotation(TypeUse.class);
        assertNull(typeUseAnnotation);
    }
}
