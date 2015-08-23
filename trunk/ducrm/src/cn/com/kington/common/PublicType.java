package cn.com.kington.common;

/**
 * ϵͳ���ò�����ö���Ͷ���
 * 
 * @author ������
 * 
 */
public class PublicType {
	public static enum Sex {
		MALE("��"),
		FEMALE("Ů");

		private String text;

		public String getText() {
			return this.text;
		}

		private Sex(String str) {
			this.text = str;
		}
	}
	
	/**
	 * Ѫ��
	 * @author ������
	 *
	 */
	public static enum BloodSort {
		A("A��"),
		B("B��"),
		AB("AB��"),
		O("O��"),
		OTHER("����Ѫ��");
		
		private String text;
		
		public String getText() {
			return this.text;
		}
		
		private BloodSort(String str) {
			this.text = str;
		}
	}
	
	/**
	 * ѧ��
	 * @author ������
	 *
	 */
	public static enum Degree {
		D1("��ʿ��"),
		D2("��ʿ"),
		D3("MBA"),
		D4("˶ʿ"),
		D5("����"),
		D6("��ר"),
		D7("����"),
		D8("��ר"),
		D9("��У"),
		D10("ְ��"),
		D11("��"),
		D12("����"),
		D13("Сѧ"),
		D14("��ä");
		
		private String text;
		
		public String getText() {
			return this.text;
		}
		
		private Degree(String str) {
			this.text = str;
		}
	}
	
	
	public static enum ManSort{
		CUSTOMER("�ͻ�"),
		PROVIDER("��Ӧ��"),
		RELATION("����"),
		EMPLOYEE("Ա��");
		
		private String text;
		
		public String getText(){
			return this.text;
		}
		
		private ManSort(String str){
			this.text = str;
		}
	}
	
	public static enum OrderGrade{
		GENERAL("����"),
		FAST("��"),
		FASTER("�ؼ�");
		
		private String text;
		
		public String getText(){
			return this.text;
		}
		
		private OrderGrade(String str){
			this.text = str;
		}
	}
	
	
	public static enum PlanSort{
		PM("�¼ƻ�"),
		PS("���ȼƻ�"),
		PY("��ȼƻ�");
		
		private String text;
		
		public String getText(){
			return this.text;
		}
		
		private PlanSort(String str){
			this.text = str;
		}
	}
	
	public static enum AskStyle{
		MEET("����"),
		PHONE("�绰"),
		FAX("����"),
		EXPRESS("���"),
		POST("�ʼ�"),
		LETTER("�ź�"),
		OTHER("����");
		
		private String text;
		
		public String getText(){
			return this.text;
		}
		
		private AskStyle(String str){
			this.text = str;
		}
	}
	
	
	
	public static enum StateType{
		AUDIT_WAIT("�����"),
		AUDIT_YES("ͨ��"),
		AUDIT_NO("��ͨ��"),
		AUDIT_PRO("�����"),
		PRICE_WAIT("������"),
		PRICE_YES("ͬ��"),
		PRICE_NO("��ͬ��"),
		PRICE_PRO("������"),
		PRICE_OK("��ȷ��"),
		ASK_WAIT("��ѯ��"),
		ASK_YES("��ѯ��"),
		ASK_NO("δѯ��"),
		ASK_PRO("ѯ����"),
		ASK_OK("��ȷ��"),
		SIGN_WAIT("��ǩԼ"),
		SIGN_YES("��ǩԼ"),
		SIGN_NO("δǩԼ"),
		SIGN_PRO("ǩԼ��"),
		SIGN_OK("��ȷ��"),
		BGT_WAIT("��Ԥ��"),
		BGT_YES("��Ԥ��"),
		BGT_NO("δԤ��"),
		BGT_PRO("Ԥ����"),
		BGT_OK("��ȷ��"),
		ADJ_WAIT("���̵�"),
		ADJ_YES("���̵�"),
		ADJ_NO("δ�̵�"),
		ADJ_PRO("�̵���"),
		ADJ_OK("��ȷ��"),
		CHECK_WAIT("������"),
		CHECK_YES("�Ѻ���"),
		CHECK_NO("δ����"),
		CHECK_PRO("������"),
		CHECK_OK("��ȷ��"),
		BAL_WAIT("������"),
		BAL_YES("�ѽ���"),
		BAL_NO("δ����"),
		BAL_PRO("������"),
		BAL_OK("��ȷ��"),
		FLW_WAIT("������"),
		FLW_YES("�Ѹ���"),
		FLW_NO("δ����"),
		FLW_PRO("������"),
		FLW_OK("��ȷ��"),
		IN_WAIT("�����"),
		IN_YES("�����"),
		IN_NO("δ���"),
		IN_PRO("�����"),
		IN_OK("��ȷ��"),
		OUT_WAIT("������"),
		OUT_YES("�ѳ���"),
		OUT_NO("δ����"),
		OUT_PRO("������"),
		OUT_OK("��ȷ��"),
		BACK_WAIT("���˻�"),
		BACK_YES("���˻�"),
		BACK_NO("δ�˻�"),
		BACK_PRO("�˻���"),
		BACK_OK("��ȷ��"),
		MAKE_WAIT("������"),
		MAKE_STOP("ֹͣ����"),
		MAKE_PAUSE("��ͣ����"),
		MAKE_YES("������"),
		MAKE_NO("δ����"),
		MAKE_PRO("������"),
		MAKE_OK("��ȷ��"),
		SURE_WAIT("��ȷ��"),
		SURE_YES("��ȷ��"),
		SURE_NO("δȷ��"),
		SURE_PRO("ȷ����"),
		SURE_OK("��ȷ��");
		
		private String text;
		
		public String getText(){
			return this.text;
		}
		
		private StateType(String str){
			this.text = str;
		}
	}
	
	/**
	 * ��Ʒ����
	 * @author ������
	 *
	 */
	public static enum ProductType {
		INSIDE("�ڲ�"),
		OUTSIDE("�ⲿ");
		
		private String text;
		
		public String getText() {
			return this.text;
		}
		
		private ProductType(String str) {
			this.text = str;
		}
	}
	
	/**
	 * ����״̬
	 * @author ������
	 *
	 */
	public static enum OrderState {
		JCXXGL_KHGL("�ͻ�����"),
		JCXXGL_GYSGL("��Ӧ�̹���"),
		JCXXGL_CPGL("��Ʒ����"),
		JCXXGL_WLGL("���Ϲ���"),
		XSGL("���۹���"),
		XSGL_XMGL("��Ŀ����"),
		XSGL_XMGL_XZDD("��������"),
		XSGL_XMGL_DDYS("����Ԥ��"),
		XSGL_XMGL_DDBJ("��������"),
		XSGL_XMGL_BJSH("�������"),
		XSGL_XMGL_BJQR("����ȷ��"),
		XSGL_XMGL_DDQY("����ǩԼ"),
		XSGL_XMGL_HTQR("��ͬȷ��"),
		XSGL_XMGL_DDGL("��������"),
		XSGL_XMYS("��ĿԤ��"),
		XSGL_XMYS_CBYS("�ɱ�Ԥ��"),
		XSGL_XMYS_RGYS("�˹�Ԥ��"),
		XSGL_XMYS_QTFY("��������"),
		
		XSGL_DDGL("��������"),
		XSGL_DDGL_DDLR("����¼��"),
		XSGL_DDGL_DDGL("��������"),
		
		XSGL_BJGL("���۹���"),
		XSGL_BJGL_CPBJ("��Ʒ����"),
		XSGL_BJGL_BJSH("�������"),
		XSGL_BJGL_BJQR("����ȷ��"),
		XSGL_BJGL_BJGL("���۹���"),
		
		CGGL("�ɹ�����"),
		CGGL_WLZX("������ѯ"),
		CGGL_WLZX_XJZX("ѯ����ѯ"),
		CGGL_WLZX_XJQR("ѯ��ȷ��"),
		CGGL_WLZX_XJGL("ѯ�۹���"),
		CGGL_WLCG("���ϲɹ�"),
		CGGL_WLCG_CGSQ("�ɹ�����"),
		CGGL_WLCG_CGSH("�ɹ����"),
		CGGL_WLCG_CGGL("�ɹ�����"),
		CGGL_WLCG_CGRK("�ɹ����"),
		CGGL_WLCG_CGTH("�ɹ��˻�"),
		CGGL_WLCG_THSH("�˻����"),
		CKGL("�ֿ����"),
		CKGL_CKGL("�ֿ����"),
		CKGL_KCGL("������"),
		SCGL("��������"),
		SCGL_SCPG("�����Ź�"),
		SCGL_DDSC("��������"),
		SCGL_SCPZ("��������"),
		SCGL_SCRZ("������־"),
		SCGL_SCRK("�������"),
		SCGL_SCCK("��������");

		
		private String text;
		
		public String getText() {
			return this.text;
		}
		
		private OrderState(String str) {
			this.text = str;
		}
	}
	
	/**
	 * ����/����
	 * @author ������
	 *
	 */
	public static enum Sort{
		MATERIAL("����"),
		PRODUCT("��Ʒ"),
		WORK("����"),
		COST("�ɱ�"),
		WAGE("�˹�"),
		AREA("����"),
		CUSTOMER("�ͻ�����"),
		CERTIFICATE("֤������"),
		DUTY("ְ��"),
		PLAN("�ƻ�"),
		RECEIPT("Ʊ��"),
		CONTRACT("��ͬ"),
		SELL("��������"),
		PAY("֧����ʽ"),
		ASK("����/ѯ�۷�ʽ"),
		CONTACT("��ϵ��ʽ"),
		PLOY("�����"),
		UNIT("��λ"),
		NATION("����"),
		POLITY("������ò"),
		OTHER("����");
		
		private String text;
		
		public String getText() {
			return this.text;
		}
		
		private Sort(String str) {
			this.text = str;
		}
	}
	
	/**
	 * ��������
	 * @author ������
	 *
	 */
	public static enum OrderSort{
		SELL("���۶���"),
		PROJECT("��Ŀ����"),
		OEM("�ӹ�����"),
		OTHER("����");
		
		private String text;
		
		public String getText(){
			return this.text;
		}
		
		private OrderSort(String str){
			this.text = str;
		}
	}
}
