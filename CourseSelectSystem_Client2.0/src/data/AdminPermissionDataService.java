package data;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AdminPermissionDataService extends Remote{
     void setPermission(int type,String yesOrno) throws RemoteException;
     int getPermission(int type) throws RemoteException;
}
