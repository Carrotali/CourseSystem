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
		return "ѧ��;����;����;ѧԺ;ѧ�ּ�;��ҵ�ʸ����;��ѧ�ʸ����";
	}

	@Override
	public ArrayList<String> read() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		list.add("ѧ�ţ����������룻ѧԺ��ѧ�ּ�����ҵ�ʸ���ˣ���ѧ�ʸ����");
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
