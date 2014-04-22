package pl.jug.warszawa.typeannotations.checker;

import org.checkerframework.checker.interning.qual.Interned;
import org.checkerframework.checker.javari.qual.ReadOnly;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.checker.regex.qual.Regex;
import org.checkerframework.checker.tainting.qual.Tainted;
import org.checkerframework.checker.tainting.qual.Untainted;

import java.util.Date;
import java.util.List;

public class TaintingExample {

    public void annotationsAsTypeQualifiers() {
        @Nullable Integer nullable;
        @NonNull Date nonNull;
        @Regex String regularExpression;
        @Tainted String tainted;
        @Interned Integer interned;
        @ReadOnly List<String> readOnly;
    }

    public String getSafeQuery(@Tainted String lastName) {
        return createQuery(sanitize(lastName));
    }

    public String getVulnerableQuery(@Tainted String lastName) {
        // use of a @Tainted String without sanitizing
        return createQuery(lastName);
    }

    public @Untainted String sanitize(@Tainted String tainted) {
        for (char c : tainted.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)) {
                throw new IllegalArgumentException("SQL Injection: " + tainted);
            }
        }
        return new @Untainted String(tainted);
    }

    private String createQuery(@Untainted String lastName) {
        return "SELECT p.id FROM person p " +
                "WHERE p.last_name = '" + lastName + "'";
    }
}
