
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
				 //���Բ���Ժϵ������ʦ��Ϣ����
					String temp=data.find("30002" );
					System.out.println(temp);
					temp=data.find("20002" );
					System.out.println(temp);
					
					//���Ը���Ժϵ������ʦ��Ϣ����
					data.update("20002;��׿;000000;��ѧϵ");
					temp=data.find("20002" );
					System.out.println(temp);				
		}
	}
