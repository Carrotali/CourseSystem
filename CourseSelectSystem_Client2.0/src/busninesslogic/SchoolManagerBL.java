package busninesslogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import data.CourseDataService;
import data.InstitutePlanDataService;
import data.OverallPolicyDataService;
import data.SchoolManagerDataService;
import data.SchoolPlanDataService;
import data.SelectCourseDataService;
import data.StudentInforDataService;
/*
 * 类名：SchoolManagerBL
 * 功能：实现SchoolManagerBLService接口
 */
public class SchoolManagerBL implements SchoolManagerBLService {
	

	//查看学校课程
	@Override
	/*方法名：checkSchoolCourse
	 * 功能：查看学习课程
	 * (non-Javadoc)
	 * @see busninesslogic.SchoolManagerBLService#checkSchoolCourse()
	 */
	public String[][] checkSchoolCourse() {
		ArrayList<String> courseList = new ArrayList<String>();
		try {
			CourseDataService courseData =(CourseDataService) Naming.lookup("rmi://localhost:8888/CourseData"); 
			courseList = courseData.read();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
		String[][] courses = new String[courseList.size()][];
		for(int i = 0 ; i < courseList.size() ; i++){
			courses[i] = courseList.get(i).split(";");
		}
		return courses;
	}

	//根据课程号查看具体某一门课程
	@Override
	/*方法名：checkSchoolCourse
	 * 功能：查看学习课程
	 * (non-Javadoc)
	 * @see busninesslogic.SchoolManagerBLService#checkSchoolCourse(java.lang.String)
	 */
	public String[] checkSchoolCourse(String courseNo) {
		String[] findCourse = null;
		ArrayList<String> courseList = new ArrayList<String>();
		try {
			CourseDataService courseData =(CourseDataService) Naming.lookup("rmi://localhost:8888/CourseData"); 
			courseList = courseData.read();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
		for(String str:courseList){
			String[] temp = str.split(";");
			if(temp[1].equals(courseNo)){
				findCourse = temp;
				break;
			}
		}
		return findCourse;
	}
	
	//查看个人信息
	@Override
	/*方法名：checkSelfInfor
	 * 功能：查看个人信息
	 * (non-Javadoc)
	 * @see busninesslogic.SchoolManagerBLService#checkSelfInfor(java.lang.String)
	 */
	public String[] checkSelfInfor(String id){
		String[] infor =  null;
		try { 
			SchoolManagerDataService schoolManagerInforData =(SchoolManagerDataService) Naming.lookup("rmi://localhost:8888/SchoolManagerData"); 
			infor = schoolManagerInforData.find(id).split(";");
			System.out.println(); 
            System.out.println(); 
        } catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
		return infor;
	}
	

	//查看学生信息
	@Override
	/*方法名：checkStudentInfor
	 * 功能：查看学生信息
	 * (non-Javadoc)
	 * @see busninesslogic.SchoolManagerBLService#checkStudentInfor()
	 */
	public String[][] checkStudentInfor() {
		ArrayList<String> stuInforList = new ArrayList<String>();
		try { 
			StudentInforDataService studentInforData =(StudentInforDataService) Naming.lookup("rmi://localhost:8888/StudentInforData"); 
			stuInforList = studentInforData.read();
        } catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
		
		String[][] stuInfor = new String[stuInforList.size()][];
		for(int i = 0 ; i < stuInforList.size() ; i++){
			stuInfor[i] = stuInforList.get(i).split(";");
		}
//		System.out.println(stuInfor.length);
		for(int i = 0 ; i < stuInforList.size() ; i++){
		
		for(int j = 2;j< 6 ; j++){
			stuInfor[i][j] = stuInfor[i][j+1];
	    }
		stuInfor[i][6] ="";
		}
		return stuInfor;
	}

	//根据学生学号查看某位学生的信息
	@Override
	/*方法名：checkStudentInfor
	 * 功能：根据学生学号查看某位学生的信息
	 * (non-Javadoc)
	 * @see busninesslogic.SchoolManagerBLService#checkStudentInfor(java.lang.String)
	 */
	public String[] checkStudentInfor(String id) {
		ArrayList<String> stuInforList = new ArrayList<String>();
		try { 
			StudentInforDataService studentInforData =(StudentInforDataService) Naming.lookup("rmi://localhost:8888/StudentInforData"); 
			stuInforList = studentInforData.read();
        } catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
		  String[]stuInfor = null;
		  
		  for(String str:stuInforList){
				String[] temp = str.split(";");
				if(temp[0].equals(id)){
                    stuInfor = temp;
					break;
				}
			}
		  if(stuInfor == null) return stuInfor;
		  for(int j = 2;j< 6 ; j++){
				stuInfor[j] = stuInfor[j+1];
		    }
			stuInfor[6] ="";
		  return stuInfor;
	}

	//查看教师信息
	@Override
	/*方法名：checkManagerInfor
	 * 功能：查看教师信息
	 * (non-Javadoc)
	 * @see busninesslogic.SchoolManagerBLService#checkManagerInfor()
	 */
	public String[][] checkTeacherInfor() {
	  ArrayList<String> ManagerInforList = new ArrayList<String>();
	  try { 
		  SchoolManagerDataService schoolManagerDataService =(SchoolManagerDataService) Naming.lookup("rmi://localhost:8888/ManagerInforData"); 
			ManagerInforList=schoolManagerDataService.read();
      } catch (NotBoundException e) { 
          e.printStackTrace(); 
      } catch (MalformedURLException e) { 
          e.printStackTrace(); 
      } catch (RemoteException e) { 
          e.printStackTrace();   
      } 
	  
	  String[][] ManagerInfor = new String[ManagerInforList.size()][];
	  for(int i = 0 ; i < ManagerInforList.size() ; i++){
		  ManagerInfor[i] = ManagerInforList.get(i).split(";");	
		  ManagerInfor[i][2] = ManagerInfor[i][3];
		  ManagerInfor[i][3]="";
	  }
	  
	  ArrayList<String> courseList = new ArrayList<String>();
	  try {
			CourseDataService courseData =(CourseDataService) Naming.lookup("rmi://localhost:8888/CourseData"); 
			courseList = courseData.read();
		} catch (NotBoundException e) { 
          e.printStackTrace(); 
      } catch (MalformedURLException e) { 
          e.printStackTrace(); 
      } catch (RemoteException e) { 
          e.printStackTrace();   
      } 
		String[][] courses = new String[courseList.size()][];
		for(int i = 0 ; i < courseList.size() ; i++){
			courses[i] = courseList.get(i).split(";");
		}
		for(int j = 0 ;j <ManagerInforList.size() ; j++ ){
		 for(int i = 0 ; i < courseList.size() ; i++){
			if(courses[i][8].contains(ManagerInfor[j][0])){
				ManagerInfor[j][3]=ManagerInfor[j][3]+courses[i][1]+courses[i][3]+" ";
			}
	     }
	   }
		
		return ManagerInfor;
	}

	//根据教师工号查看某位教师的信息
	@Override
	/*方法名：checkManagerInfor
	 * 功能：根据教师工号查看某位教师的信息
	 * (non-Javadoc)
	 * @see busninesslogic.SchoolManagerBLService#checkManagerInfor(java.lang.String)
	 */
	public String[] checkTeacherInfor(String id) {
		ArrayList<String> ManagerInforList = new ArrayList<String>();
		try { 
			SchoolManagerDataService ManagerInforData =(SchoolManagerDataService) Naming.lookup("rmi://localhost:8888/ManagerInforData"); 
				ManagerInforList=ManagerInforData.read();
	      } catch (NotBoundException e) { 
	          e.printStackTrace(); 
	      } catch (MalformedURLException e) { 
	          e.printStackTrace(); 
	      } catch (RemoteException e) { 
	          e.printStackTrace();   
	      } 
		  String[]ManagerInfor = null;
		  
		  for(String str:ManagerInforList){
				String[] temp = str.split(";");
				if(temp[0].equals(id)){
					ManagerInfor = temp;
					break;
				}
			}
		  if(ManagerInfor==null){
			  return ManagerInfor;
		  }
		  ManagerInfor[2] = ManagerInfor[3];
		  ManagerInfor[3]="";
		    ArrayList<String> courseList = new ArrayList<String>();
		    try {
				CourseDataService courseData =(CourseDataService) Naming.lookup("rmi://localhost:8888/CourseData"); 
				courseList = courseData.read();
			} catch (NotBoundException e) { 
	          e.printStackTrace(); 
	      } catch (MalformedURLException e) { 
	          e.printStackTrace(); 
	      } catch (RemoteException e) { 
	          e.printStackTrace();   
	      } 
			String[][] courses = new String[courseList.size()][];
			for(int i = 0 ; i < courseList.size() ; i++){
				courses[i] = courseList.get(i).split(";");
			}
		
			 for(int i = 0 ; i < courseList.size() ; i++){
				if(courses[i][8].contains(ManagerInfor[0])){
					ManagerInfor[3]=ManagerInfor[3]+courses[i][1]+courses[i][3]+" ";
				}
		     }
		   

			
			return ManagerInfor;

	}

	
	
	@Override
	//查看通识通修课程
	/*方法名：checkCourseForAll
	 * 功能：查看通识通修课程
	 * (non-Javadoc)
	 * @see busninesslogic.SchoolManagerBLService#checkCourseForAll(java.lang.String)
	 */
	public String[][] checkCourseForAll(String institute) {
		ArrayList<String> courseList = new ArrayList<String>();		
		try {
			CourseDataService courseData =(CourseDataService) Naming.lookup("rmi://localhost:8888/CourseData"); 
			courseList = courseData.read();
		} catch (NotBoundException e) { 
          e.printStackTrace(); 
          } catch (MalformedURLException e) { 
          e.printStackTrace(); 
          } catch (RemoteException e) { 
          e.printStackTrace();   
      } 
		

		int j=0;
		int k=-1;
		for(int i = 0 ; i < courseList.size() ; i++){
			String[]temp = courseList.get(i).split(";");
			if(temp[0].equals("通识通修课程")){
				j++;		
			}
		}
		
		String[][] courses = new String[j][];
	
		for(int i = 0 ; i < courseList.size() ; i++){
			String[]temp = courseList.get(i).split(";");
			if(temp[0].equals("通识通修课程")){
				k++;
				courses[k] = courseList.get(i).split(";");
			}
			
		}
		return courses;
	
		
	}
	
	//查看院系教学计划
	/*方法名： checkInstitutePoint
	 * 功能：查看院系教学计划
	 * (non-Javadoc)
	 * @see busninesslogic.SchoolManagerBLService#checkInstitutePoint(java.lang.String)
	 */
	public String[] checkInstitutePoint(String institute) {
		ArrayList<String> courseList = new ArrayList<String>();		
		try {
			InstitutePlanDataService institutePlanData =(InstitutePlanDataService) Naming.lookup("rmi://localhost:8888/InstitutePlanData"); 
			courseList = institutePlanData.read();
		} catch (NotBoundException e) { 
          e.printStackTrace(); 
      } catch (MalformedURLException e) { 
          e.printStackTrace(); 
      } catch (RemoteException e) { 
          e.printStackTrace();   
      } 
		
		String[] planPoint = null;
		for(int i = 0 ; i < courseList.size() ; i++){
			String[]temp = courseList.get(i).split(";");
			if(temp[0].equals(institute)){
				planPoint = courseList.get(i).split(";");
			}
		}
		return planPoint;
	}


	@Override
	//course为要写入的通识通修课程信息，由界面读取信息然后调用
	/*方法名：publishCourseForAll
	 * 功能：course为要写入的通识通修课程信息，由界面读取信息然后调用
	 * (non-Javadoc)
	 * @see busninesslogic.SchoolManagerBLService#publishCourseForAll(java.lang.String)
	 */
	public Boolean publishCourseForAll(String course) {
		// TODO Auto-generated method stub
		Boolean isPublish = false;
		try {
			CourseDataService courseData =(CourseDataService) Naming.lookup("rmi://localhost:8888/CourseData"); 
			isPublish = courseData.add(course);
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
		
		return isPublish;
	}

	//发布整体框架策略
	@Override
	/*方法名：publishOverAllPolicy
	 * 功能：发布整体框架策略
	 * (non-Javadoc)
	 * @see busninesslogic.SchoolManagerBLService#publishOverAllPolicy(java.lang.String[])
	 */
	public Boolean publishOverAllPolicy(String[] policy) {
		// TODO Auto-generated method stub
		Boolean isPublish = false;
		try {
			OverallPolicyDataService overallPolicyData =(OverallPolicyDataService) Naming.lookup("rmi://localhost:8888/OverallPolicyData"); 
			isPublish = overallPolicyData.write(policy);
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
		return isPublish;
	}

	@Override
	//查看学科专业课程和跨专业课程
	/*方法名：checkInstituteCourse
	 * 功能：查看学科专业课程和跨专业课程
	 * (non-Javadoc)
	 * @see busninesslogic.SchoolManagerBLService#checkInstituteCourse(java.lang.String)
	 */
	public String[][] checkInstituteCourse(String institute) {
		ArrayList<String> courseList = new ArrayList<String>();		
		try {
			CourseDataService courseData =(CourseDataService) Naming.lookup("rmi://localhost:8888/CourseData"); 
			courseList = courseData.read();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
		
		int j=0;
		int k=-1;
		for(int i = 0 ; i < courseList.size() ; i++){
			String[]temp = courseList.get(i).split(";");
			if((temp[2].equals(institute))&&(temp[0].equals("学科专业课程")||temp[0].equals("跨专业课程"))){
				j++;	
			}
		}
		
	//	System.out.println(j);
		
		String[][] courses = new String[j][];
	
		for(int i = 0 ; i < courseList.size() ; i++){
			String[]temp = courseList.get(i).split(";");
			if((temp[2].equals(institute))&&(temp[0].equals("学科专业课程")||temp[0].equals("跨专业课程"))){
				k++;
				courses[k] = courseList.get(i).split(";");
			}
			
		}
		return courses;
		
	}
	
	
	
	
	
	@Override
	//查看整体框架策略
	/*方法名：checkOverallPolicy
	 * 功能：/查看整体框架策略
	 * (non-Javadoc)
	 * @see busninesslogic.SchoolManagerBLService#checkOverallPolicy()
	 */
	public String[][] checkOverallPolicy() {
		ArrayList<String> overallPolicyList = new ArrayList<String>();		
		try {
			OverallPolicyDataService overallPolicyData =(OverallPolicyDataService) Naming.lookup("rmi://localhost:8888/OverallPolicyData"); 
			overallPolicyList = overallPolicyData.read();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
		String[][] overallPolicy = new String[overallPolicyList.size()][];
		for(int i = 0 ; i < overallPolicyList.size() ; i++){
		
			overallPolicy[i] = overallPolicyList.get(i).split(";");
			
		}
		return overallPolicy;
	}

	//修改密码
	@Override
	/*方法名：changePassword
	 * 功能：修改密码
	 * (non-Javadoc)
	 * @see busninesslogic.SchoolManagerBLService#changePassword(java.lang.String, java.lang.String)
	 */
	public Boolean changePassword(String id,String newPassword){
		String[] infor = null;
	    Boolean isChange = false;
	    	try { 
			    SchoolManagerDataService managerInforData =(SchoolManagerDataService) Naming.lookup("rmi://localhost:8888/SchoolManagerDataService"); 
			    infor = managerInforData.find(id).split(";");
			    isChange = managerInforData.update(infor[0] + ";" + infor[1] + ";" + newPassword + ";" 
	                + infor[3]);
            } catch (NotBoundException e) { 
            e.printStackTrace(); 
            } catch (MalformedURLException e) { 
            e.printStackTrace(); 
            } catch (RemoteException e) { 
            e.printStackTrace();   
            } 
		    return isChange;
	}

	
	@Override
	/*方法名：checkSchoolPlan
	 * 功能：查看学校教学计划
	 * (non-Javadoc)
	 * @see busninesslogic.SchoolManagerBLService#checkSchoolPlan(java.lang.String, java.lang.String)
	 */
	public String[][] checkSchoolPlan() {
		// TODO Auto-generated method stub

		ArrayList<String> schoolPlanList = new ArrayList<String>();
		try {
			SchoolPlanDataService schoolPlanDataService = (SchoolPlanDataService) Naming
					.lookup("rmi://localhost:8888/SchoolPlanData");
			schoolPlanList = schoolPlanDataService.read();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	
		String[][] schoolPlan = new String[3*schoolPlanList.size()][5];
		String[]tmp=new String[11];
		for(int i = 0 ; i < schoolPlanList.size() ; i++){
			tmp= schoolPlanList.get(i).split(";");
			schoolPlan[3*i][0]=tmp[0];
			schoolPlan[3*i][1]=tmp[1];
			schoolPlan[3*i][2]=tmp[2];
			schoolPlan[3*i][3]=tmp[3];
			schoolPlan[3*i][4]=tmp[10];
			schoolPlan[3*i+1][0]="";
			schoolPlan[3*i+1][1]=tmp[4];
			schoolPlan[3*i+1][2]=tmp[5];
			schoolPlan[3*i+1][3]=tmp[6];
			schoolPlan[3*i+1][4]="";
			schoolPlan[3*i+2][0]="";
			schoolPlan[3*i+2][1]=tmp[7];
			schoolPlan[3*i+2][2]=tmp[8];
			schoolPlan[3*i+2][3]=tmp[9];
			schoolPlan[3*i+2][4]="";
		}
		
		return schoolPlan;
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
							&&Integer.parseInt(selectRecord.get(i).split(";")[2]) >-1) {
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
			for(int k =0;k<4;k++){
				if(num[k]!=0){
					result[2*k]=(double)(Math.round(sum[k]/num[k])/100.0);
					result[2*k+1]=(double)(Math.round(failNum[k]*100/num[k])/100.0);
				}		
			else {
				result[2*k] =result[2*k+1] = 0;
			}
			}
			return result;
		}


}
