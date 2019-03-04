package com.yucaijr.controller;




import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.yucaijr.model.SysRole;
import com.yucaijr.service.SysMenuService;
import com.yucaijr.service.SysRoleService;
import com.yucaijr.util.ResultVOUtil;
import com.yucaijr.util.TreeUtil;
import com.yucaijr.vo.ResultVO;



@RestController
@RequestMapping(value="/role")
public class SysRoleController {

	
	
	@Autowired
	private SysRoleService sysRoleService;
	
	@Autowired
	private SysMenuService sysMenuService;
	
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Object list() {
		return sysRoleService.getRoleList();
	}
	
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public void creat(@ModelAttribute SysRole sysRole) {
		sysRoleService.insertWithActity(sysRole);
	}
	
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public void update(@ModelAttribute SysRole sysRole) {
		sysRoleService.update(sysRole);
	}
	
	@RequestMapping(value="/checkName",method=RequestMethod.GET)
	public ResultVO checkUsername(@RequestParam(value="name", defaultValue="")String name) {
		SysRole sysRole=sysRoleService.getRoleByUserName(name);
		if(sysRole!=null) {
			return ResultVOUtil.success("1");
		}
		return ResultVOUtil.success("0");
	}
	
	
	@RequestMapping(value="/permission",method=RequestMethod.GET)
	public Object tree(@RequestParam(value="id", defaultValue="") Integer id) {
		SysRole sysRole=sysRoleService.getRoleById(id);
		List<String> list=null;
		if(sysRole!=null) {
			String menus=sysRole.getPermission();
			if(menus!=null) {
				list=Arrays.asList(menus.split(","));
			}
		}
		
		TreeUtil t=new TreeUtil();
		t.fillTree(sysMenuService.getSysMenuList(),list);
		return t.getComboTreeList();
	}
	
	@RequestMapping(value="/permission/update",method=RequestMethod.POST)
	public ResultVO permissionUpdate(@RequestParam(value="id", defaultValue="") Integer id,
			@RequestParam(value="permissions", defaultValue="") String permissions) {
		sysRoleService.updatePermission(id, permissions);
		return ResultVOUtil.success();
	}
}
