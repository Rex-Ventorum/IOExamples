package ioexamples;

import java.io.File;
import java.util.List;
import junit.framework.TestCase;
import org.junit.Test;

public class FileServiceTest extends TestCase{
    
    public FileServiceTest(String testName) {
        super(testName);
    }
    
    @Test
    public void testReadFile() throws Exception{
        File file = new File("src" + File.separatorChar + "test.txt");
        FileService service = new FileService();
        List<String> lineList = service.readFile(file);
        int linesExpected = 3;
        int linesActual = lineList.size();
        assertEquals(linesExpected,linesActual);
    }
 
    
}
