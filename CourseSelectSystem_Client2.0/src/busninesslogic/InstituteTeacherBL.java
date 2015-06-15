package busninesslogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import data.*;

/*
 * ������InstituteTeacherBL
 * ���ܣ�ʵ��InstituteTeacherBLService�ӿ�
 */
public class InstituteTeacherBL implements InstituteTeacherBLService{
	/*
	 * ��������checkColist
	 * ���ܣ��鿴ѧԺ�γ�
	 * (non-Javadoc)
	 * @see busninesslogic.InstituteTeacherBLService#checkColist(java.lang.String)
	 */
	public String[][] checkColist(String instituteName) {
	 	ArrayList<String> courseList = new ArrayList<String>();
		try { 
			CourseDataService courseData =(CourseDataService) Naming.lookup("rmi://localhost:8888/CourseData"); 
			//��ȡȫ���γ�
			courseList = courseData.read();
        } catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
		
		int num = 0;
		for(int i = 0; i < courseList.size();i++){
			if(instituteName.equals(courseList.get(i).split(";")[2])){//�ж��Ƿ�Ϊ��Ժ�γ�
				num++;
			}
		}
		String[][] courses = new String[num][];
		int j = 0;
		for(int i = 0 ; i < courseList.size() ; i++){
			if(instituteName.equals(courseList.get(i).split(";")[2])){
				courses[j] = courseList.get(i).split(";");	
				j++;
			}
		}
		
		return courses;
	}

	//�鿴�γ���ϸ��Ϣ
	/*��������checkCoInfro
	 * ���ܣ��鿴�γ���Ϣ
	 * (non-Javadoc)
	 * @see busninesslogic.InstituteTeacherBLService#checkCoInfro(java.lang.String)
	 */
	public String[] checkCoInfro(String courseNo) {
		String[] findCourseInfro = null;
		ArrayList<String> courseList = new ArrayList<String>();
		
		try { 
			CourseDataService courseData =(CourseDataService) Naming.lookup("rmi://localhost:8888/CourseData"); 
			courseList = courseData.read();
			System.out.println(); 
            System.out.println(); 
        } catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
		boolean exist = false;
		for(String str:courseList){
			String[] temp = str.split(";");
			if(temp[1].equals(courseNo)){
				findCourseInfro = temp;
				exist = true;
				break;
			}
		}
		if(exist == false){
			findCourseInfro = null;
		}
		return findCourseInfro;
	}

	@Override
	//�鿴ѧ���б�
	/*��������checkStlist
	 * ���ܣ��鿴ѧ���б�
	 * (non-Javadoc)
	 * @see busninesslogic.InstituteTeacherBLService#checkStlist(java.lang.String)
	 */
	public String[][] checkStlist(String courseNo) {
		
		ArrayList<String> selectRecord = new ArrayList<String>();
		try { 
			SelectCourseDataService selectCourseDataService =(SelectCourseDataService) Naming.lookup("rmi://localhost:8888/SelectCourseData"); 
			selectRecord = selectCourseDataService.read();
			System.out.println(); 
            System.out.println(); 
        } catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
		
		int num = 0;
	    for(int i = 0 ; i < selectRecord.size() ; i++){
		   if (courseNo.equals(selectRecord.get(i).split(";")[1])){
			   num++;
		   }
	    }//���ѡ��ÿε�ѧ������num��    
	    
 	    String[][] result = new String[num][];	    	    
		if(num != 0 ){
			
			String[] stuNo = new String[num];
			int n = 0;
			for(int i = 0 ; i < selectRecord.size() ; i++){
				   if (courseNo.equals(selectRecord.get(i).split(";")[1])){
					   stuNo[n] = selectRecord.get(i).split(";")[0];
					   n++;
				   }
			}//���ѡ��ÿε�ѧ��ѧ�����顣
			
			ArrayList<String> stuInfroList = new ArrayList<String>();
			try { 
				StudentInforDataService studentInfroData =(StudentInforDataService) Naming.lookup("rmi://localhost:8888/StudentInforData"); 
				stuInfroList = studentInfroData.read();
				System.out.println(); 
	            System.out.println(); 
	        } catch (NotBoundException e) { 
	            e.printStackTrace(); 
	        } catch (MalformedURLException e) { 
	            e.printStackTrace(); 
	        } catch (RemoteException e) { 
	            e.printStackTrace();   
	        } 
			
	 	    for(int i = 0;i < num;i ++){
	 	    	for(int j = 0;j < stuInfroList.size();j ++){
	 	    		if(stuNo[i].equals(stuInfroList.get(j).split(";")[0])){
	 	    			result[i] = stuInfroList.get(j).split(";");
	 	    		}
	 	    	}
	 	   }
	 	   for (int i = 0;i < num;i++){
	 		   result[i][2] = courseNo;
	 	   }
		   /*int p = 0;
		   for(int i = 0 ; i < stuInforList.size() ; i++){
			  if (courseNo.equals(stuInforList.get(i).split(";")[1])){
				  result[p] = stuInforList.get(i).split(";");
				  p++;
			  }
			  
		   }*/
		}
		else{
			result = null;
		}
		return result;
	}

	@Override
	//����γ�
	/*��������manageCourse
	 * ���ܣ�����γ�
	 * (non-Javadoc)
	 * @see busninesslogic.InstituteTeacherBLService#manageCourse(java.lang.String, java.lang.String)
	 */
	public Boolean manageCourse(String teacherName,String courseNo) {
	  ArrayList<String> teacherInforList = new ArrayList<String>();
	  try { 
		  TeacherInforDataService teacherInforData =(TeacherInforDataService) Naming.lookup("rmi://localhost:8888/TeacherInforData"); 
		  teacherInforList = teacherInforData.read();
      } catch (NotBoundException e) { 
          e.printStackTrace(); 
      } catch (MalformedURLException e) { 
          e.printStackTrace(); 
      } catch (RemoteException e) { 
          e.printStackTrace();   
      } 
	  
	  String[] teacherInfor = new String[teacherInforList.size()];
	  for(int i = 0 ; i < teacherInforList.size() ; i++){
		  teacherInfor[i] = teacherInforList.get(i).split(";")[0];	
	  }
	  boolean th_exist = false;
	  String[] thstr = null;
	  for(int i = 0;i < teacherInforList.size();i++){
		  if (teacherName.equals(teacherInfor[i])){
			  th_exist = true;
			  thstr = teacherInforList.get(i).split(";");
		  }
	  }
	  ArrayList<String> courseList = new ArrayList<String>();
	  try {
		  CourseDataService courseData =(CourseDataService) Naming.lookup("rmi://localhost:8888/CourseData");
		  courseList = courseData.read();
	  }catch (NotBoundException e) { 
		  e.printStackTrace(); 
	  } catch (MalformedURLException e) { 
		  e.printStackTrace(); 
	  } catch (RemoteException e) { 
		  e.printStackTrace();   
	  } 
	  String[] courses = new String[courseList.size()];
	  for(int i = 0 ; i < courseList.size() ; i++){
		  courses[i] = courseList.get(i).split(";")[1];
	  }
	  boolean co_exist = false;
	  String[] costr = null;
	  for(int i = 0;i < courseList.size();i++){
		  if (courseNo.equals(courses[i])){
			  co_exist = true;
			  costr = courseList.get(i).split(";");
		  }
	  }
	  
	  Boolean isSet = false;
	  
	  if(th_exist == true&&co_exist == true){
		  isSet = true;
		  costr[8] = thstr[1] + "," + thstr[0];
		  String newCoInfro = "";
		  for(int i = 0 ; i < 10;i++){
			  newCoInfro = newCoInfro + costr[i] + ";";
		  }
		  newCoInfro += costr[10];
		  try {
			 CourseDataService courseData =(CourseDataService) Naming.lookup("rmi://localhost:8888/CourseData"); 
			 isSet = courseData.update(newCoInfro);
		  }catch (NotBoundException e) { 
             e.printStackTrace(); 
          } catch (MalformedURLException e) { 
             e.printStackTrace(); 
          } catch (RemoteException e) { 
             e.printStackTrace();   
          } 
		  
	  }
		
      return isSet;
	}

	//�ƶ�Ժϵ��ѧ�ƻ�
	@Override
	/*��������makePlan
	 * ���ܣ��ƶ���ѧ�ƻ�
	 * (non-Javadoc)
	 * @see busninesslogic.InstituteTeacherBLService#makePlan(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public Boolean makePlan(String instituteName,String first,String second,String third,String forth,String fifth,String sixth) {
      String plans = instituteName + ";" + first + ";" + second + ";" + third + ";" + forth + ";" + fifth + ";" + sixth;
      Boolean isMake = false;

      try {
        	InstitutePlanDataService institutePlanData =(InstitutePlanDataService) Naming.lookup("rmi://localhost:8888/InstitutePlanData");
        	isMake = institutePlanData.write(plans);
  	  }catch (NotBoundException e) { 
  		  e.printStackTrace(); 
  	  } catch (MalformedURLException e) { 
  		  e.printStackTrace(); 
  	  } catch (RemoteException e) { 
  		  e.printStackTrace();   
  	  } 
        
      return isMake;
	}
	
	//�õ�������Ϣ
	/*��������getSelfInfor
	 * ���ܣ��õ�������Ϣ
	 * (non-Javadoc)
	 * @see busninesslogic.InstituteTeacherBLService#getSelfInfor(java.lang.String)
	 */
	public String[] getSelfInfor(String id) {
		String [] inforList = null;
		try { 
			InstituteTeacherDataService instituteTeacherData =(InstituteTeacherDataService) Naming.lookup("rmi://localhost:8888/InstituteTeacherData"); 
			inforList = instituteTeacherData.find(id).split(";");
        } catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
		return inforList;
	}
	
	//�޸�����
	/*��������changePassword
	 * ���ܣ��޸�����
	 * (non-Javadoc)
	 * @see busninesslogic.InstituteTeacherBLService#changePassword(java.lang.String, java.lang.String)
	 */
	public Boolean changePassword(String id,String newPassword){
		String[] infor = null;
	    Boolean isChange = false;
	    	try { 
			    InstituteTeacherDataService instituteTeacherData =(InstituteTeacherDataService) Naming.lookup("rmi://localhost:8888/InstituteTeacherData"); 
			    infor = instituteTeacherData.find(id).split(";");
			    isChange = instituteTeacherData.update(infor[0] + ";" + infor[1] + ";" + newPassword + ";" 
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
/*��������PublishCourse
 * ���ܣ������γ�
 * (non-Javadoc)
 * @see busninesslogic.InstituteTeacherBLService#PublishCourse(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
 */
	public Boolean PublishCourse(String coNo,String coName,String coAttribute,String coRight,String coSeason,String coInstitute,String coTime,String coClassroom){
		  Boolean isSet = false;
		  ArrayList<String> courseList = new ArrayList<String>();
		  try {
			  CourseDataService courseData =(CourseDataService) Naming.lookup("rmi://localhost:8888/CourseData");
			  courseList = courseData.read();
		  }catch (NotBoundException e) { 
			  e.printStackTrace(); 
		  } catch (MalformedURLException e) { 
			  e.printStackTrace(); 
		  } catch (RemoteException e) { 
			  e.printStackTrace();   
		  } 
		  
		  String[] coursesNo = new String[courseList.size()];
		  for(int i = 0 ; i < courseList.size() ; i++){
			  coursesNo[i] = courseList.get(i).split(";")[1];
		  }
		  boolean coNoIsExist = false;
		  for(int i = 0 ; i < courseList.size() ; i++){
			  if(coNo.equals(coursesNo[i])){
				  coNoIsExist = true;
			  }
		  }
		  String[] coursesName = new String[courseList.size()];
		  for(int i = 0 ; i < courseList.size() ; i++){
			  coursesName[i] = courseList.get(i).split(";")[3];
		  }
		  boolean coNameIsExist = false;
		  for(int i = 0 ; i < courseList.size() ; i++){
			  if(coName.equals(coursesName[i])){
				  coNameIsExist = true;
			  }
		  }
		  
		  if((coNoIsExist || coNameIsExist) == false){		  
		    String newCourse = coAttribute + ";" + coNo + ";" + coInstitute + ";" + coName + ";" + coRight + ";" + coSeason + ";" + coTime + ";" + coClassroom + ";" + "��" + ";" + "��" + ";" + "��";
		    try {
			  CourseDataService courseData =(CourseDataService) Naming.lookup("rmi://localhost:8888/CourseData");
			  courseData.add(newCourse);
		    }catch (NotBoundException e) { 
			  e.printStackTrace(); 
		    } catch (MalformedURLException e) { 
			  e.printStackTrace(); 
		    } catch (RemoteException e) { 
			  e.printStackTrace();  
		    } 
			  isSet = true;
		  }
		  
		  ArrayList<String> stuList = new ArrayList<String>();
		  try {
			  StudentInforDataService stuData =(StudentInforDataService) Naming.lookup("rmi://localhost:8888/StudentInforData");
			  stuList = stuData.read();
		  }catch (NotBoundException e) { 
			  e.printStackTrace(); 
		  } catch (MalformedURLException e) { 
			  e.printStackTrace(); 
		  } catch (RemoteException e) { 
			  e.printStackTrace();   
		  } 
		  //String[] stuInstituteList = new String[stuList.size()];
		  int counter = 0;
		  for(int i = 0 ; i < stuList.size() ; i++){
			  //stuInstituteList[i] = stuList.get(i).split(";")[3];
			  if(stuList.get(i).split(";")[3].equals(coInstitute)){
				  counter++;
			  }
		  }
		  String [] stuNeedtoAdd = new String[counter];
		  int j = 0;
		  for(int i = 0;i < stuList.size() ; i++){
			  if(stuList.get(i).split(";")[3].equals(coInstitute)){
				  stuNeedtoAdd[j] = stuList.get(i).split(";")[0];
				  j++;
			  }
		  }
		  String [] newSelectRecord = new String[counter];
		  for(int i = 0;i < counter;i++){
			  newSelectRecord[i] = stuNeedtoAdd[i] + ";" + coNo + ";" + "��";
			  try {
				  SelectCourseDataService selcetRecord =(SelectCourseDataService) Naming.lookup("rmi://localhost:8888/SelectCourseData");
				  selcetRecord.add(newSelectRecord[i]);
			  }catch (NotBoundException e) { 
				  e.printStackTrace(); 
			  } catch (MalformedURLException e) { 
				  e.printStackTrace(); 
			  } catch (RemoteException e) { 
				  e.printStackTrace();   
			  } 
		  }	
		  
		  return isSet;
	}
	
}
