package com.manage;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class UtilTest {

	Util util=new Util();
	
	@Test
	public void testGetName() {
		
		assertEquals("����",util.getName("����,�����찲��"));
	}

	@Test
	public void testSeparateName() {
		assertEquals("�����찲��",util.separateName("����,�����찲��"));
	}

	@Test
	public void testGetPhone() {
		assertEquals("12345678901",util.getPhone("��12345678901��ô"));
	}
	@Test
	public void testSeparatePhone() {
		//System.out.println(util.separatePhone("��12345678901��ô"));
		assertEquals("����ô",util.separatePhone("��12345678901��ô"));
		
	}
	

	@Test
	public void testGetAddress1() {
		List<String> addressList=new ArrayList<>();
		addressList.add("����ʡ");
		addressList.add("Ȫ����");
		addressList.add("�ϰ���");
		addressList.add("ϼ����");
		addressList.add("������");
		addressList.add("41��");
		addressList.add("���෹��");
		assertEquals(addressList,util.getAddress("2","����ʡȪ�����ϰ���ϼ����������41�����෹��"));
	}
	@Test
	public void testGetAddress2() {
		List<String> addressList=new ArrayList<>();
		addressList.add("����");
		addressList.add("������");
		addressList.add("������");
		addressList.add("�����ڽֵ�");
		addressList.add("������");
		addressList.add("1��");
		addressList.add("����Ժ");
		assertEquals(addressList,util.getAddress("2","�����ж����������ڽֵ�������1������Ժ"));
	}
	@Test
	public void testGetAddress3() {
		List<String> addressList=new ArrayList<>();
		addressList.add("����ʡ");
		addressList.add("�人��");
		addressList.add("������");
		addressList.add("�Ͻֵ�");
		addressList.add("���Ӻ���");
		addressList.add("1��");
		addressList.add("���㳡");
		assertEquals(addressList,util.getAddress("2","����ʡ�人�к������Ͻֵ����Ӻ���1�����㳡"));
	}
	@Test
	public void testSeparateTotalInfo3() {
		List<String> addressList=new ArrayList<>();
		addressList.add("��ʡ");
		addressList.add("������");
		addressList.add("������");
		addressList.add("�Ͻ���");
		addressList.add("ѧԺ·");
		addressList.add("2��");
		addressList.add("���ݴ�ѧ");
		assertEquals(addressList,util.getAddress("2","��ʡ�������������Ͻ���ѧԺ·2�Ÿ��ݴ�ѧ"));
	}
	@Test
	public void testSeparateTotalInfo2() {
		List<String> addressList=new ArrayList<>();
		addressList.add("����ʡ");
		addressList.add("����");
		addressList.add("������");
		addressList.add("�Ͻ���");
		addressList.add("ѧԺ·");
		addressList.add("2��");
		addressList.add("���ݴ�ѧ");
		assertEquals(addressList,util.getAddress("2","����ʡ�����������Ͻ���ѧԺ·2�Ÿ��ݴ�ѧ"));
	}
	@Test
	public void testSeparateTotalInfo() {
		List<String> addressList=new ArrayList<>();
		addressList.add("����ʡ");
		addressList.add("������");
		addressList.add("����");
		addressList.add("�Ͻ���");
		addressList.add("ѧԺ·");
		addressList.add("2��");
		addressList.add("���ݴ�ѧ");
		assertEquals(addressList,util.getAddress("2","����ʡ�����������Ͻ���ѧԺ·2�Ÿ��ݴ�ѧ"));
	}
}
