/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioexamples;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Brandon
 */
public interface RecordCreater {
    public abstract List<Map<String,String>> createRecord(List<String> dataLines);
    public abstract List<String> createDataLines(List<Map<String,String>> record);
}
