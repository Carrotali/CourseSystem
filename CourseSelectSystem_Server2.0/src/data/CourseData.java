package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
/*
 * 类名：CourseData 
 * 功能：实现CourseDataService接口
 * 
 */
public class CourseData extends UnicastRemoteObject implements CourseDataService{
	public CourseData() throws RemoteException{};

	/*
	 * 方法名：read
	 * 功能：读出课程
	 * (non-Javadoc)
	 * @see busninesslogic.CourseDataService#read()
	 */
	public ArrayList<String> read() throws RemoteException{
		File courseList = new File("courselist");
		ArrayList<String> list=new ArrayList<String>();
		try {
		BufferedReader reader=new BufferedReader(new FileReader(courseList));
		String line=null;
		while((line=reader.readLine())!=null){
		list.add(line);
        }		
		} catch (FileNotFoundException e1) {
		System.out.println("No file found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return list;	
	}
	
	/*
	 * 方法名：add
	 * 功能：新增课程
	 * (non-Javadoc)
	 * @see busninesslogic.CourseDataService#add()
	 */
	public Boolean add(String input) throws RemoteException{
		Boolean isAdded = true;
		BufferedReader reader = null;
		File courseList = new File("courseList");
		ArrayList<String> list=new ArrayList<String>();
		try {
		reader=new BufferedReader(new FileReader(courseList));
		String line=null;
		while((line=reader.readLine())!=null){
		list.add(line);
        }		
		} catch (FileNotFoundException e1) {
		System.out.println("No file found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String[] courseInfor = input.split(";");
		 for(String str:list){
				String[] temp = str.split(";");
				if(temp[1].equals(courseInfor[1])){
					isAdded = false;  
					break;
				}
			}	
	//	System.out.print(isAdded) ;
		 
		 //最好出现一个界面，显示课程已存在，未添加成
		if(isAdded==false){
			System.out.print("The course existed already");
		}
		else{
			list.add(input);
			FileWriter fw = null;
			try {
				fw = new FileWriter("courseList");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int j = 0; j < list.size(); j++) {
				System.out.println(list.get(j));
				try {
					fw.write(list.get(j)+"\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//将文件写回
			}
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return isAdded;
	}
	
	/*
	 * 方法名：find
	 * 功能：查找课程
	 * (non-Javadoc)
	 * @see busninesslogic.CourseDataService#find()
	 */	public String find(String courseNo) throws RemoteException{
		Boolean isExist=false;
		BufferedReader reader = null;
		File courseList = new File("courseList");
		ArrayList<String> list=new ArrayList<String>();
		try {
		reader=new BufferedReader(new FileReader(courseList));
		String line=null;
		while((line=reader.readLine())!=null){
		list.add(line);
        }		
		} catch (FileNotFoundException e1) {
		System.out.println("No file found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int i = 0;
		 for(i=0 ; i < list.size() ; i++){			
				String[] temp = list.get(i).split(";");
				if(temp[1].equals(courseNo)){
					isExist = true; 
					break;
				}
			}	
		if(isExist== true){
			return list.get(i);
		}
		else{
		return null;
		}
	}
	
	 /*
		 * 方法名：update
		 * 功能：更新课程
		 * (non-Javadoc)
		 * @see busninesslogic.CourseDataService#update()
		 */	public Boolean update(String input) throws RemoteException{
		Boolean isExist=false;
		BufferedReader reader = null;
		File courseList = new File("courseList");
		ArrayList<String> list=new ArrayList<String>();
		try {
		reader=new BufferedReader(new FileReader(courseList));
		String line=null;
		while((line=reader.readLine())!=null){
		list.add(line);
        }		
		} catch (FileNotFoundException e1) {
		System.out.println("No file found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] courseInfor = input.split(";");
		int i = 0;
		
		 for(i=0 ; i < list.size() ; i++){			
				String[] temp = list.get(i).split(";");
				if(temp[1].equals(courseInfor[1])){
					list.remove(i);
					list.add(input);
					isExist = true;
					break;
				}
			}	
		 FileWriter fw = null;
			try {
				fw = new FileWriter("courseList");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int j = 0; j < list.size(); j++) {
				System.out.println(list.get(j));
				try {
					fw.write(list.get(j)+"\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//将文件写回
			}
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return isExist;
		
	}


}
