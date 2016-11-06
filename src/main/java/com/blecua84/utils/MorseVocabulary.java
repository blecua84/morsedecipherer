package com.blecua84.utils;

/**
 * Morse value for each letter.
 *
 * @author blecua84
 */
public enum MorseVocabulary {

    A(".-"),
    B("-..."),
    C("-.-."),
    D("-.."),
    E("."),
    F("..-."),
    G("--."),
    H("...."),
    I(".."),
    J(".---"),
    K("-.-"),
    L(".-.."),
    M("--"),
    N("-."),
    O("---"),
    P(".--."),
    Q("--.-"),
    R(".-."),
    S("..."),
    T("-"),
    U("..-"),
    V("...-"),
    W(".--"),
    X("-..-"),
    Y("-.--"),
    Z("--..");

    private String morseValue;

    MorseVocabulary(String morseValue) {
        this.morseValue = morseValue;
    }

    public String getMorseValue() {
        return this.morseValue;
    }
}
