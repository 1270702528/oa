package com.yucaijr.util;



import java.util.HashMap;
import java.util.Map;

public class MapMerge {

	/**
	 * 
	 * @param map1 查询出来的map
	 * @param map2 所有map
	 * @return
	 */
	public static Map<String, String> mapMerge(Map<Integer, String> map1,Map<Integer, String> map2){
		Map<String, String> map=new HashMap<>();
		for(Integer key:map2.keySet()) {
			if(!map1.containsKey(key)) {
				map.put(map2.get(key), "0");
			}else {
				map.put(map2.get(key), map1.get(key));
			}
		}
		return map;
	}
}
