package data_Stub;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import data.CourseDataService;

public class CourseData_Stub extends UnicastRemoteObject implements CourseDataService{
	public CourseData_Stub() throws RemoteException{};
	public ArrayList<String> read() throws RemoteException{
		ArrayList<String> list = new ArrayList<String>();
		list.add("通识通修；0001；开课院系；课程名称；学分；开设学期；上课时间；上课地点；任课老师；教材；参考书目");
		list.add("学科专业；0002；开课院系；课程名称；学分；开设学期；上课时间；上课地点；任课老师；教材；参考书目");
		list.add("跨专业课程；0003；开课院系；课程名称；学分；开设学期；上课时间；上课地点；任课老师；教材；参考书目");
		return list;	
		
	}

	public Boolean add(String input) throws RemoteException{
		return true;
	}
	public String find(String courseNo) throws RemoteException{
		return "通识通修；0004；开课院系；课程名称；学分；开设学期；上课时间；上课地点；任课老师；教材；参考书目";
	}
	public Boolean update(String input) throws RemoteException{
		return true;
	}
}
