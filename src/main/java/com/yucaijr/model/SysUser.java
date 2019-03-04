package com.yucaijr.model;

/**
 * 用户表
 *
 */
public class SysUser {

	/**
	 * 主键
	 */
	private Integer id;
	
	/**
	 * 用户名
	 */
	private String account;
	
	/**
	 * 密码
	 */
	private String password;
	
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 性别
	 */
	private Integer sex;
	
	/**
	 * 电话号码
	 */
	private String phone;
	
	/**
	 * 角色id
	 */
	private String roleid;
	
	/**
	 * 状态   1：启用 2：冻结 3：删除
	 */
	private Integer status;
	
	/**
	 * 创建时间
	 */
	private String createtime;
	
	/**
	 * 角色名
	 */
	private String roleName;
	
	

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	@Override
	public String toString() {
		return "SysUser [id=" + id + ", account=" + account + ", password=" + password  + ", name="
				+ name + ", sex=" + sex + ", phone=" + phone + ", roleid=" + roleid + ", status=" + status
				+ ", createtime=" + createtime + ", roleName=" + roleName + "]";
	}
	
	
}
