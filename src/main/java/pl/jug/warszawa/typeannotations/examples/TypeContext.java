package pl.jug.warszawa.typeannotations.examples;

import pl.jug.warszawa.typeannotations.Field;
import pl.jug.warszawa.typeannotations.TypeUse;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

// 1. A type in the extends or implements clause of a class declaration
public class TypeContext implements @TypeUse Serializable {

    public TypeContext() {
        // 11. A type in the explicit type argument list to an explicit constructor invocation statement or class instance creation expression or method invocation expression
        <@TypeUse Long>this(0l);
        new <@TypeUse String> GenericClass<@TypeUse Long>(123l, "abc")
                .<@TypeUse Integer> getSingletonMap(123);

        // 12. In an unqualified class instance creation expression, as the class type to be instantiated or as the direct superclass or direct superinterface of an anonymous class to be instantiated
        new @TypeUse Thread(new @TypeUse Runnable() {
            @Override
            public void run() {}
        });

        // 13. The element type in an array creation expression
        Integer[] array = new Integer @TypeUse[] {};

        // 14 The type in the cast operator of a cast expression
        String s = (@TypeUse String) "abc";

        // 15. The type that follows the instanceof relational operator
        boolean isInstance = s instanceof @TypeUse String;

        List<Integer> list = new ArrayList<>();
        List<GenericClass<Integer>> collect = list.stream()
                // 16. In a method reference expression, as the reference type to search for a member method or as the class type or array type to construct
                .<GenericClass<Integer>> map(@TypeUse GenericClass::new)
                .collect(Collectors.<GenericClass<Integer>>toList());
    }

    public <N extends Number> TypeContext(N number) {
    }

    // 2. A type in the extends clause of an interface declaration
    public interface InterfaceExample extends @TypeUse Runnable {
    }

    // 3. The return type of a method (including the type of an element of an annotation type)
    public @TypeUse String getValue() {
        return value;
    }

    // 4. A type in the throws clause of a method or constructor
    public void throwException() throws @TypeUse Exception {
    }

    // 5. A type in the extends clause of a type parameter declaration of a generic class, interface, method, or constructor
    public <N extends @TypeUse Number> Integer getInteger(N number) {
        return number.intValue();
    }

    // 6. The type in a field declaration of a class or interface (including an enum constant)
    private @Field @TypeUse String value;
    private enum Status {@TypeUse OK, @TypeUse ERROR}

    // 7. The type in a formal parameter declaration of a method, constructor or lambda expression
    public List<Car> filterCars(@TypeUse List<Car> cars, int year) {
        return cars.stream()
                .filter((@TypeUse Car c) -> c.getYear() == year)
                .collect(Collectors.toList());
    }

    public class Car {
        private int year;

        public Car(int year) {
        }

        public int getYear() {
            return year;
        }
    }

    // 8. The type of the receiver parameter of a method
    public void show(@TypeUse TypeContext this, boolean other) {

        // 9. The type in a local variable declaration
        @TypeUse Date date;

        try {
            Integer.parseInt("12345");
        }
        // 10. The type in an exception parameter declaration
        catch (@TypeUse NumberFormatException e) {
        }
    }

}
