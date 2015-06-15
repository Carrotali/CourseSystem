package data_Stub;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import data.CourseDataService;

public class CourseData_Stub extends UnicastRemoteObject implements CourseDataService{
	public CourseData_Stub() throws RemoteException{};
	public ArrayList<String> read() throws RemoteException{
		ArrayList<String> list = new ArrayList<String>();
		list.add("ͨʶͨ�ޣ�0001������Ժϵ���γ����ƣ�ѧ�֣�����ѧ�ڣ��Ͽ�ʱ�䣻�Ͽεص㣻�ο���ʦ���̲ģ��ο���Ŀ");
		list.add("ѧ��רҵ��0002������Ժϵ���γ����ƣ�ѧ�֣�����ѧ�ڣ��Ͽ�ʱ�䣻�Ͽεص㣻�ο���ʦ���̲ģ��ο���Ŀ");
		list.add("��רҵ�γ̣�0003������Ժϵ���γ����ƣ�ѧ�֣�����ѧ�ڣ��Ͽ�ʱ�䣻�Ͽεص㣻�ο���ʦ���̲ģ��ο���Ŀ");
		return list;	
		
	}

	public Boolean add(String input) throws RemoteException{
		return true;
	}
	public String find(String courseNo) throws RemoteException{
		return "ͨʶͨ�ޣ�0004������Ժϵ���γ����ƣ�ѧ�֣�����ѧ�ڣ��Ͽ�ʱ�䣻�Ͽεص㣻�ο���ʦ���̲ģ��ο���Ŀ";
	}
	public Boolean update(String input) throws RemoteException{
		return true;
	}
}
