package data_Stub;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import data.OverallPolicyDataService;


public class OverallPolicyData_Stub extends UnicastRemoteObject implements OverallPolicyDataService{

	protected OverallPolicyData_Stub() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<String> read() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		list.add("��ѧ��רҵ�γ̣�����ѧ�֣�����ѧ��");
		list.add("��רҵѡ�޿γ̣�����ѧ�֣�����ѧ��");
		list.add("����רҵѡ�޿γ̣�����ѧ�֣�����ѧ��");
		list.add("������ѡ�޿γ̣�����ѧ�֣�����ѧ��");
		list.add("���ڶ����ã�����ѧ�֣�����ѧ��");
		list.add("����ҵ������ƣ�����ѧ�֣�����ѧ��");
		
		return list;
	}

	@Override
	public Boolean write(String[] input) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

}
