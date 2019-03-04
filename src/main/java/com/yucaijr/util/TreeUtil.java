package com.yucaijr.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yucaijr.model.SysMenu;

public class TreeUtil {

	List<Map<String,Object>> comboTreeList  =new ArrayList<Map<String,Object>>();  
	
	
	public List<Map<String, Object>> getComboTreeList() {
		return comboTreeList;
	}

	/**
	 * 
	 * @param list
	 * @param menus 需要选中的项
	 */
	public void fillTree(List<SysMenu> list,List<String> menus) {
		for (int i = 0; i < list.size(); i++) {  
	        Map<String, Object> map = null;  
	        SysMenu sysMenu = (SysMenu) list.get(i);  
	        if (sysMenu.getPcode().equals("0")) {  
	            map = new HashMap<String, Object>();  
	            map.put("id", list.get(i).getId());        
	            map.put("text",list.get(i).getName()); 
	            map.put("url",list.get(i).getUrl());
	            if(menus!=null &&menus.contains(list.get(i).getId().toString())){
	            	map.put("checked", true);
	            }
	            List<Map<String, Object>> childList=createComboTreeChildren(list, sysMenu.getCode().toString(), menus);
	            map.put("children",childList );  
	        }  
	        if (map != null)  
	        {
	        	comboTreeList.add(map);  
	        }
	    }  
		
	}
	
	private List<Map<String, Object>> createComboTreeChildren(List<SysMenu> list, String fid,List<String> menus) {  
	
	    List<Map<String, Object>> childList = new ArrayList<Map<String, Object>>();  
	    for (int j = 0; j < list.size(); j++) {  
	        Map<String, Object> map = null;  
	        SysMenu treeChild = (SysMenu) list.get(j);  
	        if(treeChild.getPcode().equals(fid)){  
	            map = new HashMap<String, Object>();  
	            map.put("id", list.get(j).getId());  
	            map.put("text", list.get(j).getName());  
	            map.put("url",list.get(j).getUrl());
	            if(menus!=null&&menus.contains(list.get(j).getId().toString())){
	            	map.put("checked", true);
	            }
	            map.put("children", createComboTreeChildren(list, treeChild.getId().toString(),menus));  
	        }  
	        if(map != null)  
	        {
	        	 childList.add(map);  
	        }
	    }  
	    return childList;  
	}  
	
	
}
