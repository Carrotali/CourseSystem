
	package tester;

	import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import data.InstituteTeacherData;

	public class InstituteTeacherTester {

		
			   public static void main(String[] args) throws IOException{
				
		       InstituteTeacherData data = new InstituteTeacherData();
		       ArrayList<String> infor = new ArrayList<String>();
//				TeacherInforTester a = null;
//				a.run();
	//
//			}
//			
//			 void run() throws IOException{
				 //测试查找院系教务老师信息功能
					String temp=data.find("30002" );
					System.out.println(temp);
					temp=data.find("20002" );
					System.out.println(temp);
					
					//测试更新院系教务老师信息功能
					data.update("20002;陈卓;000000;数学系");
					temp=data.find("20002" );
					System.out.println(temp);				
		}
	}
