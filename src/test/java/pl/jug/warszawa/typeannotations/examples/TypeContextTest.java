package pl.jug.warszawa.typeannotations.examples;

import org.junit.Test;
import pl.jug.warszawa.typeannotations.TypeUse;

import java.lang.reflect.Field;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class TypeContextTest {
    @Test
    public void testTypeUseNotFieldAnnotation() throws NoSuchFieldException {
        Field field = TypeContext.class.getDeclaredField("value");
        assertNotNull(field);
        TypeUse annotation = field.getDeclaredAnnotation(TypeUse.class);
        assertNull(annotation);
    }
}
