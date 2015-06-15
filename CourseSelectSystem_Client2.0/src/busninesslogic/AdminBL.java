package busninesslogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import data.*;

/*
 * ������AdminBL
 * ���ܣ�ʵ��AdminBLService�ӿ�
 * 
 */
public class AdminBL implements AdminBLService {
	
	/*
	 * ��������checkSchoolTeacherInfor
	 * ���ܣ��鿴ѧУ������ʦ��Ϣ
	 * (non-Javadoc)
	 * @see busninesslogic.AdminBLService#checkSchoolTeacherInfor()
	 */
     public String[][] checkSchoolTeacherInfor() {
		ArrayList<String> inforList = new ArrayList<String>();
		try { 
			SchoolTeacherDataService inforData =(SchoolTeacherDataService) Naming.lookup("rmi://localhost:8888/SchoolTeacherData"); 
			inforList = inforData.read();
        } catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
		
		String[][] infor = new String[inforList.size()][];
		for(int i = 0 ; i < inforList.size() ; i++){
			infor[i] = inforList.get(i).split(";");
		}
		for(int i = 0 ; i < inforList.size() ; i++){
		
			infor[i] = inforList.get(i).split(";");	
		}
		return infor;
	}
	
	/*
	 * ��������checkInstituteTeacherInfor
	 * ���ܣ��鿴Ժϵ������ʦ��Ϣ
	 * (non-Javadoc)
	 * @see busninesslogic.AdminBLService#checkInstituteTeacherInfor()
	 */
	public String[][] checkInstituteTeacherInfor() {
		ArrayList<String> inforList = new ArrayList<String>();
		try { 
			InstituteTeacherDataService inforData =(InstituteTeacherDataService) Naming.lookup("rmi://localhost:8888/InstituteTeacherData"); 
			inforList = inforData.read();
        } catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
		
		String[][] infor = new String[inforList.size()][];
		for(int i = 0 ; i < inforList.size() ; i++){
			infor[i] = inforList.get(i).split(";");
		}
		return infor;
	}

	/*
	 * ��������checkStudentInfor
	 * ���ܣ��鿴ѧ����Ϣ
	 * (non-Javadoc)
	 * @see busninesslogic.AdminBLService#checkStudentInfor()
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
		return stuInfor;
	}

	/*
	 * ��������checkTeacherInfor
	 * ���ܣ��鿴�ον�ʦ��Ϣ
	 * (non-Javadoc)
	 * @see busninesslogic.AdminBLService#checkTeacherInfor()
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
		  }
			return teacherInfor;
		}
	
	/*
	 * ��������DeleteSchoolTeacher
	 * ���ܣ�ɾ��ѧУ����Ա
	 * (non-Javadoc)
	 * @see busninesslogic.AdminBLService#DeleteSchoolTeacher(java.lang.String)
	 */
    public Boolean DeleteSchoolTeacher(String schoolTeacherNo){
    	Boolean isDelete = false;
    	if(!schoolTeacherNo.equals(null)){ 	
    	ArrayList<String> schoolTeacherList = new ArrayList<String>();
		try { 
			SchoolTeacherDataService schoolTeacherData =(SchoolTeacherDataService) Naming.lookup("rmi://localhost:8888/SchoolTeacherData"); 
			schoolTeacherList = schoolTeacherData.read();
        } catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
    	boolean isExist = false;
		for(int i = 0;i < schoolTeacherList.size();i++){
			if (schoolTeacherNo.equals(schoolTeacherList.get(i).split(";")[0])){
				isExist = true;
			}
		}
		if(isExist){
			try { 
				SchoolTeacherDataService schoolTeacherData =(SchoolTeacherDataService) Naming.lookup("rmi://localhost:8888/SchoolTeacherData"); 
				schoolTeacherData.delete(schoolTeacherNo);
	        } catch (NotBoundException e) { 
	            e.printStackTrace(); 
	        } catch (MalformedURLException e) { 
	            e.printStackTrace(); 
	        } catch (RemoteException e) { 
	            e.printStackTrace();   
	        } 
			isDelete = true;
		}
    	}
		return isDelete;  	 
     }

    /*
     * ��������DeleteInstituteTeacher
     * ���ܣ�ɾ��Ժϵ������ʦ
     * (non-Javadoc)
     * @see busninesslogic.AdminBLService#DeleteInstituteTeacher(java.lang.String)
     */
    public Boolean DeleteInstituteTeacher(String instituteTeacherNo){
     	Boolean isDelete = false;
     	ArrayList<String> instituteTeacherList = new ArrayList<String>();
 		try { 
 			InstituteTeacherDataService instituteTeacherData =(InstituteTeacherDataService) Naming.lookup("rmi://localhost:8888/InstituteTeacherData"); 
 			instituteTeacherList = instituteTeacherData.read();
 			System.out.println(); 
            System.out.println(); 
        } catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
     	boolean isExist = false;
 		for(int i = 0;i < instituteTeacherList.size();i++){
 			if (instituteTeacherNo.equals(instituteTeacherList.get(i).split(";")[0])){
 				isExist = true;
 			}
 		}
 		if(isExist){
 			try { 
 				InstituteTeacherDataService instituteTeacherData =(InstituteTeacherDataService) Naming.lookup("rmi://localhost:8888/InstituteTeacherData"); 
 				instituteTeacherData.delete(instituteTeacherNo);
 				System.out.println(); 
 	            System.out.println(); 
 	        } catch (NotBoundException e) { 
 	            e.printStackTrace(); 
 	        } catch (MalformedURLException e) { 
 	            e.printStackTrace(); 
 	        } catch (RemoteException e) { 
 	            e.printStackTrace();   
 	        } 
 			isDelete = true;
 		}
 		return isDelete;  	 
      }
     
    /*
     * ��������DeleteTeacher
     * ���ܣ�ɾ���ο���ʦ
     * (non-Javadoc)
     * @see busninesslogic.AdminBLService#DeleteTeacher(java.lang.String)
     */
    public Boolean DeleteTeacher(String teacherNo){
      	Boolean isDelete = false;
      	ArrayList<String> teacherList = new ArrayList<String>();
  		try { 
  			TeacherInforDataService teacherData =(TeacherInforDataService) Naming.lookup("rmi://localhost:8888/TeacherInforData"); 
  			teacherList = teacherData.read();
  			System.out.println(); 
            System.out.println(); 
        } catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) {
        	e.printStackTrace();   
        } 
      	boolean isExist = false;
  		for(int i = 0;i < teacherList.size();i++){
  			if (teacherNo.equals(teacherList.get(i).split(";")[0])){
  				isExist = true;
  				
  			}
  		}
  		if(isExist){
  			try { 
  				TeacherInforDataService teacherData =(TeacherInforDataService) Naming.lookup("rmi://localhost:8888/TeacherInforData"); 
  				teacherData.delete(teacherNo);
  				System.out.println(); 
  	            System.out.println(); 
  	        } catch (NotBoundException e) { 
  	            e.printStackTrace(); 
  	        } catch (MalformedURLException e) { 
  	            e.printStackTrace(); 
  	        } catch (RemoteException e) { 
  	            e.printStackTrace();   
  	        } 
  			isDelete = true;
  		}
  		return isDelete;  	 
       }
     
    /*
     * ��������DeleteStudent
     * ���ܣ�ɾ��ѧ��
     * (non-Javadoc)
     * @see busninesslogic.AdminBLService#DeleteStudent(java.lang.String)
     */
    public Boolean DeleteStudent(String studentNo){
     	Boolean isDelete = false;
     	ArrayList<String> studentList = new ArrayList<String>();
 		try { 
 			StudentInforDataService studentInforData =(StudentInforDataService) Naming.lookup("rmi://localhost:8888/StudentInforData"); 
 			studentList = studentInforData.read();
 			System.out.println(); 
            System.out.println(); 
        } catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
     	boolean isExist = false;
 		for(int i = 0;i < studentList.size();i++){
 			if (studentNo.equals(studentList.get(i).split(";")[0])){
 				isExist = true;
 			}
 		}
 		if(isExist){
 			try { 
 				StudentInforDataService studentInforData =(StudentInforDataService) Naming.lookup("rmi://localhost:8888/StudentInforData"); 
 				studentInforData.delete(studentNo);
 				System.out.println(); 
 	            System.out.println(); 
 	        } catch (NotBoundException e) { 
 	            e.printStackTrace(); 
 	        } catch (MalformedURLException e) { 
 	            e.printStackTrace(); 
 	        } catch (RemoteException e) { 
 	            e.printStackTrace();   
 	        } 
 			isDelete = true;
 		}
 		return isDelete;  	 
      }
     
    /*
     * ��������getAbleToReselectCourse
     * ���ܣ�ȡ���Ƿ񿪷Ų�ѡ
     * (non-Javadoc)
     * @see busninesslogic.AdminBLService#getAbleToReselectCourse()
     */
    public Boolean getAbleToReselectCourse() {
  		int able = -1;
  		try { 
  			AdminPermissionDataService adminPermission =(AdminPermissionDataService) Naming.lookup("rmi://localhost:8888/AdminPermissionData"); 
  			able = adminPermission.getPermission(3);
          } catch (NotBoundException e) { 
              e.printStackTrace(); 
          } catch (MalformedURLException e) { 
              e.printStackTrace(); 
          } catch (RemoteException e) { 
              e.printStackTrace();   
          } 
  		if(able == 0){//��ѡ
  			return true;
  		}else{
  			return false;
  		}
  	}
     
    /*
     * ��������setAbleToReselectCourse
     * ���ܣ������Ƿ񿪷Ų�ѡ
     * (non-Javadoc)
     * @see busninesslogic.AdminBLService#setAbleToReselectCourse(java.lang.String)
     */
    public int setAbleToReselectCourse(String yesOrno){
     	 int able = 2;
     	 if(yesOrno.equals("��")){
     		 able = 0;
     		try { 
      			AdminPermissionDataService adminPermission =(AdminPermissionDataService) Naming.lookup("rmi://localhost:8888/AdminPermissionData"); 
      			adminPermission.setPermission(3,"0");
              } catch (NotBoundException e) { 
                  e.printStackTrace(); 
              } catch (MalformedURLException e) { 
                  e.printStackTrace(); 
              } catch (RemoteException e) { 
                  e.printStackTrace();   
              } 
     	 }else if(yesOrno.equals("��")){
     		 able = 1;
     		try { 
      			AdminPermissionDataService adminPermission =(AdminPermissionDataService) Naming.lookup("rmi://localhost:8888/AdminPermissionData"); 
      			adminPermission.setPermission(3,"1");
              } catch (NotBoundException e) { 
                  e.printStackTrace(); 
              } catch (MalformedURLException e) { 
                  e.printStackTrace(); 
              } catch (RemoteException e) { 
                  e.printStackTrace();   
              } 
     	 }
     	 return able;
      }
      
    /*
     * ��������getAbleToChangePolicy
     * ���ܣ�ȡ���Ƿ񿪷Ÿ��������ܲ���
     * (non-Javadoc)
     * @see busninesslogic.AdminBLService#getAbleToChangePolicy()
     */
    public Boolean getAbleToChangePolicy() {
  		int able = -1;
  		try { 
  			AdminPermissionDataService adminPermission =(AdminPermissionDataService) Naming.lookup("rmi://localhost:8888/AdminPermissionData"); 
  			able = adminPermission.getPermission(0);
  			System.out.println("____"+able);
          } catch (NotBoundException e) { 
              e.printStackTrace(); 
          } catch (MalformedURLException e) { 
              e.printStackTrace(); 
          } catch (RemoteException e) { 
              e.printStackTrace();   
          } 
  		if(able == 0){//��ѡ
  			return true;
  		}else{
  			return false;
  		}
  	}
      
    /*
     * ��������setAbleToChangePolicy
     * ���ܣ������Ƿ񿪷��޸������ܲ���
     * (non-Javadoc)
     * @see busninesslogic.AdminBLService#setAbleToChangePolicy(java.lang.String)
     */
    public int setAbleToChangePolicy(String yesOrno){
     	 int able = 2;
     	 if(yesOrno.equals("��")){
     		 able = 0;
     		try { 
      			AdminPermissionDataService adminPermission =(AdminPermissionDataService) Naming.lookup("rmi://localhost:8888/AdminPermissionData"); 
      			adminPermission.setPermission(0,"0");
              } catch (NotBoundException e) { 
                  e.printStackTrace(); 
              } catch (MalformedURLException e) { 
                  e.printStackTrace(); 
              } catch (RemoteException e) { 
                  e.printStackTrace();   
              } 
     	 }else if(yesOrno.equals("��")){
     		 able = 1;
     		try { 
      			AdminPermissionDataService adminPermission =(AdminPermissionDataService) Naming.lookup("rmi://localhost:8888/AdminPermissionData"); 
      			adminPermission.setPermission(0,"1");
              } catch (NotBoundException e) { 
                  e.printStackTrace(); 
              } catch (MalformedURLException e) { 
                  e.printStackTrace(); 
              } catch (RemoteException e) { 
                  e.printStackTrace();   
              } 
     	 }
     	 return able;
      }
    
    /*
     * ��������getAbleToChangePlan
     * ���ܣ�ȡ���Ƿ񿪷��޸�Ժϵ��ѧ�ƻ�
     * (non-Javadoc)
     * @see busninesslogic.AdminBLService#getAbleToChangePlan()
     */
    public Boolean getAbleToChangePlan() {
  		int able = -1;
  		try { 
  			AdminPermissionDataService adminPermission =(AdminPermissionDataService) Naming.lookup("rmi://localhost:8888/AdminPermissionData"); 
  			able = adminPermission.getPermission(1);
  			System.out.println("____"+able);
          } catch (NotBoundException e) { 
              e.printStackTrace(); 
          } catch (MalformedURLException e) { 
              e.printStackTrace(); 
          } catch (RemoteException e) { 
              e.printStackTrace();   
          } 
  		if(able == 0){//��ѡ
  			return true;
  		}else{
  			return false;
  		}
  	}
     
    /*
     * ��������setAbleToChangePlan
     * ���ܣ������Ƿ񿪷��޸�Ժϵ��ѧ�ƻ�
     * (non-Javadoc)
     * @see busninesslogic.AdminBLService#setAbleToChangePlan(java.lang.String)
     */
    public int setAbleToChangePlan(String yesOrno){
     	 int able = 2;
     	 if(yesOrno.equals("��")){
     		 able = 0;
     		try { 
      			AdminPermissionDataService adminPermission =(AdminPermissionDataService) Naming.lookup("rmi://localhost:8888/AdminPermissionData"); 
      			adminPermission.setPermission(1,"0");
              } catch (NotBoundException e) { 
                  e.printStackTrace(); 
              } catch (MalformedURLException e) { 
                  e.printStackTrace(); 
              } catch (RemoteException e) { 
                  e.printStackTrace();   
              } 
     	 }else if(yesOrno.equals("��")){
     		 able = 1;
     		try { 
      			AdminPermissionDataService adminPermission =(AdminPermissionDataService) Naming.lookup("rmi://localhost:8888/AdminPermissionData"); 
      			adminPermission.setPermission(1,"1");
              } catch (NotBoundException e) { 
                  e.printStackTrace(); 
              } catch (MalformedURLException e) { 
                  e.printStackTrace(); 
              } catch (RemoteException e) { 
                  e.printStackTrace();   
              } 
     	 }
     	 return able;
      }

 	/*
 	 * ��������getAbleToSelectCourse
 	 * ���ܣ�ȡ���Ƿ񿪷�ѡ��
 	 * (non-Javadoc)
 	 * @see busninesslogic.AdminBLService#getAbleToSelectCourse()
 	 */
 	public Boolean getAbleToSelectCourse() {
 		int able = -1;
 		try { 
 			AdminPermissionDataService adminPermission =(AdminPermissionDataService) Naming.lookup("rmi://localhost:8888/AdminPermissionData"); 
 			able = adminPermission.getPermission(2);
 			System.out.println("____"+able);
         } catch (NotBoundException e) { 
             e.printStackTrace(); 
         } catch (MalformedURLException e) { 
             e.printStackTrace(); 
         } catch (RemoteException e) { 
             e.printStackTrace();   
         } 
 		if(able == 0){//��ѡ
 			return true;
 		}else{
 			return false;
 		}
 	}

 	/*
 	 * ��������setAbleToSelectCourse
 	 * ���ܣ������Ƿ񿪷�ѡ��
 	 * (non-Javadoc)
 	 * @see busninesslogic.AdminBLService#setAbleToSelectCourse(java.lang.String)
 	 */
 	public int setAbleToSelectCourse(String yesOrno) {
 		int able = 2;
    	    if(yesOrno.equals("��")){
    		    able = 0;
    		    try { 
          			AdminPermissionDataService adminPermission =(AdminPermissionDataService) Naming.lookup("rmi://localhost:8888/AdminPermissionData"); 
          			adminPermission.setPermission(2,"0");
                  } catch (NotBoundException e) { 
                      e.printStackTrace(); 
                  } catch (MalformedURLException e) { 
                      e.printStackTrace(); 
                  } catch (RemoteException e) { 
                      e.printStackTrace();   
                  } 
    	    }else if(yesOrno.equals("��")){
    		    able = 1;
    		    try { 
          			AdminPermissionDataService adminPermission =(AdminPermissionDataService) Naming.lookup("rmi://localhost:8888/AdminPermissionData"); 
          			adminPermission.setPermission(2,"1");
                  } catch (NotBoundException e) { 
                      e.printStackTrace(); 
                  } catch (MalformedURLException e) { 
                      e.printStackTrace(); 
                  } catch (RemoteException e) { 
                      e.printStackTrace();   
                  } 
    	    }
    	    return able;
 	}
}
