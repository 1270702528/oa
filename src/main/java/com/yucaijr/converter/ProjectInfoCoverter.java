package com.yucaijr.converter;

import java.lang.reflect.Field;
import java.util.Map;

import com.yucaijr.model.File1;
import com.yucaijr.model.File2;
import com.yucaijr.model.File3;
import com.yucaijr.model.File4;
import com.yucaijr.model.File5;
import com.yucaijr.model.ProjectInfo;
import com.yucaijr.util.ReflectionUtil;

public class ProjectInfoCoverter {

	public static Object projectInfofoCoverter(int index,ProjectInfo p) {
		switch (index) {
		case 0:
			return ProjectInfoToFile1(p);

		case 1:
			return ProjectInfoToFile2(p);
			
		case 2:
			return ProjectInfoToFile3(p);
			
		case 3:
			return ProjectInfoToFile4(p);
			
		case 4:
			return ProjectInfoToFile5(p);
		}
		return null;
	}
	

	public static Object ProjectInfoToFile1(ProjectInfo p) {
		File1 file1=new File1();	
		return getFields(file1, p, ProjectInfoPropertiesMapping.File1Mapping());
	}
	
	public static Object ProjectInfoToFile2(ProjectInfo p) {
		File2 file2=new File2();
		return  getFields(file2, p, ProjectInfoPropertiesMapping.File2Mapping());
	}
	
	public static Object ProjectInfoToFile3(ProjectInfo p) {
		File3 file3=new File3();
		return getFields(file3, p, ProjectInfoPropertiesMapping.File3Mapping());
	}

	public static Object ProjectInfoToFile4(ProjectInfo p) {
		File4 file4=new File4();
		return getFields(file4, p, ProjectInfoPropertiesMapping.File4Mapping());
	}

	public static Object ProjectInfoToFile5(ProjectInfo p) {
		File5 file5=new File5();
		return getFields(file5, p, ProjectInfoPropertiesMapping.File5Mapping());
	}
	
	
	public static Object getFields(Object files,Object projectInfo,Map<String,String> map) {
		for(Field f: files.getClass().getDeclaredFields()) {
			if(map.containsKey(f.getName())) {
				String projectInfoKey=map.get(f.getName());
				String projectInfoVal=(String) ReflectionUtil.getValue(projectInfo, projectInfoKey);
				ReflectionUtil.setValue(files, f.getName(), projectInfoVal);
			}
		}
		return files;
	}
}
