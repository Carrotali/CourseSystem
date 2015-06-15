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
 * 类名：StudentInforData 
 * 功能：实现StudentInforDataService接口
 * 
 */
public class StudentInforData extends UnicastRemoteObject implements StudentInforDataService{

	public StudentInforData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	/*
	 * 方法名：delete
	 * 功能：删除学生
	 * (non-Javadoc)
	 * @see busninesslogic.StudentInforDataService#delete()
	 */
	@Override
	public Boolean delete(String input) throws RemoteException {
		Boolean isExist=false;
		BufferedReader reader = null;
		File userList = new File("studentInfor");
		ArrayList<String> list=new ArrayList<String>();
		try {
		reader=new BufferedReader(new FileReader(userList));
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
			 String temp = list.get(i).split(";")[0];
				if(temp.equals(input)){
					list.remove(i);
					isExist = true;
					break;
				}
	     }	
		 FileWriter fw = null;
			try {
				fw = new FileWriter("studentInfor");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int j = 0; j < list.size(); j++) {
//					System.out.println(list.get(j));
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
	 * 方法名：find()
	 * 功能：查找学生
	 * (non-Javadoc)
	 * @see busninesslogic.StudentInforDataService#find()()
	 */
	@Override
	public String find(String id) throws RemoteException {
		Boolean isExist=false;
		BufferedReader reader = null;
		File userList = new File("studentInfor");
		ArrayList<String> list=new ArrayList<String>();
		try {
		reader=new BufferedReader(new FileReader(userList));
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
				if(temp[0].equals(id)){
					isExist = true; 
					break;
				}
			}	
		if(isExist== true){
			return list.get(i);
		}
		else{
		return null;
		}	}
	/*
	 * 方法名：read()
	 * 功能：读出学生数据
	 * (non-Javadoc)
	 * @see busninesslogic.StudentInforDataService#read()()
	 */
	@Override
	public ArrayList<String> read() throws RemoteException {
		File courseList = new File("studentInfor");
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

	@Override
	/*
	 * 方法名：update()
	 * 功能：更新学生数据
	 * (non-Javadoc)
	 * @see busninesslogic.StudentInforDataService#update()()
	 */	
	public Boolean update(String input) throws RemoteException {
		Boolean isExist=false;
		BufferedReader reader = null;
		File userList = new File("studentInfor");
		ArrayList<String> list=new ArrayList<String>();
		try {
		reader=new BufferedReader(new FileReader(userList));
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
		String[] userInfor = input.split(";");
		int i = 0;
		
		 for(i=0 ; i < list.size() ; i++){			
				String[] temp = list.get(i).split(";");
				if(temp[0].equals(userInfor[0])){
					list.remove(i);
					list.add(input);
					isExist = true;
					break;
				}
			}	
		 FileWriter fw = null;
			try {
				fw = new FileWriter("studentInfor");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for (int j = 0; j < list.size(); j++) {
//					System.out.println(list.get(j));
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
	 * 方法名：add()
	 * 功能：新增学生数据
	 * (non-Javadoc)
	 * @see busninesslogic.StudentInforDataService#add()()
	 */
	@Override
	public Boolean add(String input) throws RemoteException {
		String[] courseInfor = input.split(";");
		Boolean isAdded = true;
		BufferedReader reader = null;
		File courseList = new File("studentInfor");
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
		
		 for(String str:list){
				String[] temp = str.split(";");
				if(temp[0].equals(courseInfor[0])){
					isAdded = false;  
					break;
				}
			}		 
		 //最好出现一个界面，显示课程已存在，未添加成
		if(isAdded==false){
//			System.out.print("The course existed already");
		}
		else{
			list.add(input);
			FileWriter fw = null;
			try {
				fw = new FileWriter("studentInfor");
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


}
