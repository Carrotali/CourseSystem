package tester;

import java.io.IOException;
import java.util.ArrayList;

import data.SelectCourseData;



public class SelectRecordTester {
	 
	public static void main(String[] args) throws IOException{
		SelectCourseData data=new SelectCourseData();
     ArrayList<String> selectRecord= new ArrayList<String>();
//		SelectRecordTester a = null;
//		a.run();
//		
//	}
//	
//	 void run() throws IOException{
		//���Բ鿴ѡ�μ�¼����
		selectRecord=data.read();	
		for(int i=0;i<selectRecord.size();i++){
			System.out.println(selectRecord.get(i));
		}
		//�������ѡ�μ�¼����
		data.add("121200001;10001;��");
		data.add("121200021;10004;��");
		selectRecord=data.read();	
		for(int i=0;i<selectRecord.size();i++){
			System.out.println(selectRecord.get(i));
		}
		//����ɾ��ѡ�μ�¼����
		data.delete("121200021;10004;��");
		selectRecord=data.read();	
		for(int i=0;i<selectRecord.size();i++){
			System.out.println(selectRecord.get(i));
		}
		//���ԵǼǳɼ�����
		data.setScore("121200004;10001;82");
		selectRecord=data.read();	
		for(int i=0;i<selectRecord.size();i++){
			System.out.println(selectRecord.get(i));
		}
	 }
}
