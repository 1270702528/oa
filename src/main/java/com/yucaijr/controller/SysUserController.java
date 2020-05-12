package com.yucaijr.controller;


import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.yucaijr.Enum.ErrorEnum;
import com.yucaijr.model.SysMenu;
import com.yucaijr.model.SysRole;
import com.yucaijr.model.SysUser;
import com.yucaijr.service.SysMenuService;
import com.yucaijr.service.SysRoleService;
import com.yucaijr.service.SysUserService;
import com.yucaijr.util.DataTool;
import com.yucaijr.util.ResultVOUtil;
import com.yucaijr.util.SessionTool;
import com.yucaijr.util.TreeUtil;
import com.yucaijr.vo.ResultVO;
import com.yucaijr.converter.SysUser2SysUserForm;


@RestController
@RequestMapping(value="user")
public class SysUserController {

	@Autowired
	private SysUserService sysUserService;
	
	@Autowired
	private SysRoleService sysRoleService;
	
	@Autowired
	private SysMenuService sysMenuService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public  ResultVO login(@RequestParam(value="username", defaultValue="") String username,
			@RequestParam(value="password", defaultValue="") String password,
			HttpServletRequest request) {
		SysUser sysUser= sysUserService.getByUsernameAndPasswd(username, password);
		if(sysUser==null) {
			return ResultVOUtil.error(ErrorEnum.USER_PASSWORD_ERROR);
		}
		List<SysRole> sysRoles=sysRoleService.getRoleById(DataTool.String2List(sysUser.getRoleid()));
		
		String permissons="";
		List<String> roles=new ArrayList<>();
		for(SysRole sysRole:sysRoles) {
			if(sysRole.getPermission()!=null) {
				permissons+=sysRole.getPermission();
			}
			if(sysRole.getName()!=null) {
				roles.add(sysRole.getName());
			}
			
		}
	
		List<String> permisson=DataTool.String2List(permissons);
		SessionTool.setPermissionSession(request, permisson);
		SessionTool.setUserSession(request, sysUser);
		SessionTool.setRoleSession(request, roles);
		
		return ResultVOUtil.success();
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public  Object list(@RequestParam(value="username", defaultValue="") String username) {
		return SysUser2SysUserForm.converter(sysUserService.getSysUserList());
		
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public  ResultVO create(@ModelAttribute SysUser sysUser,
			@RequestParam(value="roles", defaultValue="") String roles) {
		sysUser.setRoleid(roles);
		sysUserService.insertWithActivity(sysUser);
		return ResultVOUtil.success();
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public  ResultVO update(@ModelAttribute SysUser sysUser,
			@RequestParam(value="roles", defaultValue="") String roles) {
		sysUser.setRoleid(roles);
		sysUserService.updateWithActivity(sysUser);
		return ResultVOUtil.success();
	}
	
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public  ResultVO delete(@RequestParam(value="id", defaultValue="")Integer id) {
		sysUserService.updateStatus(id);
		return ResultVOUtil.success();
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.POST)
	public  ResultVO logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return ResultVOUtil.success();
	}
	
	@RequestMapping(value="/getuserinfo",method=RequestMethod.GET)
	public  Object getuserinfo(HttpServletRequest request) {
		return request.getSession().getAttribute("user");
	}
	
	@RequestMapping(value="/checkUsername",method=RequestMethod.GET)
	public ResultVO checkUsername(@RequestParam(value="username", defaultValue="")String username) {
		SysUser sysUser=sysUserService.getByUsername(username);
		if(sysUser!=null) {
			return ResultVOUtil.success("1");
		}
		return ResultVOUtil.success("0");
	}
	

	@RequestMapping(value="/permission",method=RequestMethod.GET)
	public  Object permission(HttpServletRequest request) {
		List<Integer> list=SessionTool.getPermissionSession(request);
		if(list==null) {
			return null;
		}
		List<SysMenu> sysMenus=sysMenuService.getSysMenuList(list);
		for(SysMenu s:sysMenuService.getTopSysMenuList()) {
			if(!sysMenus.contains(s)) {
				sysMenus.add(s);
			}
		}
		TreeUtil t=new TreeUtil();
		t.fillTree(sysMenus,null);
		return  t.getComboTreeList();
	}
	
//	@RequestMapping(value="/hasUploadPermission",method=RequestMethod.GET)
//	public  ResultVO hasUploadPermission(HttpServletRequest request) {
//		List<String> roles=SessionTool.getRoleSession(request);
//		if(roles.contains("项目经理"))
//		{
//			return ResultVOUtil.success();
//		}
//		return ResultVOUtil.error(1001, "没有权限");
//	}
	
	@RequestMapping(value="/checkUsername2",method=RequestMethod.GET)
	public ResultVO checkUsername2(@RequestParam(value="username", defaultValue="")String username) {
		SysUser sysUser=sysUserService.getByUsername(username);
		if(sysUser!=null) {
			return ResultVOUtil.success("1");
		}
		return ResultVOUtil.success("0");
	}
}
