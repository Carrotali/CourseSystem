package busninesslogic;
/*
 * �ӿ�����SchoolTeacherBLService
 * ���ܣ�ѧУ����Ա�߼���
 */

public interface SchoolManagerBLService {
	String[][] checkSchoolCourse();
	String[] checkSchoolCourse(String courseNo);
	
	String[] checkSelfInfor(String id);

	String[][] checkStudentInfor();
	String[] checkStudentInfor(String id);
	    
	String[][] checkTeacherInfor();
	String[] checkTeacherInfor(String id);
	
	String[][] checkInstituteCourse(String institute);//�鿴ѧ��רҵ�γ̺Ϳ�רҵ�γ�
	String[] checkInstitutePoint(String institute);//�鿴Ժϵ��ѧ�ƻ�
	
	
	String[][] checkCourseForAll(String institute);  //�鿴ͨʶͨ�޿γ�
	Boolean publishCourseForAll(String course);
	
	Boolean publishOverAllPolicy(String[]policy);
	String[][] checkOverallPolicy();
	
	Boolean changePassword(String id,String newPassword);
	
	String[][] checkSchoolPlan();
	
	double[] checkInstituteScore(String institute);//�鿴��Ժѧ���ɼ������꼶����ƽ���ֺ͹ҿ���
}
