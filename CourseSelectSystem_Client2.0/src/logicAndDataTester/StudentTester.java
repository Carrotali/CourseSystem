package logicAndDataTester;

import busninesslogic.StudentBL;

public class StudentTester {
 public static void main(String[]args){
	 StudentBL studentBL = new StudentBL();
	 String[][]temp;
	 String[] tmp;
	 Boolean isDone=false;
	 
	 System.out.println("���Բ鿴ѧУ�γ̹���");
	 temp=studentBL.checkSchoolCourse();
	 for(int i=0;i<temp.length;i++){
		 for(int j=0;j<temp[0].length;j++){
			 System.out.print( temp[i][j]+" ");
		 }
		 System.out.println( );
	 }
	 
	 System.out.println( );
	 System.out.println("���Բ鿴ѧУĳ�ſγ̹���");
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
	 System.out.println("���Բ鿴ѧ����Ϣ����");
	 tmp=studentBL.checkSelfInfor("121200001");
	 for(int j=0;j<tmp.length;j++){
		 System.out.print( tmp[j]+" ");
	 }
	 
	 System.out.println("���Բ鿴ѧ���γ̹���");
	 temp=studentBL.checkMyCourse("121200001");
	 for(int i=0;i<temp.length;i++){
		 for(int j=0;j<temp[0].length;j++){
			 System.out.print( temp[i][j]+" ");
		 }
		 System.out.println( );
	 }
	 
	 
	 System.out.println( );
	 System.out.println("����ѡ�ι���");
	 isDone=studentBL.selectCourse("121200001","10004");
	 System.out.println(isDone);
	 System.out.println("Ŀǰ��ѧ����ѡ�γ�");
	 temp=studentBL.checkMyCourse("121200001");
	 for(int i=0;i<temp.length;i++){
		 for(int j=0;j<temp[0].length;j++){
			 System.out.print( temp[i][j]+" ");
		 }
		 System.out.println( );
	 }
	 
	 System.out.println( );
	 System.out.println("������ѡ����");
	 isDone=studentBL.quitCourse("121200001","10004");
	 System.out.println(isDone);
	 System.out.println( );
	 System.out.println("Ŀǰ��ѧ����ѡ�γ�");
	 temp=studentBL.checkMyCourse("121200001");
	 for(int i=0;i<temp.length;i++){
		 for(int j=0;j<temp[0].length;j++){
			 System.out.print( temp[i][j]+" ");
		 }
		 System.out.println( );
	 }
	 System.out.println( );
	 System.out.println("���Բ�ѡ����");
	 isDone=studentBL.reselectCourse("121200001","10004");
	 System.out.println(isDone);
	 System.out.println( );
	 System.out.println("Ŀǰ��ѧ����ѡ�γ�");
	 temp=studentBL.checkMyCourse("121200001");
	 for(int i=0;i<temp.length;i++){
		 for(int j=0;j<temp[0].length;j++){
			 System.out.print( temp[i][j]+" ");
		 }
		 System.out.println( );
	 }
	
	 System.out.println( );
	 System.out.println("���Բ鿴ѡ�μ�¼����");
	 
	 temp=studentBL.showSelectList();
//	 System.out.println(temp.length );
	 for(int i=0;i<temp.length;i++){
		 for(int j=0;j<temp[0].length;j++){
			 System.out.print( temp[i][j]+" ");
		 }
		 System.out.println( );
	 }
	 System.out.println( );
	 
	 System.out.println("���Բ鿴ѧ���ɼ�����");
	 temp=studentBL.showScore("121200001");
	 System.out.println(temp.length );
	 for(int i=0;i<temp.length;i++){
		 for(int j=0;j<temp[0].length;j++){
			 System.out.print( temp[i][j]+" ");
		 }
		 System.out.println( );
	 }
 
	 
	 System.out.println("���Բ鿴Ժϵ׼׼��ѧ�ֹ���");
	 System.out.println("���ѧԺ׼��ѧ�֣�"+studentBL.getInScore("���ѧԺ"));
	 System.out.println("���ѧԺ׼��ѧ�֣�"+studentBL.getOutScore("���ѧԺ"));
//		String[] checkSchoolCourse(String CourseNo);
//		String[][] checkMyCourse(String id);
//		String[] checkSelfInfor(String id);


//		String getInScore(String institute);
//		String getOutScore(String institute);
//		Boolean changePassword(String id, String newPassword);
	 
 } 
	 
 }
	
	
	





