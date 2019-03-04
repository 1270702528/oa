package com.yucaijr.util;

import java.util.ArrayList;
import java.util.List;

public class DataTool {

	public static List<String> String2List(String s){
		List<String> list=new ArrayList<>();
		String [] ss=s.split(",");
		for (String string : ss) {
			if(string!=null && string.trim().length()>0) {
				if(!list.contains(string)) {
					list.add(string);
				}
				
			}
		}
		return list;
	}
	
	
	
	
}
