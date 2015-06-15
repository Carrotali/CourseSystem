package data_Stub;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import data.SelectCourseDataService;

public class SelectCourseData_Stub extends UnicastRemoteObject implements SelectCourseDataService{

	protected SelectCourseData_Stub() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<String> read() throws RemoteException {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Ñ§ºÅ£»¿Î³ÌºÅ£»³É¼¨");
		
		return list;
	}

	@Override
	public Boolean add(String input) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Boolean delete(String input) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Boolean setScore(String input) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

}
