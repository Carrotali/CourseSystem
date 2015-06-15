package tester;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import data.CourseData;


public class CourseTester{
       
	public static void main(String[] args) throws IOException{
		CourseData data=new CourseData();
	    ArrayList<String> course= new ArrayList<String>();
		
		CourseTester a = new CourseTester();
//		a.run();
//		//course=data.read();
//			
//	}
//	
//	 void run() throws IOException{
		course=data.read();		
		for(int i=0;i<course.size();i++){
			System.out.println(course.get(i));
		}
		//测试添加课程功能
		data.add("学科专业课程 ;10006;体育部 ;体育;1;第二学期 ;星期二3-4节 ;体育馆;不详;无;无" );
		course=data.read();		
		for(int i=0;i<course.size();i++){
			System.out.println(course.get(i));
		}
		data.add("学科专业课程 ;10006;体育部 ;体育;1;第二学期 ;星期二3-4节 ;体育馆;不详;无;无" );
		course=data.read();		
		for(int i=0;i<course.size();i++){
			System.out.println(course.get(i));
		}
		
		//测试按照课程号课程查找功能
		String temp=data.find("10002");
		System.out.println(temp);
		temp=data.find("10008");
		System.out.println(temp);
		
		//测试更新完善课程信息课程功能
		String newCourse="学科专业课程 ;10003;软件学院 ;软件工程与计算1;4;第三学期 ;星期二3-4节 ;仙2-303;刘钦,10001、邵栋,10004 ;《软件工程与计算》;无 ";
		data.update(newCourse);	
		course=data.read();		
		for(int i=0;i<course.size();i++){
			System.out.println(course.get(i));
		}
	}
	
		
}
