package ioexamples;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LabWork {
    public static void main(String[] args) throws Exception {
        FileService service = new FileService();
        RecordCreater recordCreater = new ContactListRecordCreater();
        
        //LAB 1: Read In Records And Print Last Name and Zip Code
        File contactFile = new File("src" + File.separatorChar + "contactList.txt");
        List<String> dataLines = service.readFile(contactFile);
        List<Map<String,String>> contacts = recordCreater.createRecord(dataLines);
        
        System.out.println("LAB 1: Read In Record And Print LastName, ZipCode");
        for(Map<String,String> record : contacts){
            System.out.println(record.get(ContactListRecordCreater.FIRST_NAME_KEY) + ", " + record.get(ContactListRecordCreater.ZIP_CODE_KEY));
        }
        
        //LAB 1: Append 2 Records To File 
        List<Map<String,String>> newContacts = new LinkedList<>();
        Map<String,String> newRecord = new HashMap<>();
        newRecord.put(ContactListRecordCreater.FIRST_NAME_KEY, "Sally");
        newRecord.put(ContactListRecordCreater.LAST_NAME_KEY, "Johns");
        newRecord.put(ContactListRecordCreater.CITY_KEY, "Smallvil");
        newRecord.put(ContactListRecordCreater.STATE_KEY, "IL");
        newRecord.put(ContactListRecordCreater.STREET_ADDRESS_KEY, "N867W0932 ThisPlace Rd");
        newRecord.put(ContactListRecordCreater.ZIP_CODE_KEY, "3245");
        newContacts.add(newRecord);
        newRecord = new HashMap<>();
        newRecord.put(ContactListRecordCreater.FIRST_NAME_KEY, "David");
        newRecord.put(ContactListRecordCreater.LAST_NAME_KEY, "Yort");
        newRecord.put(ContactListRecordCreater.CITY_KEY, "Miami");
        newRecord.put(ContactListRecordCreater.STATE_KEY, "FL");
        newRecord.put(ContactListRecordCreater.STREET_ADDRESS_KEY, "53 BrickBuilding Rd App 4");
        newRecord.put(ContactListRecordCreater.ZIP_CODE_KEY, "6542");
        newContacts.add(newRecord);
        dataLines = recordCreater.createDataLines(newContacts);
        service.writeFile(contactFile,dataLines, true);
        
        //Reread File
        dataLines = service.readFile(contactFile);
        contacts = recordCreater.createRecord(dataLines);
        
        System.out.println("\nLAB 1: Read In Record And Print LastName, ZipCode (+ 2 New Records)");
        for(Map<String,String> record : contacts){
            System.out.println(record.get(ContactListRecordCreater.FIRST_NAME_KEY) + ", " + record.get(ContactListRecordCreater.ZIP_CODE_KEY));
        }
        
        //LAB 2: Find Second Contact and Print State
        Map<String,String> secondContact = contacts.get(1);
        System.out.println("\nLAB 2: Find Second Contact and Print State");
        System.out.println(secondContact.get(ContactListRecordCreater.FIRST_NAME_KEY) + " " + secondContact.get(ContactListRecordCreater.LAST_NAME_KEY) 
                + " state: " + secondContact.get(ContactListRecordCreater.STATE_KEY));
    }
}
