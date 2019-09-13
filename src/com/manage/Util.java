package com.manage;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
	
	public void separateTotalInfo(String totalAddress){
		TotalInfo totalInfo=new TotalInfo();
		
		//����Ϣȡ����
		String[] info = totalAddress.split(".\n");
	
		List<UserInfo> userList=new ArrayList<>();
		for(int i=0;i<info.length;i++){
			
			//ɾ����һ���ַ��ǻس������⣨/r/n�����е����⣩
			info[i]=info[i].substring(1,info[i].length());
			//&&info[i].endsWith(".") ��ֹ������޿ո�
			if(i==info.length-1&&info[i].endsWith(".")){
				//�������һ���ַ�.û��ɾ��������
				info[i]=info[i].substring(0,info[i].length()-1);
				//System.out.println(i+"cnsjla"+info[i]);
			}
			
			UserInfo userInfo=new UserInfo();
			userInfo.set����(getName(info[i]));
			info[i]=separateName(info[i]);
			
			userInfo.set�ֻ�(getPhone(info[i]));
			
			info[i]=separatePhone(info[i]);
			//System.out.println(info[i]);
			//System.out.println();
			userInfo.set��ַ(getAddress(info[i]));
			/*userList.add(userInfo);*/
		}
		//totalInfo.setAddressBook(userList);
		
	
	}
	private String getName(String info){
		String []message =info.split(",");
		//System.out.println(name[0]);
		return message[0];
	}
	private String separateName(String info){
		//�����ִ�info��ɾ��
		String []message =info.split(",");
		//System.out.println(message[1]);
		return message[1];
	}
	private String getPhone(String info){
		Pattern pattern =Pattern.compile("\\d{11}");
		Matcher matcher = pattern.matcher(info);
		while(matcher.find()){
			return matcher.group();
		}
		return "�ֻ��Ŷ�ʧ";
	}
	private String separatePhone(String info){
		return info.replaceAll("\\d{11}","");
		
		
	}
	private List<String> getAddress(String info){ 
		 List<String> addressList=new ArrayList<>();
		 String regex="(?<province>[^ʡ]+������|.*?ʡ|.*?������)?(?<city>[^��]+������|.*?����|.*?������λ|.+��|��Ͻ��|.*?��)?(?<county>[^��]+��|.+?��|.+��|.+��|.+����|.+��)?(?<town>[^��]+��|.+�ֵ�)?(?<village>.*)";
		 Pattern pattern=Pattern.compile(regex);
		 Matcher matcher=pattern.matcher(info);
		 String province=null,city=null,county=null,town=null,village=null;
		 while(matcher.find()){
	            
	            province=matcher.group("province");
	            addressList.add(province==null?"":province.trim());
	          
		 
	            city=matcher.group("city");
	            addressList.add(city==null?"":city.trim());
	            
	            county=matcher.group("county");
	            addressList.add(county==null?"":county.trim());
	            
	            town=matcher.group("town");
	            addressList.add(town==null?"":town.trim());
	            
	            village=matcher.group("village");
	            addressList.add(village==null?"":village.trim());   	
	          
	           
	        }
		 
		//ֱϽ�е����
		 if(addressList.get(0).equals("")&&!addressList.get(1).equals("")){
  		   String pro=addressList.get(1).substring(0,2);
  		   addressList.set(0,pro);
  	   	 }
		 
		 for(int i = 0; i < addressList.size(); i++)
         {   
			
      	    String str=addressList.get(i);
            System.out.println(str);
         }
		return addressList;
	}
	
}
