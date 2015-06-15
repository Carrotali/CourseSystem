package busninesslogic;
/*
 * 接口名：SchoolTeacherBLService
 * 功能：学校教务处老师逻辑层
 */

public interface SchoolTeacherBLService {
	String[][] checkSchoolCourse();
	String[] checkSchoolCourse(String courseNo);
	
	String[] checkSelfInfor(String id);

	String[][] checkStudentInfor();
	String[] checkStudentInfor(String id);
	    
	String[][] checkTeacherInfor();
	String[] checkTeacherInfor(String id);
	
	String[][] checkInstituteCourse(String institute);//查看学科专业课程和跨专业课程
	String[] checkInstitutePoint(String institute);//查看院系教学计划
	
	
	String[][] checkCourseForAll(String institute);  //查看通识通修课程
	Boolean publishCourseForAll(String course);
	
	Boolean publishOverAllPolicy(String[]policy);
	String[][] checkOverallPolicy();
	
	Boolean changePassword(String id,String newPassword);
}

