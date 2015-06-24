package data;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface SchoolPlanDataService extends Remote{
	ArrayList<String> read() throws RemoteException;
	Boolean write(String input) throws RemoteException;
}
