package cn.com.kington.common;

/**
 * 系统常用参数和枚举型对象
 * 
 * @author 杜永生
 * 
 */
public class PublicType {
	public static enum Sex {
		MALE("男"),
		FEMALE("女");

		private String text;

		public String getText() {
			return this.text;
		}

		private Sex(String str) {
			this.text = str;
		}
	}
	
	/**
	 * 血型
	 * @author 杜永生
	 *
	 */
	public static enum BloodSort {
		A("A型"),
		B("B型"),
		AB("AB型"),
		O("O型"),
		OTHER("其他血型");
		
		private String text;
		
		public String getText() {
			return this.text;
		}
		
		private BloodSort(String str) {
			this.text = str;
		}
	}
	
	/**
	 * 学历
	 * @author 杜永生
	 *
	 */
	public static enum Degree {
		D1("博士后"),
		D2("博士"),
		D3("MBA"),
		D4("硕士"),
		D5("本科"),
		D6("大专"),
		D7("高中"),
		D8("中专"),
		D9("技校"),
		D10("职高"),
		D11("理工"),
		D12("初中"),
		D13("小学"),
		D14("文盲");
		
		private String text;
		
		public String getText() {
			return this.text;
		}
		
		private Degree(String str) {
			this.text = str;
		}
	}
	
	
	public static enum ManSort{
		CUSTOMER("客户"),
		PROVIDER("供应商"),
		RELATION("亲属"),
		EMPLOYEE("员工");
		
		private String text;
		
		public String getText(){
			return this.text;
		}
		
		private ManSort(String str){
			this.text = str;
		}
	}
	
	public static enum OrderGrade{
		GENERAL("常规"),
		FAST("急"),
		FASTER("特急");
		
		private String text;
		
		public String getText(){
			return this.text;
		}
		
		private OrderGrade(String str){
			this.text = str;
		}
	}
	
	
	public static enum PlanSort{
		PM("月计划"),
		PS("季度计划"),
		PY("年度计划");
		
		private String text;
		
		public String getText(){
			return this.text;
		}
		
		private PlanSort(String str){
			this.text = str;
		}
	}
	
	public static enum AskStyle{
		MEET("当面"),
		PHONE("电话"),
		FAX("传真"),
		EXPRESS("快递"),
		POST("邮件"),
		LETTER("信函"),
		OTHER("其他");
		
		private String text;
		
		public String getText(){
			return this.text;
		}
		
		private AskStyle(String str){
			this.text = str;
		}
	}
	
	
	
	public static enum StateType{
		AUDIT_WAIT("待审核"),
		AUDIT_YES("通过"),
		AUDIT_NO("不通过"),
		AUDIT_PRO("审核中"),
		PRICE_WAIT("待报价"),
		PRICE_YES("同意"),
		PRICE_NO("不同意"),
		PRICE_PRO("报价中"),
		PRICE_OK("已确认"),
		ASK_WAIT("待询价"),
		ASK_YES("已询价"),
		ASK_NO("未询价"),
		ASK_PRO("询价中"),
		ASK_OK("已确认"),
		SIGN_WAIT("待签约"),
		SIGN_YES("已签约"),
		SIGN_NO("未签约"),
		SIGN_PRO("签约中"),
		SIGN_OK("已确认"),
		BGT_WAIT("待预算"),
		BGT_YES("已预算"),
		BGT_NO("未预算"),
		BGT_PRO("预算中"),
		BGT_OK("已确认"),
		ADJ_WAIT("待盘点"),
		ADJ_YES("已盘点"),
		ADJ_NO("未盘点"),
		ADJ_PRO("盘点中"),
		ADJ_OK("已确认"),
		CHECK_WAIT("待核算"),
		CHECK_YES("已核算"),
		CHECK_NO("未核算"),
		CHECK_PRO("核算中"),
		CHECK_OK("已确认"),
		BAL_WAIT("待结算"),
		BAL_YES("已结算"),
		BAL_NO("未结算"),
		BAL_PRO("结算中"),
		BAL_OK("已确认"),
		FLW_WAIT("待跟单"),
		FLW_YES("已跟单"),
		FLW_NO("未跟单"),
		FLW_PRO("跟单中"),
		FLW_OK("已确认"),
		IN_WAIT("待入库"),
		IN_YES("已入库"),
		IN_NO("未入库"),
		IN_PRO("入库中"),
		IN_OK("已确认"),
		OUT_WAIT("待出库"),
		OUT_YES("已出库"),
		OUT_NO("未出库"),
		OUT_PRO("出库中"),
		OUT_OK("已确认"),
		BACK_WAIT("待退回"),
		BACK_YES("已退回"),
		BACK_NO("未退回"),
		BACK_PRO("退回中"),
		BACK_OK("已确认"),
		MAKE_WAIT("待生产"),
		MAKE_STOP("停止生产"),
		MAKE_PAUSE("暂停生产"),
		MAKE_YES("已生产"),
		MAKE_NO("未生产"),
		MAKE_PRO("生产中"),
		MAKE_OK("已确认"),
		SURE_WAIT("待确认"),
		SURE_YES("已确认"),
		SURE_NO("未确认"),
		SURE_PRO("确认中"),
		SURE_OK("已确认");
		
		private String text;
		
		public String getText(){
			return this.text;
		}
		
		private StateType(String str){
			this.text = str;
		}
	}
	
	/**
	 * 产品分类
	 * @author 杜永生
	 *
	 */
	public static enum ProductType {
		INSIDE("内部"),
		OUTSIDE("外部");
		
		private String text;
		
		public String getText() {
			return this.text;
		}
		
		private ProductType(String str) {
			this.text = str;
		}
	}
	
	/**
	 * 订单状态
	 * @author 杜永生
	 *
	 */
	public static enum OrderState {
		JCXXGL_KHGL("客户管理"),
		JCXXGL_GYSGL("供应商管理"),
		JCXXGL_CPGL("产品管理"),
		JCXXGL_WLGL("物料管理"),
		XSGL("销售管理"),
		XSGL_XMGL("项目管理"),
		XSGL_XMGL_XZDD("新增订单"),
		XSGL_XMGL_DDYS("订单预算"),
		XSGL_XMGL_DDBJ("订单报价"),
		XSGL_XMGL_BJSH("报价审核"),
		XSGL_XMGL_BJQR("报价确认"),
		XSGL_XMGL_DDQY("订单签约"),
		XSGL_XMGL_HTQR("合同确认"),
		XSGL_XMGL_DDGL("订单管理"),
		XSGL_XMYS("项目预算"),
		XSGL_XMYS_CBYS("成本预算"),
		XSGL_XMYS_RGYS("人工预算"),
		XSGL_XMYS_QTFY("其他费用"),
		
		XSGL_DDGL("订单管理"),
		XSGL_DDGL_DDLR("订单录入"),
		XSGL_DDGL_DDGL("订单管理"),
		
		XSGL_BJGL("报价管理"),
		XSGL_BJGL_CPBJ("产品报价"),
		XSGL_BJGL_BJSH("报价审核"),
		XSGL_BJGL_BJQR("报价确认"),
		XSGL_BJGL_BJGL("报价管理"),
		
		CGGL("采购管理"),
		CGGL_WLZX("物料咨询"),
		CGGL_WLZX_XJZX("询价咨询"),
		CGGL_WLZX_XJQR("询价确认"),
		CGGL_WLZX_XJGL("询价管理"),
		CGGL_WLCG("物料采购"),
		CGGL_WLCG_CGSQ("采购申请"),
		CGGL_WLCG_CGSH("采购审核"),
		CGGL_WLCG_CGGL("采购管理"),
		CGGL_WLCG_CGRK("采购入库"),
		CGGL_WLCG_CGTH("采购退回"),
		CGGL_WLCG_THSH("退回审核"),
		CKGL("仓库管理"),
		CKGL_CKGL("仓库管理"),
		CKGL_KCGL("库存管理"),
		SCGL("生产管理"),
		SCGL_SCPG("生产排工"),
		SCGL_DDSC("订单生产"),
		SCGL_SCPZ("生产配置"),
		SCGL_SCRZ("生产日志"),
		SCGL_SCRK("生产入库"),
		SCGL_SCCK("生产出库");

		
		private String text;
		
		public String getText() {
			return this.text;
		}
		
		private OrderState(String str) {
			this.text = str;
		}
	}
	
	/**
	 * 分类/种类
	 * @author 杜永生
	 *
	 */
	public static enum Sort{
		MATERIAL("物料"),
		PRODUCT("产品"),
		WORK("工序"),
		COST("成本"),
		WAGE("人工"),
		AREA("地区"),
		CUSTOMER("客户类型"),
		CERTIFICATE("证件类型"),
		DUTY("职务"),
		PLAN("计划"),
		RECEIPT("票据"),
		CONTRACT("合同"),
		SELL("销售类型"),
		PAY("支付方式"),
		ASK("报价/询价方式"),
		CONTACT("联系方式"),
		PLOY("活动类型"),
		UNIT("单位"),
		NATION("民族"),
		POLITY("政治面貌"),
		OTHER("其他");
		
		private String text;
		
		public String getText() {
			return this.text;
		}
		
		private Sort(String str) {
			this.text = str;
		}
	}
	
	/**
	 * 订单类型
	 * @author 杜永生
	 *
	 */
	public static enum OrderSort{
		SELL("销售订单"),
		PROJECT("项目订单"),
		OEM("加工订单"),
		OTHER("其他");
		
		private String text;
		
		public String getText(){
			return this.text;
		}
		
		private OrderSort(String str){
			this.text = str;
		}
	}
}
