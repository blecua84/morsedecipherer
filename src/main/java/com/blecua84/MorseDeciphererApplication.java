package com.blecua84;

import com.blecua84.services.Decipherer;
import com.blecua84.services.impl.DeciphererImpl;
import com.blecua84.utils.MorseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.util.*;

@SpringBootApplication
public class MorseDeciphererApplication {

    // System Logger
    private static final Logger log = LoggerFactory.getLogger(MorseDeciphererApplication.class);

    // Library of morse words's name
    private static final String LIBRARY_FILE_NAME = "google1000.txt";

    /**
     * Method for loading the morse library file with text words and the translation to morse. In the map, the key
     * will be the morse translation.
     *
     * @return Map<String,String>
     */
    public static Map<String, String> morseLibrary() {
        log.info("Init morseLibrary...");

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        // Save the word and its morse translation
        HashMap<String, String> morseWordsMap = new HashMap<>();

        try {
            Scanner inputFile = new Scanner(new File(classLoader.getResource(LIBRARY_FILE_NAME).getFile()));

            String wordFile;

            while(inputFile.hasNextLine()) {
                wordFile = inputFile.nextLine();

                morseWordsMap.put(MorseUtils.textToMorse(wordFile), wordFile);
            }
        } catch (IOException e) {
            log.error("It couldn't load Morse Library in System: ", e);
        }

        log.info("End morseLibrary!!");
        return morseWordsMap;
    }

	public static void main(String[] args) {
        log.info("Init main...");
		SpringApplication.run(MorseDeciphererApplication.class, args);

        Decipherer decipherer = new DeciphererImpl(morseLibrary());

        Scanner input = new Scanner(System.in);
        System.out.print("Enter your morse phase: ");
        String morseMessage = input.next();
        log.info("Input phrase: " + morseMessage);

        Set<String> decipheredPhrasesResult = decipherer.decipherer(morseMessage);

        if(!decipheredPhrasesResult.isEmpty()) {
            System.out.println("Result translations: ");
            for(String translation: decipheredPhrasesResult) {
                System.out.println("Translation: " + translation);
            }
        } else {
            System.out.println("There weren't any translations for the input phrase.");
        }

        log.info("End main!!");
	}
}
