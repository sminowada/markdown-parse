import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String[] markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        for(int i=0; i<markdown.length; i++) {

            if(markdown[i].contains("[") && markdown[i].contains("]") 
                && markdown[i].contains("(") && markdown[i].contains(")") 
                && markdown[i].contains(".")) {
                
                String link = markdown[i];
                int openParen = link.indexOf("(");

                if(link.substring(openParen, link.length() - 1).contains(" ")) {
                    link = link.substring(0, link.indexOf(" ", openParen));
                }
                
                int closeParen = link.lastIndexOf(")");
                link = link.substring(openParen + 1, closeParen);
                toReturn.add(link);  
            }
            
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        String[] contentsArray = contents.split("\n");
        ArrayList<String> links = getLinks(contentsArray);
        System.out.println(links);
    }
}


