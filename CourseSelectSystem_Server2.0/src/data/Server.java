package data;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {

	
	public static void main(String[] args) {
		try { 
            CourseDataService courseData = new CourseData();
            InstitutePlanDataService institutePlanData = new InstitutePlanData();
            InstituteTeacherDataService instituteTeacherData = new InstituteTeacherData();
            OverallPolicyDataService overallPolicyData = new OverallPolicyData();
            SchoolTeacherDataService schoolTeacherData = new SchoolTeacherData();
            SelectCourseDataService selectCourseData = new SelectCourseData();
            StudentInforDataService studentInforData = new StudentInforData();
            TeacherInforDataService teacherInforData = new TeacherInforData();
            AdminPermissionDataService adminPermissionData = new AdminPermissionData();
            
            LocateRegistry.createRegistry(8888); 
            
            Naming.bind("rmi://localhost:8888/CourseData",courseData); 
            System.out.println(">>>>>INFO:Զ��CourseDataService����󶨳ɹ���"); 
            
            Naming.bind("rmi://localhost:8888/InstitutePlanData",institutePlanData );
            System.out.println(">>>>>INFO:Զ��InstitutePlanDataService����󶨳ɹ���"); 
            
            Naming.bind("rmi://localhost:8888/InstituteTeacherData", instituteTeacherData);
            System.out.println(">>>>>INFO:Զ��InstituteTeacherDataService��󶨳ɹ���"); 
            
            Naming.bind("rmi://localhost:8888/OverallPolicyData", overallPolicyData);
            System.out.println(">>>>>INFO:Զ��OverallPolicyDataService��󶨳ɹ���"); 
            
            Naming.bind("rmi://localhost:8888/SchoolTeacherData", schoolTeacherData);
            System.out.println(">>>>>INFO:Զ��SchoolTeacherDataService��󶨳ɹ���"); 
            
            Naming.bind("rmi://localhost:8888/SelectCourseData", selectCourseData);
            System.out.println(">>>>>INFO:Զ��SelectCourseDataService��󶨳ɹ���"); 
            
            Naming.bind("rmi://localhost:8888/StudentInforData", studentInforData);
            System.out.println(">>>>>INFO:Զ��StudentInforDataService��󶨳ɹ���"); 
            
            Naming.bind("rmi://localhost:8888/TeacherInforData", teacherInforData);
            System.out.println(">>>>>INFO:Զ��TeacherInforDataServic��󶨳ɹ���");
            
            Naming.bind("rmi://localhost:8888/AdminPermissionData", adminPermissionData);
            System.out.println(">>>>>INFO:Զ��AdminPermissionDataServic��󶨳ɹ���");
                    
        } catch (RemoteException e) { 
            System.out.println("����Զ�̶������쳣��"); 
            e.printStackTrace(); 
        } catch (AlreadyBoundException e) { 
            System.out.println("�����ظ��󶨶����쳣��"); 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            System.out.println("����URL�����쳣��"); 
            e.printStackTrace(); 
        } 
	}

}
