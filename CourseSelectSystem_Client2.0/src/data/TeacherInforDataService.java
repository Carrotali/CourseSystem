package data;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface TeacherInforDataService extends Remote{
	ArrayList<String> read() throws RemoteException; 
	String find(String id) throws RemoteException;
	Boolean update(String input) throws RemoteException;
	Boolean delete(String input) throws RemoteException;
	Boolean add(String input) throws RemoteException;
}
