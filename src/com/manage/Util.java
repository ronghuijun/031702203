package com.manage;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
	
	public void separateTotalInfo(String totalAddress){
		TotalInfo totalInfo=new TotalInfo();
		
		//把信息取出来
		String[] info = totalAddress.split(".\n");
	
		List<UserInfo> userList=new ArrayList<>();
		for(int i=0;i<info.length;i++){
			
			//删除第一个字符是回车的问题（/r/n好像有点问题）
			info[i]=info[i].substring(1,info[i].length());
			//&&info[i].endsWith(".") 防止最后有无空格
			if(i==info.length-1&&info[i].endsWith(".")){
				//处理最后一个字符.没被删除的问题
				info[i]=info[i].substring(0,info[i].length()-1);
				//System.out.println(i+"cnsjla"+info[i]);
			}
			
			UserInfo userInfo=new UserInfo();
			userInfo.set姓名(getName(info[i]));
			info[i]=separateName(info[i]);
			
			userInfo.set手机(getPhone(info[i]));
			
			info[i]=separatePhone(info[i]);
			//System.out.println(info[i]);
			//System.out.println();
			userInfo.set地址(getAddress(info[i]));
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
		//把名字从info里删除
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
		return "手机号丢失";
	}
	private String separatePhone(String info){
		return info.replaceAll("\\d{11}","");
		
		
	}
	private List<String> getAddress(String info){ 
		 List<String> addressList=new ArrayList<>();
		 String regex="(?<province>[^省]+自治区|.*?省|.*?行政区)?(?<city>[^市]+自治州|.*?地区|.*?行政单位|.+盟|市辖区|.*?市)?(?<county>[^县]+县|.+?区|.+市|.+旗|.+海域|.+岛)?(?<town>[^区]+镇|.+街道)?(?<village>.*)";
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
		 
		//直辖市的情况
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
