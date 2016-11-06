package com.blecua84.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Morse Utils class test.
 *
 * @author blecua84
 */
public class MorseUtilsTest {

    @Test
    public void testTextToMorse_OK() throws Exception {
        assertTrue(MorseUtils.textToMorse("overall").equals("---...-..-..-.-...-.."));
    }

    @Test
    public void testTextToMorse_KO_NULL() throws Exception {
        assertTrue(MorseUtils.textToMorse("") == null);
    }
}