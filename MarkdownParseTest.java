import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;

public class MarkdownParseTest {


    @Test
    public void addition() {
        assertEquals(2,1+1);
    }
    
    @Test
    public void linkcheck() throws IOException{
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> output = MarkdownParse.getLinks(content);
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("https://something.com");
        expected.add("some-thing.html");
        
        assertEquals(expected,output);

////test 2 
        Path fileName1 = Path.of("test1.md");
        String content1 = Files.readString(fileName1);
        ArrayList<String> output1 = MarkdownParse.getLinks(content1);
        ArrayList<String> expected1 = new ArrayList<String>();
        assertEquals(expected1,output1);


//test 3
        Path fileName2 = Path.of("newmarkdown.md");
        String content2 = Files.readString(fileName2);
        ArrayList<String> output2 = MarkdownParse.getLinks(content2);
        ArrayList<String> expected2= new ArrayList<String>();
        expected2.add("https://example.com");
        expected2.add("https://exam(");
        expected2.add("https://wrong(");
        System.out.println(output2);
        
        assertEquals(expected2,output2);

    }
    
}
