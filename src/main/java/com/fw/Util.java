package com.fw;

import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Map;

public class Util {

    public static String getValueFromDataTable(DataTable dataTable, String title) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        return (String) ((Map) list.get(0)).get(title);
    }

    public static void waitThread(int mill){
        try {
            Thread.sleep(mill);
        }catch (InterruptedException interruptedException){
            //TODO
        }
    }

}
