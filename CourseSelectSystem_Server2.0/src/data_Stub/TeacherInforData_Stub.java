package data_Stub;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import data.TeacherInforDataService;


public class TeacherInforData_Stub extends UnicastRemoteObject implements TeacherInforDataService{

	protected TeacherInforData_Stub() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<String> read() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		list.add("工号；姓名；密码；院系");
		
		return list;
	}

	@Override
	public String find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return "工号；姓名；密码；院系";
	}

	@Override
	public Boolean update(String input) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
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
