package ioexamples;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class FileService {
    
    private BufferedReader reader; 
    private PrintWriter writer;
    
    public List<String> readFile(File file) throws FileNotFoundException, IOException, Exception{
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
        }catch(Exception e){
            throw e;
        }finally{
            if(reader != null) reader.close();
        }
        return lineList;
    }
    
    public void writeFile(File file, List<String> data, boolean append) throws IOException,FileNotFoundException,Exception {
        try{
            writer = new PrintWriter(new BufferedWriter(new FileWriter(file,append)));
            for(String s : data){
                writer.println(s);
            }
        }catch(FileNotFoundException fnf){
            throw fnf;
        }catch(IOException ioe){
            throw ioe;
        }catch(Exception e){
            throw e;
        }finally{
            if(writer != null) writer.close();
        }
    }
}
