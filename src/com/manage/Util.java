package com.manage;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.google.gson.*;


public class Util {
	
	public TotalInfo separateTotalInfo(String totalAddress){
		TotalInfo totalInfo=new TotalInfo();
		String[] info = totalAddress.split(".\n");
		System.out.print(info.length);
		
		List<UserInfo> userList=new ArrayList<>();
		for(int i=0;i<info.length;i++){
			
			//删除第一个字符是回车的问题
			if(String.valueOf(info[i].charAt(0)).equals("\n")){
				info[i]=info[i].substring(1,info[i].length());
			}
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
			userList.add(userInfo);
		}
		totalInfo.setAddressBook(userList);
		return totalInfo;
		//produceJsonFile(totalInfo);
		/*
		Gson gson=new Gson();
		
		String res=gson.toJson(totalInfo);
		System.out.println(res);
	*/
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
		 //String regex="(?<province>[^省]+自治区|.*?省|.*?行政区)?(?<city>[^市]+自治州|.*?地区|.*?行政单位|.+盟|市辖区|.*?市)?(?<county>[^县]+县|.+?区|.+市|.+旗|.+海域|.+岛)?(?<town>[^区]+镇|.+街道)?(?<village>.*)";
		 String regex="(?<province>[^省]+自治区|.*?省|.*?行政区)?(?<city>[^市]+自治州|.*?地区|.*?行政单位|.+盟|市辖区|.*?市)?(?<dist>[^县]+县|.+?区|.+市|.+旗|.+海域|.+岛)?(?<town>[^区]+镇|.+街道|.+乡|.+县)?(?<village>[^村]+路|.+街|.+巷|.+道|.+段|.+队|.+弄|.+胡同|.+村|.+委会|.+开发区)?(?<number>[^区号]+号)?(?<road>.*)";
			
		 Pattern pattern=Pattern.compile(regex);
		 Matcher matcher=pattern.matcher(info);
		 String province=null,city=null,dist=null,town=null,village=null,number=null,road=null;
		 if(matcher.find()){
	            
	            province=matcher.group("province");
	            addressList.add(province==null?"":province.trim());
	          
	            city=matcher.group("city");
	            addressList.add(city==null?"":city.trim());
	            
	            dist=matcher.group("dist");
	            addressList.add(dist==null?"":dist.trim());
	            
	            town=matcher.group("town");
	            addressList.add(town==null?"":town.trim());
	            
	            village=matcher.group("village");
	            addressList.add(village==null?"":village.trim());  
	            //add
	           number=matcher.group("number");
	            addressList.add(number==null?"":number.trim());  
	            
	            road=matcher.group("road");
	            addressList.add(road==null?"":road.trim());  
	          
	           
	        }
		 
		//直辖市的情况
		 if(addressList.get(0).equals("")&&!addressList.get(1).equals("")){
  		   String pro=addressList.get(1).substring(0,2);
  		   addressList.set(0,pro);
  	   	 }
		 System.out.println(addressList.size());
		 for(int i = 0; i < 7; i++)
         {   
			
      	    String str=addressList.get(i);
            System.out.println(str);
         }
		return addressList;
	}
	public void produceJsonFile(TotalInfo totalInfo){
		
	//info[i]=info[i].substring(0,info[i].length()-1);
		Gson gson=new Gson();
		
		String res=gson.toJson(totalInfo);
		res=res.substring(15,res.length()-1);
		System.out.println(res);
		
		String filePath="D:\\2.txt";
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(filePath);
			fos.write(res.getBytes());
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
