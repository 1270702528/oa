package com.yucaijr.Enum;

public enum ErrorEnum {

	USER_PASSWORD_ERROR(1001, "用户名密码错误")
	;
	
	private Integer code;
	
	private String msg;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	 ErrorEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	
}
