package data;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface InstitutePlanDataService extends Remote{
	ArrayList<String> read() throws RemoteException;
	Boolean write(String input) throws RemoteException;
}
