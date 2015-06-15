package busninesslogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import data.InstituteTeacherDataService;
import data.SchoolTeacherDataService;
import data.StudentInforDataService;
import data.TeacherInforDataService;
/*
 * 类名：LoginBL
 * 功能：实现LoginBLService接口
 */
public class LoginBL implements LoginBLService{
	/*方法名：isLogin
	 * 功能：实现登陆
	 * (non-Javadoc)
	 * @see busninesslogic.LoginBLService#isLogin(java.lang.String, java.lang.String, java.lang.String)
	 */
	public Boolean isLogin(String role, String id, String password) {
		Boolean isLogin = false;
		String infor = null;
		//System.out.println(role+id+password); 
		
		/*根据用户的身份从相应的文件中读取信息
		      若密码与用户名匹配则返回true并跳转到对应界面
		      若不匹配则返回false，在界面层会有相应提示信息
		*/
		
		if(role.equals("学生")){
			try { 
				StudentInforDataService studentInforData =(StudentInforDataService) Naming.lookup("rmi://localhost:8888/StudentInforData"); 
				//根据界面中输入的ID得到对应信息
				infor = studentInforData.find(id);
				//System.out.println(); 
	        } catch (NotBoundException e) { 
	            e.printStackTrace(); 
	        } catch (MalformedURLException e) { 
	            e.printStackTrace(); 
	        } catch (RemoteException e) { 
	            e.printStackTrace();   
	        } 
			//比较密码
			if(infor!=null){
				if(infor.split(";")[2].equals(password)){
					isLogin = true;
				}
			}
		}else if(role.equals("任课老师")){
			try { 
				TeacherInforDataService teacherInforData =(TeacherInforDataService) Naming.lookup("rmi://localhost:8888/TeacherInforData"); 
				infor = teacherInforData.find(id);
				//System.out.println("Infor is :" + infor);
	        } catch (NotBoundException e) { 
	            e.printStackTrace(); 
	        } catch (MalformedURLException e) { 
	            e.printStackTrace(); 
	        } catch (RemoteException e) { 
	            e.printStackTrace();   
	        } 
			
			if(infor!=null){
				if(infor.split(";")[2].equals(password)){
					isLogin = true;
				}
			}
		}else if(role.equals("院系教务处老师")){
			try { 
				InstituteTeacherDataService instituteTeacherData =(InstituteTeacherDataService) Naming.lookup("rmi://localhost:8888/InstituteTeacherData"); 
				infor = instituteTeacherData.find(id);
				//System.out.println(); 
	            //System.out.println(); 
	        } catch (NotBoundException e) { 
	            e.printStackTrace(); 
	        } catch (MalformedURLException e) { 
	            e.printStackTrace(); 
	        } catch (RemoteException e) { 
	            e.printStackTrace();   
	        } 
			
			if(infor!=null){
				if(infor.split(";")[2].equals(password)){
					isLogin = true;
				}
			}
		}else if(role.equals("学校教务处老师")){
			try { 
				SchoolTeacherDataService schoolTeacherData =(SchoolTeacherDataService) Naming.lookup("rmi://localhost:8888/SchoolTeacherData"); 
				infor = schoolTeacherData.find(id);
				//System.out.println("Infor is :" + infor);
	        } catch (NotBoundException e) { 
	            e.printStackTrace(); 
	        } catch (MalformedURLException e) { 
	            e.printStackTrace(); 
	        } catch (RemoteException e) { 
	            e.printStackTrace();   
	        } 
			if(infor!=null){
				if(infor.split(";")[2].equals(password)){
					isLogin = true;
				}
			}
		}else{
			if(id.equals("admin")&&password.equals("admin")){
				isLogin = true;
			}
		}
		return isLogin;
	}
	
	@Override
	/*方法名：register
	 * 功能：实现注册功能
	 * (non-Javadoc)
	 * @see busninesslogic.LoginBLService#register(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public Boolean register(String role, String id,String name, String password,String institute) {
		Boolean isRegister = true;
		String infor = null;
		if(role.equals("学生")){
			try { 
				StudentInforDataService studentInforData =(StudentInforDataService) Naming.lookup("rmi://localhost:8888/StudentInforData"); 
				//根据界面中输入的ID得到对应信息
				isRegister = studentInforData.add(id+";"+name+";"+password+";"+institute+";无;无;无");
//				System.out.println(isRegister); 
	        } catch (NotBoundException e) { 
	            e.printStackTrace(); 
	        } catch (MalformedURLException e) { 
	            e.printStackTrace(); 
	        } catch (RemoteException e) { 
	            e.printStackTrace();   
	        } 
			
		}else if(role.equals("任课老师")){
			try { 
				TeacherInforDataService teacherInforData =(TeacherInforDataService) Naming.lookup("rmi://localhost:8888/TeacherInforData"); 
				isRegister = teacherInforData.add(id+";"+name+";"+password+";"+institute);
				//System.out.println("Infor is :" + infor);
	        } catch (NotBoundException e) { 
	            e.printStackTrace(); 
	        } catch (MalformedURLException e) { 
	            e.printStackTrace(); 
	        } catch (RemoteException e) { 
	            e.printStackTrace();   
	        } 
			
			
		}else if(role.equals("院系教务处老师")){
			try { 
				InstituteTeacherDataService instituteTeacherData =(InstituteTeacherDataService) Naming.lookup("rmi://localhost:8888/InstituteTeacherData"); 
				isRegister = instituteTeacherData.add(id+";"+name+";"+password+";"+institute);
				//System.out.println(); 
	            //System.out.println(); 
	        } catch (NotBoundException e) { 
	            e.printStackTrace(); 
	        } catch (MalformedURLException e) { 
	            e.printStackTrace(); 
	        } catch (RemoteException e) { 
	            e.printStackTrace();   
	        } 
		}else{
			try { 
				SchoolTeacherDataService schoolTeacherData =(SchoolTeacherDataService) Naming.lookup("rmi://localhost:8888/SchoolTeacherData"); 
				isRegister = schoolTeacherData.add(id+";"+name+";"+password);
				//System.out.println("Infor is :" + infor);
	        } catch (NotBoundException e) { 
	            e.printStackTrace(); 
	        } catch (MalformedURLException e) { 
	            e.printStackTrace(); 
	        } catch (RemoteException e) { 
	            e.printStackTrace();   
	        } 
		}
		return isRegister;
	}
}
		
