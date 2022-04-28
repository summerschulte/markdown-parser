//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        Scanner scnr = new Scanner(System.in);

        int currentIndex = 0;
        while(currentIndex < markdown.length() && markdown.indexOf("[", currentIndex) != -1) {
            int openBracket = markdown.indexOf("[", currentIndex);
            if (openBracket < 0) { break; }
            int closeBracket = markdown.indexOf("]", openBracket);
            if (closeBracket < 0) { break; }
            int openParen = markdown.indexOf("(", closeBracket);
            if (openParen < 0) { break; }
            if (openParen == closeBracket + 1) {
                int closeParen = markdown.indexOf(")", openParen);

                if (openParen < 0) {break; }
                String link = scnr.next();
                System.out.print(link);
                toReturn.add(markdown.substring(openParen + 1, closeParen));
                currentIndex = closeParen + 1;

            }
            else {
                currentIndex = closeBracket + 1;
            }
        }
        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}