package com.api.automation.pojo;

public class RecordRequest {
	
	private RecordData data;
	
	public RecordRequest() {
    }

    public RecordRequest(RecordData data) {
        this.data = data;
    }

    public RecordData getData() {
        return data;
    }

    public void setData(RecordData data) {
        this.data = data;
    }
}
