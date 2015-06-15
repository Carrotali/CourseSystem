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
            System.out.println(">>>>>INFO:远程TeacherInforDataServic象绑定成功！");
            
            Naming.bind("rmi://localhost:8888/AdminPermissionData", adminPermissionData);
            System.out.println(">>>>>INFO:远程AdminPermissionDataServic象绑定成功！");
                    
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
