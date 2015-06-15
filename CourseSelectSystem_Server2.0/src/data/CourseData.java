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
 * ������CourseData 
 * ���ܣ�ʵ��CourseDataService�ӿ�
 * 
 */
public class CourseData extends UnicastRemoteObject implements CourseDataService{
	public CourseData() throws RemoteException{};

	/*
	 * ��������read
	 * ���ܣ������γ�
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
	 * ��������add
	 * ���ܣ������γ�
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
		 
		 //��ó���һ�����棬��ʾ�γ��Ѵ��ڣ�δ��ӳ�
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
				//���ļ�д��
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
	 * ��������find
	 * ���ܣ����ҿγ�
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
		 * ��������update
		 * ���ܣ����¿γ�
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
				//���ļ�д��
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
