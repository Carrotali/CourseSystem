package busninesslogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import data.CourseDataService;
import data.InstitutePlanDataService;
import data.InstituteManagerDataService;
import data.SelectCourseDataService;
import data.StudentInforDataService;
import data.TeacherInforDataService;

/*
 * 类名：InstituteManagerBL
 * 功能：实现InstituteManagerBLService接口
 */
public class InstituteManagerBL implements InstituteManagerBLService {
	/*
	 * 方法名：checkColist 功能：查看学院课程 (non-Javadoc)
	 * 
	 * @see
	 * busninesslogic.InstituteManagerBLService#checkColist(java.lang.String)
	 */
	public String[][] checkColist(String instituteName) {
		ArrayList<String> courseList = new ArrayList<String>();
		try {
			CourseDataService courseData = (CourseDataService) Naming
					.lookup("rmi://localhost:8888/CourseData");
			// 读取全部课程
			courseList = courseData.read();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		int num = 0;
		for (int i = 0; i < courseList.size(); i++) {
			if (instituteName.equals(courseList.get(i).split(";")[2])) {// 判断是否为本院课程
				num++;
			}
		}
		String[][] courses = new String[num][];
		int j = 0;
		for (int i = 0; i < courseList.size(); i++) {
			if (instituteName.equals(courseList.get(i).split(";")[2])) {
				courses[j] = courseList.get(i).split(";");
				j++;
			}
		}

		return courses;
	}

	// 查看课程详细信息
	/*
	 * 方法名：checkCoInfro 功能：查看课程信息 (non-Javadoc)
	 * 
	 * @see
	 * busninesslogic.InstituteManagerBLService#checkCoInfro(java.lang.String)
	 */
	public String[] checkCoInfro(String courseNo) {
		String[] findCourseInfro = null;
		ArrayList<String> courseList = new ArrayList<String>();

		try {
			CourseDataService courseData = (CourseDataService) Naming
					.lookup("rmi://localhost:8888/CourseData");
			courseList = courseData.read();
			System.out.println();
			System.out.println();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		boolean exist = false;
		for (String str : courseList) {
			String[] temp = str.split(";");
			if (temp[1].equals(courseNo)) {
				findCourseInfro = temp;
				exist = true;
				break;
			}
		}
		if (exist == false) {
			findCourseInfro = null;
		}
		return findCourseInfro;
	}

	@Override
	// 查看学生列表
	/*
	 * 方法名：checkStlist 功能：查看学生列表 (non-Javadoc)
	 * 
	 * @see
	 * busninesslogic.InstituteManagerBLService#checkStlist(java.lang.String)
	 */
	public String[][] checkStlist(String courseNo) {

		ArrayList<String> selectRecord = new ArrayList<String>();
		try {
			SelectCourseDataService selectCourseDataService = (SelectCourseDataService) Naming
					.lookup("rmi://localhost:8888/SelectCourseData");
			selectRecord = selectCourseDataService.read();
			System.out.println();
			System.out.println();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		int num = 0;
		for (int i = 0; i < selectRecord.size(); i++) {
			if (courseNo.equals(selectRecord.get(i).split(";")[1])) {
				num++;
			}
		}// 获得选择该课的学生人数num。

		String[][] result = new String[num][];
		if (num != 0) {

			String[] stuNo = new String[num];
			int n = 0;
			for (int i = 0; i < selectRecord.size(); i++) {
				if (courseNo.equals(selectRecord.get(i).split(";")[1])) {
					stuNo[n] = selectRecord.get(i).split(";")[0];
					n++;
				}
			}// 获得选择该课的学生学号数组。

			ArrayList<String> stuInfroList = new ArrayList<String>();
			try {
				StudentInforDataService studentInfroData = (StudentInforDataService) Naming
						.lookup("rmi://localhost:8888/StudentInforData");
				stuInfroList = studentInfroData.read();
				System.out.println();
				System.out.println();
			} catch (NotBoundException e) {
				e.printStackTrace();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (RemoteException e) {
				e.printStackTrace();
			}

			for (int i = 0; i < num; i++) {
				for (int j = 0; j < stuInfroList.size(); j++) {
					if (stuNo[i].equals(stuInfroList.get(j).split(";")[0])) {
						result[i] = stuInfroList.get(j).split(";");
					}
				}
			}
			for (int i = 0; i < num; i++) {
				result[i][2] = courseNo;
			}
			/*
			 * int p = 0; for(int i = 0 ; i < stuInforList.size() ; i++){ if
			 * (courseNo.equals(stuInforList.get(i).split(";")[1])){ result[p] =
			 * stuInforList.get(i).split(";"); p++; }
			 * 
			 * }
			 */
		} else {
			result = null;
		}
		return result;
	}

	@Override
	// 管理课程
	/*
	 * 方法名：manageCourse 功能：管理课程 (non-Javadoc)
	 * 
	 * @see
	 * busninesslogic.InstituteManagerBLService#manageCourse(java.lang.String,
	 * java.lang.String)
	 */
	public Boolean manageCourse(String teacherName, String courseNo) {
		ArrayList<String> teacherInforList = new ArrayList<String>();
		try {
			TeacherInforDataService teacherInforData = (TeacherInforDataService) Naming
					.lookup("rmi://localhost:8888/TeacherInforData");
			teacherInforList = teacherInforData.read();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		String[] teacherInfor = new String[teacherInforList.size()];
		for (int i = 0; i < teacherInforList.size(); i++) {
			teacherInfor[i] = teacherInforList.get(i).split(";")[0];
		}
		boolean th_exist = false;
		String[] thstr = null;
		for (int i = 0; i < teacherInforList.size(); i++) {
			if (teacherName.equals(teacherInfor[i])) {
				th_exist = true;
				thstr = teacherInforList.get(i).split(";");
			}
		}
		ArrayList<String> courseList = new ArrayList<String>();
		try {
			CourseDataService courseData = (CourseDataService) Naming
					.lookup("rmi://localhost:8888/CourseData");
			courseList = courseData.read();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		String[] courses = new String[courseList.size()];
		for (int i = 0; i < courseList.size(); i++) {
			courses[i] = courseList.get(i).split(";")[1];
		}
		boolean co_exist = false;
		String[] costr = null;
		for (int i = 0; i < courseList.size(); i++) {
			if (courseNo.equals(courses[i])) {
				co_exist = true;
				costr = courseList.get(i).split(";");
			}
		}

		Boolean isSet = false;

		if (th_exist == true && co_exist == true) {
			isSet = true;
			costr[8] = thstr[1] + "," + thstr[0];
			String newCoInfro = "";
			for (int i = 0; i < 10; i++) {
				newCoInfro = newCoInfro + costr[i] + ";";
			}
			newCoInfro += costr[10];
			try {
				CourseDataService courseData = (CourseDataService) Naming
						.lookup("rmi://localhost:8888/CourseData");
				isSet = courseData.update(newCoInfro);
			} catch (NotBoundException e) {
				e.printStackTrace();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (RemoteException e) {
				e.printStackTrace();
			}

		}

		return isSet;
	}

	// 制定院系教学计划
	@Override
	/*
	 * 方法名：makePlan 功能：制定教学计划 (non-Javadoc)
	 * 
	 * @see busninesslogic.InstituteManagerBLService#makePlan(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	public Boolean makePlan(String instituteName, String first, String second,
			String third, String forth, String fifth, String sixth) {
		String plans = instituteName + ";" + first + ";" + second + ";" + third
				+ ";" + forth + ";" + fifth + ";" + sixth;
		Boolean isMake = false;

		try {
			InstitutePlanDataService institutePlanData = (InstitutePlanDataService) Naming
					.lookup("rmi://localhost:8888/InstitutePlanData");
			isMake = institutePlanData.write(plans);
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		return isMake;
	}

	// 得到个人信息
	/*
	 * 方法名：getSelfInfor 功能：得到个人信息 (non-Javadoc)
	 * 
	 * @see
	 * busninesslogic.InstituteManagerBLService#getSelfInfor(java.lang.String)
	 */
	public String[] getSelfInfor(String id) {
		String[] inforList = null;
		try {
			InstituteManagerDataService InstituteManagerData = (InstituteManagerDataService) Naming
					.lookup("rmi://localhost:8888/InstituteManagerData");
			inforList = InstituteManagerData.find(id).split(";");
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return inforList;
	}

	// 修改密码
	/*
	 * 方法名：changePassword 功能：修改密码 (non-Javadoc)
	 * 
	 * @see
	 * busninesslogic.InstituteManagerBLService#changePassword(java.lang.String,
	 * java.lang.String)
	 */
	public Boolean changePassword(String id, String newPassword) {
		String[] infor = null;
		Boolean isChange = false;
		try {
			InstituteManagerDataService InstituteManagerData = (InstituteManagerDataService) Naming
					.lookup("rmi://localhost:8888/InstituteManagerData");
			infor = InstituteManagerData.find(id).split(";");
			isChange = InstituteManagerData.update(infor[0] + ";" + infor[1]
					+ ";" + newPassword + ";" + infor[3]);
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return isChange;
	}

	/*
	 * 方法名：PublishCourse 功能：发布课程 (non-Javadoc)
	 * 
	 * @see
	 * busninesslogic.InstituteManagerBLService#PublishCourse(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	public Boolean PublishCourse(String coNo, String coName,
			String coAttribute, String coRight, String coSeason,
			String coInstitute, String coTime, String coClassroom) {
		Boolean isSet = false;
		ArrayList<String> courseList = new ArrayList<String>();
		try {
			CourseDataService courseData = (CourseDataService) Naming
					.lookup("rmi://localhost:8888/CourseData");
			courseList = courseData.read();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		String[] coursesNo = new String[courseList.size()];
		for (int i = 0; i < courseList.size(); i++) {
			coursesNo[i] = courseList.get(i).split(";")[1];
		}
		boolean coNoIsExist = false;
		for (int i = 0; i < courseList.size(); i++) {
			if (coNo.equals(coursesNo[i])) {
				coNoIsExist = true;
			}
		}
		String[] coursesName = new String[courseList.size()];
		for (int i = 0; i < courseList.size(); i++) {
			coursesName[i] = courseList.get(i).split(";")[3];
		}
		boolean coNameIsExist = false;
		for (int i = 0; i < courseList.size(); i++) {
			if (coName.equals(coursesName[i])) {
				coNameIsExist = true;
			}
		}

		if ((coNoIsExist || coNameIsExist) == false) {
			String newCourse = coAttribute + ";" + coNo + ";" + coInstitute
					+ ";" + coName + ";" + coRight + ";" + coSeason + ";"
					+ coTime + ";" + coClassroom + ";" + "无" + ";" + "无" + ";"
					+ "无";
			try {
				CourseDataService courseData = (CourseDataService) Naming
						.lookup("rmi://localhost:8888/CourseData");
				courseData.add(newCourse);
			} catch (NotBoundException e) {
				e.printStackTrace();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			isSet = true;
		}

		ArrayList<String> stuList = new ArrayList<String>();
		try {
			StudentInforDataService stuData = (StudentInforDataService) Naming
					.lookup("rmi://localhost:8888/StudentInforData");
			stuList = stuData.read();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		// String[] stuInstituteList = new String[stuList.size()];
		int counter = 0;
		for (int i = 0; i < stuList.size(); i++) {
			// stuInstituteList[i] = stuList.get(i).split(";")[3];
			if (stuList.get(i).split(";")[3].equals(coInstitute)) {
				counter++;
			}
		}
		String[] stuNeedtoAdd = new String[counter];
		int j = 0;
		for (int i = 0; i < stuList.size(); i++) {
			if (stuList.get(i).split(";")[3].equals(coInstitute)) {
				stuNeedtoAdd[j] = stuList.get(i).split(";")[0];
				j++;
			}
		}
		String[] newSelectRecord = new String[counter];
		for (int i = 0; i < counter; i++) {
			newSelectRecord[i] = stuNeedtoAdd[i] + ";" + coNo + ";" + "无";
			try {
				SelectCourseDataService selcetRecord = (SelectCourseDataService) Naming
						.lookup("rmi://localhost:8888/SelectCourseData");
				selcetRecord.add(newSelectRecord[i]);
			} catch (NotBoundException e) {
				e.printStackTrace();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}

		return isSet;
	}

	// 查看院系教学计划
	/*
	 * 方法名： checkInstitutePoint 功能：查看院系教学计划 (non-Javadoc)
	 * 
	 * @see
	 * busninesslogic.SchoolTeacherBLService#checkInstitutePoint(java.lang.String
	 * )
	 */
	public String[] checkInstitutePoint(String institute) {
		ArrayList<String> courseList = new ArrayList<String>();
		try {
			InstitutePlanDataService institutePlanData = (InstitutePlanDataService) Naming
					.lookup("rmi://localhost:8888/InstitutePlanData");
			courseList = institutePlanData.read();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		String[] planPoint = null;
		for (int i = 0; i < courseList.size(); i++) {
			String[] temp = courseList.get(i).split(";");
			if (temp[0].equals(institute)) {
				planPoint = courseList.get(i).split(";");
			}
		}
		return planPoint;
	}

	// 查看本院学生成绩，按年级计算平均分和挂科率
	@Override
	public double[] checkInstituteScore(String institute) {
		ArrayList<String> selectRecord = new ArrayList<String>();
		try {
			SelectCourseDataService selectCourseDataService = (SelectCourseDataService) Naming
					.lookup("rmi://localhost:8888/SelectCourseData");
			selectRecord = selectCourseDataService.read();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		int[] num = new int[4];
		int[] sum = new int[4];
		int[] failNum = new int[4];
		for (int j = 0; j < 4; j++) {
			num[j] = 0;
			sum[j] = 0;
			failNum[j] = 0;
		}
		for (int i = 0; i < selectRecord.size(); i++) {
			if (institute.equals(selectRecord.get(i).split(";")[3])) {
				if (selectRecord.get(i).split(";")[0].charAt(0) == '1'
						&& selectRecord.get(i).split(";")[0].charAt(1) == '4'
						&& Integer.parseInt(selectRecord.get(i).split(";")[2]) > -1) {
					num[0]++;
					sum[0] += Integer
							.parseInt(selectRecord.get(i).split(";")[2]);
					if (Integer.parseInt(selectRecord.get(i).split(";")[2]) < 60) {
						failNum[0]++;
					}
				}

				else if (selectRecord.get(i).split(";")[0].charAt(0) == '1'
						&& selectRecord.get(i).split(";")[0].charAt(1) == '3') {
					num[1]++;
					sum[1] += Integer
							.parseInt(selectRecord.get(i).split(";")[2]);
					if (Integer.parseInt(selectRecord.get(i).split(";")[2]) < 60) {
						failNum[1]++;
					}
				} else if (selectRecord.get(i).split(";")[0].charAt(0) == '1'
						&& selectRecord.get(i).split(";")[0].charAt(1) == '2') {
					num[2]++;
					sum[2] += Integer
							.parseInt(selectRecord.get(i).split(";")[2]);
					if (Integer.parseInt(selectRecord.get(i).split(";")[2]) < 60) {
						failNum[2]++;
					}
				} else if (selectRecord.get(i).split(";")[0].charAt(0) == '1'
						&& selectRecord.get(i).split(";")[0].charAt(1) == '1') {
					num[3]++;
					sum[3] += Integer
							.parseInt(selectRecord.get(i).split(";")[2]);
					if (Integer.parseInt(selectRecord.get(i).split(";")[2]) < 60) {
						failNum[3]++;
					}
				}

			}
		}// 获得各年级学生人数num、各年级分数总和及挂科人数。

		double[] result = new double[8];
		for (int k = 0; k < 4; k++) {
			if (num[k] != 0) {
				result[2 * k] = (double) (Math.round(sum[k] / num[k]) / 100.0);
				result[2 * k + 1] = (double) (Math.round(failNum[k] * 100
						/ num[k]) / 100.0);
			} else {
				result[2 * k] = result[2 * k + 1] = 0;
			}
		}
		return result;
	}

	// 查看某门课程成绩分布
	@Override
	public int[] checkScoreDistribution(String courseNo) {
		ArrayList<String> selectRecord = new ArrayList<String>();
		try {
			SelectCourseDataService selectCourseDataService = (SelectCourseDataService) Naming
					.lookup("rmi://localhost:8888/SelectCourseData");
			selectRecord = selectCourseDataService.read();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		int[] result = new int[5];
		for (int k = 0; k < 5; k++)
			result[k] = 0;
		for (int i = 0; i < selectRecord.size(); i++) {
			if (courseNo.equals(selectRecord.get(i).split(";")[1])) {
				if (Integer.parseInt(selectRecord.get(i).split(";")[2]) > -1
						&& Integer.parseInt(selectRecord.get(i).split(";")[2]) < 60) {
					result[0]++;
				} else if (Integer.parseInt(selectRecord.get(i).split(";")[2]) < 70) {
					result[1]++;
				} else if (Integer.parseInt(selectRecord.get(i).split(";")[2]) < 80) {
					result[2]++;
				} else if (Integer.parseInt(selectRecord.get(i).split(";")[2]) < 90) {
					result[3]++;
				} else if (Integer.parseInt(selectRecord.get(i).split(";")[2]) < 101) {
					result[4]++;
				}
			}
		}// 获得各年级学生人数num、各年级分数总和及挂科人数。
		return result;

	}

}
