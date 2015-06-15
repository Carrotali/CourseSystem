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
 * ������OverallPolicyData 
 * ���ܣ�ʵ��OverallPolicyDataService�ӿ�
 * 
 */
public class OverallPolicyData extends UnicastRemoteObject implements OverallPolicyDataService{

	public OverallPolicyData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	/*
	 * ��������read
	 * ���ܣ���������
	 * (non-Javadoc)
	 * @see busninesslogic.OverallPolicyDataService#read()
	 */
	@Override
	public ArrayList<String>read() throws RemoteException {	
			File institutePlanList = new File("overPolicy");
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
			
		
			return list;	
		}

	/*
	 * ��������write
	 * ���ܣ�д�����
	 * (non-Javadoc)
	 * @see busninesslogic.OverallPolicyDataService#write()
	 */
	@Override
	public Boolean write(String[] input) throws RemoteException {
		Boolean written=true;
		FileWriter fw = null;
		try {
			fw = new FileWriter("overPolicy");
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try{
		for (int j = 0; j < input.length ; j++) {
		//	System.out.println(list.get(j));
			fw.write(input[j]+"\n");
			//���ļ�д��
		}
		} catch (FileNotFoundException e1) {
			System.out.println("No file found");
			written = false;
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return written;
	}

	}


