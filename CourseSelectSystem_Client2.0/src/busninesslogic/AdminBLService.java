package busninesslogic;

/*
 * �ӿ�����AdminBLService
 * ���ܣ�����Ա�߼���
 */
public interface AdminBLService {
	
	  String[][] checkSchoolTeacherInfor();
	  String[][] checkInstituteTeacherInfor();
	  String[][] checkStudentInfor();
	  String[][] checkTeacherInfor();
	
	  Boolean DeleteSchoolTeacher(String schoolTeacherNo);
	  Boolean DeleteTeacher(String teacherNo);
	  Boolean DeleteInstituteTeacher(String instituteTeacherNo);
	  Boolean DeleteStudent(String studentNo);
	
	  Boolean getAbleToSelectCourse();
	  Boolean getAbleToReselectCourse();
	  Boolean getAbleToChangePlan();
	  Boolean getAbleToChangePolicy();
	  int setAbleToSelectCourse(String yesOrno);
	  int setAbleToReselectCourse(String yesOrno);
	  int setAbleToChangePolicy(String yesOrno);
	  int setAbleToChangePlan(String yesOrno);
}