package com.blecua84.utils;

/**
 * Utility class for Morse operations.
 *
 * @author blecua84
 */
public class MorseUtils {

    /**
     * It translate an input real text word to its morse value.
     *
     * @param wordToTranslateMorse Word thant you want to translate to morse.
     * @return Word traduced to morse.
     */
    public static String textToMorse(String wordToTranslateMorse) {
        String morseWord = null;

        if(wordToTranslateMorse != null && !wordToTranslateMorse.isEmpty()) {
            morseWord = "";

            for(int i = 0; i < wordToTranslateMorse.length(); i++) {
                String character = Character.toString(wordToTranslateMorse.charAt(i));

                morseWord += MorseVocabulary.valueOf(character.toUpperCase()).getMorseValue();
            }
        }

        return morseWord;
    }
}
