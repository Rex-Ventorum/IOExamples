/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ioexamples;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Brandon
 */
public class ContactListRecordCreater implements RecordCreater{
    private static final int LINES_PER_RECORD = 3;
    
    public static final String FIRST_NAME_KEY = "FirstName";
    public static final String LAST_NAME_KEY = "LastName";
    public static final String STREET_ADDRESS_KEY = "StreetAddress";
    public static final String CITY_KEY = "City";
    public static final String STATE_KEY = "State";
    public static final String ZIP_CODE_KEY = "Zip";
    
    @Override
    public final List<Map<String, String>> createRecord(List<String> dataLines) {
        if(dataLines == null) throw new IllegalArgumentException("Data Lines Must Not Be Null");
        if(dataLines.size() % LINES_PER_RECORD != 0) throw new IllegalArgumentException("Data Lines must be divisable by " + LINES_PER_RECORD);
        List<Map<String,String>> contacts = new LinkedList<>();
        for(int i=0; i<dataLines.size(); i+=LINES_PER_RECORD){
            Map<String,String> contactRecord = new HashMap<String,String>();
            String line1 = dataLines.get(i);
            String line2 = dataLines.get(i+1);
            String line3 = dataLines.get(i+2);
            
            //Line1 = FirstName LastName
            String[] parts = line1.split(" ");
            contactRecord.put(FIRST_NAME_KEY, parts[0]);
            contactRecord.put(LAST_NAME_KEY, parts[1]);
            
            //Line2 = StreetAddress
            contactRecord.put(STREET_ADDRESS_KEY, line2);
            
            //Line3 = City, State Zip
            parts = line3.replace(",", "").split(" ");
            contactRecord.put(CITY_KEY, parts[0]);
            contactRecord.put(STATE_KEY, parts[1]);
            contactRecord.put(ZIP_CODE_KEY, parts[2]);
            contacts.add(contactRecord);
        }//end of loop
        return contacts;
    }

    @Override
    public List<String> createDataLines(List<Map<String, String>> records) {
        List<String> dataLines = new LinkedList<>();
        for(Map<String,String> record : records){
            String line = record.get(FIRST_NAME_KEY) + " " + record.get(LAST_NAME_KEY);
            dataLines.add(line);
            line = record.get(STREET_ADDRESS_KEY);
            dataLines.add(line);
            line = record.get(CITY_KEY) + ", " + record.get(STATE_KEY) + " " + record.get(ZIP_CODE_KEY);
            dataLines.add(line);
        }
        return dataLines;
    }
}
