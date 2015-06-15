package logicAndDataTester;

import busninesslogic.StudentBL;

public class StudentTester {
 public static void main(String[]args){
	 StudentBL studentBL = new StudentBL();
	 String[][]temp;
	 String[] tmp;
	 Boolean isDone=false;
	 
	 System.out.println("测试查看学校课程功能");
	 temp=studentBL.checkSchoolCourse();
	 for(int i=0;i<temp.length;i++){
		 for(int j=0;j<temp[0].length;j++){
			 System.out.print( temp[i][j]+" ");
		 }
		 System.out.println( );
	 }
	 
	 System.out.println( );
	 System.out.println("测试查看学校某门课程功能");
	 tmp=studentBL.checkSchoolCourse("10001");
	 for(int j=0;j<tmp.length;j++){
		 System.out.print( tmp[j]+" ");
	 }
	 System.out.println( );
	 tmp=studentBL.checkSchoolCourse("10002"); 
	 for(int j=0;j<tmp.length;j++){
		 System.out.print( tmp[j]+" ");
	 }
	 System.out.println( );
	 
	 
	 System.out.println( );
	 System.out.println("测试查看学生信息功能");
	 tmp=studentBL.checkSelfInfor("121200001");
	 for(int j=0;j<tmp.length;j++){
		 System.out.print( tmp[j]+" ");
	 }
	 
	 System.out.println("测试查看学生课程功能");
	 temp=studentBL.checkMyCourse("121200001");
	 for(int i=0;i<temp.length;i++){
		 for(int j=0;j<temp[0].length;j++){
			 System.out.print( temp[i][j]+" ");
		 }
		 System.out.println( );
	 }
	 
	 
	 System.out.println( );
	 System.out.println("测试选课功能");
	 isDone=studentBL.selectCourse("121200001","10004");
	 System.out.println(isDone);
	 System.out.println("目前该学生已选课程");
	 temp=studentBL.checkMyCourse("121200001");
	 for(int i=0;i<temp.length;i++){
		 for(int j=0;j<temp[0].length;j++){
			 System.out.print( temp[i][j]+" ");
		 }
		 System.out.println( );
	 }
	 
	 System.out.println( );
	 System.out.println("测试退选功能");
	 isDone=studentBL.quitCourse("121200001","10004");
	 System.out.println(isDone);
	 System.out.println( );
	 System.out.println("目前该学生已选课程");
	 temp=studentBL.checkMyCourse("121200001");
	 for(int i=0;i<temp.length;i++){
		 for(int j=0;j<temp[0].length;j++){
			 System.out.print( temp[i][j]+" ");
		 }
		 System.out.println( );
	 }
	 System.out.println( );
	 System.out.println("测试补选功能");
	 isDone=studentBL.reselectCourse("121200001","10004");
	 System.out.println(isDone);
	 System.out.println( );
	 System.out.println("目前该学生已选课程");
	 temp=studentBL.checkMyCourse("121200001");
	 for(int i=0;i<temp.length;i++){
		 for(int j=0;j<temp[0].length;j++){
			 System.out.print( temp[i][j]+" ");
		 }
		 System.out.println( );
	 }
	
	 System.out.println( );
	 System.out.println("测试查看选课记录功能");
	 
	 temp=studentBL.showSelectList();
//	 System.out.println(temp.length );
	 for(int i=0;i<temp.length;i++){
		 for(int j=0;j<temp[0].length;j++){
			 System.out.print( temp[i][j]+" ");
		 }
		 System.out.println( );
	 }
	 System.out.println( );
	 
	 System.out.println("测试查看学生成绩功能");
	 temp=studentBL.showScore("121200001");
	 System.out.println(temp.length );
	 for(int i=0;i<temp.length;i++){
		 for(int j=0;j<temp[0].length;j++){
			 System.out.print( temp[i][j]+" ");
		 }
		 System.out.println( );
	 }
 
	 
	 System.out.println("测试查看院系准准出学分功能");
	 System.out.println("软件学院准入学分："+studentBL.getInScore("软件学院"));
	 System.out.println("软件学院准出学分："+studentBL.getOutScore("软件学院"));
//		String[] checkSchoolCourse(String CourseNo);
//		String[][] checkMyCourse(String id);
//		String[] checkSelfInfor(String id);


//		String getInScore(String institute);
//		String getOutScore(String institute);
//		Boolean changePassword(String id, String newPassword);
	 
 } 
	 
 }
	
	
	





