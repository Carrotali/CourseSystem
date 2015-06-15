package busninesslogic;
/*
 * �ӿ�����TeacherBLService
 * ���ܣ��ο���ʦ�߼���
 */

public interface TeacherBLService {
	String[] getSelfInfor(String id);
	
	String[] getCourseNo(String id);
	
	String[][] checkStudents(String id);
	String[][] checkStudents(String courseNo,String id);
	
	String[][] publishScore(String id,String courseNo,String score,String teacherid); 
	
	Boolean setCourseInfor(String courseNo,String id,String[] courseInfor);
	
	String[] getCourseInfor(String courseNo);
	
	Boolean changePassword(String id,String newPassword);
}
