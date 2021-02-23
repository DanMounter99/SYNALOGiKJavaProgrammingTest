import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println(WordCounter.getWordCount("src\\main\\resources\\exampleInput.txt"));

        print("word.hello".replaceAll("([.|!|?|,])",""));
    }

    private static void print(String string) {
        System.out.println(string);
    }
}
