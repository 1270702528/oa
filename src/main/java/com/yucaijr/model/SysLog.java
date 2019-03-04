package com.yucaijr.model;
/**
 * 操作日志表
 *
 */
public class SysLog {

	/**
	 * 主键
	 */
	private int id;
	
	/**
	 * 操作用户
	 */
	private String name;
	
	/**
	 * 操作类型
	 */
	private String type;
	
	/**
	 * 操作时间
	 */
	private String createTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public SysLog(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}
	
	
}
