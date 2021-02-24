# SYNALOGiK Java Programming Test
Programming test completed for SYNALOGiK

## Instructions for installation:

To clone this repository, open IntelliJ and select File > New... > Project from Version Control
Then enter this url: https://github.com/DanMounter99/SYNALOGiKJavaProgrammingTest.git and select Clone.

Please note that this project uses Java 15. (Specifically OpenJDK 15.0.2)

## Instructions for use:

Output is produced by the static method getWordCount(filepath) of the class WordCounter. As such, you can obtain the desired output as a String by cloning this repository and calling WordCounter.getWordCount(file_path), as can be seen in the unit tests within the WordCounterTest class as well as the main() function of the Main class.

The filepath can be local (starting by default in the root "SYNALOGiK Programming Test" folder) or absolute.

## Assumptions:

From the given example, I have assumed that a word is an unbroken sequence of characters which are not spaces. Basic punctuation does not count towards the length of a word (i.e. commas, periods, question marks, exclamation marks, colons and semicolons) but other non-alphanumeric symbols (including / and &) do count towards this length; this assumption is based on the fact that "morning." is a seven-length word, while "18/05/2016" is a 10-length word.

## Further details

Test cases are in the WordCounterTest class, which is in src/test/java.
The Maven POM file is pom.xml in the root directory.

Please let me know if you have any problems or would like to ask some questions about this system. Thank you!
