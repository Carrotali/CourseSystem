package data_Stub;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import data.InstituteTeacherDataService;

public class InstituteTeacherData_Stub extends UnicastRemoteObject implements InstituteTeacherDataService{
	protected InstituteTeacherData_Stub() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public String find(String id) throws RemoteException{
		// TODO Auto-generated method stub
		return "工号；姓名；密码；院系";
	}

	public Boolean update(String input) throws RemoteException{
		return true;
	}

	@Override
	public ArrayList<String> read() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(String input) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean add(String input) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
