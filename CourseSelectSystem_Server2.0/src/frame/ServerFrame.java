package frame;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import javax.swing.*;
import data.AdminPermissionData;
import data.AdminPermissionDataService;
import data.CourseData;
import data.CourseDataService;
import data.InstitutePlanData;
import data.InstitutePlanDataService;
import data.InstituteTeacherData;
import data.InstituteTeacherDataService;
import data.OverallPolicyData;
import data.OverallPolicyDataService;
import data.SchoolTeacherData;
import data.SchoolTeacherDataService;
import data.SelectCourseData;
import data.SelectCourseDataService;
import data.StudentInforData;
import data.StudentInforDataService;
import data.TeacherInforData;
import data.TeacherInforDataService;


public class ServerFrame {
	private JFrame ServerFrame;
	private JPanel mainPanel;
	private JLabel inforLabel;
	private JButton startButton;
	private JButton stopButton;
	
	public static void main(String[] args){
        new ServerFrame();
	}
	
	public ServerFrame(){
		ServerFrame = new JFrame();
		ServerFrame.setSize(300,250);
		ServerFrame.setLocation(400,100);
		ServerFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("ͼ��.jpg"));
		ServerFrame.setTitle("�������˽���");
		ServerFrame.getContentPane().setLayout(null);
		ServerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ServerFrame.setVisible(true);
		
		mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 300, 250);
		mainPanel.setLayout(null);
		mainPanel.setVisible(true);
		ServerFrame.setContentPane(mainPanel);
		
		inforLabel = new JLabel("������δ���С�����������");
		inforLabel.setBounds(100,0,300,70);
		inforLabel.setVisible(true);
		mainPanel.add(inforLabel);
		
		startButton = new JButton("START");
		startButton.setBounds(100,100,100,30);
		startButton.setVisible(true);
		startButton.addActionListener(new StartActionListener());
		mainPanel.add(startButton);
		
		stopButton = new JButton("STOP");
		stopButton.setBounds(100,150,100,30);
		stopButton.setVisible(true);
		stopButton.addActionListener(new StopActionListener());
		mainPanel.add(stopButton);
		
	}
	
	class StartActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try { 
	            CourseDataService courseData = new CourseData();
	            InstitutePlanDataService institutePlanData = new InstitutePlanData();
	            InstituteTeacherDataService instituteTeacherData = new InstituteTeacherData();
	            OverallPolicyDataService overallPolicyData = new OverallPolicyData();
	            SchoolTeacherDataService schoolTeacherData = new SchoolTeacherData();
	            SelectCourseDataService selectCourseData = new SelectCourseData();
	            StudentInforDataService studentInforData = new StudentInforData();
	            TeacherInforDataService teacherInforData = new TeacherInforData();
	            AdminPermissionDataService adminPermissionData = new AdminPermissionData();
	            
	            LocateRegistry.createRegistry(8888); 
	            
	            Naming.bind("rmi://localhost:8888/CourseData",courseData); 
	            System.out.println(">>>>>INFO:Զ��CourseDataService����󶨳ɹ���"); 
	            
	            Naming.bind("rmi://localhost:8888/InstitutePlanData",institutePlanData );
	            System.out.println(">>>>>INFO:Զ��InstitutePlanDataService����󶨳ɹ���"); 
	            
	            Naming.bind("rmi://localhost:8888/InstituteTeacherData", instituteTeacherData);
	            System.out.println(">>>>>INFO:Զ��InstituteTeacherDataService��󶨳ɹ���"); 
	            
	            Naming.bind("rmi://localhost:8888/OverallPolicyData", overallPolicyData);
	            System.out.println(">>>>>INFO:Զ��OverallPolicyDataService��󶨳ɹ���"); 
	            
	            Naming.bind("rmi://localhost:8888/SchoolTeacherData", schoolTeacherData);
	            System.out.println(">>>>>INFO:Զ��SchoolTeacherDataService��󶨳ɹ���"); 
	            
	            Naming.bind("rmi://localhost:8888/SelectCourseData", selectCourseData);
	            System.out.println(">>>>>INFO:Զ��SelectCourseDataService��󶨳ɹ���"); 
	            
	            Naming.bind("rmi://localhost:8888/StudentInforData", studentInforData);
	            System.out.println(">>>>>INFO:Զ��StudentInforDataService��󶨳ɹ���"); 
	            
	            Naming.bind("rmi://localhost:8888/TeacherInforData", teacherInforData);
	            System.out.println(">>>>>INFO:Զ��TeacherInforDataServic��󶨳ɹ���");
	            
	            Naming.bind("rmi://localhost:8888/AdminPermissionData", adminPermissionData);
	            System.out.println(">>>>>INFO:Զ��AdminPermissionDataServic��󶨳ɹ���");
	                    
	        } catch (RemoteException ex) { 
	            System.out.println("����Զ�̶������쳣��"); 
	            ex.printStackTrace(); 
	        } catch (AlreadyBoundException ex) { 
	            System.out.println("�����ظ��󶨶����쳣��"); 
	            ex.printStackTrace(); 
	        } catch (MalformedURLException ex) { 
	            System.out.println("����URL�����쳣��"); 
	            ex.printStackTrace(); 
	        } 
			inforLabel.setText("������������......");
			ServerFrame.repaint();
		}
		
	}
	
	class StopActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}
