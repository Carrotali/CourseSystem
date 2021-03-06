package busninesslogic;
/*
 * 接口名：InstituteTeacherBLService
 * 功能：院系教务处老师逻辑层
 */
public interface InstituteManagerBLService {
	String[][] checkStlist(String courseNo);//查看学生列表

	String[] checkCoInfro(String courseNo);//查看课程详细信息

	String[][] checkColist(String instituteName);//查看学院课程

	Boolean manageCourse(String teacherName,String courseNo);//管理课程

	Boolean makePlan(String instituteName,String first,String second,String third,String forth,String fifth,String sixth);//制定院系教学计划

	String[] getSelfInfor(String id);//得到学院教务处老师信息

	Boolean changePassword(String iD, String text);
	
    Boolean PublishCourse(String coNo,String coName,String coAttribute,String coRight,String coSeason,String coInstitute,String coTime,String coClassroom);
   
    String[] checkInstitutePoint(String institute);//查看院系教学计划
    double[] checkInstituteScore(String institute);//查看本院学生成绩，按年级计算平均分和挂科率
    int[] checkScoreDistribution(String courseNo);//查看某门课程成绩分布
}
