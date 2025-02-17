import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParseTest {

    List<String> emptyString;

    @Before
    public void setUp() {
        emptyString = new ArrayList<>();
    }

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    
    @Test
    public void testFile1() throws IOException {
        List<String> testFileLinks = List.of("https://something.com", "some-thing.html");
        Path testFile = Path.of("test-files/test-file.md");
        String testFileContent = Files.readString(testFile);
        assertEquals(MarkdownParse.getLinks(testFileContent), testFileLinks);
    }

    @Test
    public void testFile2() throws IOException {
        List<String> testFileLinks = List.of("https://something.com", "some-page.html");
        Path testFile = Path.of("test-files/test-file2.md");
        String testFileContent = Files.readString(testFile);
        assertEquals(MarkdownParse.getLinks(testFileContent), testFileLinks);
    }

    @Test
    public void testFile3() throws IOException {
        Path testFile = Path.of("test-files/test-file3.md");
        String testFileContent = Files.readString(testFile);
        assertEquals(MarkdownParse.getLinks(testFileContent), emptyString);
    }

    @Test
    public void testFile4() throws IOException {
        Path testFile = Path.of("test-files/test-file4.md");
        String testFileContent = Files.readString(testFile);
        assertEquals(MarkdownParse.getLinks(testFileContent), emptyString);
    }

    @Test
    public void testFile5() throws IOException {
        Path testFile = Path.of("test-files/test-file5.md");
        String testFileContent = Files.readString(testFile);
        assertEquals(MarkdownParse.getLinks(testFileContent), emptyString);
    }
    
    @Test
    public void testFile6() throws IOException {
        List<String> testFileLinks = List.of("page.com");
        Path testFile = Path.of("test-files/test-file6.md");
        String testFileContent = Files.readString(testFile);
        assertEquals(MarkdownParse.getLinks(testFileContent), testFileLinks);
    }

    @Test
    public void testFile7() throws IOException {
        Path testFile = Path.of("test-files/test-file7.md");
        String testFileContent = Files.readString(testFile);
        assertEquals(MarkdownParse.getLinks(testFileContent), emptyString);
    }
    
    @Test
    public void testFile8() throws IOException {
        List<String> testFileLinks = List.of("a link on the first line");
        Path testFile = Path.of("test-files/test-file8.md");
        String testFileContent = Files.readString(testFile);
        assertEquals(MarkdownParse.getLinks(testFileContent), testFileLinks);
    }
    @Test
    public void testsnippit1() throws IOException {
        List<String> testFileLinks = List.of("`google.com", "google.com", "ucsd.edu");
        Path testFile = Path.of("test-files/snippit1.md");
        String testFileContent = Files.readString(testFile);
        assertEquals(testFileLinks, MarkdownParse.getLinks(testFileContent));

    }
    @Test
    public void testSnippet2() throws IOException {
        List<String> testFileLinks = List.of("a.com", "a.com(())", "example.com");
        Path testFile = Path.of("test-files/snippit2.md");
        String testFileContent = Files.readString(testFile);
        assertEquals(testFileLinks, MarkdownParse.getLinks(testFileContent));
    }
    @Test
    public void testSnippet3() throws IOException {
        List<String> testFileLinks = List.of("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");
        Path testFile = Path.of("test-files/snippit3.md");
        String testFileContent = Files.readString(testFile);
        assertEquals(testFileLinks, MarkdownParse.getLinks(testFileContent));
    }
} 