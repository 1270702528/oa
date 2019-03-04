package com.yucaijr.converter;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import com.yucaijr.form.SysUserForm;
import com.yucaijr.model.SysUser;


public class SysUser2SysUserForm {

	public static List<SysUserForm> converter(List<SysUser> list){
		List<SysUserForm> forms=new ArrayList<>();
		for(SysUser s:list) {
			SysUserForm form=new SysUserForm();
			BeanUtils.copyProperties(s, form);
			forms.add(form);
		}
		return forms;
	}
}
