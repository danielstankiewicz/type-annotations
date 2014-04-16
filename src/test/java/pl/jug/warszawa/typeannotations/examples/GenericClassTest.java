package pl.jug.warszawa.typeannotations.examples;

import org.junit.Test;
import pl.jug.warszawa.typeannotations.TypeParameter;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;

import static org.junit.Assert.*;

public class GenericClassTest {
    @Test
    public void testGetClassTypeParameter() {
        TypeVariable<Class<GenericClass>>[] typeParameters = GenericClass.class.getTypeParameters();
        assertTrue(typeParameters.length == 1);
        TypeVariable<Class<GenericClass>> typeParameter = typeParameters[0];
        assertEquals("V", typeParameter.getName());
        TypeParameter annotation = typeParameter.getAnnotation(TypeParameter.class);
        assertNotNull(annotation);
        assertEquals("class", annotation.value());
    }

    @Test
    public void testGetConstructorTypeParameter() throws NoSuchMethodException {
        Constructor<GenericClass> constructor = GenericClass.class.getConstructor(Number.class, Object.class);
        assertNotNull(constructor);
        TypeVariable<Constructor<GenericClass>>[] typeParameters = constructor.getTypeParameters();
        assertTrue(typeParameters.length == 1);
        TypeVariable<Constructor<GenericClass>> typeParameter = typeParameters[0];
        assertEquals("A", typeParameter.getName());
        TypeParameter annotation = typeParameter.getAnnotation(TypeParameter.class);
        assertNotNull(annotation);
        assertEquals("constructor", annotation.value());
    }

    @Test
    public void testGetMethodTypeParameter() throws NoSuchMethodException {
        Method method = GenericClass.class.getMethod("getSingletonMap", Object.class);
        assertNotNull(method);
        TypeVariable<Method>[] typeParameters = method.getTypeParameters();
        assertTrue(typeParameters.length == 1);
        TypeVariable<Method> typeParameter = typeParameters[0];
        assertEquals("K", typeParameter.getName());
        TypeParameter annotation = typeParameter.getAnnotation(TypeParameter.class);
        assertNotNull(annotation);
        assertEquals("method", annotation.value());
    }

}
