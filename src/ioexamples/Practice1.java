package ioexamples;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Practice1 {
    public static void main(String[] args) throws IOException {
        File file = new File("src" + File.separatorChar + "test.txt");
        FileService service = new FileService();
        List<String> lineList = service.readFile(file);
        
        for(String line : lineList)System.out.println(line);
    }   
}
