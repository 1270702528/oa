package com.yucaijr.model;

/**
 * 项目信息表
 *
 */
public class ProjectInfo {

	/**
	 * 主键
	 */
	private int id;
	/**
	 * 状态  -1:删除  , 0:初始录入  , 1:审核中 , 2:审核不通过 , 3:审核通过  , 4:流标   
	 */
	private int status;
	
	/**
	 * 申请人
	 */
	private String userName;
	
	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * 项目描述
	 */
	private String description;
	
	/**
	 * 创建时间
	 */
	private String createTime;
	
	/**
	 * 0:没有驳回权限 , 1:有驳回权限 ,  2:流标   , 
	 */
	private int operType;
	
	/**校验是否可以提交任务
	 * 1:尽职调查报告后, 2:项目审批表（市场部）后, 3:评审会决议书后, 4:上线通知书后, 5:项目放款审批表后,
	 */
	private int checkType;

	/**
	 * 任务名称
	 */
	private String taskName;

	/**
	 * 企业名称
	 */
	private String F01;
	
	/**
	 * 成立日期
	 */
	private String F02;
	
	/**
	 * 注册资本
	 */
	private String F03;
	
	/**
	 * 实收资本
	 */
	private String F04;
	
	/**
	 * 注册号/信用代码
	 */
	private String F05;
	
	/**
	 * 开户许可证
	 */
	private String F06;
	
	/**
	 * 经营地址
	 */
	private String F07;
	
	/**
	 * 企业类型
	 */
	private String F08;
	
	/**
	 * 法定代表人
	 */
	private String F09;
	
	/**
	 * 联系人电话
	 */
	private String F10;
	
	/**
	 * 账户名
	 */
	private String F11;
	
	/**
	 * 账  号
	 */
	private String F12;
	
	/**
	 * 开户行
	 */
	private String F13;
	
	/**
	 * 从业人数
	 */
	private String F14;
	
	/**
	 * 管理人员人数
	 */
	private String F15;
	
	/**
	 * 普通员工人数
	 */
	private String F16;
	
	/**
	 * 股东情况
	 */
	private String F17;
	
	/**
	 * 财务情况
	 */
	private String F18;
	
	/**
	 * 资产明细
	 */
	private String F19;
	
	/**
	 * 资产负债状况
	 */
	private String F20;
	
	/**
	 * 借款金额
	 */
	private String F21;
	
	/**
	 * 借款期限
	 */
	private String F22;
	
	/**
	 * 借款年化利率
	 */
	private String F23;
	
	/**
	 * 居间服务年化利率
	 */
	private String F24;
	
	/**
	 * 还款方式
	 */
	private String F25;
	
	/**
	 * 担保方式
	 */
	private String F26;
	
	/**
	 * 借款用途调查
	 */
	private String F27;
	
	/**
	 * 还款来源调查
	 */
	private String F28;
	
	/**
	 * 保证人姓名
	 */
	private String F29;
	
	/**
	 * 保证人身份证号
	 */
	private String F30;
	
	/**
	 * 保证人联系电话
	 */
	private String F31;
	
	/**
	 * 保证人单位地址
	 */
	private String F32;
	
	/**
	 * 在其他网贷平台借款情况
	 */
	private String F33;
	
	/**
	 * 借款人名称
	 */
	private String F34;
	
	/**
	 * 业务种类
	 */
	private String F35;
	
	
	/**
	 * 项目来源
	 */
	private String F36;
	
	/**
	 * 尽调时间
	 */
	private String F37;
	
	/**
	 * 尽调人
	 */
	private String F38;
	
	/**
	 * 调查意见
	 */
	private String F39;
	
	/**
	 * 项目上线条件
	 */
	private String F40;
	
	/**
	 * 担保措施
	 */
	private String F41;
	
	/**
	 * 借款人基本情况
	 */
	private String F42;
	
	/**
	 * 经营情况
	 */
	private String F43;
	
	/**
	 * 联系人
	 */
	private String F44;
	
	/**
	 * 主要担保方式
	 */
	private String F45;
	
	/**
	 * 结论
	 */
	private String F46;
	
	/**
	 * 审核事宜
	 */
	private String F47;
	
	/**
	 * 项目主办人
	 */
	private String F48;
	
	/**
	 * 项目风控人员
	 */
	private String F49;
	
	
	/**
	 * 罚息
	 */
	private String F50;
	
	/**
	 * 保证合同内容
	 */
	private String F51;
	
	/**
	 * 签发人签字
	 */
	private String F52;
	
	/**
	 * 借款协议编号
	 */
	private String F53;
	
	
	/**
	 * 在借总金额
	 */
	private String F54;
	
	/**
	 * 筹款期限
	 */
	private String F55;
	
	
	/**
	 * 上传资料/文件/照片明细
	 */
	private String F56;
	
	/**
	 * 注册时间
	 */
	private String F57;
	
	
	/**
	 * 收入情况
	 */
	private String F58;
	
	/**
	 * 企业行业
	 */
	private String F59;
	
	/**
	 * 企业规模
	 */
	private String F60;
	
	
	/**
	 * 第一还款来源
	 */
	private String F61;
	
	/**
	 * 还款保障措施
	 */
	private String F62;
	
	/**
	 * 主要担保情况
	 */
	private String F63;
	
	/**
	 * 项目经理签名
	 */
	private String F64;
	
	/**
	 * 部门经理签名
	 */
	private String F65;
	
	/**
	 * 市场部经理审批意见
	 */
	private String F66;
	
	/**
	 * 签发人签字
	 */
	private String F67;
	
	/**
	 * 风控部经理意见
	 */
	private String F68;
	
	/**
	 * 运营部经理上线意见
	 */
	private String F69;
	
	/**
	 * 风控部经理签名
	 */
	private String F70;
	
	/**
	 * 运营部经理签名
	 */
	private String F71;
	
	/**
	 * 运营部经理签名
	 */
	private String F72;
	
	/**
	 * 运营部经办人签名
	 */
	private String F73;
	
	/**
	 * 运营部经理放款意见
	 */
	private String F74;
	
	/**
	 * 财务部经办人意见
	 */
	private String F75;
	
	/**
	 * 财务部经办人签名
	 */
	private String F76;
	
	/**
	 * 尽职调查报告时间
	 */
	private String F77;
	
	/**
	 * 评审会决议书时间
	 */
	private String F78;
	
	/**
	 * 上线通知书时间
	 */
	private String F79;
	
	/**
	 * 放款时间
	 */
	private String F80;
	
	/**
	 * 尽职调查报告 报存地址
	 */
	private String F81;
	
	/**
	 * 项目审批表  报存地址
	 */
	private String F82;
	
	/**
	 * 评审会决议书 报存地址
	 */
	private String F83;
	
	/**
	 * 上线通知书  报存地址
	 */
	private String F84;
	
	/**
	 * 项目放款审批表 报存地址
	 */
	private String F85;
	
	/**
	 * 申请时间
	 */
	private String F86;
	
	
	/**
	 * 借款用途及还款来源
	 */
	private String F87;
	
	/**
	 * 负债情况
	 */
	private String F88;
	
	/**
	 * 项目风险提示
	 */
	private String F89;
	
	
	/**
	 * 风控措施
	 */
	private String F90;
	
	/**
	 * 审查结论
	 */
	private String F91;
	
	/**
	 * 总经理审批意见
	 */
	private String F92;
	
	
	/**
	 * 风控部经理审批意见(带签名)
	 */
	private String F93;
	
	/**
	 * 运营部经理审批意见(带签名)
	 */
	private String F94;
	
	/**
	 * 总经理审批意见(带签名)
	 */
	private String F95;
	
	
	
	public String getF93() {
		return F93;
	}

	public void setF93(String f93) {
		F93 = f93;
	}

	public String getF94() {
		return F94;
	}

	public void setF94(String f94) {
		F94 = f94;
	}

	public String getF95() {
		return F95;
	}

	public void setF95(String f95) {
		F95 = f95;
	}

	public String getF89() {
		return F89;
	}

	public void setF89(String f89) {
		F89 = f89;
	}

	public String getF90() {
		return F90;
	}

	public void setF90(String f90) {
		F90 = f90;
	}

	public String getF91() {
		return F91;
	}

	public void setF91(String f91) {
		F91 = f91;
	}

	public String getF92() {
		return F92;
	}

	public void setF92(String f92) {
		F92 = f92;
	}

	public int getCheckType() {
		return checkType;
	}

	public void setCheckType(int checkType) {
		this.checkType = checkType;
	}

	public String getF86() {
		return F86;
	}

	public void setF86(String f86) {
		F86 = f86;
	}

	public String getF87() {
		return F87;
	}

	public void setF87(String f87) {
		F87 = f87;
	}

	public String getF88() {
		return F88;
	}

	public void setF88(String f88) {
		F88 = f88;
	}

	public String getF34() {
		return F34;
	}

	public void setF34(String f34) {
		F34 = f34;
	}

	public String getF35() {
		return F35;
	}

	public void setF35(String f35) {
		F35 = f35;
	}

	public String getF36() {
		return F36;
	}

	public void setF36(String f36) {
		F36 = f36;
	}

	public String getF37() {
		return F37;
	}

	public void setF37(String f37) {
		F37 = f37;
	}

	public String getF38() {
		return F38;
	}

	public void setF38(String f38) {
		F38 = f38;
	}

	public String getF39() {
		return F39;
	}

	public void setF39(String f39) {
		F39 = f39;
	}

	public String getF40() {
		return F40;
	}

	public void setF40(String f40) {
		F40 = f40;
	}

	public String getF41() {
		return F41;
	}

	public void setF41(String f41) {
		F41 = f41;
	}

	public String getF42() {
		return F42;
	}

	public void setF42(String f42) {
		F42 = f42;
	}

	public String getF43() {
		return F43;
	}

	public void setF43(String f43) {
		F43 = f43;
	}

	public String getF44() {
		return F44;
	}

	public void setF44(String f44) {
		F44 = f44;
	}

	public String getF45() {
		return F45;
	}

	public void setF45(String f45) {
		F45 = f45;
	}

	public String getF46() {
		return F46;
	}

	public void setF46(String f46) {
		F46 = f46;
	}

	public String getF47() {
		return F47;
	}

	public void setF47(String f47) {
		F47 = f47;
	}

	public String getF48() {
		return F48;
	}

	public void setF48(String f48) {
		F48 = f48;
	}

	public String getF49() {
		return F49;
	}

	public void setF49(String f49) {
		F49 = f49;
	}

	public String getF50() {
		return F50;
	}

	public void setF50(String f50) {
		F50 = f50;
	}

	public String getF51() {
		return F51;
	}

	public void setF51(String f51) {
		F51 = f51;
	}

	public String getF52() {
		return F52;
	}

	public void setF52(String f52) {
		F52 = f52;
	}

	public String getF53() {
		return F53;
	}

	public void setF53(String f53) {
		F53 = f53;
	}

	public String getF54() {
		return F54;
	}

	public void setF54(String f54) {
		F54 = f54;
	}

	public String getF55() {
		return F55;
	}

	public void setF55(String f55) {
		F55 = f55;
	}

	public String getF56() {
		return F56;
	}

	public void setF56(String f56) {
		F56 = f56;
	}

	public String getF57() {
		return F57;
	}

	public void setF57(String f57) {
		F57 = f57;
	}

	public String getF58() {
		return F58;
	}

	public void setF58(String f58) {
		F58 = f58;
	}

	public String getF59() {
		return F59;
	}

	public void setF59(String f59) {
		F59 = f59;
	}

	public String getF60() {
		return F60;
	}

	public void setF60(String f60) {
		F60 = f60;
	}

	public String getF61() {
		return F61;
	}

	public void setF61(String f61) {
		F61 = f61;
	}

	public String getF62() {
		return F62;
	}

	public void setF62(String f62) {
		F62 = f62;
	}

	public String getF63() {
		return F63;
	}

	public void setF63(String f63) {
		F63 = f63;
	}

	public String getF64() {
		return F64;
	}

	public void setF64(String f64) {
		F64 = f64;
	}

	public String getF65() {
		return F65;
	}

	public void setF65(String f65) {
		F65 = f65;
	}

	public String getF66() {
		return F66;
	}

	public void setF66(String f66) {
		F66 = f66;
	}

	public String getF67() {
		return F67;
	}

	public void setF67(String f67) {
		F67 = f67;
	}

	public String getF68() {
		return F68;
	}

	public void setF68(String f68) {
		F68 = f68;
	}

	public String getF69() {
		return F69;
	}

	public void setF69(String f69) {
		F69 = f69;
	}

	public String getF70() {
		return F70;
	}

	public void setF70(String f70) {
		F70 = f70;
	}

	public String getF71() {
		return F71;
	}

	public void setF71(String f71) {
		F71 = f71;
	}

	public String getF72() {
		return F72;
	}

	public void setF72(String f72) {
		F72 = f72;
	}

	public String getF73() {
		return F73;
	}

	public void setF73(String f73) {
		F73 = f73;
	}

	public String getF74() {
		return F74;
	}

	public void setF74(String f74) {
		F74 = f74;
	}

	public String getF75() {
		return F75;
	}

	public void setF75(String f75) {
		F75 = f75;
	}

	public String getF76() {
		return F76;
	}

	public void setF76(String f76) {
		F76 = f76;
	}

	public String getF77() {
		return F77;
	}

	public void setF77(String f77) {
		F77 = f77;
	}

	public String getF78() {
		return F78;
	}

	public void setF78(String f78) {
		F78 = f78;
	}

	public String getF79() {
		return F79;
	}

	public void setF79(String f79) {
		F79 = f79;
	}

	public String getF80() {
		return F80;
	}

	public void setF80(String f80) {
		F80 = f80;
	}

	public String getF81() {
		return F81;
	}

	public void setF81(String f81) {
		F81 = f81;
	}

	public String getF82() {
		return F82;
	}

	public void setF82(String f82) {
		F82 = f82;
	}

	public String getF83() {
		return F83;
	}

	public void setF83(String f83) {
		F83 = f83;
	}

	public String getF84() {
		return F84;
	}

	public void setF84(String f84) {
		F84 = f84;
	}

	public String getF85() {
		return F85;
	}

	public void setF85(String f85) {
		F85 = f85;
	}

	public String getF01() {
		return F01;
	}

	public void setF01(String f01) {
		F01 = f01;
	}

	public String getF02() {
		return F02;
	}

	public void setF02(String f02) {
		F02 = f02;
	}

	public String getF03() {
		return F03;
	}

	public void setF03(String f03) {
		F03 = f03;
	}

	public String getF04() {
		return F04;
	}

	public void setF04(String f04) {
		F04 = f04;
	}

	public String getF05() {
		return F05;
	}

	public void setF05(String f05) {
		F05 = f05;
	}

	public String getF06() {
		return F06;
	}

	public void setF06(String f06) {
		F06 = f06;
	}

	public String getF07() {
		return F07;
	}

	public void setF07(String f07) {
		F07 = f07;
	}

	public String getF08() {
		return F08;
	}

	public void setF08(String f08) {
		F08 = f08;
	}

	public String getF09() {
		return F09;
	}

	public void setF09(String f09) {
		F09 = f09;
	}

	public String getF10() {
		return F10;
	}

	public void setF10(String f10) {
		F10 = f10;
	}

	public String getF11() {
		return F11;
	}

	public void setF11(String f11) {
		F11 = f11;
	}

	public String getF12() {
		return F12;
	}

	public void setF12(String f12) {
		F12 = f12;
	}

	public String getF13() {
		return F13;
	}

	public void setF13(String f13) {
		F13 = f13;
	}

	public String getF14() {
		return F14;
	}

	public void setF14(String f14) {
		F14 = f14;
	}

	public String getF15() {
		return F15;
	}

	public void setF15(String f15) {
		F15 = f15;
	}

	public String getF16() {
		return F16;
	}

	public void setF16(String f16) {
		F16 = f16;
	}

	public String getF17() {
		return F17;
	}

	public void setF17(String f17) {
		F17 = f17;
	}

	public String getF18() {
		return F18;
	}

	public void setF18(String f18) {
		F18 = f18;
	}

	public String getF19() {
		return F19;
	}

	public void setF19(String f19) {
		F19 = f19;
	}

	public String getF20() {
		return F20;
	}

	public void setF20(String f20) {
		F20 = f20;
	}

	public String getF21() {
		return F21;
	}

	public void setF21(String f21) {
		F21 = f21;
	}

	public String getF22() {
		return F22;
	}

	public void setF22(String f22) {
		F22 = f22;
	}

	public String getF23() {
		return F23;
	}

	public void setF23(String f23) {
		F23 = f23;
	}

	public String getF24() {
		return F24;
	}

	public void setF24(String f24) {
		F24 = f24;
	}

	public String getF25() {
		return F25;
	}

	public void setF25(String f25) {
		F25 = f25;
	}

	public String getF26() {
		return F26;
	}

	public void setF26(String f26) {
		F26 = f26;
	}

	public String getF27() {
		return F27;
	}

	public void setF27(String f27) {
		F27 = f27;
	}

	public String getF28() {
		return F28;
	}

	public void setF28(String f28) {
		F28 = f28;
	}

	public String getF29() {
		return F29;
	}

	public void setF29(String f29) {
		F29 = f29;
	}

	public String getF30() {
		return F30;
	}

	public void setF30(String f30) {
		F30 = f30;
	}

	public String getF31() {
		return F31;
	}

	public void setF31(String f31) {
		F31 = f31;
	}

	public String getF32() {
		return F32;
	}

	public void setF32(String f32) {
		F32 = f32;
	}

	public String getF33() {
		return F33;
	}

	public void setF33(String f33) {
		F33 = f33;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public int getOperType() {
		return operType;
	}

	public void setOperType(int operType) {
		this.operType = operType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	
}
