package com.fj.domain;
public class BookType {
	private int id;
	private String typeName;
	private int days;
	
	public BookType(){
		
	}

	public BookType(int id, String typeName, int days) {
		super();
		this.id = id;
		this.typeName = typeName;
		this.days = days;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}
	
	

	
	
	
}
