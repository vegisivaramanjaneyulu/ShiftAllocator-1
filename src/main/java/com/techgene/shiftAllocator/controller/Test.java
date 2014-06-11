package com.techgene.shiftAllocator.controller;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class Test {

	/**
	 * @param args
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
//		List<String> empNames = new ArrayList<String>();
//		empNames.add("pavan");
//		empNames.add("sampath");
//		String[] s=new String[empNames.size()];
//				s=empNames.toArray(s);
//		for(String str:s){
//			System.out.println(str);
//		}
//		
String date="2014-22-08";
String dt[]=date.split("-");
System.out.println(dt[1]);
	}

}
