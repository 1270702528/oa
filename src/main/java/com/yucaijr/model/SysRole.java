package com.yucaijr.model;
/**
 * 角色表
 *
 */
public class SysRole {

	/**
	 * 主键
	 */
	private Integer id;
	
	/**
	 * 角色名
	 */
	private String name;
	
	/**
	 * 描述
	 */
	private String message;

	/**
	 * 权限
	 */
	private String permission;
	
	
	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "SysRole [id=" + id + ", name=" + name + ", message=" + message + "]";
	}
	
	
}
