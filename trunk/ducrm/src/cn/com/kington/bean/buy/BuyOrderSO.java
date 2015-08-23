package cn.com.kington.bean.buy;

import cn.com.kington.bean.store.AbsBaseOrderSO;
import cn.com.kington.common.PublicType.StateType;

/**
 * ���۲ɹ������ϲɹ���
 * 
 * @author ������
 * 
 */
public class BuyOrderSO extends AbsBaseOrderSO {
	private static final long serialVersionUID = 4023750376162942593L;
	private String deliver;// ��������
	private StateType balanceState;// ����״̬
	private StateType inState;// ���״̬
	private StateType backState;// ��״̬
	private String cause;// �˻�ԭ��;

	public BuyOrderSO() {
		super();
	}

	public String getDeliver() {
		return deliver;
	}

	public void setDeliver(String deliver) {
		this.deliver = deliver;
	}

	public StateType getBalanceState() {
		return balanceState;
	}

	public void setBalanceState(StateType balanceState) {
		this.balanceState = balanceState;
	}

	public StateType getInState() {
		return inState;
	}

	public void setInState(StateType inState) {
		this.inState = inState;
	}

	public StateType getBackState() {
		return backState;
	}

	public void setBackState(StateType backState) {
		this.backState = backState;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

}
