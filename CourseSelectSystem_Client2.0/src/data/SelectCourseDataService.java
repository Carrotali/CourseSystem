package data;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface SelectCourseDataService extends Remote{
	ArrayList<String> read() throws RemoteException; 
	Boolean add(String input) throws RemoteException;
	Boolean delete(String input) throws RemoteException;
	Boolean setScore(String input) throws RemoteException;
}
