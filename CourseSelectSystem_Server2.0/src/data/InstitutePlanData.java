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
 * 类名：InstitutePlanData 
 * 功能：实现InstitutePlanDataService接口
 * 
 */

public class InstitutePlanData extends UnicastRemoteObject implements InstitutePlanDataService {

	public InstitutePlanData() throws RemoteException {
	}
	/*
	 * 方法名：read
	 * 功能：读出计划
	 * (non-Javadoc)
	 * @see busninesslogic.InstitutePlanDataService#read()
	 */
	public ArrayList<String> read() throws RemoteException {
		File institutePlanList = new File("institutePlan");
		ArrayList<String> list=new ArrayList<String>();
		try {
		BufferedReader reader=new BufferedReader(new FileReader(institutePlanList));
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
	 * 方法名：write
	 * 功能：写入计划
	 * (non-Javadoc)
	 * @see busninesslogic.InstitutePlanDataService#write()
	 */
	public Boolean write(String input) throws RemoteException {
		Boolean isUpdate = false;
		BufferedReader reader = null;
		File institutePlanList = new File("institutePlan");
		ArrayList<String> list=new ArrayList<String>();
		try {
		reader=new BufferedReader(new FileReader(institutePlanList));
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
		
		//比较input的第一项即院系
		
		String[] courseInfor = input.split(";");
		 for(int i = 0;i<list.size();i++){
				String[] temp = list.get(i).split(";");
				if(temp[0].equals(courseInfor[0])){
					list.remove(i);
					list.add(input);
					isUpdate = true;  
					break;
				}
			}	

		if(isUpdate==false){
			//System.out.print("The plan existed already")
			list.add(input);
			isUpdate = true;
		}
		
		FileWriter fw = null;
		try {
			fw = new FileWriter("institutePlan");
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		for (int j = 0; j < list.size(); j++) {
		//	System.out.println(list.get(j));
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
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isUpdate;
	}



}
