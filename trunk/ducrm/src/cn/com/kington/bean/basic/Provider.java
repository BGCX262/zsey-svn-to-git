package cn.com.kington.bean.basic;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * ��Ӧ��
 * 
 * @author ������
 * 
 */
@Entity
@Table(name = "base_provider")
public class Provider extends AbsBaseClient {
	private static final long serialVersionUID = -5189254564090294161L;

	public Provider() {
		super();
	}

}
