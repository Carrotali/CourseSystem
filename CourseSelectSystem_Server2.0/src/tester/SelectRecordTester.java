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
		//测试查看选课记录功能
		selectRecord=data.read();	
		for(int i=0;i<selectRecord.size();i++){
			System.out.println(selectRecord.get(i));
		}
		//测试添加选课记录功能
		data.add("121200001;10001;无");
		data.add("121200021;10004;无");
		selectRecord=data.read();	
		for(int i=0;i<selectRecord.size();i++){
			System.out.println(selectRecord.get(i));
		}
		//测试删除选课记录功能
		data.delete("121200021;10004;无");
		selectRecord=data.read();	
		for(int i=0;i<selectRecord.size();i++){
			System.out.println(selectRecord.get(i));
		}
		//测试登记成绩功能
		data.setScore("121200004;10001;82");
		selectRecord=data.read();	
		for(int i=0;i<selectRecord.size();i++){
			System.out.println(selectRecord.get(i));
		}
	 }
}
