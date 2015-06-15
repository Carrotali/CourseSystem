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
		list.add("（学科专业课程）建议学分；开设学期");
		list.add("（专业选修课程）建议学分；开设学期");
		list.add("（跨专业选修课程）建议学分；开设学期");
		list.add("（公共选修课程）建议学分；开设学期");
		list.add("（第二课堂）建议学分；开设学期");
		list.add("（毕业论文设计）建议学分；开设学期");
		
		return list;
	}

	@Override
	public Boolean write(String[] input) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

}
