package busninesslogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import data.*;
/*
 * 类名：TeacherBL
 * 功能：实现TeacherBLService接口
 */
public class TeacherBL implements TeacherBLService{
	/*方法名：getCourseNo
	 * 功能：得到课程号
	 * (non-Javadoc)
	 * @see busninesslogic.TeacherBLService#getCourseNo(java.lang.String)
	 */
	public String[] getCourseNo(String id) {
		ArrayList<String> findList = new ArrayList<String>();
		ArrayList<String> courseList = null;
		try {
			CourseDataService courseData =(CourseDataService) Naming.lookup("rmi://localhost:8888/CourseData"); 
			courseList = courseData.read();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
		for(String str:courseList){
			if(str.split(";")[8].contains(id)){
				findList.add(str.split(";")[1]);
			}
		}
		String[] courseNo = new String[findList.size()];
		for(int i = 0;i<findList.size();i++){
			courseNo[i] = findList.get(i);
			//System.out.println(courseNo[i]);
		}
		return courseNo;
	}
	/*方法名：checkStudents
	 * 功能：查看学生列表
	 * (non-Javadoc)
	 * @see busninesslogic.TeacherBLService#checkStudents(java.lang.String, java.lang.String)
	 */
	public String[][] checkStudents(String courseNo,String id) {
		ArrayList<String> findList = new ArrayList<String>();
		ArrayList<String> selectRecord = new ArrayList<String>();
		try {
			SelectCourseDataService selectCourseData =(SelectCourseDataService) Naming.lookup("rmi://localhost:8888/SelectCourseData"); 
			selectRecord = selectCourseData.read();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
		
		String stuInfor;
		String[] stuInfor2;
		
		//for(String str:selectRecord){
			//System.out.println(str);
		//}
		for(String str:selectRecord){
		    if(str.split(";")[1].equals(courseNo)){
				try {
					StudentInforDataService studentInforData =(StudentInforDataService) Naming.lookup("rmi://localhost:8888/StudentInforData");
					stuInfor = studentInforData.find(str.split(";")[0]) ;
					stuInfor2 = stuInfor.split(";");
					stuInfor=stuInfor2[0]+";"+stuInfor2[1];
					for(int j = 2;j< 6 ; j++){
						stuInfor=stuInfor+";"+ stuInfor2[j+1];
					}
					
					findList.add(courseNo+";"+stuInfor + ";" + str.split(";")[2]);
				} catch (NotBoundException e) { 
		            e.printStackTrace(); 
		        } catch (MalformedURLException e) { 
		            e.printStackTrace(); 
		        } catch (RemoteException e) { 
		            e.printStackTrace();   
		        } 
			}
		}
		String[][] studentList = new String[findList.size()][];
		for(int i = 0; i<findList.size();i++){
			studentList[i] = findList.get(i).split(";");
		}
		return studentList;
	}
	/*方法名： publishScore
	 * 功能：发布学生成绩
	 * (non-Javadoc)
	 * @see busninesslogic.TeacherBLService#publishScore(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public String[][] publishScore(String id, String courseNo, String score,String teacherid) {
		Boolean isSet = false;
		try { 
			SelectCourseDataService selectCourseData =(SelectCourseDataService) Naming.lookup("rmi://localhost:8888/SelectCourseData"); 
			isSet = selectCourseData.setScore(id+";"+courseNo+";"+score);
        } catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
		if(isSet){
			return checkStudents(teacherid);
		}else{
			return null;
		}
	}
	/*方法名：setCourseInfor
	 * 功能：完善课程信息
	 * (non-Javadoc)
	 * @see busninesslogic.TeacherBLService#setCourseInfor(java.lang.String, java.lang.String, java.lang.String[])
	 */
	public Boolean setCourseInfor(String courseNo,String id, String[] courseInfor){
		String[] course = null;
		try {
			CourseDataService courseData =(CourseDataService) Naming.lookup("rmi://localhost:8888/CourseData"); 
			if(courseData.find(courseNo)!=null){
				course = courseData.find(courseNo).split(";");
			}
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();
        }
		Boolean isSet = false;
		if(course!=null){
			if(course[8].contains(id)){
			course[9] = courseInfor[0];
			course[10] = courseInfor[1];
		    String str = course[0];
		    for(int i = 1;i<course.length;i++){
			     str = str + ";" + course[i];
		    }
		
		    try {
			     CourseDataService courseData =(CourseDataService) Naming.lookup("rmi://localhost:8888/CourseData"); 
			     isSet = courseData.update(str);
		        }catch (NotBoundException e) { 
                  e.printStackTrace(); 
                } catch (MalformedURLException e) { 
                  e.printStackTrace(); 
                } catch (RemoteException e) { 
                  e.printStackTrace();   
                } 
		    }
		    return isSet;
		}else{
			return false;
		}
		
	}
	/*方法名： getCourseInfor
	 * 功能：得到课程信息
	 * (non-Javadoc)
	 * @see busninesslogic.TeacherBLService#getCourseInfor(java.lang.String)
	 */
	public String[] getCourseInfor(String courseNo) {
		String[] infor = null;
		try {
			CourseDataService courseData =(CourseDataService) Naming.lookup("rmi://localhost:8888/CourseData"); 
			infor =  courseData.find(courseNo).split(";");
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
		return infor;
	}
	/*方法名：getSelfInfor
	 * 功能：得到个人信息
	 * (non-Javadoc)
	 * @see busninesslogic.TeacherBLService#getSelfInfor(java.lang.String)
	 */
	public String[] getSelfInfor(String id) {
		String [] inforList = null;
		try { 
			TeacherInforDataService teacherInforData =(TeacherInforDataService) Naming.lookup("rmi://localhost:8888/TeacherInforData"); 
			inforList = teacherInforData.find(id).split(";");
        } catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
		return inforList;
	}
	/*方法名：checkStudents
	 * 功能：查看学生列表
	 * (non-Javadoc)
	 * @see busninesslogic.TeacherBLService#checkStudents(java.lang.String)
	 */
	public String[][] checkStudents(String id) {
		String [] courseList = getCourseNo(id);
		ArrayList<String> findList = new ArrayList<String>();
		ArrayList<String> selectRecord = new ArrayList<String>();
		try {
			SelectCourseDataService selectCourseData =(SelectCourseDataService) Naming.lookup("rmi://localhost:8888/SelectCourseData"); 
			selectRecord = selectCourseData.read();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
		
		String stuInfor;
		String[] stuInfor2;
		
		for(String courseNo:courseList){
			System.out.println(courseNo);
			for(String str:selectRecord){
				System.out.println(str);
		    if(str.split(";")[1].equals(courseNo)){
		    	System.out.println(str);
				try {
					StudentInforDataService studentInforData =(StudentInforDataService) Naming.lookup("rmi://localhost:8888/StudentInforData");
					stuInfor = studentInforData.find(str.split(";")[0]) ;
					System.out.println(stuInfor);
					stuInfor2 = stuInfor.split(";");
					stuInfor=stuInfor2[0]+";"+stuInfor2[1];
					for(int j = 2;j< 6 ; j++){
						stuInfor=stuInfor+";"+ stuInfor2[j+1];
					}			
					findList.add(courseNo+";"+stuInfor + ";" + str.split(";")[2]);
				} catch (NotBoundException e) { 
		            e.printStackTrace(); 
		        } catch (MalformedURLException e) { 
		            e.printStackTrace(); 
		        } catch (RemoteException e) { 
		            e.printStackTrace();   
		        } 
			}
		}
		}
		
		String[][] studentList = new String[findList.size()][];
		for(int i = 0; i<findList.size();i++){
			studentList[i] = findList.get(i).split(";");
		}
		return studentList;
	}
	/*方法名：changePassword
	 * 功能：修改密码
	 * (non-Javadoc)
	 * @see busninesslogic.TeacherBLService#changePassword(java.lang.String, java.lang.String)
	 */
	public Boolean changePassword(String id,String newPassword){
		String[] infor = null;
	    Boolean isChange = false;
	    	try { 
			    TeacherInforDataService teacherInforData =(TeacherInforDataService) Naming.lookup("rmi://localhost:8888/TeacherInforData"); 
			    infor = teacherInforData.find(id).split(";");
			    isChange = teacherInforData.update(infor[0] + ";" + infor[1] + ";" + newPassword + ";" 
	                + infor[3]);
            } catch (NotBoundException e) { 
            e.printStackTrace(); 
            } catch (MalformedURLException e) { 
            e.printStackTrace(); 
            } catch (RemoteException e) { 
            e.printStackTrace();   
            } 
		    return isChange;
	}
}
