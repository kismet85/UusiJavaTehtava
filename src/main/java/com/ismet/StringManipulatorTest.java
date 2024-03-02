package com.ismet;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringManipulatorTest {

    @Test
    void testConcatenate() {
        StringManipulator manipulator = new StringManipulator();
        String str1 = "Hello";
        String str2 = "World";
        String expected = "HelloWorld";
        assertEquals(expected, manipulator.concatenate(str1, str2));
    }

    @Test
    void testFindLength() {
        StringManipulator manipulator = new StringManipulator();
        String str = "Hello";
        int expected = 5;
        assertEquals(expected, manipulator.findLength(str));
    }

    @Test
    void testConvertToUpperCase() {
        StringManipulator manipulator = new StringManipulator();
        String str = "hello";
        String expected = "HELLO";
        assertEquals(expected, manipulator.convertToUpperCase(str));
    }

    @Test
    void testConvertToLowerCase() {
        StringManipulator manipulator = new StringManipulator();
        String str = "HELLO";
        String expected = "hello";
        assertEquals(expected, manipulator.convertToLowerCase(str));
    }

    @Test
    void testContainsSubstring() {
        StringManipulator manipulator = new StringManipulator();
        String str = "Hello World";
        String subStr = "World";
        assertTrue(manipulator.containsSubstring(str, subStr));
    }
}
