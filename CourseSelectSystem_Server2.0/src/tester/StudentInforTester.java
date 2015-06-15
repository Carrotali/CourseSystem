package tester;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import data.StudentInforData;

public class StudentInforTester {

	
	      
	       static ArrayList<String> infor= new ArrayList<String>();
		   public static void main(String[] args) throws IOException{
			 
			StudentInforTester a =new StudentInforTester();
			a.run();

		}
		
		 void run() throws IOException{
			 StudentInforData data=new StudentInforData();
			infor=data.read();		
			for(int i=0;i<infor.size();i++){
				System.out.println(infor.get(i));
			}
			//测试查找学生信息功能
	//		System.out.println("测试查找学生信息功能");
			String temp=data.find("121200001" );
			System.out.println(temp);
			temp=data.find("121200008" );
			System.out.println(temp);
			
			//测试更新学生信息功能
			data.update("1200003;王五;000000;软件学院;3.9;未达到毕业资格;不可退学");
			infor=data.read();		
			for(int i=0;i<infor.size();i++){
				System.out.println(infor.get(i));
			}
					
			
	}

	
}
