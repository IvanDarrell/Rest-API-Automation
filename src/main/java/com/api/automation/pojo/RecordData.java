package com.api.automation.pojo;

public class RecordData {
	
	
	private String name;
	private Float price;
    private String category;
    private boolean in_stock;

    public RecordData() {
    }

    public RecordData(String name, Float price, String category, boolean in_stock) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.in_stock = in_stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Number getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isIn_stock() {
        return in_stock;
    }

    public void setIn_stock(boolean in_stock) {
        this.in_stock = in_stock;
    }
    
    
    
}
