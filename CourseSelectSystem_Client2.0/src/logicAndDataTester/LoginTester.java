package logicAndDataTester;

import busninesslogic.LoginBL;

public class LoginTester {

	public static void main(String[] args) {
		LoginBL loginBL = new LoginBL();
		System.out.println("����ѧ���ĵ�¼����");
		if(loginBL.isLogin("ѧ��", "121200001", "111111")){
			System.out.println("Student Logins sucessfully!");
		}else{
			System.out.println("Please relogin!");
		}
		if(loginBL.isLogin("ѧ��", "1200001", "111111")){
			System.out.println("Student Logins sucessfully!");
		}else{
			System.out.println("Please relogin!");
		}
		
		if(loginBL.isLogin("ѧ��", "121200001", "111110")){
			System.out.println("Student Logins sucessfully!");
		}else{
			System.out.println("Please relogin!");
		}
		
		System.out.println(); 
        System.out.println(); 
		System.out.println("�����ο���ʦ�ĵ�¼����");
		if(loginBL.isLogin("�ο���ʦ", "10001", "111111")){
			System.out.println("Student Logins sucessfully!");
		}else{
			System.out.println("Please relogin!");
		}
		
		if(loginBL.isLogin("�ο���ʦ", "10001", "111110")){
			System.out.println("Student Logins sucessfully!");
		}else{
			System.out.println("Please relogin!");
		}
		
		System.out.println(); 
        System.out.println(); 
		System.out.println("����Ժϵ������ʦ�ĵ�¼����");
		if(loginBL.isLogin("Ժϵ������ʦ", "20001", "111111")){
			System.out.println("Student Logins sucessfully!");
		}else{
			System.out.println("Please relogin!");
		}
		
		if(loginBL.isLogin("Ժϵ������ʦ", "20001", "111110")){
			System.out.println("Student Logins sucessfully!");
		}else{
			System.out.println("Please relogin!");
		}
		
		System.out.println(); 
        System.out.println(); 
		System.out.println("����ѧУ������ʦ�ĵ�¼����");
		if(loginBL.isLogin("ѧУ������ʦ", "30001", "111111")){
			System.out.println("Student Logins sucessfully!");
		}else{
			System.out.println("Please relogin!");
		}
		
		if(loginBL.isLogin("ѧУ������ʦ", "30001", "111110")){
			System.out.println("Student Logins sucessfully!");
		}else{
			System.out.println("Please relogin!");
		}
		
	}

}
