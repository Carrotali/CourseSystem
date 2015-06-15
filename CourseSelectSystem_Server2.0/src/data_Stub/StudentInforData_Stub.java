package data_Stub;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import data.StudentInforDataService;


public class StudentInforData_Stub extends UnicastRemoteObject implements StudentInforDataService{

	protected StudentInforData_Stub() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return "学号;姓名;密码;学院;学分绩;毕业资格审核;退学资格审核";
	}

	@Override
	public ArrayList<String> read() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		list.add("学号；姓名；密码；学院；学分绩；毕业资格审核；退学资格审核");
		return list;
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
