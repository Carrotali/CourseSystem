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
 * 类名：SelectCourseData 
 * 功能：实现SelectCourseDataService接口
 * 
 */
public class SelectCourseData extends UnicastRemoteObject implements SelectCourseDataService{

	public SelectCourseData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	/*
	 * 方法名：read()
	 * 功能：读出数据
	 * (non-Javadoc)
	 * @see busninesslogic.SelectCourseDataService#read()()
	 */
	@Override
	public ArrayList<String> read() throws RemoteException {
		File courseList = new File("selectRecord");
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
		
	//	System.out.println(list.size());
		return list;	
	}
	/*
	 * 方法名：add()
	 * 功能：新增数据
	 * (non-Javadoc)
	 * @see busninesslogic.SelectCourseDataService#add()()
	 */
	@Override
	public Boolean add(String input) throws RemoteException {
		Boolean isAdded = true;
		BufferedReader reader = null;
		File courseList = new File("selectRecord");
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
		
		String[] selectRecord = input.split(";");
		 for(String str:list){
				String[] temp = str.split(";");
				if((temp[0].equals(selectRecord[0]))&&(temp[1].equals(selectRecord[1]))){
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
			//System.out.print("The existed already");
			list.add(input);
			FileWriter fw = null;
			try {
				fw = new FileWriter("selectRecord");
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
	 * 方法名：delete
	 * 功能：删除数据
	 * (non-Javadoc)
	 * @see busninesslogic.SelectCourseDataService#delete()
	 */
	@Override
	public Boolean delete(String input) throws RemoteException {
		Boolean isExist=false;
		BufferedReader reader = null;
		File courseList = new File("selectRecord");
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
		String[] selectRecord = input.split(";");
		int i = 0;
		
		 for(i=0 ; i < list.size() ; i++){			
				String[] temp = list.get(i).split(";");
				if((temp[0].equals(selectRecord[0]))&&(temp[1].equals(selectRecord[1]))){
					list.remove(i);					
					isExist = true;
					break;
				}
			}
		 
		 FileWriter fw = null;
			try {
				fw = new FileWriter("selectRecord");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int j = 0; j < list.size(); j++) {
//				System.out.println(list.get(j));
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
	/*
	 * 方法名：setScore
	 * 功能：输入分数
	 * (non-Javadoc)
	 * @see busninesslogic.SelectCourseDataService#setScore()
	 */
	
	@Override
	public Boolean setScore(String input) throws RemoteException {
		Boolean isExist=false;
		BufferedReader reader = null;
		File courseList = new File("selectRecord");
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
		String[] selectRecord = input.split(";");
		int i = 0;
		
		 for(i=0 ; i < list.size() ; i++){			
				String[] temp = list.get(i).split(";");
				if((temp[0].equals(selectRecord[0]))&&(temp[1].equals(selectRecord[1]))){
					list.remove(i);
					list.add(input);
					isExist = true;
					break;
				}
			}	
		 if(isExist==true){
		 FileWriter fw = null;
			try {
				fw = new FileWriter("selectRecord");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int j = 0; j < list.size(); j++) {
//				System.out.println(list.get(j));
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
		 }
		 else{
			 System.out.println("The course did not exist");
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
