package com.yucaijr.util;


import java.util.HashMap;
import java.util.Map;

import com.yucaijr.Enum.LogEnum;

public class GetAllEnum {

	public static Map<Integer,String> getAllFromEnum(){
		Map<Integer,String> map=new HashMap<>();
		for(LogEnum l:LogEnum.values()) {
			map.put(l.getType(), l.getMessage());
		}
		return map;
	}
	
	public static void main(String[] args) {
		System.out.println(getAllFromEnum());
		}
}
