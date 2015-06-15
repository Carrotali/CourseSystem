package logicAndDataTester;

import busninesslogic.InstituteTeacherBL;

public class InstituteTeacherTester {
	public static void main(String[]args){
		InstituteTeacherBL InstituteTeacherBL = new InstituteTeacherBL();
		 String[][]temp;
		 String[] tmp;
		 Boolean isDone=false;
		 Boolean temp1=false;
		 
		 System.out.println("测试查看学校课程功能");
		 temp=InstituteTeacherBL.checkColist(null);
		 for(int i=0;i<temp.length;i++){
			 for(int j=0;j<temp[0].length;j++){
				 System.out.print( temp[i][j]+" ");
			 }
			 System.out.println( );
		 }
		 
		 
		 System.out.println( );
		 System.out.println("测试查看学校某门课程功能");
		 tmp=InstituteTeacherBL.checkCoInfro("10001");
		 for(int j=0;j<tmp.length;j++){
			 System.out.print( tmp[j]+" ");
		 }
		 System.out.println( );
		 tmp=InstituteTeacherBL.checkCoInfro("10002"); 
		 for(int j=0;j<tmp.length;j++){
			 System.out.print( tmp[j]+" ");
		 }
		
		 System.out.println( );
		 System.out.println("测试查看学生列表功能");
		 temp=InstituteTeacherBL.checkStlist(null);
		 for(int i=0;i<temp.length;i++){
			 for(int j=0;j<temp[0].length;j++){
				 System.out.print( temp[i][j]+" ");
			 }
			 System.out.println( );
		 }
		 
		 System.out.println("测试管理课程信息功能");
		 temp1=InstituteTeacherBL.manageCourse(null,null);
		 for(int i=0;i<temp.length;i++){
			 for(int j=0;j<temp[0].length;j++){
				 System.out.print( temp[i][j]+" ");
			 }
			 System.out.println( );
		 }
		 
		 System.out.println( );
		 System.out.println("测试制定教学计划功能");
		 String fir = "建筑";
		 String sec = "18";
		 String thi = "20";
		 String fou = "27";
		 String fiv = "15";
		 String six = "20";
		 String sev = "40";
		 //String[]plan ={"建筑","18","20","27","15","20","40"};
		 isDone=InstituteTeacherBL.makePlan(fir,sec,thi,fou,fiv,six,sev);
		 System.out.println(isDone);
		 System.out.println("再次输入教学计划");
		 isDone=InstituteTeacherBL.makePlan(fir,sec,thi,fou,fiv,six,sev);
		 System.out.println(isDone);
	}
}
