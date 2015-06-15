package logicAndDataTester;

import busninesslogic.SchoolTeacherBL;



public class SchoolTeacherTester {

	public static void main(String[]args){
		 SchoolTeacherBL schoolTeacherBL = new SchoolTeacherBL();
	 String[][]temp;
	 String[] tmp;
	 Boolean isDone=false;
	 
	 System.out.println("���Բ鿴ѧУ�γ̹���");
	 temp=schoolTeacherBL.checkSchoolCourse();
	 for(int i=0;i<temp.length;i++){
		 for(int j=0;j<temp[0].length;j++){
			 System.out.print( temp[i][j]+" ");
		 }
		 System.out.println( );
	 }
	 
	 System.out.println( );
	 System.out.println("���Բ鿴ѧУĳ�ſγ̹���");
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
	 
	 
	 System.out.println("���Բ鿴ѧ����Ϣ����");
	 temp=schoolTeacherBL.checkStudentInfor();
	 for(int i=0;i<temp.length;i++){
		 for(int j=0;j<temp[0].length;j++){
			 System.out.print( temp[i][j]+" ");
		 }
		 System.out.println( );
	 }
	 
	 System.out.println( );
	 System.out.println("���Բ鿴ĳλѧ����Ϣ����");
	 tmp=schoolTeacherBL.checkStudentInfor("121200001");
	 for(int j=0;j<tmp.length;j++){
		 System.out.print( tmp[j]+" ");
	 }
	 System.out.println( );
	 
	 
	 System.out.println("���Բ鿴��ʦ��Ϣ����");
	 temp=schoolTeacherBL.checkTeacherInfor();
	 for(int i=0;i<temp.length;i++){
		 for(int j=0;j<temp[0].length;j++){
			 System.out.print( temp[i][j]+" ");
		 }
		 System.out.println( );
	 }
	 
	 System.out.println( );
	 System.out.println("���Բ鿴ĳλ��ʦ��Ϣ����");
	 tmp=schoolTeacherBL.checkTeacherInfor("10001");
	 for(int j=0;j<tmp.length;j++){
		 System.out.print( tmp[j]+" ");
	 }
	 System.out.println( );
	 System.out.println( );
	
	 
	 
	 
	 
	 
	 
	 
	 System.out.println("���Բ鿴ѧ��רҵ�γ̺Ϳ�רҵ�γ̹���");
	 temp=schoolTeacherBL.checkInstituteCourse("���ѧԺ");
	 for(int i=0;i<temp.length;i++){
		 for(int j=0;j<temp[0].length;j++){
			 System.out.print( temp[i][j]+" ");
		 }
		 System.out.println( );
	 }
	 
	 System.out.println("���Բ鿴ͨʶͨ�޿γ̹���");
	 temp=schoolTeacherBL.checkCourseForAll("���ѧԺ");
	// System.out.println( temp[0]);
	 for(int i=0;i<temp.length;i++){
		 for(int j=0;j<temp[0].length;j++){
			 System.out.print( temp[i][j]+" ");
		 }
		 System.out.println( );
	 }
	 
	 System.out.println( );
	 System.out.println("���Է���ͨʶͨ�޿γ̹���");
	 isDone=schoolTeacherBL.publishCourseForAll("ͨʶͨ�޿γ�;40016;�����γ� ;��������ѧ;2;�ڶ�ѧ�� ;���ڶ�3-4�� ;�ɢ�-320;����;��;��");
//	 System.out.println(isDone);
//	 System.out.println( );
	 System.out.println("�鿴���º��ͨʶͨ�޿γ̹���");
	 temp=schoolTeacherBL.checkCourseForAll(" ");
	 for(int i=0;i<temp.length;i++){
		 for(int j=0;j<temp[0].length;j++){
			 System.out.print( temp[i][j]+" ");
		 }
		 System.out.println( );
	 }
	 
	 System.out.println( );
	 System.out.println("���Բ鿴Ժϵ��ѧ�ƻ�����");
	 tmp=schoolTeacherBL.checkInstitutePoint("���ѧԺ");
	 for(int j=0;j<tmp.length;j++){
		 System.out.print( tmp[j]+" ");
	 }
	 System.out.println( );
	 System.out.println( );
	 
	 System.out.println("���Բ鿴�����ܲ��Թ���");
	 temp=schoolTeacherBL.checkOverallPolicy();
	 for(int i=0;i<temp.length;i++){
		 for(int j=0;j<temp[0].length;j++){
			 System.out.print( temp[i][j]+" ");
		 }
		 System.out.println( );
	 }
	 
	 System.out.println( );
	 System.out.println("���Է��������ܲ��Թ���");
	 String temp2[]={"ѧ��רҵ�γ�;38-45;2-8ѧ��","רҵѡ�޿γ�;12-22;3-8ѧ��","��רҵѡ�޿γ�;5-10;3-8ѧ��",
				"����ѡ�޿γ�;7-8;3-8ѧ��","�ڶ�����;7-12;3-8ѧ��","��ҵ�������;8-10;7-8ѧ��"};
	 isDone=schoolTeacherBL.publishOverAllPolicy(temp2);
	 System.out.println("�鿴�µ������ܲ��Թ���");
	 temp=schoolTeacherBL.checkOverallPolicy();
	 for(int i=0;i<temp.length;i++){
		 for(int j=0;j<temp[0].length;j++){
			 System.out.print( temp[i][j]+" ");
		 }
		 System.out.println( );
	 }
 }
	
}




