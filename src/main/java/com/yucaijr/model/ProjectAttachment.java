package com.yucaijr.model;

/**
 * 项目附件表
 *
 */
public class ProjectAttachment {

	/**
	 * 主键
	 */
	public int id;
	
	/**
	 * 项目信息id
	 */
	public int projectInfoId;
	
	/**
	 * 文件路径
	 */
	private String imageUrl="";
	
	/**
	 * 附件名
	 */
	private String name;
	
	/**
	 * 序号
	 */
	private int orderNum;
	
	/**
	 * 上传者
	 */
	private String userName;
	
	/**
	 * 上传时间
	 */
	private String createTime;
	
	/**
	 * 是否重点标记
	 */
	private boolean remark;

	
	public boolean isRemark() {
		return remark;
	}

	public void setRemark(boolean remark) {
		this.remark = remark;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public int getProjectInfoId() {
		return projectInfoId;
	}

	public void setProjectInfoId(int projectInfoId) {
		this.projectInfoId = projectInfoId;
	}

	@Override
	public String toString() {
		return "ProjectAttachment [id=" + id + ", projectInfoId=" + projectInfoId + ", imageUrl=" + imageUrl + ", name="
				+ name + ", orderNum=" + orderNum + ", userName=" + userName + ", createTime=" + createTime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProjectAttachment other = (ProjectAttachment) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
	
	
}
