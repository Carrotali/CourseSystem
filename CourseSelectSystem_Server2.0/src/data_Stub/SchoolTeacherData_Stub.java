package data_Stub;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import data.SchoolTeacherDataService;


public class SchoolTeacherData_Stub extends UnicastRemoteObject implements SchoolTeacherDataService {

	protected SchoolTeacherData_Stub() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return "π§∫≈£ª–’√˚£ª√‹¬Î";
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
	public ArrayList<String> read() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean add(String input) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
