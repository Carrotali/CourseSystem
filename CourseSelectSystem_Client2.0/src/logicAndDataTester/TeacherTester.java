package logicAndDataTester;

import busninesslogic.TeacherBL;



public class TeacherTester {
	public static void main(String[]args){
		TeacherBL teacherBL = new TeacherBL();
		 String[][]temp;
		 String[] tmp;
		 Boolean isDone=false;
		 
		 System.out.println("���Բ鿴ѡ��ѧ������");
		 temp=teacherBL.checkStudents("10001");
		 for(int i=0;i<temp.length;i++){
			 for(int j=0;j<temp[0].length;j++){
				 System.out.print( temp[i][j]+" ");
			 }
		 }
		 
		 System.out.println( );
		 
		 System.out.println("���Բ鿴ѧУĳ�ſγ̹���");
		 tmp=teacherBL.getCourseInfor("10001");
		 for(int j=0;j<tmp.length;j++){
			 System.out.print( tmp[j]+" ");
		 }
		 tmp=teacherBL.getCourseInfor("10002");
		 for(int j=0;j<tmp.length;j++){
			 System.out.print( tmp[j]+" ");
		 }
		 System.out.println( );
		 
		 System.out.println("�������ƿγ���Ϣ����");
		 String[]plan ={"����������ļ���������","��Thinking In Java��"};
		 isDone=teacherBL.setCourseInfor("10001","10001",plan);
		 System.out.println(isDone);
		 tmp=teacherBL.getCourseInfor("10001");
		 for(int j=0;j<tmp.length;j++){
			 System.out.print( tmp[j]+" ");
		 }
		 System.out.println( );
		 
		 System.out.println("���Է���ѧ���ɼ�����");
//	     publishScore(String id, String courseNo, String score)
		 temp=teacherBL.publishScore("121200003","10001","80","10001");
		 for(int i=0;i<temp.length;i++){
			 for(int j=0;j<temp[0].length;j++){
				 System.out.print( temp[i][j]+" ");
			 }
			 System.out.println( );
		 }
		
		 System.out.println("���Բ鿴�ҵĿγ̹���,�õ����ǿγ̱��");
		 tmp=teacherBL.getCourseNo("10001");
		 for(int j=0;j<tmp.length;j++){
			 System.out.print( tmp[j]+" ");
		 }
		 System.out.println( );
	}
}
