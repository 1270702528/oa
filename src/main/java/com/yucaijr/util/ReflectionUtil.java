package com.yucaijr.util;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class ReflectionUtil {

	private ReflectionUtil() {
		throw new  AssertionError();
	}
	
	/**
	*通过反射取对象指定字段(属性)的值
	* @param target目标对象
	* @param fieldName字段的名字
	* @throws如果取不到对象指定字段的值则抛出异常
	* @return字段的值
	*/
	public static Object getValue(Object target, String fieldName){
		Class<?> clazz = target.getClass();
		String[] fs = fieldName.split("\\.");
		try{
			for(int i = 0; i < fs.length - 1; i++) {
				Field f = clazz.getDeclaredField(fs[i]);
				f.setAccessible(true);
				target = f.get(target);
				clazz = target.getClass();
			}
			Field f = clazz.getDeclaredField(fs[fs.length -  1]);
			f.setAccessible(true);
			return  f.get(target);
		}
		catch (Exception e) {
			throw new  RuntimeException(e);
		}
	}




	 
	/**
	*通过反射给对象的指定字段赋值
	* @param target目标对象
	* @param fieldName字段的名称
	* @param value值
	*/
	public static void setValue(Object target, String fieldName, Object value) {
		Class<?> clazz = target.getClass();
		String[] fs = fieldName.split("\\.");
		try{
			for(int i = 0; i < fs.length - 1; i++) {
				Field f = clazz.getDeclaredField(fs[i]);
				f.setAccessible(true);
				Object val = f.get(target);
				if(val == null)  {
				Constructor<?> c = f.getType().getDeclaredConstructor();
				c.setAccessible(true);
				val = c.newInstance();
				f.set(target, val);
				}
				target = val;
				clazz = target.getClass();
			}
			
			Field f = clazz.getDeclaredField(fs[fs.length -  1]);
			f.setAccessible(true);
			f.set(target, value);
		}
		catch (Exception e) {
			throw new  RuntimeException(e);
			}
		}


	public static Object TranVals(Object src,Object target) {
		for(Field f: target.getClass().getDeclaredFields()) {
			Object targetVal=getValue(target, f.getName());
			if(targetVal==null) {
				Object srcVal=getValue(src, f.getName());
				setValue(target, f.getName(), srcVal);
			}
			if(targetVal instanceof  String) {
				String stv=(String)targetVal;
				if(stv.equals("")) {
					Object srcVal=getValue(src, f.getName());
					setValue(target, f.getName(), srcVal);
				}
			}
		}
		
		return target;
	}
}
