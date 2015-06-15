package logicAndDataTester;

import busninesslogic.LoginBL;

public class LoginTester {

	public static void main(String[] args) {
		LoginBL loginBL = new LoginBL();
		System.out.println("测试学生的登录功能");
		if(loginBL.isLogin("学生", "121200001", "111111")){
			System.out.println("Student Logins sucessfully!");
		}else{
			System.out.println("Please relogin!");
		}
		if(loginBL.isLogin("学生", "1200001", "111111")){
			System.out.println("Student Logins sucessfully!");
		}else{
			System.out.println("Please relogin!");
		}
		
		if(loginBL.isLogin("学生", "121200001", "111110")){
			System.out.println("Student Logins sucessfully!");
		}else{
			System.out.println("Please relogin!");
		}
		
		System.out.println(); 
        System.out.println(); 
		System.out.println("测试任课老师的登录功能");
		if(loginBL.isLogin("任课老师", "10001", "111111")){
			System.out.println("Student Logins sucessfully!");
		}else{
			System.out.println("Please relogin!");
		}
		
		if(loginBL.isLogin("任课老师", "10001", "111110")){
			System.out.println("Student Logins sucessfully!");
		}else{
			System.out.println("Please relogin!");
		}
		
		System.out.println(); 
        System.out.println(); 
		System.out.println("测试院系教务处老师的登录功能");
		if(loginBL.isLogin("院系教务处老师", "20001", "111111")){
			System.out.println("Student Logins sucessfully!");
		}else{
			System.out.println("Please relogin!");
		}
		
		if(loginBL.isLogin("院系教务处老师", "20001", "111110")){
			System.out.println("Student Logins sucessfully!");
		}else{
			System.out.println("Please relogin!");
		}
		
		System.out.println(); 
        System.out.println(); 
		System.out.println("测试学校教务处老师的登录功能");
		if(loginBL.isLogin("学校教务处老师", "30001", "111111")){
			System.out.println("Student Logins sucessfully!");
		}else{
			System.out.println("Please relogin!");
		}
		
		if(loginBL.isLogin("学校教务处老师", "30001", "111110")){
			System.out.println("Student Logins sucessfully!");
		}else{
			System.out.println("Please relogin!");
		}
		
	}

}
