package pl.jug.warszawa.typeannotations;

import org.junit.Test;
import pl.jug.warszawa.typeannotations.examples.Naive;

public class NaiveTest {
    @Test
    public void testTypeUse() {
        new Naive().typeUse();
    }
}
