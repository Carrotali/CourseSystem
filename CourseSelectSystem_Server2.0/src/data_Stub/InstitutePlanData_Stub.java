package data_Stub;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import data.InstitutePlanDataService;


public class InstitutePlanData_Stub extends UnicastRemoteObject implements InstitutePlanDataService {

	public InstitutePlanData_Stub() throws RemoteException {
	}

	public ArrayList<String> read() throws RemoteException {
		ArrayList<String> list = new ArrayList<String>();
		list.add("院系；第一学年学分；第二学年学分；第三学年学分；第四学年学分；准入学分；准出学分");
		return list;	
	}

	public Boolean write(String input) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

}
