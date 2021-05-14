package krol.stephen.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExampleTest {

    @Test
    public void funcTest() {
        assertEquals(2, ExampleMain.testFunction(1));
    }
}
