package tester;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import data.TeacherInforData;



public class TeacherInforTester {

	
	       
	       static ArrayList<String> infor= new ArrayList<String>();
	       void run() throws IOException{
	    	   TeacherInforData data=new TeacherInforData();
				infor=data.read();		
				for(int i=0;i<infor.size();i++){
					System.out.println(infor.get(i));
				}
				//测试查找任课老师信息功能
				String temp=data.find("10001" );
				System.out.println(temp);
				temp=data.find("20002" );
				System.out.println(temp);
				
				//测试更新任课老师信息功能
				data.update("10013;曹永红;000000;政府管理学院");
				infor=data.read();		
				for(int i=0;i<infor.size();i++){
					System.out.println(infor.get(i));
				}
						
				
		}
		   public static void main(String[] args) throws IOException{
			
			TeacherInforTester a = new TeacherInforTester();
			a.run();

		}
		
		

	
}
