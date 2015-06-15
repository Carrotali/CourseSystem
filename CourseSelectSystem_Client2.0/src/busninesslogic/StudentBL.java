package busninesslogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import data.*;
/*
 * ������StudentBL
 * ���ܣ�ʵ��StudentBLService�ӿ�
 */

public class StudentBL implements StudentBLService{
	
	//�鿴ѧУ�γ�
	/*��������checkSchoolCourse
	 * ���ܣ��鿴ѧУ�γ�
	 * 	(non-Javadoc)
	 * @see busninesslogic.StudentBLService#checkSchoolCourse()
	 */
	public String[][] checkSchoolCourse(){	
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
	
	//���ݿγ̺Ų鿴�γ���Ϣ
	/*��������checkSchoolCourse
	 * ���ܣ����ݿγ̺Ų鿴�γ���Ϣ
	 * (non-Javadoc)
	 * @see busninesslogic.StudentBLService#checkSchoolCourse(java.lang.String)
	 */
	public String[] checkSchoolCourse(String courseNo){
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
	
	//�鿴���˿γ�
	/*��������checkMyCourse
	 * ���ܣ��鿴���˿γ�
	 * (non-Javadoc)
	 * @see busninesslogic.StudentBLService#checkMyCourse(java.lang.String)
	 */
	public String[][] checkMyCourse(String id){
		ArrayList<String> selectList = new ArrayList<String>();
		try {
			SelectCourseDataService selectCourseData =(SelectCourseDataService) Naming.lookup("rmi://localhost:8888/SelectCourseData"); 
			selectList = selectCourseData.read();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
		ArrayList<String> findList = new ArrayList<String>();
		for(String str:selectList){
			String[] temp = str.split(";");
			if(temp[0].equals(id)){
				try {
					CourseDataService courseData =(CourseDataService) Naming.lookup("rmi://localhost:8888/CourseData"); 
					findList.add(courseData.find(temp[1]));
				} catch (NotBoundException e) { 
		            e.printStackTrace(); 
		        } catch (MalformedURLException e) { 
		            e.printStackTrace(); 
		        } catch (RemoteException e) { 
		            e.printStackTrace();   
		        } 
			}
		}
		String[][] courses = new String[findList.size()][];
		for(int i = 0 ; i < findList.size() ; i++){
			courses[i] = findList.get(i).split(";");
		}
		return courses;
	}
	
	//�鿴������Ϣ
	/*��������checkSelfInfor
	 * ���ܣ��鿴������Ϣ
	 * (non-Javadoc)
	 * @see busninesslogic.StudentBLService#checkSelfInfor(java.lang.String)
	 */
	public String[] checkSelfInfor(String id){
		String[] infor =  null;
		try { 
			StudentInforDataService studentInforData =(StudentInforDataService) Naming.lookup("rmi://localhost:8888/StudentInforData"); 
			infor = studentInforData.find(id).split(";");
        } catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
		return infor;
	}
	
	//ѡ��
	/*��������selectCourse
	 * ���ܣ�ѡ��
	 * (non-Javadoc)
	 * @see busninesslogic.StudentBLService#selectCourse(java.lang.String, java.lang.String)
	 */
	public Boolean selectCourse(String id,String courseNo){
		Boolean isSelect = false;
		try { 
			SelectCourseDataService selectCourseService =(SelectCourseDataService) Naming.lookup("rmi://localhost:8888/SelectCourseData"); 
			isSelect = selectCourseService.add(id + ";" + courseNo+";��");
			System.out.println(); 
            System.out.println(); 
        } catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
		return isSelect;
	}
	
	//��ѡ
	/*��������reselectCourse
	 * ���ܣ���ѡ
	 * (non-Javadoc)
	 * @see busninesslogic.StudentBLService#reselectCourse(java.lang.String, java.lang.String)
	 */
	public Boolean reselectCourse(String id,String courseNo){
		Boolean isSelect = false;
		try { 
			SelectCourseDataService selectCourseService =(SelectCourseDataService) Naming.lookup("rmi://localhost:8888/SelectCourseData"); 
			isSelect = selectCourseService.add(id + ";" + courseNo + ";��");
			System.out.println(); 
            System.out.println(); 
        } catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
		return isSelect;
	}
	
	//��ѡ
	/*��������quitCourse
	 * ���ܣ���ѡ
	 * (non-Javadoc)
	 * @see busninesslogic.StudentBLService#quitCourse(java.lang.String, java.lang.String)
	 */
	public Boolean quitCourse(String id,String courseNo){
		Boolean isQuit = false;
		try { 
			SelectCourseDataService selectCourseService =(SelectCourseDataService) Naming.lookup("rmi://localhost:8888/SelectCourseData"); 
			isQuit = selectCourseService.delete(id + ";" + courseNo);
			System.out.println(); 
            System.out.println(); 
        } catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
		return isQuit;
	}

	//�鿴��ѡ�γ��б�
	/*��������showSelectList
	 * ���ܣ��鿴��ѡ�γ��б�
	 * (non-Javadoc)
	 * @see busninesslogic.StudentBLService#showSelectList()
	 */
	public String[][] showSelectList() {
		ArrayList<String> courseList = null;
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
		ArrayList<String> findList = new ArrayList<String>();
		for(String str:courseList){
			String[] temp = str.split(";");
			if((temp[0].equals("ͨʶͨ�޿γ�"))||(temp[0].equals("��רҵ�γ�"))){
				
				findList.add(str);
			}
		}
		String[][] courses = new String[findList.size()][];
		for(int i = 0 ; i < findList.size() ; i++){
			courses[i] = findList.get(i).split(";");
		}
		return courses;
	}

	//�鿴����
	/*��������showScore
	 * ���ܣ��鿴����
	 * (non-Javadoc)
	 * @see busninesslogic.StudentBLService#showScore(java.lang.String)
	 */
	public String[][] showScore(String id) {
		ArrayList<String> selectList = new ArrayList<String>();
		ArrayList<String> findList = new ArrayList<String>();
		try { 
			SelectCourseDataService selectCourseData =(SelectCourseDataService) Naming.lookup("rmi://localhost:8888/SelectCourseData"); 
			CourseDataService courseData =(CourseDataService) Naming.lookup("rmi://localhost:8888/CourseData"); 
			selectList = selectCourseData.read();
			for(String str:selectList){
				String[] temp = str.split(";");
				if(temp[0].equals(id)){
					
					findList.add(courseData.find(temp[1]) + ";" + temp[2]);
			
				}
			}
            System.out.println(); 
        } catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 

		
		String[][] courses = new String[findList.size()][];
		for(int i = 0 ; i < findList.size() ; i++){
			courses[i] = findList.get(i).split(";");
		}
		return courses;
	}

	//�鿴׼��ѧ��
	/*��������getInScore
	 * ���ܣ��鿴׼��ѧ��
	 * (non-Javadoc)
	 * @see busninesslogic.StudentBLService#getInScore(java.lang.String)
	 */
	public String getInScore(String institute){
		String inScore = null;
		ArrayList<String> temp = new ArrayList<String>();
		try {
			InstitutePlanDataService institutePlanData =(InstitutePlanDataService) Naming.lookup("rmi://localhost:8888/InstitutePlanData"); 
			temp =	institutePlanData.read();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
		
		for(String str:temp){
			if(str.split(";")[0].equals(institute)){
				inScore = str.split(";")[5];
			}
		}
		return inScore;
	}
	
	//�鿴׼��ѧ��
	/*��������getOutScore
	 * ���ܣ��鿴׼��ѧ��
	 * (non-Javadoc)
	 * @see busninesslogic.StudentBLService#getOutScore(java.lang.String)
	 */
	public String getOutScore(String institute){
		String outScore = null;
		ArrayList<String> temp = new ArrayList<String>();
		try {
			InstitutePlanDataService institutePlanData =(InstitutePlanDataService) Naming.lookup("rmi://localhost:8888/InstitutePlanData"); 
			temp =	institutePlanData.read();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
		for(String str:temp){
			if(str.split(";")[0].equals(institute)){
				outScore = str.split(";")[6];
			}
		}
		return outScore;
	}

	//�޸�����
	/*��������changePassword
	 * ���ܣ��޸�����
	 * (non-Javadoc)
	 * @see busninesslogic.StudentBLService#changePassword(java.lang.String, java.lang.String)
	 */
	public Boolean changePassword(String id, String newPassword) {
		String[] infor = null;
	    Boolean isChange = false;
		try { 
			StudentInforDataService studentInforData =(StudentInforDataService) Naming.lookup("rmi://localhost:8888/StudentInforData"); 
			infor = studentInforData.find(id).split(";");
			isChange = studentInforData.update(infor[0] + ";" + infor[1] + ";" + newPassword + ";" 
	                + infor[3] + ";" + infor[4] + ";" + infor[5] + ";" + infor[6]);
			System.out.println(); 
            System.out.println(); 
        } catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
		
		return isChange;
	}
		
}

/*
	Boolean fileWriter(File file,String input){
		Boolean isRepeat = false;
		try{
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String reading;
			while((reading = reader.readLine()) != null){
				if(input.equals(reading)){
					isRepeat = true;
					break;
				}
			}
			reader.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		if(!isRepeat){
			try{
				BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
				writer.write(input);
				writer.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return !isRepeat;
	}
	
	ArrayList<String> fileFinder(File file,String infor){
		return null;
	}
	Boolean fileIsHave(File file,String infor){
		Boolean isHave = false;
		try{
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String reading;
			while((reading = reader.readLine()) != null){
				if(infor.equals(reading)){
					isHave = true;
					break;
				}
			}
			reader.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return isHave;
	}
	
	Boolean fileDelete(File file,String input){
		ArrayList<String> fileContent = new ArrayList<String>();
		Boolean isRepeat = false;
		try{
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String reading;
			while((reading = reader.readLine()) != null){
				if(input.equals(reading)){
					isRepeat = true;
				}else{
					fileContent.add(reading);
				}
			}
			reader.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		for(String str : fileContent){
			try{
				BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
				writer.write(str);
				writer.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return isRepeat;
	}
*/