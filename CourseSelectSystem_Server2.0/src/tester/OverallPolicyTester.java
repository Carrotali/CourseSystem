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
			 //���Բ鿴��ѧ�ƻ�����
			infor=data.read();		
			for(int i=0;i<infor.size();i++){
				System.out.println(infor.get(i));
			}
		
			//�����ƶ���ѧ�ƻ�����
			String temp[]={"ѧ��רҵ�γ�;38-45;2-8ѧ��","רҵѡ�޿γ�;12-22;3-8ѧ��","��רҵѡ�޿γ�;5-10;3-8ѧ��",
			"����ѡ�޿γ�;7-8;3-8ѧ��","�ڶ�����;7-12;3-8ѧ��","��ҵ�������;8-10;7-8ѧ��"};



			data.write(temp);
		
			infor=data.read();		
			for(int i=0;i<infor.size();i++){
				System.out.println(infor.get(i));
			}
					
			
	}

	
}
