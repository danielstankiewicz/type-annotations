package pl.jug.warszawa.typeannotations.examples;

import pl.jug.warszawa.typeannotations.TypeUse;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// 1. A type in the extends or implements clause of a class declaration
public class TypeContext implements @TypeUse Serializable {

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
    private @TypeUse String value;
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
