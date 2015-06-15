package data;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface CourseDataService extends Remote{
	String find(String courseNo) throws RemoteException;
	ArrayList<String> read() throws RemoteException;
	Boolean add(String input) throws RemoteException;
	Boolean update(String input) throws RemoteException;
}
