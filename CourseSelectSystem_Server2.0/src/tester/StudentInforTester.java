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
			//���Բ���ѧ����Ϣ����
	//		System.out.println("���Բ���ѧ����Ϣ����");
			String temp=data.find("121200001" );
			System.out.println(temp);
			temp=data.find("121200008" );
			System.out.println(temp);
			
			//���Ը���ѧ����Ϣ����
			data.update("1200003;����;000000;���ѧԺ;3.9;δ�ﵽ��ҵ�ʸ�;������ѧ");
			infor=data.read();		
			for(int i=0;i<infor.size();i++){
				System.out.println(infor.get(i));
			}
					
			
	}

	
}
