package logicAndDataTester;

import busninesslogic.InstituteTeacherBL;

public class InstituteTeacherTester {
	public static void main(String[]args){
		InstituteTeacherBL InstituteTeacherBL = new InstituteTeacherBL();
		 String[][]temp;
		 String[] tmp;
		 Boolean isDone=false;
		 Boolean temp1=false;
		 
		 System.out.println("���Բ鿴ѧУ�γ̹���");
		 temp=InstituteTeacherBL.checkColist(null);
		 for(int i=0;i<temp.length;i++){
			 for(int j=0;j<temp[0].length;j++){
				 System.out.print( temp[i][j]+" ");
			 }
			 System.out.println( );
		 }
		 
		 
		 System.out.println( );
		 System.out.println("���Բ鿴ѧУĳ�ſγ̹���");
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
		 System.out.println("���Բ鿴ѧ���б���");
		 temp=InstituteTeacherBL.checkStlist(null);
		 for(int i=0;i<temp.length;i++){
			 for(int j=0;j<temp[0].length;j++){
				 System.out.print( temp[i][j]+" ");
			 }
			 System.out.println( );
		 }
		 
		 System.out.println("���Թ���γ���Ϣ����");
		 temp1=InstituteTeacherBL.manageCourse(null,null);
		 for(int i=0;i<temp.length;i++){
			 for(int j=0;j<temp[0].length;j++){
				 System.out.print( temp[i][j]+" ");
			 }
			 System.out.println( );
		 }
		 
		 System.out.println( );
		 System.out.println("�����ƶ���ѧ�ƻ�����");
		 String fir = "����";
		 String sec = "18";
		 String thi = "20";
		 String fou = "27";
		 String fiv = "15";
		 String six = "20";
		 String sev = "40";
		 //String[]plan ={"����","18","20","27","15","20","40"};
		 isDone=InstituteTeacherBL.makePlan(fir,sec,thi,fou,fiv,six,sev);
		 System.out.println(isDone);
		 System.out.println("�ٴ������ѧ�ƻ�");
		 isDone=InstituteTeacherBL.makePlan(fir,sec,thi,fou,fiv,six,sev);
		 System.out.println(isDone);
	}
}
