package busninesslogic;
/*
 * �ӿ�����StudentBLService
 * ���ܣ�ѧ���߼���
 */

public interface StudentBLService {
	
	String[][] checkSchoolCourse();
	
	String[] checkSchoolCourse(String CourseNo);
	
	String[][] checkMyCourse(String id);
	
	String[] checkSelfInfor(String id);
	
	Boolean selectCourse(String id,String courseNo);
	
	Boolean reselectCourse(String id,String courseNo);
	
	Boolean quitCourse(String id,String courseNo);
	
	String[][] showSelectList();
	
	String[][] showScore(String id);
	
	String getInScore(String institute);
	
	String getOutScore(String institute);
	
	Boolean changePassword(String id, String newPassword);
}
