package logicAndDataTester;

import busninesslogic.SchoolTeacherBL;



public class SchoolTeacherTester {

	public static void main(String[]args){
		 SchoolTeacherBL schoolTeacherBL = new SchoolTeacherBL();
	 String[][]temp;
	 String[] tmp;
	 Boolean isDone=false;
	 
	 System.out.println("测试查看学校课程功能");
	 temp=schoolTeacherBL.checkSchoolCourse();
	 for(int i=0;i<temp.length;i++){
		 for(int j=0;j<temp[0].length;j++){
			 System.out.print( temp[i][j]+" ");
		 }
		 System.out.println( );
	 }
	 
	 System.out.println( );
	 System.out.println("测试查看学校某门课程功能");
	 tmp=schoolTeacherBL.checkSchoolCourse("10001");
	 for(int j=0;j<tmp.length;j++){
		 System.out.print( tmp[j]+" ");
	 }
	 System.out.println( );
	 tmp=schoolTeacherBL.checkSchoolCourse("10002"); 
	 for(int j=0;j<tmp.length;j++){
		 System.out.print( tmp[j]+" ");
	 }
	 System.out.println( );
	 
	 
	 System.out.println("测试查看学生信息功能");
	 temp=schoolTeacherBL.checkStudentInfor();
	 for(int i=0;i<temp.length;i++){
		 for(int j=0;j<temp[0].length;j++){
			 System.out.print( temp[i][j]+" ");
		 }
		 System.out.println( );
	 }
	 
	 System.out.println( );
	 System.out.println("测试查看某位学生信息功能");
	 tmp=schoolTeacherBL.checkStudentInfor("121200001");
	 for(int j=0;j<tmp.length;j++){
		 System.out.print( tmp[j]+" ");
	 }
	 System.out.println( );
	 
	 
	 System.out.println("测试查看教师信息功能");
	 temp=schoolTeacherBL.checkTeacherInfor();
	 for(int i=0;i<temp.length;i++){
		 for(int j=0;j<temp[0].length;j++){
			 System.out.print( temp[i][j]+" ");
		 }
		 System.out.println( );
	 }
	 
	 System.out.println( );
	 System.out.println("测试查看某位教师信息功能");
	 tmp=schoolTeacherBL.checkTeacherInfor("10001");
	 for(int j=0;j<tmp.length;j++){
		 System.out.print( tmp[j]+" ");
	 }
	 System.out.println( );
	 System.out.println( );
	
	 
	 
	 
	 
	 
	 
	 
	 System.out.println("测试查看学科专业课程和跨专业课程功能");
	 temp=schoolTeacherBL.checkInstituteCourse("软件学院");
	 for(int i=0;i<temp.length;i++){
		 for(int j=0;j<temp[0].length;j++){
			 System.out.print( temp[i][j]+" ");
		 }
		 System.out.println( );
	 }
	 
	 System.out.println("测试查看通识通修课程功能");
	 temp=schoolTeacherBL.checkCourseForAll("软件学院");
	// System.out.println( temp[0]);
	 for(int i=0;i<temp.length;i++){
		 for(int j=0;j<temp[0].length;j++){
			 System.out.print( temp[i][j]+" ");
		 }
		 System.out.println( );
	 }
	 
	 System.out.println( );
	 System.out.println("测试发布通识通修课程功能");
	 isDone=schoolTeacherBL.publishCourseForAll("通识通修课程;40016;公共课程 ;艺术与哲学;2;第二学期 ;星期二3-4节 ;仙Ⅰ-320;不详;无;无");
//	 System.out.println(isDone);
//	 System.out.println( );
	 System.out.println("查看更新后的通识通修课程功能");
	 temp=schoolTeacherBL.checkCourseForAll(" ");
	 for(int i=0;i<temp.length;i++){
		 for(int j=0;j<temp[0].length;j++){
			 System.out.print( temp[i][j]+" ");
		 }
		 System.out.println( );
	 }
	 
	 System.out.println( );
	 System.out.println("测试查看院系教学计划功能");
	 tmp=schoolTeacherBL.checkInstitutePoint("软件学院");
	 for(int j=0;j<tmp.length;j++){
		 System.out.print( tmp[j]+" ");
	 }
	 System.out.println( );
	 System.out.println( );
	 
	 System.out.println("测试查看整体框架策略功能");
	 temp=schoolTeacherBL.checkOverallPolicy();
	 for(int i=0;i<temp.length;i++){
		 for(int j=0;j<temp[0].length;j++){
			 System.out.print( temp[i][j]+" ");
		 }
		 System.out.println( );
	 }
	 
	 System.out.println( );
	 System.out.println("测试发布整体框架策略功能");
	 String temp2[]={"学科专业课程;38-45;2-8学期","专业选修课程;12-22;3-8学期","跨专业选修课程;5-10;3-8学期",
				"公共选修课程;7-8;3-8学期","第二课堂;7-12;3-8学期","毕业论文设计;8-10;7-8学期"};
	 isDone=schoolTeacherBL.publishOverAllPolicy(temp2);
	 System.out.println("查看新的整体框架策略功能");
	 temp=schoolTeacherBL.checkOverallPolicy();
	 for(int i=0;i<temp.length;i++){
		 for(int j=0;j<temp[0].length;j++){
			 System.out.print( temp[i][j]+" ");
		 }
		 System.out.println( );
	 }
 }
	
}




