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
 * ������SchoolTeacherBL
 * ���ܣ�ʵ��SchoolTeacherBLService�ӿ�
 */
public class SchoolTeacherBL implements SchoolTeacherBLService {

	//�鿴ѧУ�γ�
	@Override
	/*��������checkSchoolCourse
	 * ���ܣ��鿴ѧϰ�γ�
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

	//���ݿγ̺Ų鿴����ĳһ�ſγ�
	@Override
	/*��������checkSchoolCourse
	 * ���ܣ��鿴ѧϰ�γ�
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
	
	//�鿴������Ϣ
	@Override
	/*��������checkSelfInfor
	 * ���ܣ��鿴������Ϣ
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
	

	//�鿴ѧ����Ϣ
	@Override
	/*��������checkStudentInfor
	 * ���ܣ��鿴ѧ����Ϣ
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

	//����ѧ��ѧ�Ų鿴ĳλѧ������Ϣ
	@Override
	/*��������checkStudentInfor
	 * ���ܣ�����ѧ��ѧ�Ų鿴ĳλѧ������Ϣ
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

	//�鿴��ʦ��Ϣ
	@Override
	/*��������checkTeacherInfor
	 * ���ܣ��鿴��ʦ��Ϣ
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

	//���ݽ�ʦ���Ų鿴ĳλ��ʦ����Ϣ
	@Override
	/*��������checkTeacherInfor
	 * ���ܣ����ݽ�ʦ���Ų鿴ĳλ��ʦ����Ϣ
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
	//�鿴ͨʶͨ�޿γ�
	/*��������checkCourseForAll
	 * ���ܣ��鿴ͨʶͨ�޿γ�
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
			if(temp[0].equals("ͨʶͨ�޿γ�")){
				j++;		
			}
		}
		
		String[][] courses = new String[j][];
	
		for(int i = 0 ; i < courseList.size() ; i++){
			String[]temp = courseList.get(i).split(";");
			if(temp[0].equals("ͨʶͨ�޿γ�")){
				k++;
				courses[k] = courseList.get(i).split(";");
			}
			
		}
		return courses;
	
		
	}
	
	//�鿴Ժϵ��ѧ�ƻ�
	/*�������� checkInstitutePoint
	 * ���ܣ��鿴Ժϵ��ѧ�ƻ�
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
	//courseΪҪд���ͨʶͨ�޿γ���Ϣ���ɽ����ȡ��ϢȻ�����
	/*��������publishCourseForAll
	 * ���ܣ�courseΪҪд���ͨʶͨ�޿γ���Ϣ���ɽ����ȡ��ϢȻ�����
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

	//���������ܲ���
	@Override
	/*��������publishOverAllPolicy
	 * ���ܣ����������ܲ���
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
	//�鿴ѧ��רҵ�γ̺Ϳ�רҵ�γ�
	/*��������checkInstituteCourse
	 * ���ܣ��鿴ѧ��רҵ�γ̺Ϳ�רҵ�γ�
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
			if((temp[2].equals(institute))&&(temp[0].equals("ѧ��רҵ�γ�")||temp[0].equals("��רҵ�γ�"))){
				j++;	
			}
		}
		
	//	System.out.println(j);
		
		String[][] courses = new String[j][];
	
		for(int i = 0 ; i < courseList.size() ; i++){
			String[]temp = courseList.get(i).split(";");
			if((temp[2].equals(institute))&&(temp[0].equals("ѧ��רҵ�γ�")||temp[0].equals("��רҵ�γ�"))){
				k++;
				courses[k] = courseList.get(i).split(";");
			}
			
		}
		return courses;
		
	}
	
	
	
	
	
	@Override
	//�鿴�����ܲ���
	/*��������checkOverallPolicy
	 * ���ܣ�/�鿴�����ܲ���
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

	//�޸�����
	@Override
	/*��������changePassword
	 * ���ܣ��޸�����
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
