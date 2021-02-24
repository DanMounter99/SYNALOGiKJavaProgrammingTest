import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class WordCounter {
    private static final String PUNCTUATION_REGEX = "([.|!?,:;])";

    /**
     * Reports information about the number of words within the given file, if one can be found. Return an error message otherwise.
     * @param filepath The location of the file in which words should be counted
     * @return A string output describing the word count, average word length, frequency of each word length and the length(s) for which the frequency is highest
     */
    public static String getWordCount(String filepath) {
        FileInputStream in;
        try {
            in = new FileInputStream(filepath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "Error: this file could not be found.";
        }
        Scanner scanner = new Scanner(in);
        // initialise a HashMap to link word length to number of occurrences
        HashMap<Integer, Integer> occurrenceMap = new HashMap<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] words = splitLineIntoWords(line);
            for (String word : words) {
                incrementWordCounter(occurrenceMap,word.length());
            }
        }

        // start constructing the output text
        StringBuilder lengthCountParagraphBuilder = new StringBuilder();
        int wordCount = 0;
        int wordLengthsTotal = 0;
        int highestFrequency = 0;
        ArrayList<Integer> lengthsWithHighestFrequency = new ArrayList<>();
        // iterate through every observed word length
        for (Integer wordLength : occurrenceMap.keySet()) {
            Integer occurrences = occurrenceMap.get(wordLength);
            // build length count line
            String lengthCountLine = "Number of words of length " + wordLength.toString() + " is " + occurrences + "\n";
            lengthCountParagraphBuilder.append(lengthCountLine);
            // update wordCount and wordLengthsTotal
            wordCount = wordCount + occurrences;
            wordLengthsTotal += wordLength * occurrences;
            // update highestFrequency
            if (occurrences == highestFrequency) {
                lengthsWithHighestFrequency.add(wordLength);
            }
            if (occurrences > highestFrequency) {
                // forget the previous holders of the highest frequency
                lengthsWithHighestFrequency.clear();
                lengthsWithHighestFrequency.add(wordLength);
                highestFrequency = occurrences;
            }
        }
        // word count
        String wordCountString = "Word count = " + wordCount + "\n";
        // average word length rounded to three decimal places
        double averageWordLength = (double) wordLengthsTotal / (double) wordCount;
        averageWordLength = Math.round(averageWordLength*1000.0) / 1000.0;
        String averageWordLengthString = "Average word length = " + averageWordLength + "\n";
        // highest frequency
        String highestFrequencyString = buildHighestFrequencyString(highestFrequency,lengthsWithHighestFrequency);

        return wordCountString + averageWordLengthString + lengthCountParagraphBuilder.toString() + highestFrequencyString;
    }

    /**
     * If a value exists for the given key in the given HashMap, increases it by 1. Initialises the key with value 1 otherwise.
     * @param map The HashMap to be modified
     * @param wordLength The key for which the value will be incremented
     */
    private static void incrementWordCounter(HashMap<Integer,Integer> map, int wordLength) {
        //if a value exists for key wordLength, increase it by 1.
        //otherwise, initialise the key with value 1.
        map.merge(wordLength, 1, Integer::sum);
    }

    /**
     * Split the given string into an array of strings separated by spaces with basic punctuation removed.
     * @param line The line to be split
     * @return An array of words
     */
    private static String[] splitLineIntoWords(String line) {
        // remove punctuation from this line
        String formattedLine = line.replaceAll(PUNCTUATION_REGEX,"");
        return formattedLine.split(" ");
    }

    /**
     * Build a string which reports that the length(s) in the given ArrayList have the highest frequency of occurrence
     * @param highestFrequency The highest frequency of occurrence
     * @param lengthsWithHighestFrequency The length(s) to be reported to have the given frequency of occurrence
     * @return A string which reports that the length(s) in the given ArrayList have the highest frequency of occurrence
     */
    private static String buildHighestFrequencyString(int highestFrequency, ArrayList<Integer> lengthsWithHighestFrequency) {
        // are there any words at all?
        if (lengthsWithHighestFrequency.isEmpty()) {
            return "Frequency cannot be calculated for a file containing no words.";
        }
        String highestFrequencyString = "The most frequently occurring word length is " + highestFrequency;
        highestFrequencyString += ", for word length";
        //account for plurality
        if (lengthsWithHighestFrequency.size() > 1) {
            highestFrequencyString += "s";
        }
        highestFrequencyString += " of ";
        //iterate through every given length
        String lengthSeparator = " & ";
        for (Integer length : lengthsWithHighestFrequency) {
            highestFrequencyString += length + lengthSeparator;
        }
        //remove the final separator
        return highestFrequencyString.substring(0,highestFrequencyString.length()-lengthSeparator.length());
    }
}
