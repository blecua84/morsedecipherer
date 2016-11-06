package com.blecua84.services.impl;

import com.blecua84.services.Decipherer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Decipherer implementation class.
 *
 * @author blecua84
 */
public class DeciphererImpl implements Decipherer {

    // System Logger
    private static final Logger log = LoggerFactory.getLogger(DeciphererImpl.class);

    // Morse Words
    private Map<String, String> morseLibrary;

    // Insert new words
    private Set<String> partialLibrary;

    /**
     * Constructor.
     */
    public DeciphererImpl() {
        this.partialLibrary = new HashSet<>();
    }

    @Override
    public Set<String> decipherer(String message, Map<String, String> morseLibrary) {
        log.info("Init decipherer...");

        // Save the morseLibrary
        this.morseLibrary = morseLibrary;

        // Clear the list where the results will be stored
        this.partialLibrary.clear();

        // Doing the recursive operation
        decipherRec(message, "");

        log.info("End decipherer!!");
        return this.partialLibrary;
    }

    /**
     * Recursive method for calculating all the posibles combination for the input "message".
     *
     * @param message Input morse message.
     * @param result Input translation result.
     */
    private void decipherRec(String message, String result) {
        Set<String> initialWordsLocal = new HashSet<>();

        int count = 0;
        String morseWord = "";

        while (count <= message.length() - 1) {
            morseWord += message.substring(count, count + 1);

            if (this.morseLibrary.containsKey(morseWord)) {
                if (!initialWordsLocal.contains(morseWord)) {
                    initialWordsLocal.add(morseWord);

                    decipherRec(message.substring(morseWord.length(), message.length()),
                            result + this.morseLibrary.get(morseWord) + " ");
                }
            }

            count++;
        }

        if(!result.isEmpty() && !" ".equals(result))
            this.partialLibrary.add(result);
    }
}
