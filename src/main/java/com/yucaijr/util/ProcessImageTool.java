package com.yucaijr.util;

import java.util.Map;

public class ProcessImageTool {

	
	public static String getStyle(Map<String, Object> map) {
		StringBuilder sb=new StringBuilder();
		sb.append("top:");
		sb.append(map.get("y")+"px;");
		sb.append("left:");
		sb.append(map.get("x")+"px;");
		sb.append("width:");
		sb.append(map.get("width")+"px;");
		sb.append("height:");
		sb.append(map.get("height")+"px; ");
		return sb.toString();
	}
}
