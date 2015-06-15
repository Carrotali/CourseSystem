package logicAndDataTester;

import busninesslogic.TeacherBL;



public class TeacherTester {
	public static void main(String[]args){
		TeacherBL teacherBL = new TeacherBL();
		 String[][]temp;
		 String[] tmp;
		 Boolean isDone=false;
		 
		 System.out.println("测试查看选课学生功能");
		 temp=teacherBL.checkStudents("10001");
		 for(int i=0;i<temp.length;i++){
			 for(int j=0;j<temp[0].length;j++){
				 System.out.print( temp[i][j]+" ");
			 }
		 }
		 
		 System.out.println( );
		 
		 System.out.println("测试查看学校某门课程功能");
		 tmp=teacherBL.getCourseInfor("10001");
		 for(int j=0;j<tmp.length;j++){
			 System.out.print( tmp[j]+" ");
		 }
		 tmp=teacherBL.getCourseInfor("10002");
		 for(int j=0;j<tmp.length;j++){
			 System.out.print( tmp[j]+" ");
		 }
		 System.out.println( );
		 
		 System.out.println("测试完善课程信息功能");
		 String[]plan ={"《软件开发的技术基础》","《Thinking In Java》"};
		 isDone=teacherBL.setCourseInfor("10001","10001",plan);
		 System.out.println(isDone);
		 tmp=teacherBL.getCourseInfor("10001");
		 for(int j=0;j<tmp.length;j++){
			 System.out.print( tmp[j]+" ");
		 }
		 System.out.println( );
		 
		 System.out.println("测试发布学生成绩功能");
//	     publishScore(String id, String courseNo, String score)
		 temp=teacherBL.publishScore("121200003","10001","80","10001");
		 for(int i=0;i<temp.length;i++){
			 for(int j=0;j<temp[0].length;j++){
				 System.out.print( temp[i][j]+" ");
			 }
			 System.out.println( );
		 }
		
		 System.out.println("测试查看我的课程功能,得到的是课程编号");
		 tmp=teacherBL.getCourseNo("10001");
		 for(int j=0;j<tmp.length;j++){
			 System.out.print( tmp[j]+" ");
		 }
		 System.out.println( );
	}
}
