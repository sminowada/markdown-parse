import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void subtraction() {
        assertEquals(10, 20-10);
    }

    @Test
    public void test() throws IOException{
        String fileContents = Files.readString(Path.of("empty-file.md"));
        ArrayList<String> testOutput = MarkdownParse.getLinks(fileContents.split("\n"));
        System.out.println(testOutput);
    }
}