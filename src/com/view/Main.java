package com.view;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import com.manage.Util;

import java.io.File;  
import java.io.InputStreamReader;  
import java.io.BufferedReader;  
import java.io.BufferedWriter;  
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.manage.*;

public class Main {

	private static AddressView addressview;
	public static void main(String[] args)  throws IOException{
		// TODO Auto-generated method stub
		  /*addressview =new AddressView();
		  addressview.view();*/
		   String total="";
		   //String fileName ="D:\\test.txt";
		   String fileName =args[0];
	        //FileReader fileReader = new FileReader(fileName);

	        //BufferedReader bufferedReader = new BufferedReader(fileReader);

	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "utf-8"));  
        
	        String line =bufferedReader.readLine();

	        while (line!=null){
	        	
	            //System.out.println(line);
	            total=total+line+"\n";
	            line = bufferedReader.readLine();
	        }
	       Util util=new Util();
	        bufferedReader.close();
	        //System.out.println(total);
	       //util.produceJsonFile(util.separateTotalInfo(total),"1");
			util.produceJsonFile(util.separateTotalInfo(total),args[1]);
	        //fileReader.close();

	    
	}

}
