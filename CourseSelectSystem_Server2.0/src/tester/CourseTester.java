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
		//������ӿγ̹���
		data.add("ѧ��רҵ�γ� ;10006;������ ;����;1;�ڶ�ѧ�� ;���ڶ�3-4�� ;������;����;��;��" );
		course=data.read();		
		for(int i=0;i<course.size();i++){
			System.out.println(course.get(i));
		}
		data.add("ѧ��רҵ�γ� ;10006;������ ;����;1;�ڶ�ѧ�� ;���ڶ�3-4�� ;������;����;��;��" );
		course=data.read();		
		for(int i=0;i<course.size();i++){
			System.out.println(course.get(i));
		}
		
		//���԰��տγ̺ſγ̲��ҹ���
		String temp=data.find("10002");
		System.out.println(temp);
		temp=data.find("10008");
		System.out.println(temp);
		
		//���Ը������ƿγ���Ϣ�γ̹���
		String newCourse="ѧ��רҵ�γ� ;10003;���ѧԺ ;������������1;4;����ѧ�� ;���ڶ�3-4�� ;��2-303;����,10001���۶�,10004 ;�������������㡷;�� ";
		data.update(newCourse);	
		course=data.read();		
		for(int i=0;i<course.size();i++){
			System.out.println(course.get(i));
		}
	}
	
		
}
