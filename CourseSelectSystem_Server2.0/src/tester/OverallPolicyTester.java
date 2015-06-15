package tester;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import data.OverallPolicyData;

public class OverallPolicyTester {

	
	      
		   public static void main(String[] args) throws IOException{
			 OverallPolicyData data=new OverallPolicyData();
	       ArrayList<String> infor= new ArrayList<String>();
			 //测试查看教学计划功能
			infor=data.read();		
			for(int i=0;i<infor.size();i++){
				System.out.println(infor.get(i));
			}
		
			//测试制定教学计划功能
			String temp[]={"学科专业课程;38-45;2-8学期","专业选修课程;12-22;3-8学期","跨专业选修课程;5-10;3-8学期",
			"公共选修课程;7-8;3-8学期","第二课堂;7-12;3-8学期","毕业论文设计;8-10;7-8学期"};



			data.write(temp);
		
			infor=data.read();		
			for(int i=0;i<infor.size();i++){
				System.out.println(infor.get(i));
			}
					
			
	}

	
}
