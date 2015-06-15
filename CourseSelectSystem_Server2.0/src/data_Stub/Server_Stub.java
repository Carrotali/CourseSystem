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
            System.out.println(">>>>>INFO:远程CourseDataService对象绑定成功！"); 
            
            Naming.bind("rmi://localhost:8888/InstitutePlanData",institutePlanData );
            System.out.println(">>>>>INFO:远程InstitutePlanDataService对象绑定成功！"); 
            
            Naming.bind("rmi://localhost:8888/InstituteTeacherData", instituteTeacherData);
            System.out.println(">>>>>INFO:远程InstituteTeacherDataService象绑定成功！"); 
            
            Naming.bind("rmi://localhost:8888/OverallPolicyData", overallPolicyData);
            System.out.println(">>>>>INFO:远程OverallPolicyDataService象绑定成功！"); 
            
            Naming.bind("rmi://localhost:8888/SchoolTeacherData", schoolTeacherData);
            System.out.println(">>>>>INFO:远程SchoolTeacherDataService象绑定成功！"); 
            
            Naming.bind("rmi://localhost:8888/SelectCourseData", selectCourseData);
            System.out.println(">>>>>INFO:远程SelectCourseDataService象绑定成功！"); 
            
            Naming.bind("rmi://localhost:8888/StudentInforData", studentInforData);
            System.out.println(">>>>>INFO:远程StudentInforDataService象绑定成功！"); 
            
            Naming.bind("rmi://localhost:8888/TeacherInforData", teacherInforData);
            System.out.println(">>>>>INFO:远程TeacherInforDataService象绑定成功！");
                    
        } catch (RemoteException e) { 
            System.out.println("创建远程对象发生异常！"); 
            e.printStackTrace(); 
        } catch (AlreadyBoundException e) { 
            System.out.println("发生重复绑定对象异常！"); 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            System.out.println("发生URL畸形异常！"); 
            e.printStackTrace(); 
        } 
	}

}
