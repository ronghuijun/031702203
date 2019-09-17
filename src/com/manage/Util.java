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
		//System.out.print(info.length);
		
		List<UserInfo> userList=new ArrayList<>();
		for(int i=0;i<info.length;i++){
			//�жϵ�ַ�Ѷȵȼ�
			String level;
			
			//ɾ����һ���ַ��ǻس�������
			if(String.valueOf(info[i].charAt(0)).equals("\n")){
				info[i]=info[i].substring(1,info[i].length());
			}
			
			//&&info[i].endsWith(".") ��ֹ������޿ո�
			if(i==info.length-1&&info[i].endsWith(".")){
				//�������һ���ַ�.û��ɾ��������
				info[i]=info[i].substring(0,info[i].length()-1);
				//System.out.println(i+"cnsjla"+info[i]);
			}
			level=getLevel(info[i]);
			info[i]=separateLevel(info[i]);
			
			UserInfo userInfo=new UserInfo();
			
			userInfo.set����(getName(info[i]));
			info[i]=separateName(info[i]);
			
			userInfo.set�ֻ�(getPhone(info[i]));
			info[i]=separatePhone(info[i]);
			
			//System.out.println(info[i]);
			//System.out.println();
			
			userInfo.set��ַ(getAddress(level,info[i]));
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
	public String getLevel(String info){
		String []message=info.split("!");
		return message[0];
	}
	public String separateLevel(String info){
		String []message =info.split("!");
		//System.out.println(message[1]);
		return message[1];
	}
	public String getName(String info){
		String []message =info.split(",");
		//System.out.println(name[0]);
		return message[0];
	}
	public String separateName(String info){
		//�����ִ�info��ɾ��
		String []message =info.split(",");
		//System.out.println(message[1]);
		return message[1];
	}
	public String getPhone(String info){
		Pattern pattern =Pattern.compile("\\d{11}");
		Matcher matcher = pattern.matcher(info);
		while(matcher.find()){
			return matcher.group();
		}
		return "�ֻ��Ŷ�ʧ";
	}
	public String separatePhone(String info){
		return info.replaceAll("\\d{11}","");
		
		
	}
	public List<String> getAddress(String level,String info){ 
		List<String> addressList=new ArrayList<>();
		String province=null,city=null,dist=null,town=null,village=null,number=null,road=null;
		
		if(level.equals("1")){
			
			 String regex="(?<province>[^ʡ]+������|.*?ʡ|.*?������)?(?<city>[^��]+������|.*?����|.*?������λ|.+��|��Ͻ��|.*?��)?(?<dist>[^��]+��|.+?��|.+��|.+��|.+����|.+��)?(?<town>[^��]+��|.+�ֵ�)?(?<village>.*)";
			 //String regex="(?<province>[^ʡ]+������|.*?ʡ|.*?������)?(?<city>[^��]+������|.*?����|.*?������λ|.+��|��Ͻ��|.*?��)?(?<dist>[^��]+��|.+?��|.+��|.+��|.+����|.+��)?(?<town>[^��]+��|.+�ֵ�|.+��|.+��)?(?<village>[^��]+·|.+��|.+��|.+��|.+��|.+��|.+Ū|.+��ͬ|.+��|.+ί��|.+������)?(?<number>[^����]+��)?(?<road>.*)";
				
			 Pattern pattern=Pattern.compile(regex);
			 Matcher matcher=pattern.matcher(info);
			 
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
		          
		           
	        }
		}
		else{
		
			 //String regex="(?<province>[^ʡ]+������|.*?ʡ|.*?������)?(?<city>[^��]+������|.*?����|.*?������λ|.+��|��Ͻ��|.*?��)?(?<county>[^��]+��|.+?��|.+��|.+��|.+����|.+��)?(?<town>[^��]+��|.+�ֵ�)?(?<village>.*)";
			 String regex="(?<province>[^ʡ]+������|.*?ʡ|.*?������)?(?<city>[^��]+������|.*?����|.*?������λ|.+��|��Ͻ��|.*?��)?(?<dist>[^��]+��|.+?��|.+��|.+��|.+����|.+��)?(?<town>[^��]+��|.+�ֵ�|.+��|.+��)?(?<village>[^��]+·|.+��|.+��|.+��|.+��|.+��|.+Ū|.+��ͬ|.+��|.+ί��|.+������)?(?<number>[^����]+��)?(?<road>.*)";
				
			 Pattern pattern=Pattern.compile(regex);
			 Matcher matcher=pattern.matcher(info);
			 
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
		 }
		
		
		//ֱϽ�е����
		 if(addressList.get(0).equals("")&&!addressList.get(1).equals("")){
  		   String pro=addressList.get(1).substring(0,2);
  		   addressList.set(0,pro);
  	   	 }
		 
		 //System.out.println(addressList.size());
		 /*for(int i = 0; i < 7; i++)
         {   
			
      	    String str=addressList.get(i);
           // System.out.println(str);
         }*/
		return addressList;
	}
	public void produceJsonFile(TotalInfo totalInfo,String filePath){
		
	//info[i]=info[i].substring(0,info[i].length()-1);
		Gson gson=new Gson();
		
		String res=gson.toJson(totalInfo);
		res=res.substring(15,res.length()-1);
		//System.out.println(res);
		
		//String filepath="D:\\3.txt";
		String filepath=filePath;
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(filepath);
			//fos = new FileOutputStream(filePath);
			fos.write(res.getBytes());
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
