package tester;


	import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import data.SchoolTeacherData;

	


	public class SchoolTeacherTester {

		
		      
			   public static void main(String[] args) throws IOException{
				 SchoolTeacherData data=new SchoolTeacherData();
		       ArrayList<String> infor= new ArrayList<String>();
//				TeacherInforTester a = null;
//				a.run();
	//
//			}
//			
//			 void run() throws IOException{
			
				//���Բ���ѧУ������ʦ��Ϣ����
				String temp=data.find("30002" );
				System.out.println(temp);
				temp=data.find("20002" );
				System.out.println(temp);
				
				//���Ը���ѧУ������ʦ��Ϣ����
				data.update("30002;�����;000000");
				temp=data.find("30002" );
				System.out.println(temp);
		}
	}
