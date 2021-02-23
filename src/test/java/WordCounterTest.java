import static org.junit.jupiter.api.Assertions.assertEquals;

class WordCounterTest {


    @org.junit.jupiter.api.Test
    void exampleOutputTest() {
        String expectedOutput = "Word count = 9\n" +
                "Average word length = 4.556\n" +
                "Number of words of length 1 is 1\n" +
                "Number of words of length 2 is 1\n" +
                "Number of words of length 3 is 1\n" +
                "Number of words of length 4 is 2\n" +
                "Number of words of length 5 is 2\n" +
                "Number of words of length 7 is 1\n" +
                "Number of words of length 10 is 1\n" +
                "The most frequently occurring word length is 2, for word lengths of 4 & 5";
        String actualOutput = WordCounter.getWordCount("src\\main\\resources\\exampleInput.txt");
        assertEquals(expectedOutput,actualOutput);
    }

    @org.junit.jupiter.api.Test
    void punctuationTest() {
        String expectedOutput = "Word count = 4\n" +
                                "Average word length = 7.25\n" +
                                "Number of words of length 3 is 1\n" +
                                "Number of words of length 7 is 1\n" +
                                "Number of words of length 8 is 1\n" +
                                "Number of words of length 11 is 1\n" +
                                "The most frequently occurring word length is 1, for word lengths of 3 & 7 & 8 & 11";
        String actualOutput = WordCounter.getWordCount("src\\main\\resources\\punctuationTestFile.txt");
        assertEquals(expectedOutput,actualOutput);
    }

    @org.junit.jupiter.api.Test
    void fileNotFoundTest() {
        String expectedOutput = "Error: this file could not be found.";
        String actualOutput = WordCounter.getWordCount("Path to a file which does not exist.");
        assertEquals(expectedOutput,actualOutput);
    }

    @org.junit.jupiter.api.Test
    void emptyFileTest() {
        String expectedOutput = "Word count = 0\n" +
                                "Average word length = 0.0\n" +
                                "Frequency cannot be calculated for a file containing no words.";
        String actualOutput = WordCounter.getWordCount("src\\main\\resources\\emptyTestFile.txt");
        assertEquals(expectedOutput,actualOutput);
    }

    @org.junit.jupiter.api.Test
    void noWordsFileTest() {
        String expectedOutput = "Word count = 0\n" +
                                "Average word length = 0.0\n" +
                                "Frequency cannot be calculated for a file containing no words.";
        String actualOutput = WordCounter.getWordCount("src\\main\\resources\\onlySpaceTestFile.txt");
        assertEquals(expectedOutput,actualOutput);
    }


    @org.junit.jupiter.api.Test
    void oneWordTest() {
        String expectedOutput = "Word count = 1\n" +
                                "Average word length = 26.0\n" +
                                "Number of words of length 26 is 1\n" +
                                "The most frequently occurring word length is 1, for word length of 26";
        String actualOutput = WordCounter.getWordCount("src\\main\\resources\\oneWordTestFile.txt");
        assertEquals(expectedOutput,actualOutput);
    }
}