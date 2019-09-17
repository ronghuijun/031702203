package com.manage;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class UtilTest {

	Util util=new Util();
	
	@Test
	public void testGetName() {
		
		assertEquals("丽丽",util.getName("丽丽,北京天安门"));
	}

	@Test
	public void testSeparateName() {
		assertEquals("北京天安门",util.separateName("丽丽,北京天安门"));
	}

	@Test
	public void testGetPhone() {
		assertEquals("12345678901",util.getPhone("我12345678901怎么"));
	}
	@Test
	public void testSeparatePhone() {
		//System.out.println(util.separatePhone("我12345678901怎么"));
		assertEquals("我怎么",util.separatePhone("我12345678901怎么"));
		
	}
	

	@Test
	public void testGetAddress1() {
		List<String> addressList=new ArrayList<>();
		addressList.add("福建省");
		addressList.add("泉州市");
		addressList.add("南安市");
		addressList.add("霞美镇");
		addressList.add("美西街");
		addressList.add("41号");
		addressList.add("青青饭店");
		assertEquals(addressList,util.getAddress("2","福建省泉州市南安市霞美镇美西街41号青青饭店"));
	}
	@Test
	public void testGetAddress2() {
		List<String> addressList=new ArrayList<>();
		addressList.add("北京");
		addressList.add("北京市");
		addressList.add("东城区");
		addressList.add("东道口街道");
		addressList.add("美西街");
		addressList.add("1号");
		addressList.add("人民法院");
		assertEquals(addressList,util.getAddress("2","北京市东城区东道口街道美西街1号人民法院"));
	}
	@Test
	public void testGetAddress3() {
		List<String> addressList=new ArrayList<>();
		addressList.add("湖北省");
		addressList.add("武汉市");
		addressList.add("汉阳区");
		addressList.add("老街道");
		addressList.add("楚河汉街");
		addressList.add("1号");
		addressList.add("万达广场");
		assertEquals(addressList,util.getAddress("2","湖北省武汉市汉阳区老街道楚河汉街1号万达广场"));
	}
	@Test
	public void testSeparateTotalInfo3() {
		List<String> addressList=new ArrayList<>();
		addressList.add("福省");
		addressList.add("福州市");
		addressList.add("闽侯县");
		addressList.add("上街镇");
		addressList.add("学院路");
		addressList.add("2号");
		addressList.add("福州大学");
		assertEquals(addressList,util.getAddress("2","福省福州市闽侯县上街镇学院路2号福州大学"));
	}
	@Test
	public void testSeparateTotalInfo2() {
		List<String> addressList=new ArrayList<>();
		addressList.add("福建省");
		addressList.add("福市");
		addressList.add("闽侯县");
		addressList.add("上街镇");
		addressList.add("学院路");
		addressList.add("2号");
		addressList.add("福州大学");
		assertEquals(addressList,util.getAddress("2","福建省福市闽侯县上街镇学院路2号福州大学"));
	}
	@Test
	public void testSeparateTotalInfo() {
		List<String> addressList=new ArrayList<>();
		addressList.add("福建省");
		addressList.add("福州市");
		addressList.add("闽县");
		addressList.add("上街镇");
		addressList.add("学院路");
		addressList.add("2号");
		addressList.add("福州大学");
		assertEquals(addressList,util.getAddress("2","福建省福州市闽县上街镇学院路2号福州大学"));
	}
}
