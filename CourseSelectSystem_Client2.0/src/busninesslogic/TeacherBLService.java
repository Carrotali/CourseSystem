package busninesslogic;
/*
 * 接口名：TeacherBLService
 * 功能：任课老师逻辑层
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
