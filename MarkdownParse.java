//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {

        //(https://wrong.com)[otherlink5]
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            
        
            int openBracket = markdown.indexOf("[", currentIndex);
            ///next line doesnt need to be used?
            int closeBracket = markdown.indexOf("]", openBracket);
    
            int openParen = markdown.indexOf("(", closeBracket);

            int period = markdown.indexOf(".", openParen);

            int closeParen = markdown.indexOf(")", period);
              
            //one solved (when there is () in link)
            
            toReturn.add(markdown.substring(openParen + 1, closeParen));

            currentIndex = closeParen + 1;
            
           
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
