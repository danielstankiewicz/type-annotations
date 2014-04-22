package pl.jug.warszawa.typeannotations.checker;

import org.junit.Assert;
import org.junit.Test;

public class TaintingExampleTest {
    private static final String SQL_INJECTION = "anything' OR 'x' = 'x";

    @Test
    public void testSanitizeSafeString() {
        String s = "smith";
        String sanitized = new TaintingExample().sanitize(s);
        Assert.assertEquals(s, sanitized);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSanitizeSQLInjectionString() {
        String sanitized = new TaintingExample().sanitize(SQL_INJECTION);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetSafeQuery() {
        String safeQuery = new TaintingExample().getSafeQuery(SQL_INJECTION);
    }

    @Test
    public void testGetVulnerableQuery() {
        String vulnerableQuery = new TaintingExample().getVulnerableQuery(SQL_INJECTION);
        Assert.assertNotNull(vulnerableQuery);
    }
}
