package busninesslogic;
/*
 * �ӿ�����InstituteTeacherBLService
 * ���ܣ�Ժϵ������ʦ�߼���
 */
public interface InstituteTeacherBLService {
	String[][] checkStlist(String courseNo);//�鿴ѧ���б�

	String[] checkCoInfro(String courseNo);//�鿴�γ���ϸ��Ϣ

	String[][] checkColist(String instituteName);//�鿴ѧԺ�γ�

	Boolean manageCourse(String teacherName,String courseNo);//����γ�

	Boolean makePlan(String instituteName,String first,String second,String third,String forth,String fifth,String sixth);//�ƶ�Ժϵ��ѧ�ƻ�

	String[] getSelfInfor(String id);//�õ�ѧԺ������ʦ��Ϣ

	Boolean changePassword(String iD, String text);
	
    Boolean PublishCourse(String coNo,String coName,String coAttribute,String coRight,String coSeason,String coInstitute,String coTime,String coClassroom);
}
