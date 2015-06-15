package data;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface SchoolTeacherDataService extends Remote{
	String find(String id) throws RemoteException;
	Boolean update(String input) throws RemoteException;
	Boolean delete(String input) throws RemoteException;
	ArrayList<String> read() throws RemoteException;
	Boolean add(String input) throws RemoteException;
}
