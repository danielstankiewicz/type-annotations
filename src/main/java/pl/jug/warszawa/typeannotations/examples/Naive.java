package pl.jug.warszawa.typeannotations.examples;

import pl.jug.warszawa.typeannotations.TypeUse;

import java.util.ArrayList;
import java.util.List;

public class Naive {
    public List<@TypeUse String> typeUse() {
        @TypeUse String s = "abc";
        List<@TypeUse String> list = new ArrayList<>();
        list.add(s);
        list.add("def");
        boolean isTypeUse = "def" instanceof @TypeUse String;
        System.out.println("@TypeUse String: " + isTypeUse);
        return list;
    }
}
