package tester;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import data.InstitutePlanData;



public class InstitutePlanTester {

	
	       
		   public static void main(String[] args) throws IOException{
			InstitutePlanData data=new InstitutePlanData();
	       ArrayList<String> infor= new ArrayList<String>();
//			TeacherInforTester a = null;
//			a.run();
//
//		}
//		
//		 void run() throws IOException{
			 //���Բ鿴��ѧ�ƻ�����
			infor=data.read();		
			for(int i=0;i<infor.size();i++){
				System.out.println(infor.get(i));
			}
		
			//�����ƶ���ѧ�ƻ�����
			data.write("���ѧԺ;18;22;25;15;20;42");
			data.write("ҽѧԺ;18;22;25;15;20;42");
			infor=data.read();		
			for(int i=0;i<infor.size();i++){
				System.out.println(infor.get(i));
			}
					
			
	}

	
}
