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
        
        
        assertEquals(expected2,output2);

///test 4 
        Path fileName3 = Path.of("test-file2.md");
        String content3 = Files.readString(fileName3);
        ArrayList<String> output3 = MarkdownParse.getLinks(content3);
        ArrayList<String> expected3= new ArrayList<String>();
        expected3.add("https://something.com");
        expected3.add("some-thing.html");
        
        
        
        assertEquals(expected3,output3);
        ///test5
        Path fileName4 = Path.of("test-file3.md");
        String content4 = Files.readString(fileName3);
        ArrayList<String> output4 = MarkdownParse.getLinks(content4);
        ArrayList<String> expected4= new ArrayList<String>();
        expected4.add("https://something.com");
        expected4.add("some-thing.html");
        
        
        
        assertEquals(expected4,output4);


        

    }
    
}
