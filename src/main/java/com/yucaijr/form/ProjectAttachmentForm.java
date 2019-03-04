package com.yucaijr.form;

public class ProjectAttachmentForm {

	private String text;
	
	private int value;
	
	private String group;
	
	private boolean remark;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public boolean isRemark() {
		return remark;
	}

	public void setRemark(boolean remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "ProjectAttachmentForm [text=" + text + ", value=" + value + ", group=" + group + ", remark=" + remark
				+ "]";
	}
	
	
	
}
