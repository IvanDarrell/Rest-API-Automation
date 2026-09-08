package com.api.automation.utils;

import java.util.HashMap;
import java.util.Map;

import com.api.automation.pojo.RecordData;

public class TestData {

	public static String recordId;

	public static Map<String, Object> invalidRecordRequest() {
		Map<String, Object> data = new HashMap<>();
		data.put("name", "Super Mega TV");
		data.put("price", "hehehee");
		data.put("category", "Electronics");
		data.put("in_stock", true);
		Map<String, Object> request = new HashMap<>();
		request.put("data", data);
		return request;
	}
	
	
	public static RecordData validRecord() {
        return new RecordData(
            "Iphone solo",
            34.34f,
            "Electronics",
            true
        );
    }
	
	
	
	

	
	
	public static RecordData missingNameRecord() {
	    RecordData recordData = new RecordData();

	    recordData.setPrice(33.44f);
	    recordData.setCategory("Magazine");
	    recordData.setIn_stock(true);

	    return recordData;
	}
}
