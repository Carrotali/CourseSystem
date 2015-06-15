package busninesslogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import data.CourseDataService;
import data.InstitutePlanDataService;
import data.OverallPolicyDataService;
import data.SchoolTeacherDataService;
import data.StudentInforDataService;
import data.TeacherInforDataService;
/*
 * 类名：SchoolTeacherBL
 * 功能：实现SchoolTeacherBLService接口
 */
public class SchoolTeacherBL implements SchoolTeacherBLService {

	//查看学校课程
	@Override
	/*方法名：checkSchoolCourse
	 * 功能：查看学习课程
	 * (non-Javadoc)
	 * @see busninesslogic.SchoolTeacherBLService#checkSchoolCourse()
	 */
	public String[][] checkSchoolCourse() {
		ArrayList<String> courseList = new ArrayList<String>();
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
		String[][] courses = new String[courseList.size()][];
		for(int i = 0 ; i < courseList.size() ; i++){
			courses[i] = courseList.get(i).split(";");
		}
		return courses;
	}

	//根据课程号查看具体某一门课程
	@Override
	/*方法名：checkSchoolCourse
	 * 功能：查看学习课程
	 * (non-Javadoc)
	 * @see busninesslogic.SchoolTeacherBLService#checkSchoolCourse(java.lang.String)
	 */
	public String[] checkSchoolCourse(String courseNo) {
		String[] findCourse = null;
		ArrayList<String> courseList = new ArrayList<String>();
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
			String[] temp = str.split(";");
			if(temp[1].equals(courseNo)){
				findCourse = temp;
				break;
			}
		}
		return findCourse;
	}
	
	//查看个人信息
	@Override
	/*方法名：checkSelfInfor
	 * 功能：查看个人信息
	 * (non-Javadoc)
	 * @see busninesslogic.SchoolTeacherBLService#checkSelfInfor(java.lang.String)
	 */
	public String[] checkSelfInfor(String id){
		String[] infor =  null;
		try { 
			SchoolTeacherDataService schoolTeacherInforData =(SchoolTeacherDataService) Naming.lookup("rmi://localhost:8888/SchoolTeacherData"); 
			infor = schoolTeacherInforData.find(id).split(";");
			System.out.println(); 
            System.out.println(); 
        } catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
		return infor;
	}
	

	//查看学生信息
	@Override
	/*方法名：checkStudentInfor
	 * 功能：查看学生信息
	 * (non-Javadoc)
	 * @see busninesslogic.SchoolTeacherBLService#checkStudentInfor()
	 */
	public String[][] checkStudentInfor() {
		ArrayList<String> stuInforList = new ArrayList<String>();
		try { 
			StudentInforDataService studentInforData =(StudentInforDataService) Naming.lookup("rmi://localhost:8888/StudentInforData"); 
			stuInforList = studentInforData.read();
        } catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
		
		String[][] stuInfor = new String[stuInforList.size()][];
		for(int i = 0 ; i < stuInforList.size() ; i++){
			stuInfor[i] = stuInforList.get(i).split(";");
		}
//		System.out.println(stuInfor.length);
		for(int i = 0 ; i < stuInforList.size() ; i++){
		
		for(int j = 2;j< 6 ; j++){
			stuInfor[i][j] = stuInfor[i][j+1];
	    }
		stuInfor[i][6] ="";
		}
		return stuInfor;
	}

	//根据学生学号查看某位学生的信息
	@Override
	/*方法名：checkStudentInfor
	 * 功能：根据学生学号查看某位学生的信息
	 * (non-Javadoc)
	 * @see busninesslogic.SchoolTeacherBLService#checkStudentInfor(java.lang.String)
	 */
	public String[] checkStudentInfor(String id) {
		ArrayList<String> stuInforList = new ArrayList<String>();
		try { 
			StudentInforDataService studentInforData =(StudentInforDataService) Naming.lookup("rmi://localhost:8888/StudentInforData"); 
			stuInforList = studentInforData.read();
        } catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
		  String[]stuInfor = null;
		  
		  for(String str:stuInforList){
				String[] temp = str.split(";");
				if(temp[0].equals(id)){
                    stuInfor = temp;
					break;
				}
			}
		  if(stuInfor == null) return stuInfor;
		  for(int j = 2;j< 6 ; j++){
				stuInfor[j] = stuInfor[j+1];
		    }
			stuInfor[6] ="";
		  return stuInfor;
	}

	//查看教师信息
	@Override
	/*方法名：checkTeacherInfor
	 * 功能：查看教师信息
	 * (non-Javadoc)
	 * @see busninesslogic.SchoolTeacherBLService#checkTeacherInfor()
	 */
	public String[][] checkTeacherInfor() {
	  ArrayList<String> teacherInforList = new ArrayList<String>();
	  try { 
		  TeacherInforDataService teacherInforData =(TeacherInforDataService) Naming.lookup("rmi://localhost:8888/TeacherInforData"); 
			teacherInforList=teacherInforData.read();
      } catch (NotBoundException e) { 
          e.printStackTrace(); 
      } catch (MalformedURLException e) { 
          e.printStackTrace(); 
      } catch (RemoteException e) { 
          e.printStackTrace();   
      } 
	  
	  String[][] teacherInfor = new String[teacherInforList.size()][];
	  for(int i = 0 ; i < teacherInforList.size() ; i++){
		  teacherInfor[i] = teacherInforList.get(i).split(";");	
		  teacherInfor[i][2] = teacherInfor[i][3];
		  teacherInfor[i][3]="";
	  }
	  
	  ArrayList<String> courseList = new ArrayList<String>();
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
		String[][] courses = new String[courseList.size()][];
		for(int i = 0 ; i < courseList.size() ; i++){
			courses[i] = courseList.get(i).split(";");
		}
		for(int j = 0 ;j <teacherInforList.size() ; j++ ){
		 for(int i = 0 ; i < courseList.size() ; i++){
			if(courses[i][8].contains(teacherInfor[j][0])){
				teacherInfor[j][3]=teacherInfor[j][3]+courses[i][1]+courses[i][3]+" ";
			}
	     }
	   }
		
		return teacherInfor;
	}

	//根据教师工号查看某位教师的信息
	@Override
	/*方法名：checkTeacherInfor
	 * 功能：根据教师工号查看某位教师的信息
	 * (non-Javadoc)
	 * @see busninesslogic.SchoolTeacherBLService#checkTeacherInfor(java.lang.String)
	 */
	public String[] checkTeacherInfor(String id) {
		ArrayList<String> teacherInforList = new ArrayList<String>();
		try { 
			  TeacherInforDataService teacherInforData =(TeacherInforDataService) Naming.lookup("rmi://localhost:8888/TeacherInforData"); 
				teacherInforList=teacherInforData.read();
	      } catch (NotBoundException e) { 
	          e.printStackTrace(); 
	      } catch (MalformedURLException e) { 
	          e.printStackTrace(); 
	      } catch (RemoteException e) { 
	          e.printStackTrace();   
	      } 
		  String[]teacherInfor = null;
		  
		  for(String str:teacherInforList){
				String[] temp = str.split(";");
				if(temp[0].equals(id)){
					teacherInfor = temp;
					break;
				}
			}
		  if(teacherInfor==null){
			  return teacherInfor;
		  }
		  teacherInfor[2] = teacherInfor[3];
		  teacherInfor[3]="";
		    ArrayList<String> courseList = new ArrayList<String>();
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
			String[][] courses = new String[courseList.size()][];
			for(int i = 0 ; i < courseList.size() ; i++){
				courses[i] = courseList.get(i).split(";");
			}
		
			 for(int i = 0 ; i < courseList.size() ; i++){
				if(courses[i][8].contains(teacherInfor[0])){
					teacherInfor[3]=teacherInfor[3]+courses[i][1]+courses[i][3]+" ";
				}
		     }
		   

			
			return teacherInfor;

	}

	
	
	@Override
	//查看通识通修课程
	/*方法名：checkCourseForAll
	 * 功能：查看通识通修课程
	 * (non-Javadoc)
	 * @see busninesslogic.SchoolTeacherBLService#checkCourseForAll(java.lang.String)
	 */
	public String[][] checkCourseForAll(String institute) {
		ArrayList<String> courseList = new ArrayList<String>();		
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
		

		int j=0;
		int k=-1;
		for(int i = 0 ; i < courseList.size() ; i++){
			String[]temp = courseList.get(i).split(";");
			if(temp[0].equals("通识通修课程")){
				j++;		
			}
		}
		
		String[][] courses = new String[j][];
	
		for(int i = 0 ; i < courseList.size() ; i++){
			String[]temp = courseList.get(i).split(";");
			if(temp[0].equals("通识通修课程")){
				k++;
				courses[k] = courseList.get(i).split(";");
			}
			
		}
		return courses;
	
		
	}
	
	//查看院系教学计划
	/*方法名： checkInstitutePoint
	 * 功能：查看院系教学计划
	 * (non-Javadoc)
	 * @see busninesslogic.SchoolTeacherBLService#checkInstitutePoint(java.lang.String)
	 */
	public String[] checkInstitutePoint(String institute) {
		ArrayList<String> courseList = new ArrayList<String>();		
		try {
			InstitutePlanDataService institutePlanData =(InstitutePlanDataService) Naming.lookup("rmi://localhost:8888/InstitutePlanData"); 
			courseList = institutePlanData.read();
		} catch (NotBoundException e) { 
          e.printStackTrace(); 
      } catch (MalformedURLException e) { 
          e.printStackTrace(); 
      } catch (RemoteException e) { 
          e.printStackTrace();   
      } 
		
		String[] planPoint = null;
		for(int i = 0 ; i < courseList.size() ; i++){
			String[]temp = courseList.get(i).split(";");
			if(temp[0].equals(institute)){
				planPoint = courseList.get(i).split(";");
			}
		}
		return planPoint;
	}


	@Override
	//course为要写入的通识通修课程信息，由界面读取信息然后调用
	/*方法名：publishCourseForAll
	 * 功能：course为要写入的通识通修课程信息，由界面读取信息然后调用
	 * (non-Javadoc)
	 * @see busninesslogic.SchoolTeacherBLService#publishCourseForAll(java.lang.String)
	 */
	public Boolean publishCourseForAll(String course) {
		// TODO Auto-generated method stub
		Boolean isPublish = false;
		try {
			CourseDataService courseData =(CourseDataService) Naming.lookup("rmi://localhost:8888/CourseData"); 
			isPublish = courseData.add(course);
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
		
		return isPublish;
	}

	//发布整体框架策略
	@Override
	/*方法名：publishOverAllPolicy
	 * 功能：发布整体框架策略
	 * (non-Javadoc)
	 * @see busninesslogic.SchoolTeacherBLService#publishOverAllPolicy(java.lang.String[])
	 */
	public Boolean publishOverAllPolicy(String[] policy) {
		// TODO Auto-generated method stub
		Boolean isPublish = false;
		try {
			OverallPolicyDataService overallPolicyData =(OverallPolicyDataService) Naming.lookup("rmi://localhost:8888/OverallPolicyData"); 
			isPublish = overallPolicyData.write(policy);
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
		return isPublish;
	}

	@Override
	//查看学科专业课程和跨专业课程
	/*方法名：checkInstituteCourse
	 * 功能：查看学科专业课程和跨专业课程
	 * (non-Javadoc)
	 * @see busninesslogic.SchoolTeacherBLService#checkInstituteCourse(java.lang.String)
	 */
	public String[][] checkInstituteCourse(String institute) {
		ArrayList<String> courseList = new ArrayList<String>();		
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
		
		int j=0;
		int k=-1;
		for(int i = 0 ; i < courseList.size() ; i++){
			String[]temp = courseList.get(i).split(";");
			if((temp[2].equals(institute))&&(temp[0].equals("学科专业课程")||temp[0].equals("跨专业课程"))){
				j++;	
			}
		}
		
	//	System.out.println(j);
		
		String[][] courses = new String[j][];
	
		for(int i = 0 ; i < courseList.size() ; i++){
			String[]temp = courseList.get(i).split(";");
			if((temp[2].equals(institute))&&(temp[0].equals("学科专业课程")||temp[0].equals("跨专业课程"))){
				k++;
				courses[k] = courseList.get(i).split(";");
			}
			
		}
		return courses;
		
	}
	
	
	
	
	
	@Override
	//查看整体框架策略
	/*方法名：checkOverallPolicy
	 * 功能：/查看整体框架策略
	 * (non-Javadoc)
	 * @see busninesslogic.SchoolTeacherBLService#checkOverallPolicy()
	 */
	public String[][] checkOverallPolicy() {
		ArrayList<String> overallPolicyList = new ArrayList<String>();		
		try {
			OverallPolicyDataService overallPolicyData =(OverallPolicyDataService) Naming.lookup("rmi://localhost:8888/OverallPolicyData"); 
			overallPolicyList = overallPolicyData.read();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
		String[][] overallPolicy = new String[overallPolicyList.size()][];
		for(int i = 0 ; i < overallPolicyList.size() ; i++){
		
			overallPolicy[i] = overallPolicyList.get(i).split(";");
			
		}
		return overallPolicy;
	}

	//修改密码
	@Override
	/*方法名：changePassword
	 * 功能：修改密码
	 * (non-Javadoc)
	 * @see busninesslogic.SchoolTeacherBLService#changePassword(java.lang.String, java.lang.String)
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
