package com.manage;

import java.util.List;

public class UserInfo {

	private String ����;
	private String �ֻ�;
	List<String> ��ַ;
	public String get����() {
		return ����;
	}
	public void set����(String ����) {
		this.���� = ����;
	}
	public String get�ֻ�() {
		return �ֻ�;
	}
	public void set�ֻ�(String �ֻ�) {
		this.�ֻ� = �ֻ�;
	}
	public List<String> get��ַ() {
		return ��ַ;
	}
	public void set��ַ(List<String> ��ַ) {
		this.��ַ = ��ַ;
	}
	@Override
	public String toString() {
		return "UserInfo [����=" + ���� + ", �ֻ�=" + �ֻ� + ", ��ַ=" + ��ַ + "]";
	}
	
	
	
	/*public Message(String totalMessage){
		this.totalMessage= totalMessage;
		/*String[] address = totalAddress.split(".\n");
		
		String myreg ="\\d{11}";
		String[] add=address[1].split(myreg);
		System.out.println(add[1]);
	}*/
	

}
