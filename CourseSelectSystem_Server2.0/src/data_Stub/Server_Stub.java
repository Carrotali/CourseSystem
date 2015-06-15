package data_Stub;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import data.*;

public class Server_Stub {

	public static void main(String[] args) {
		try { 
            CourseDataService courseData = new CourseData_Stub();
            InstitutePlanDataService institutePlanData = new InstitutePlanData_Stub();
            InstituteTeacherDataService instituteTeacherData = new InstituteTeacherData_Stub();
            OverallPolicyDataService overallPolicyData = new OverallPolicyData_Stub();
            SchoolTeacherDataService schoolTeacherData = new SchoolTeacherData_Stub();
            SelectCourseDataService selectCourseData = new SelectCourseData_Stub();
            StudentInforDataService studentInforData = new StudentInforData_Stub();
            TeacherInforDataService teacherInforData = new TeacherInforData_Stub();
            
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
            System.out.println(">>>>>INFO:Զ��TeacherInforDataService��󶨳ɹ���");
                    
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
