package com.fj.tools;

import java.util.UUID;

public class FileClTool {
	public String getNewName(String name){
		
		String newName="";
		
		newName=UUID.randomUUID().toString()+name.substring(name.lastIndexOf("."), name.length());
		
		return newName;
	}
}
