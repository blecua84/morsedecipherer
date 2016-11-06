package com.blecua84.services;

import java.util.Set;

/**
 * Interface definition for Morse Decipherer operator.
 *
 * @author blecua84
 */
public interface Decipherer {

    /**
     * It returns one combination for the morse input "message". It'll take the words from an internal library loaded
     * at the beginning of the application.
     *
     * @param message Message to decipher.
     * @return String with the combination for the message.
     */
    Set<String> decipherer(String message);
}
