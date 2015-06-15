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
 * ������LoginBL
 * ���ܣ�ʵ��LoginBLService�ӿ�
 */
public class LoginBL implements LoginBLService{
	/*��������isLogin
	 * ���ܣ�ʵ�ֵ�½
	 * (non-Javadoc)
	 * @see busninesslogic.LoginBLService#isLogin(java.lang.String, java.lang.String, java.lang.String)
	 */
	public Boolean isLogin(String role, String id, String password) {
		Boolean isLogin = false;
		String infor = null;
		//System.out.println(role+id+password); 
		
		/*�����û�����ݴ���Ӧ���ļ��ж�ȡ��Ϣ
		      ���������û���ƥ���򷵻�true����ת����Ӧ����
		      ����ƥ���򷵻�false���ڽ���������Ӧ��ʾ��Ϣ
		*/
		
		if(role.equals("ѧ��")){
			try { 
				StudentInforDataService studentInforData =(StudentInforDataService) Naming.lookup("rmi://localhost:8888/StudentInforData"); 
				//���ݽ����������ID�õ���Ӧ��Ϣ
				infor = studentInforData.find(id);
				//System.out.println(); 
	        } catch (NotBoundException e) { 
	            e.printStackTrace(); 
	        } catch (MalformedURLException e) { 
	            e.printStackTrace(); 
	        } catch (RemoteException e) { 
	            e.printStackTrace();   
	        } 
			//�Ƚ�����
			if(infor!=null){
				if(infor.split(";")[2].equals(password)){
					isLogin = true;
				}
			}
		}else if(role.equals("�ο���ʦ")){
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
		}else if(role.equals("Ժϵ������ʦ")){
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
		}else if(role.equals("ѧУ������ʦ")){
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
	/*��������register
	 * ���ܣ�ʵ��ע�Ṧ��
	 * (non-Javadoc)
	 * @see busninesslogic.LoginBLService#register(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public Boolean register(String role, String id,String name, String password,String institute) {
		Boolean isRegister = true;
		String infor = null;
		if(role.equals("ѧ��")){
			try { 
				StudentInforDataService studentInforData =(StudentInforDataService) Naming.lookup("rmi://localhost:8888/StudentInforData"); 
				//���ݽ����������ID�õ���Ӧ��Ϣ
				isRegister = studentInforData.add(id+";"+name+";"+password+";"+institute+";��;��;��");
//				System.out.println(isRegister); 
	        } catch (NotBoundException e) { 
	            e.printStackTrace(); 
	        } catch (MalformedURLException e) { 
	            e.printStackTrace(); 
	        } catch (RemoteException e) { 
	            e.printStackTrace();   
	        } 
			
		}else if(role.equals("�ο���ʦ")){
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
			
			
		}else if(role.equals("Ժϵ������ʦ")){
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
		
