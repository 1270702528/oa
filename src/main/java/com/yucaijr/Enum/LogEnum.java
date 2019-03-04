package com.yucaijr.Enum;

public enum LogEnum {

	//LOGIN(1, "登陆"),
	LOGIN_SUCCESS(2, "登陆成功"),
	LOGIN_FAIL(3, "登陆失败"),
	//REGISTER(4, "注册"),
	REGISTER_SUCCESS(5, "注册成功"),
	REGISTER_FAIL(6, "注册失败"),
	//CHARGE(7, "充值"),
	CHARGE_SUCCESS(8, "充值成功"),
	CHARGE_FAIL(9, "充值失败"),
	//WITHDRAWAL(10, "提现"),
	WITHDRAWAL_SUCCESS(11, "提现成功"),
	WITHDRAWAL_FAIL(12, "提现失败"),
	RISK_EVALUATION(13, "风险评测"),
	//TENDER(14, "投标"),
	TENDER_SUCCESS(15, "投标成功"),
	TENDER_FAIL(16, "投标失败"),
	AUTH(17, "实名认证"),
	BIND_BANK_CARD(18, "绑定银行卡"),
	VIEW_PRODUCT(19, "查看产品"),
	;
	
	private Integer type;

    private String message;
    
    
    public Integer getType() {
		return type;
	}


	public void setType(Integer type) {
		this.type = type;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	LogEnum(Integer type, String message) {
		this.type=type;
		this.message=message;
	}
}
