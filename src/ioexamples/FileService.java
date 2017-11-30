package ioexamples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class FileService {
    
    private BufferedReader reader; 
    
    public List<String> readFile(File file) throws FileNotFoundException, IOException{
        reader = new BufferedReader(new FileReader(file));
        List<String> lineList = new LinkedList<String>();
        
        try{
            String line = reader.readLine();
            while(line != null){
                lineList.add(line);
                line = reader.readLine();
            }
        }catch(FileNotFoundException fnf){
            throw fnf;
        }catch(IOException ioe){
            throw ioe;
        }finally{
            if(reader != null) reader.close();
        }
        return lineList;
    }
}
