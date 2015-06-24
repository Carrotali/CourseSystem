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
 * ������SchoolManagerBL
 * ���ܣ�ʵ��SchoolManagerBLService�ӿ�
 */
public class SchoolManagerBL implements SchoolManagerBLService {
	

	//�鿴ѧУ�γ�
	@Override
	/*��������checkSchoolCourse
	 * ���ܣ��鿴ѧϰ�γ�
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

	//���ݿγ̺Ų鿴����ĳһ�ſγ�
	@Override
	/*��������checkSchoolCourse
	 * ���ܣ��鿴ѧϰ�γ�
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
	
	//�鿴������Ϣ
	@Override
	/*��������checkSelfInfor
	 * ���ܣ��鿴������Ϣ
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
	

	//�鿴ѧ����Ϣ
	@Override
	/*��������checkStudentInfor
	 * ���ܣ��鿴ѧ����Ϣ
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

	//����ѧ��ѧ�Ų鿴ĳλѧ������Ϣ
	@Override
	/*��������checkStudentInfor
	 * ���ܣ�����ѧ��ѧ�Ų鿴ĳλѧ������Ϣ
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

	//�鿴��ʦ��Ϣ
	@Override
	/*��������checkManagerInfor
	 * ���ܣ��鿴��ʦ��Ϣ
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

	//���ݽ�ʦ���Ų鿴ĳλ��ʦ����Ϣ
	@Override
	/*��������checkManagerInfor
	 * ���ܣ����ݽ�ʦ���Ų鿴ĳλ��ʦ����Ϣ
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
	//�鿴ͨʶͨ�޿γ�
	/*��������checkCourseForAll
	 * ���ܣ��鿴ͨʶͨ�޿γ�
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
			if(temp[0].equals("ͨʶͨ�޿γ�")){
				j++;		
			}
		}
		
		String[][] courses = new String[j][];
	
		for(int i = 0 ; i < courseList.size() ; i++){
			String[]temp = courseList.get(i).split(";");
			if(temp[0].equals("ͨʶͨ�޿γ�")){
				k++;
				courses[k] = courseList.get(i).split(";");
			}
			
		}
		return courses;
	
		
	}
	
	//�鿴Ժϵ��ѧ�ƻ�
	/*�������� checkInstitutePoint
	 * ���ܣ��鿴Ժϵ��ѧ�ƻ�
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
	//courseΪҪд���ͨʶͨ�޿γ���Ϣ���ɽ����ȡ��ϢȻ�����
	/*��������publishCourseForAll
	 * ���ܣ�courseΪҪд���ͨʶͨ�޿γ���Ϣ���ɽ����ȡ��ϢȻ�����
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

	//���������ܲ���
	@Override
	/*��������publishOverAllPolicy
	 * ���ܣ����������ܲ���
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
	//�鿴ѧ��רҵ�γ̺Ϳ�רҵ�γ�
	/*��������checkInstituteCourse
	 * ���ܣ��鿴ѧ��רҵ�γ̺Ϳ�רҵ�γ�
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
			if((temp[2].equals(institute))&&(temp[0].equals("ѧ��רҵ�γ�")||temp[0].equals("��רҵ�γ�"))){
				j++;	
			}
		}
		
	//	System.out.println(j);
		
		String[][] courses = new String[j][];
	
		for(int i = 0 ; i < courseList.size() ; i++){
			String[]temp = courseList.get(i).split(";");
			if((temp[2].equals(institute))&&(temp[0].equals("ѧ��רҵ�γ�")||temp[0].equals("��רҵ�γ�"))){
				k++;
				courses[k] = courseList.get(i).split(";");
			}
			
		}
		return courses;
		
	}
	
	
	
	
	
	@Override
	//�鿴�����ܲ���
	/*��������checkOverallPolicy
	 * ���ܣ�/�鿴�����ܲ���
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

	//�޸�����
	@Override
	/*��������changePassword
	 * ���ܣ��޸�����
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
	/*��������checkSchoolPlan
	 * ���ܣ��鿴ѧУ��ѧ�ƻ�
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
	
	
	// �鿴��Ժѧ���ɼ������꼶����ƽ���ֺ͹ҿ���
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
			}// ��ø��꼶ѧ������num�����꼶�����ܺͼ��ҿ�������

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
