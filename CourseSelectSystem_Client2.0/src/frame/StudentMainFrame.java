package frame;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import java.awt.Component;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

import frame.SchoolTeacherMainFrame.PublishCourseListener;
import frame.SchoolTeacherMainFrame.CheckCoInfroListener.CheckSchoolCourseOKButtonListener;
import frame.TeacherMainFrame.ChangePasswordListener.changePasswordOkButtonListener;
import frame.TeacherMainFrame.CheckStlistListener.CheckStudentOKButtonListener;
import frame.TeacherMainFrame.InputGradeListener.scoreOkButtonListener;

import busninesslogic.AdminBL;
import busninesslogic.AdminBLService;
import busninesslogic.LoginBL;
import busninesslogic.StudentBL;
import busninesslogic.StudentBLService;
import busninesslogic.TeacherBLService;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class StudentMainFrame /*extends JFrame*/{
	private JFrame StudentFrame;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;	
	private JButton btnNewButton_6;	
	private JButton btnNewButton_7;	
	private JPanel panelNow;
	private JTextArea textArea;
	private JTable schoolCourseTable;
	private JScrollPane schoolCourseScrollPane;
	private JTable myCourseTable;
	private JScrollPane myCourseScrollPane;
	private JTextField courseNoField;
	private JTextField newPasswordField;
	private JTextField field_8;
	private JTextField field_7;
	private JComboBox comboBox;
	private StudentBLService studentBL;
	private String ID;
	private String password;
	private AdminBLService adminBL;
	
	
	public static void main(String[] args) {
        new StudentMainFrame("121200002","111111",new StudentBL(),new AdminBL());
	}
	
	public StudentMainFrame(String ID,String password,StudentBLService studentBL,AdminBLService adminBL) {
		this.studentBL=studentBL;
		this.adminBL = adminBL;
		this.ID = ID;
		this.password = password;
		StudentFrame = new JFrame();
		StudentFrame.setSize(800,500);
		StudentFrame.setLocation(300,100);
		StudentFrame.setTitle("学生主界面");
		StudentFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("学生.jpg"));
		StudentFrame.getContentPane().setLayout(null);
		StudentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		StudentFrame.setVisible(true);
		
		panel_2 = new MyPanel();
		panel_2.setBackground(Color.white);
		panel_2.setBounds(0, 0, 80, 80);
		StudentFrame.getContentPane().add(panel_2);
		
		panel = new JPanel();
		panel.setBackground(new Color(199, 0, 133 ));
		panel.setBounds(0, 0, 820, 70);
		StudentFrame.getContentPane().add(panel);
		panel.setVisible(true);
		panel.setLayout(null);
		
		
		lblNewLabel = new JLabel("欢迎"+studentBL.checkSelfInfor(ID)[3]+studentBL.checkSelfInfor(ID)[1]+"同学!");
		lblNewLabel.setForeground(Color.white);
		lblNewLabel.setFont(new Font("楷体", Font.BOLD, 24));
		lblNewLabel.setBounds(80, 10, 500, 45);
		panel.add(lblNewLabel);
		lblNewLabel.setVisible(true); 
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(199, 0, 133 ));
		panel_1.setForeground(Color.WHITE);
		panel_1.setBounds(0, 70, 170, 400);
		StudentFrame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(true);
		
		btnNewButton = new JButton("查看全校课程");
		btnNewButton.setFont(new Font("楷体", Font.BOLD, 16));
		btnNewButton.setBounds(10, 10, 150, 35);
		btnNewButton.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton.setBackground(new Color(199, 0, 133 ));
		btnNewButton.setForeground(Color.white);
		btnNewButton.setVisible(true);
		btnNewButton.addActionListener(new CheckAllCourseListener());
		panel_1.add(btnNewButton);
		
		
		btnNewButton_1 = new JButton("查看我的课程");
		btnNewButton_1.setFont(new Font("楷体", Font.BOLD, 16));
		btnNewButton_1.setBounds(10, 55, 135, 30);
		btnNewButton_1.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton_1.setBackground(new Color(199, 0, 133 ));
		btnNewButton_1.setForeground(Color.white);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new CheckMyCourseListener());
		btnNewButton_1.setVisible(true);
		
		btnNewButton_2 = new JButton("查看个人信息");
		btnNewButton_2.setFont(new Font("楷体", Font.BOLD, 16));
		btnNewButton_2.setBounds(10, 100, 135, 30);
		btnNewButton_2.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton_2.setBackground(new Color(199, 0, 133 ));
		btnNewButton_2.setForeground(Color.white);
		panel_1.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new CheckMyInfroListener());
		btnNewButton_2.setVisible(true);
	
		btnNewButton_3 = new JButton("选择课程");
		btnNewButton_3.setFont(new Font("楷体", Font.BOLD, 16));
		btnNewButton_3.setBounds(10, 145, 135, 30);
		btnNewButton_3.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton_3.setBackground(new Color(199, 0, 133 ));
		btnNewButton_3.setForeground(Color.white);
		panel_1.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ChooseCourseListener());
		btnNewButton_3.setVisible(true);
		
		btnNewButton_4 = new JButton("退选课程");
		btnNewButton_4.setFont(new Font("楷体", Font.BOLD, 16));
		btnNewButton_4.setBounds(10, 190, 135, 30);
		btnNewButton_4.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton_4.setBackground(new Color(199, 0, 133 ));
		btnNewButton_4.setForeground(Color.white);
		panel_1.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new QuitCourseListener());
		btnNewButton_4.setVisible(true);
		
		btnNewButton_5 = new JButton("补选课程");
		btnNewButton_5.setFont(new Font("楷体", Font.BOLD, 16));
		btnNewButton_5.setBounds(10, 235, 135, 30);
		btnNewButton_5.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton_5.setBackground(new Color(199, 0, 133 ));
		btnNewButton_5.setForeground(Color.white);
		panel_1.add(btnNewButton_5);
		btnNewButton_5.addActionListener(new RechooseCourseListener());
		btnNewButton_5.setVisible(true);
		
		btnNewButton_6 = new JButton("修改密码");
		btnNewButton_6.setFont(new Font("楷体", Font.BOLD, 16));
		btnNewButton_6.setBounds(10, 280, 135, 30);
		btnNewButton_6.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton_6.setBackground(new Color(199, 0, 133 ));
		btnNewButton_6.setForeground(Color.white);
		panel_1.add(btnNewButton_6);
		btnNewButton_6.addActionListener(new ChangePasswordListener());
		btnNewButton_6.setVisible(true);
		
		btnNewButton_7 = new JButton("注销");
		btnNewButton_7.setFont(new Font("楷体", Font.BOLD, 16));
		btnNewButton_7.setBounds(10, 325, 135, 30);
		btnNewButton_7.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton_7.setBackground(new Color(199, 0, 133 ));
		btnNewButton_7.setForeground(Color.white);
		panel_1.add(btnNewButton_7);
		btnNewButton_7.addActionListener(new LogoutListener());
		btnNewButton_7.setVisible(true);
		
        panelNow = new XPanel();		
//		panelNow.setBackground(new Color(255 ,255, 224 ));
		panelNow.setBackground(Color.white);
//		panelNow.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelNow.setBounds(170, 70, 614, 400);
		StudentFrame.getContentPane().add(panelNow);
		panelNow.setVisible(true);
		
		StudentFrame.repaint();
	}

    class CheckAllCourseListener implements ActionListener{
    	public void actionPerformed(ActionEvent e){
	    	StudentFrame.remove(panelNow);
	    	StudentFrame.setTitle("学生——查看全校课程");
			JPanel Panel = new JPanel();
			Panel.setBounds(170, 70, 614, 400);
			Panel.setBackground(Color.white);
			Panel.setVisible(true);
 			Panel.setLayout(null);
    		
 			JLabel label = new JLabel("课程号");
 			label.setFont(new Font("楷体", Font.BOLD, 16));
 			label.setBounds(50, 270, 100, 30);
 			Panel.add(label);
 			label.setVisible(true);
 			
 			JLabel label2 = new JLabel("(补充了教师、教材、参考书目信息)");
 			label2.setFont(new Font("楷体", Font.BOLD, 14));
 			label2.setBounds(360, 270, 250, 30);
 			Panel.add(label2);
 			label2.setVisible(true);
			
			JButton button = new JButton("确认");
			button.setFont(new Font("楷体", Font.BOLD, 12));
			button.setBounds(282, 272, 60, 25);
			Panel.add(button);
			button.setVisible(true);
			button.addActionListener(new CheckSchoolCourseOKButtonListener());
			
			courseNoField = new JTextField();
			courseNoField.setBounds(150,270,100,30);
			Panel.add(courseNoField);
			courseNoField.setColumns(10);

			textArea = new JTextArea();
			textArea.setBounds(50,320,530,50);
			textArea.setLineWrap(true);
			textArea.setEditable(false);
			textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
			Panel.add(textArea);
			textArea.setVisible(true);

  			String[] columnTitle=new String[] {"类别","编号","院系","名称","学分","学期","时间","地点"};
  			
  			String[][]temp=studentBL.checkSchoolCourse();
  			schoolCourseTable = new JTable(temp,columnTitle);		
  			makeFace(schoolCourseTable);
  		  TableColumn column = schoolCourseTable.getColumnModel().getColumn(0);
  	      column.setPreferredWidth(105);//设置列宽的函数
  	      column = schoolCourseTable.getColumnModel().getColumn(1);
	      column.setPreferredWidth(50);//设置列宽的函数
	      column = schoolCourseTable.getColumnModel().getColumn(2);
  	      column.setPreferredWidth(107);//设置列宽的函数
  	      column = schoolCourseTable.getColumnModel().getColumn(3);
	      column.setPreferredWidth(130);//设置列宽的函数
	      column = schoolCourseTable.getColumnModel().getColumn(4);
  	      column.setPreferredWidth(35);//设置列宽的函数
  	      column = schoolCourseTable.getColumnModel().getColumn(5);
	      column.setPreferredWidth(100);//设置列宽的函数
	      column = schoolCourseTable.getColumnModel().getColumn(6);
  	      column.setPreferredWidth(100);//设置列宽的函数
  	      column = schoolCourseTable.getColumnModel().getColumn(7);
	      column.setPreferredWidth(100);//设置列宽的函数
  	     

  			

	      schoolCourseScrollPane = new JScrollPane(schoolCourseTable);//带滚动条的面板	
	      schoolCourseScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	      schoolCourseScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	      schoolCourseScrollPane.setBounds(37,10, 544, 250);
	      schoolCourseScrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
	      schoolCourseScrollPane.setVisible(true);
			Panel.add(schoolCourseScrollPane);
		
			StudentFrame.setLayout(null);
			panelNow=Panel;
			StudentFrame.add(panelNow);
			StudentFrame.repaint();
			
	    }
	    
	    class CheckSchoolCourseOKButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				

				String[]temp=studentBL.checkSchoolCourse(courseNoField.getText());
				
				if(temp==null){
					JDialog infoDialog = new JDialog();
					infoDialog.setSize(300,200);
					infoDialog.setLocation(600,300);
					infoDialog.setVisible(true);
					JLabel infoLabel = new JLabel("该课程不存在！");
					infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
					infoLabel.setVisible(true);
					infoDialog.add(infoLabel);
			    }
				else{
					panelNow.remove(textArea);
					String infor = Arrays.toString(studentBL.checkSchoolCourse(courseNoField.getText()));
					textArea = new JTextArea(infor);
					textArea.setBounds(50,320,530,50);
					textArea.setLineWrap(true);
					textArea.setEditable(false);
					textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
					panelNow.add(textArea);
					StudentFrame.repaint();
				}
			}
			
	    }
    } 

    class ChooseCourseListener implements ActionListener{
    	JScrollPane selectScrollPane;
    	JScrollPane selectScrollPane2;
    	int courseNum = 0;
	    public void actionPerformed(ActionEvent e){
	    	if(adminBL.getAbleToSelectCourse()){
	    		StudentFrame.remove(panelNow);
		    	StudentFrame.setTitle("学生——选课");
				JPanel Panel = new JPanel();
				Panel.setBounds(170, 70, 614, 400);
				Panel.setBackground(Color.white);
//				Panel.setBackground(new Color(255 ,255, 224 ));
//				Panel.setBorder(new LineBorder(new Color(0, 0, 0)));
				Panel.setVisible(true);
	 			Panel.setLayout(null);
	 			
	 			JLabel label = new JLabel("可选课程");
	 			label.setFont(new Font("楷体", Font.BOLD, 15));
	 			label.setBounds(10, 10, 100, 30);
	 			Panel.add(label);
	 			label.setVisible(true);
	 			
	 			JLabel label2 = new JLabel("已选课程");
	 			label2.setFont(new Font("楷体", Font.BOLD, 15));
	 			label2.setBounds(10, 200, 100, 30);
	 			Panel.add(label2);
	 			label2.setVisible(true);
	 			
	 			JLabel label3 = new JLabel("友情提醒");
	 			label3.setFont(new Font("楷体", Font.BOLD, 15));
	 			label3.setBounds(300, 210, 100, 30);
	 			Panel.add(label3);
	 			label3.setVisible(true);
	 			
	 			JLabel label4 = new JLabel("1.选课门数不得超过4门");
	 			label4.setFont(new Font("楷体", Font.BOLD, 15));
	 			label4.setBounds(300, 240, 200, 30);
	 			Panel.add(label4);
	 			label4.setVisible(true);
	 			
	 			JLabel label5 = new JLabel("2.选课采用直选式，先到先得");
	 			label5.setFont(new Font("楷体", Font.BOLD, 15));
	 			label5.setBounds(300, 270, 250, 30);
	 			Panel.add(label5);
	 			label5.setVisible(true);
	 			
	 			//"课程类别","课程编号","开课院系","课程名称","学分","开设学期","上课时间","上课地点","任课老师","教材","参考书目"
	 			String [] columnNames = {"课程类别","编号","开课院系","课程名称","学分","上课时间","上课地点"};
	 			
	 			String[][]temp = studentBL.showSelectList();
	 			for(int i=0;i<temp.length;i++){
	 			for(int j=5;j<7;j++){
	 				temp[i][j] = temp[i][j+1];				
	 			}
	 			}
	 			JTable selectTable = new JTable(temp,columnNames);
	 			makeFace(selectTable);
	 			TableColumn column = selectTable .getColumnModel().getColumn(0);
	 	  	      column.setPreferredWidth(105);//设置列宽的函数
	 	  	      column = selectTable .getColumnModel().getColumn(1);
	 		      column.setPreferredWidth(50);//设置列宽的函数
	 		      column = selectTable .getColumnModel().getColumn(2);
	 	  	      column.setPreferredWidth(107);//设置列宽的函数
	 	  	      column = selectTable .getColumnModel().getColumn(3);
	 		      column.setPreferredWidth(130);//设置列宽的函数
	 		      column = selectTable .getColumnModel().getColumn(4);
	 	  	      column.setPreferredWidth(35);//设置列宽的函数
	 	  	      column = selectTable .getColumnModel().getColumn(5);
	 		      column.setPreferredWidth(100);//设置列宽的函数
	 		      column = selectTable .getColumnModel().getColumn(6);
			      column.setPreferredWidth(100);//设置列宽的函数
	 		     
	 	  	      
	 			
	 		    selectScrollPane=new JScrollPane(selectTable);
	 		    selectScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	 		    selectScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	 		    selectScrollPane.setBounds(37,40, 544, 150);
	 		    selectScrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
	 		    selectScrollPane.setVisible(true);
	 			Panel.add(selectScrollPane);
	 		
	 			//得到已选课程
	 			temp = studentBL.showScore(ID);
	 			int j=0;
	 			int k=-1;
	 			for(int i = 0 ; i < temp.length ; i++){ 				
	 				if(temp[i][0].equals("通识通修课程")||temp[i][0].equals("跨专业课程")){
	 					j++;		
	 				}
	 			}
	 			courseNum = j ;
	 			String[][] courses = new String[j][];		
	 			for(int i = 0 ; i < temp.length ; i++){				
	 				if(temp[i][0].equals("通识通修课程")||temp[i][0].equals("跨专业课程")){
	 					k++;
	 					courses[k] = temp[i];
	 				}				
	 			}
	 
	 			String [] columnTitle = {"课程类别","编号"};
	 			selectTable = new JTable(courses,columnTitle);
	 			makeFace(selectTable);
	 			column= selectTable .getColumnModel().getColumn(0);
		  	     column.setPreferredWidth(105);//设置列宽的函数
		  	     column = selectTable .getColumnModel().getColumn(1);
			     column.setPreferredWidth(50);//设置列宽的函数
			     
	 			selectScrollPane2=new JScrollPane(selectTable);
	 		    selectScrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	 		    selectScrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	 		    selectScrollPane2.setBounds(37,230, 200, 90);
	 		    selectScrollPane2.setBorder(new LineBorder(new Color(0, 0, 0)));
	 		    selectScrollPane2.setVisible(true);
	 			Panel.add(selectScrollPane2);
	 			
				JLabel lblNewLabel_1 = new JLabel("选课课程号");
				lblNewLabel_1.setFont(new Font("楷体", Font.BOLD, 15));
				lblNewLabel_1.setBounds(10, 330, 100, 30);
				Panel.add(lblNewLabel_1);
				lblNewLabel_1.setVisible(true);
				
				courseNoField = new JTextField();
				courseNoField.setBounds(140, 330, 100, 30);
				Panel.add(courseNoField);
				courseNoField.setColumns(10);
				courseNoField.setVisible(true);
				
				JButton btnNewButton_6 = new JButton("确定");
				btnNewButton_6.setFont(new Font("楷体", Font.BOLD, 12));
				btnNewButton_6.addActionListener(new OkButtonListener());
				btnNewButton_6.setBounds(400, 330, 90, 30);
				Panel.add(btnNewButton_6);
				btnNewButton_6.setVisible(true);

				StudentFrame.setLayout(null);
				panelNow=Panel;
				StudentFrame.add(panelNow);
				StudentFrame.repaint();
	    	}else{
	    		JOptionPane.showMessageDialog(null, "选课尚未开始！");
	    	}
	    	
	    }
	    class OkButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if(courseNoField.getText().equals("")){
					JDialog infoDialog = new JDialog();
					infoDialog.setSize(200,100);
					infoDialog.setLocation(600,300);
					infoDialog.setVisible(true);
					JLabel infoLabel = new JLabel("课程号不能为空！");
					infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
					infoLabel.setVisible(true);
					infoDialog.add(infoLabel);
				}else{
					if(courseNum==4){
						JDialog infoDialog = new JDialog();
						infoDialog.setSize(200,100);
						infoDialog.setLocation(600,300);
						infoDialog.setVisible(true);
						JLabel infoLabel = new JLabel("您选择的课程数已满");
						infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
						infoLabel.setVisible(true);
						infoDialog.add(infoLabel);
					}
					else if(studentBL.selectCourse(ID, courseNoField.getText())){
						JDialog infoDialog = new JDialog();
						infoDialog.setSize(200,100);
						infoDialog.setLocation(600,300);
						infoDialog.setVisible(true);
						JLabel infoLabel = new JLabel("选课成功！");
						infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
						infoLabel.setVisible(true);
						infoDialog.add(infoLabel);
						
						panelNow.remove(selectScrollPane2);
						//得到已选课程
			 			String[][] temp = studentBL.showScore(ID);
			 			int j=0;
			 			int k=-1;
			 			for(int i = 0 ; i < temp.length ; i++){ 				
			 				if(temp[i][0].equals("通识通修课程")||temp[i][0].equals("跨专业课程")){
			 					j++;		
			 				}
			 			}
			 			courseNum = j ;
			 			String[][] courses = new String[j][];		
			 			for(int i = 0 ; i < temp.length ; i++){				
			 				if(temp[i][0].equals("通识通修课程")||temp[i][0].equals("跨专业课程")){
			 					k++;
			 					courses[k] = temp[i];
			 				}				
			 			}
			 
			 			String [] columnTitle = {"课程类别","编号"};
			 			JTable selectTable = new JTable(courses,columnTitle);
			 			makeFace(selectTable);
			 			TableColumn column = selectTable .getColumnModel().getColumn(0);
				  	     column.setPreferredWidth(105);//设置列宽的函数
				  	     column = selectTable .getColumnModel().getColumn(1);
					     column.setPreferredWidth(50);//设置列宽的函数
					     
			 			selectScrollPane2=new JScrollPane(selectTable);
			 		    selectScrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			 		    selectScrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			 		    selectScrollPane2.setBounds(37,230, 200, 90);
			 		    selectScrollPane2.setBorder(new LineBorder(new Color(0, 0, 0)));
			 		    selectScrollPane2.setVisible(true);
			 			panelNow.add(selectScrollPane2);
			 			StudentFrame.repaint();
						
					}else{
						JDialog infoDialog = new JDialog();
						infoDialog.setSize(300,200);
						infoDialog.setLocation(600,300);
						infoDialog.setVisible(true);
						JLabel infoLabel = new JLabel("课程号输入不正确请查证或您已选该课");
						infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
						infoLabel.setVisible(true);
						infoDialog.add(infoLabel);
					}
				}
			}
	    }
    }
    
    class CheckMyCourseListener implements ActionListener{
	    public void actionPerformed(ActionEvent e){
	    	StudentFrame.remove(panelNow);
	    	StudentFrame.setTitle("学生——查看个人课程");
			JPanel Panel = new JPanel();
			Panel.setBounds(170, 70, 614, 400);
			Panel.setBackground(Color.white);
//			Panel.setBackground(new Color(255 ,255, 224 ));
//			Panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			Panel.setVisible(true);
 			Panel.setLayout(null);
    		
 			JLabel label = new JLabel("我的课程");
 			label.setFont(new Font("楷体", Font.BOLD, 15));
 			label.setBounds(10, 10, 100, 30);
 			Panel.add(label);
 			label.setVisible(true);
 			
 			String [] columnNames = {"课程类别","课程编号","开课院系","课程名称","学分","开设学期","上课时间","上课地点","成绩"};
 			String[][]temp = studentBL.showScore(ID);
 			for(int i=0;i<temp.length;i++)
 				temp[i][8] = temp[i][11];
 			myCourseTable = new JTable(temp,columnNames);
 			makeFace(myCourseTable);
 			TableColumn column = myCourseTable .getColumnModel().getColumn(0);
 	  	      column.setPreferredWidth(115);//设置列宽的函数
 	  	      column = myCourseTable .getColumnModel().getColumn(1);
 		      column.setPreferredWidth(80);//设置列宽的函数
 		      column = myCourseTable .getColumnModel().getColumn(2);
 	  	      column.setPreferredWidth(80);//设置列宽的函数
 	  	      column = myCourseTable .getColumnModel().getColumn(3);
 		      column.setPreferredWidth(130);//设置列宽的函数
 		      column = myCourseTable .getColumnModel().getColumn(4);
 	  	      column.setPreferredWidth(35);//设置列宽的函数
 	  	      column = myCourseTable .getColumnModel().getColumn(5);
 		      column.setPreferredWidth(100);//设置列宽的函数
 		      column = myCourseTable .getColumnModel().getColumn(6);
 	  	      column.setPreferredWidth(110);//设置列宽的函数
 	  	      column = myCourseTable .getColumnModel().getColumn(7);
 		      column.setPreferredWidth(100);//设置列宽的函数
 		     column = myCourseTable .getColumnModel().getColumn(8);
		      column.setPreferredWidth(35);
 		    myCourseScrollPane=new JScrollPane(myCourseTable);
 		    myCourseScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
 		    myCourseScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
 		    myCourseScrollPane.setBounds(37,50, 544, 300);
 		    myCourseScrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
 		    myCourseScrollPane.setVisible(true);
 			Panel.add(myCourseScrollPane);
 			
			StudentFrame.setLayout(null);
			panelNow=Panel;
			StudentFrame.add(panelNow);
			StudentFrame.repaint();
	    }
    }
    
    class CheckMyInfroListener implements ActionListener{
	    public void actionPerformed(ActionEvent e){
	    	StudentFrame.remove(panelNow);
	    	StudentFrame.setTitle("学生——查看个人信息");
			JPanel Panel = new JPanel();
			Panel.setBounds(170, 70, 614, 400);
			Panel.setBackground(Color.white);
//			Panel.setBackground(new Color(255 ,255, 224 ));
//			Panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			Panel.setVisible(true);
 			Panel.setLayout(null);
    		
 			String [] infor = studentBL.checkSelfInfor(ID);
 			
 			JLabel label = new JLabel("学号");
 			label.setFont(new Font("楷体", Font.BOLD, 15));
 			label.setBounds(10, 20, 50, 30);
 			Panel.add(label);
 			label.setVisible(true);
 			
 			JTextField field = new JTextField(infor[0]);
 			field.setBounds(60,20,80,30);
 			Panel.add(field);
 			field.setEditable(false);
 			field.setVisible(true);
 			
 			JLabel label_1 = new JLabel("姓名");
 			label_1.setFont(new Font("楷体", Font.BOLD, 15));
 			label_1.setBounds(150, 20, 50, 30);
 			Panel.add(label_1);
 			label_1.setVisible(true);
 			
 			JTextField field_1 = new JTextField(infor[1]);
 			field_1.setBounds(200,20,80,30);
 			Panel.add(field_1);
 			field_1.setEditable(false);
 			field_1.setVisible(true);
 			
 			JLabel label_2 = new JLabel("退学情况");
 			label_2.setFont(new Font("楷体", Font.BOLD, 15));
 			label_2.setBounds(300, 20, 70, 30);
 			Panel.add(label_2);
 			label_2.setVisible(true);
 			
 			JTextField field_2 = new JTextField(infor[6]);
 			field_2.setBounds(370,20,80,30);
 			Panel.add(field_2);
 			field_2.setEditable(false);
 			field_2.setVisible(true);
 			
 			JLabel label_3 = new JLabel("学院");
 			label_3.setFont(new Font("楷体", Font.BOLD, 15));
 			label_3.setBounds(10, 60, 50, 30);
 			Panel.add(label_3);
 			label_3.setVisible(true);
 			
 			JTextField field_3 = new JTextField(infor[3]);
 			field_3.setBounds(60,60,80,30);
 			Panel.add(field_3);
 			field_3.setEditable(false);
 			field_3.setVisible(true);
 			
 			JLabel label_4 = new JLabel("学分绩");
 			label_4.setFont(new Font("楷体", Font.BOLD, 15));
 			label_4.setBounds(150, 60, 50, 30);
 			Panel.add(label_4);
 			label_4.setVisible(true);
 			
 			JTextField field_4 = new JTextField(infor[4]);
 			field_4.setBounds(200,60,80,30);
 			Panel.add(field_4);
 			field_4.setEditable(false);
 			field_4.setVisible(true);
 			
 			JLabel label_5 = new JLabel("毕业资格");
 			label_5.setFont(new Font("楷体", Font.BOLD, 15));
 			label_5.setBounds(300, 60, 70, 30);
 			Panel.add(label_5);
 			label_5.setVisible(true);
 			
 			JTextField field_5 = new JTextField(infor[5]);
 			field_5.setBounds(370,60,100,30);
 			Panel.add(field_5);
 			field_5.setEditable(false);
 			field_5.setVisible(true);
 			
 			JLabel label_6 = new JLabel("准入准出查询学院");
 			label_6.setFont(new Font("楷体", Font.BOLD, 15));
 			label_6.setBounds(10, 125, 200, 30);
 			Panel.add(label_6);
 			label_6.setVisible(true);
 			
 			String [] instituteName = {"软件学院","商学院","大气科学学院","地理与海洋科学学院","历史学院","哲学系"
 					                       ,"数学系","物理系","化学系","政府管理学院","医学院","建筑"};
 			comboBox = new JComboBox(instituteName);
 			comboBox.setBounds(210,125,100,30);
 			Panel.add(comboBox);
 			comboBox.setVisible(true);
 			
 			JButton OkButton = new JButton("确定");
 			OkButton.setFont(new Font("楷体", Font.BOLD, 15));
 			OkButton.setBounds(350, 125, 80, 20);
 			OkButton.addActionListener(new CheckIOOKButtonListener());
 			Panel.add(OkButton);
 			OkButton.setVisible(true);
 			
 			JLabel label_7 = new JLabel("准入学分");
 			label_7.setFont(new Font("楷体", Font.BOLD, 15));
 			label_7.setBounds(10, 180, 100, 30);
 			Panel.add(label_7);
 			label_7.setVisible(true);
 			
 			field_7 = new JTextField();
 			field_7.setBounds(110,180,100,30);
 			Panel.add(field_7);
 			field_7.setEditable(false);
 			field_7.setVisible(true);
 			
 			JLabel label_8 = new JLabel("准出学分");
 			label_8.setFont(new Font("楷体", Font.BOLD, 15));
 			label_8.setBounds(10, 230, 100, 30);
 			Panel.add(label_8);
 			label_8.setVisible(true);
 			
 			field_8 = new JTextField();
 			field_8.setBounds(110,230,100,30);
 			Panel.add(field_8);
 			field_8.setEditable(false);
 			field_8.setVisible(true);
 			
			StudentFrame.setLayout(null);
			panelNow=Panel;
			StudentFrame.add(panelNow);
			StudentFrame.repaint();
	    }
	    class  CheckIOOKButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				panelNow.remove(field_7);
				panelNow.remove(field_8);
				field_7 =  new JTextField(studentBL.getInScore((String) comboBox.getSelectedItem()));
	 			field_7.setBounds(110,180,100,30);
	 			panelNow.add(field_7);
	 			field_7.setEditable(false);
	 			field_7.setVisible(true);
	 			
	 			field_8 = new JTextField(studentBL.getOutScore((String) comboBox.getSelectedItem()));
	 			field_8.setBounds(110,230,100,30);
	 			panelNow.add(field_8);
	 			field_8.setEditable(false);
	 			field_8.setVisible(true);
	 			
	 			StudentFrame.repaint();
			}
	    	
	    }
    }
    
    class QuitCourseListener implements ActionListener{
    	JScrollPane selectScrollPane;
	    public void actionPerformed(ActionEvent e){
	    	if(adminBL.getAbleToReselectCourse()||adminBL.getAbleToSelectCourse()){
	    		StudentFrame.remove(panelNow);
		    	StudentFrame.setTitle("学生——退课");
				JPanel Panel = new JPanel();
				Panel.setBounds(170, 70, 614, 400);
				Panel.setBackground(Color.white);
//				Panel.setBackground(new Color(255 ,255, 224 ));
//				Panel.setBorder(new LineBorder(new Color(0, 0, 0)));
				Panel.setVisible(true);
	 			Panel.setLayout(null);
		    	
	 			JLabel label = new JLabel("已选课程");
	 			label.setFont(new Font("楷体", Font.BOLD, 15));
	 			label.setBounds(10, 10, 100, 30);
	 			Panel.add(label);
	 			label.setVisible(true);
	 			
	           String [] columnNames = {"课程类别","编号","开课院系","课程名称","学分","上课时间","上课地点"};
	 			
	           String[][] temp = studentBL.checkMyCourse(ID);
	 			int j=0;
	 			int k=-1;
	 			for(int i = 0 ; i < temp.length ; i++){ 				
	 				if(temp[i][0].equals("通识通修课程")||temp[i][0].equals("跨专业课程")){
	 					j++;		
	 				}
	 			}
	 	//		courseNum = j ;
	 			String[][] courses = new String[j][];		
	 			for(int i = 0 ; i < temp.length ; i++){				
	 				if(temp[i][0].equals("通识通修课程")||temp[i][0].equals("跨专业课程")){
	 					k++;
	 					courses[k] = temp[i];
	 				}				
	 			}
	 
	 			JTable selectTable = new JTable(courses,columnNames);
	 			makeFace(selectTable);
	 			TableColumn column = selectTable .getColumnModel().getColumn(0);
	 	  	      column.setPreferredWidth(105);//设置列宽的函数
	 	  	      column = selectTable .getColumnModel().getColumn(1);
	 		      column.setPreferredWidth(50);//设置列宽的函数
	 		      column = selectTable .getColumnModel().getColumn(2);
	 	  	      column.setPreferredWidth(107);//设置列宽的函数
	 	  	      column = selectTable .getColumnModel().getColumn(3);
	 		      column.setPreferredWidth(130);//设置列宽的函数
	 		      column = selectTable .getColumnModel().getColumn(4);
	 	  	      column.setPreferredWidth(35);//设置列宽的函数
	 	  	      column = selectTable .getColumnModel().getColumn(5);
	 		      column.setPreferredWidth(100);//设置列宽的函数
	 		      column = selectTable .getColumnModel().getColumn(6);
			      column.setPreferredWidth(100);//设置列宽的函数
	    
	 			myCourseScrollPane=new JScrollPane(selectTable);
	 			myCourseScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	 			myCourseScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	 			myCourseScrollPane.setBounds(37,40, 544, 250);
	 			myCourseScrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
	 			myCourseScrollPane.setVisible(true);
	 			Panel.add(myCourseScrollPane);
	 			
				JLabel lblNewLabel_1 = new JLabel("选课课程号");
				lblNewLabel_1.setFont(new Font("楷体", Font.BOLD, 15));
				lblNewLabel_1.setBounds(10, 330, 100, 30);
				Panel.add(lblNewLabel_1);
				lblNewLabel_1.setVisible(true);
				
				courseNoField = new JTextField();
				courseNoField.setBounds(140, 330, 100, 30);
				Panel.add(courseNoField);
				courseNoField.setColumns(10);
				courseNoField.setVisible(true);
				
				JButton btnNewButton_6 = new JButton("确定");
				btnNewButton_6.setFont(new Font("楷体", Font.BOLD, 12));
				btnNewButton_6.addActionListener(new OkButtonListener());
				btnNewButton_6.setBounds(400, 330, 90, 30);
				Panel.add(btnNewButton_6);
				btnNewButton_6.setVisible(true);

				StudentFrame.setLayout(null);
				panelNow=Panel;
				StudentFrame.add(panelNow);
				StudentFrame.repaint();
	    	}else{
	    		JOptionPane.showMessageDialog(null, "不能退课！");
	    	}
	    	
	    }
	    class OkButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if(courseNoField.getText().equals("")){
					JDialog infoDialog = new JDialog();
					infoDialog.setSize(200,100);
					infoDialog.setLocation(600,300);
					infoDialog.setVisible(true);
					JLabel infoLabel = new JLabel("课程号不能为空！");
					infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
					infoLabel.setVisible(true);
					infoDialog.add(infoLabel);
				}else{
					if(studentBL.quitCourse(ID, courseNoField.getText())){
						JDialog infoDialog = new JDialog();
						infoDialog.setSize(300,200);
						infoDialog.setLocation(600,300);
						infoDialog.setVisible(true);
						JLabel infoLabel = new JLabel("退选成功！");
						infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
						infoLabel.setVisible(true);
						infoDialog.add(infoLabel);
						
						panelNow.remove(myCourseScrollPane);
						
						 String [] columnNames = {"课程类别","编号","开课院系","课程名称","学分","上课时间","上课地点"};
				 			
				           String[][] temp = studentBL.checkMyCourse(ID);
				 			int j=0;
				 			int k=-1;
				 			for(int i = 0 ; i < temp.length ; i++){ 				
				 				if(temp[i][0].equals("通识通修课程")||temp[i][0].equals("跨专业课程")){
				 					j++;		
				 				}
				 			}
				 	//		courseNum = j ;
				 			String[][] courses = new String[j][];		
				 			for(int i = 0 ; i < temp.length ; i++){				
				 				if(temp[i][0].equals("通识通修课程")||temp[i][0].equals("跨专业课程")){
				 					k++;
				 					courses[k] = temp[i];
				 				}				
				 			}
				 
				 			JTable selectTable = new JTable(courses,columnNames);
				 			makeFace(selectTable);
				 			TableColumn column = selectTable .getColumnModel().getColumn(0);
				 	  	      column.setPreferredWidth(105);//设置列宽的函数
				 	  	      column = selectTable .getColumnModel().getColumn(1);
				 		      column.setPreferredWidth(50);//设置列宽的函数
				 		      column = selectTable .getColumnModel().getColumn(2);
				 	  	      column.setPreferredWidth(107);//设置列宽的函数
				 	  	      column = selectTable .getColumnModel().getColumn(3);
				 		      column.setPreferredWidth(130);//设置列宽的函数
				 		      column = selectTable .getColumnModel().getColumn(4);
				 	  	      column.setPreferredWidth(35);//设置列宽的函数
				 	  	      column = selectTable .getColumnModel().getColumn(5);
				 		      column.setPreferredWidth(100);//设置列宽的函数
				 		      column = selectTable .getColumnModel().getColumn(6);
						      column.setPreferredWidth(100);//设置列宽的函数

			 			
			 			
			 			myCourseScrollPane=new JScrollPane(selectTable);
			 			myCourseScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			 			myCourseScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			 			myCourseScrollPane.setBounds(10,40, 544, 250);
			 			myCourseScrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
			 			myCourseScrollPane.setVisible(true);
			 			panelNow.add(myCourseScrollPane);
			 			StudentFrame.repaint();
						
					}else{
						JDialog infoDialog = new JDialog();
						infoDialog.setSize(300,200);
						infoDialog.setLocation(600,300);
						infoDialog.setVisible(true);
						JLabel infoLabel = new JLabel("课程号输入不正确请查证或您未选该课");
						infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
						infoLabel.setVisible(true);
						infoDialog.add(infoLabel);
					}
				}
			}
	    }
    }
    
    class RechooseCourseListener implements ActionListener{
    	JScrollPane selectScrollPane;
    	JScrollPane selectScrollPane2;
    	int courseNum = 0;
	    public void actionPerformed(ActionEvent e){
	    	if(adminBL.getAbleToReselectCourse()){
	    		StudentFrame.remove(panelNow);
		    	StudentFrame.setTitle("学生——补选课程");
				JPanel Panel = new JPanel();
				Panel.setBounds(170, 70, 614, 400);
				Panel.setBackground(Color.white);
//				Panel.setBackground(new Color(255 ,255, 224 ));
//				Panel.setBorder(new LineBorder(new Color(0, 0, 0)));
				Panel.setVisible(true);
	 			Panel.setLayout(null);
		    	
	 			JLabel label = new JLabel("可选课程");
	 			label.setFont(new Font("楷体", Font.BOLD, 15));
	 			label.setBounds(10, 10, 100, 30);
	 			Panel.add(label);
	 			label.setVisible(true);
	 			
	 			JLabel label2 = new JLabel("已选课程");
	 			label2.setFont(new Font("楷体", Font.BOLD, 15));
	 			label2.setBounds(10, 200, 100, 30);
	 			Panel.add(label2);
	 			label2.setVisible(true);
	 			
	 			JLabel label3 = new JLabel("友情提醒");
	 			label3.setFont(new Font("楷体", Font.BOLD, 15));
	 			label3.setBounds(300, 210, 100, 30);
	 			Panel.add(label3);
	 			label3.setVisible(true);
	 			
	 			JLabel label4 = new JLabel("1.选课门数不得超过4门");
	 			label4.setFont(new Font("楷体", Font.BOLD, 15));
	 			label4.setBounds(300, 240, 200, 30);
	 			Panel.add(label4);
	 			label4.setVisible(true);
	 			
	 			JLabel label5 = new JLabel("2.选课采用直选式，先到先得");
	 			label5.setFont(new Font("楷体", Font.BOLD, 15));
	 			label5.setBounds(300, 270, 250, 30);
	 			Panel.add(label5);
	 			label5.setVisible(true);
	 			
	 			//"课程类别","课程编号","开课院系","课程名称","学分","开设学期","上课时间","上课地点","任课老师","教材","参考书目"
	 			String [] columnNames = {"课程类别","编号","开课院系","课程名称","学分","上课时间","上课地点"};
	 			
	 			String[][]temp = studentBL.showSelectList();
	 			for(int i=0;i<temp.length;i++){
	 			for(int j=5;j<7;j++){
	 				temp[i][j] = temp[i][j+1];				
	 			}
	 			}
	 			JTable selectTable = new JTable(temp,columnNames);
	 			makeFace(selectTable);
	 			TableColumn column = selectTable .getColumnModel().getColumn(0);
	 	  	      column.setPreferredWidth(105);//设置列宽的函数
	 	  	      column = selectTable .getColumnModel().getColumn(1);
	 		      column.setPreferredWidth(50);//设置列宽的函数
	 		      column = selectTable .getColumnModel().getColumn(2);
	 	  	      column.setPreferredWidth(107);//设置列宽的函数
	 	  	      column = selectTable .getColumnModel().getColumn(3);
	 		      column.setPreferredWidth(130);//设置列宽的函数
	 		      column = selectTable .getColumnModel().getColumn(4);
	 	  	      column.setPreferredWidth(35);//设置列宽的函数
	 	  	      column = selectTable .getColumnModel().getColumn(5);
	 		      column.setPreferredWidth(100);//设置列宽的函数
	 		      column = selectTable .getColumnModel().getColumn(6);
			      column.setPreferredWidth(100);//设置列宽的函数
	 		     
	 	  	      
	 			
	 		    selectScrollPane=new JScrollPane(selectTable);
	 		    selectScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	 		    selectScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	 		    selectScrollPane.setBounds(37,40, 544, 150);
	 		    selectScrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
	 		    selectScrollPane.setVisible(true);
	 			Panel.add(selectScrollPane);
	 		
	 			//得到已选课程
	 			temp = studentBL.showScore(ID);
	 			int j=0;
	 			int k=-1;
	 			for(int i = 0 ; i < temp.length ; i++){ 				
	 				if(temp[i][0].equals("通识通修课程")||temp[i][0].equals("跨专业课程")){
	 					j++;		
	 				}
	 			}
	 			courseNum = j ;
	 			String[][] courses = new String[j][];		
	 			for(int i = 0 ; i < temp.length ; i++){				
	 				if(temp[i][0].equals("通识通修课程")||temp[i][0].equals("跨专业课程")){
	 					k++;
	 					courses[k] = temp[i];
	 				}				
	 			}
	 
	 			String [] columnTitle = {"课程类别","编号"};
	 			selectTable = new JTable(courses,columnTitle);
	 			makeFace(selectTable);
	 			column= selectTable .getColumnModel().getColumn(0);
		  	     column.setPreferredWidth(105);//设置列宽的函数
		  	     column = selectTable .getColumnModel().getColumn(1);
			     column.setPreferredWidth(50);//设置列宽的函数
			     
	 			selectScrollPane2=new JScrollPane(selectTable);
	 		    selectScrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	 		    selectScrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	 		    selectScrollPane2.setBounds(37,230, 200, 90);
	 		    selectScrollPane2.setBorder(new LineBorder(new Color(0, 0, 0)));
	 		    selectScrollPane2.setVisible(true);
	 			Panel.add(selectScrollPane2);
	 			
				JLabel lblNewLabel_1 = new JLabel("选课课程号");
				lblNewLabel_1.setFont(new Font("楷体", Font.BOLD, 15));
				lblNewLabel_1.setBounds(10, 330, 100, 30);
				Panel.add(lblNewLabel_1);
				lblNewLabel_1.setVisible(true);
				
				courseNoField = new JTextField();
				courseNoField.setBounds(140, 330, 100, 30);
				Panel.add(courseNoField);
				courseNoField.setColumns(10);
				courseNoField.setVisible(true);
				
				JButton btnNewButton_6 = new JButton("确定");
				btnNewButton_6.setFont(new Font("楷体", Font.BOLD, 12));
				btnNewButton_6.addActionListener(new OkButtonListener());
				btnNewButton_6.setBounds(400, 330, 90, 30);
				Panel.add(btnNewButton_6);
				btnNewButton_6.setVisible(true);

				StudentFrame.setLayout(null);
				panelNow=Panel;
				StudentFrame.add(panelNow);
				StudentFrame.repaint();
	    	}else{
	    		JOptionPane.showMessageDialog(null,"补选尚未开始！");
	    	}
	    	
	    }
	    class OkButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if(courseNoField.getText().equals("")){
					JDialog infoDialog = new JDialog();
					infoDialog.setSize(200,100);
					infoDialog.setLocation(600,300);
					infoDialog.setVisible(true);
					JLabel infoLabel = new JLabel("课程号不能为空！");
					infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
					infoLabel.setVisible(true);
					infoDialog.add(infoLabel);
				}else{
					if(courseNum==4){
						JDialog infoDialog = new JDialog();
						infoDialog.setSize(200,100);
						infoDialog.setLocation(600,300);
						infoDialog.setVisible(true);
						JLabel infoLabel = new JLabel("您选择的课程数已满");
						infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
						infoLabel.setVisible(true);
						infoDialog.add(infoLabel);
					}
					else if(studentBL.selectCourse(ID, courseNoField.getText())){
						JDialog infoDialog = new JDialog();
						infoDialog.setSize(200,100);
						infoDialog.setLocation(600,300);
						infoDialog.setVisible(true);
						JLabel infoLabel = new JLabel("选课成功！");
						infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
						infoLabel.setVisible(true);
						infoDialog.add(infoLabel);
						
						panelNow.remove(selectScrollPane2);
						//得到已选课程
			 			String[][] temp = studentBL.showScore(ID);
			 			int j=0;
			 			int k=-1;
			 			for(int i = 0 ; i < temp.length ; i++){ 				
			 				if(temp[i][0].equals("通识通修课程")||temp[i][0].equals("跨专业课程")){
			 					j++;		
			 				}
			 			}
			 			courseNum = j ;
			 			String[][] courses = new String[j][];		
			 			for(int i = 0 ; i < temp.length ; i++){				
			 				if(temp[i][0].equals("通识通修课程")||temp[i][0].equals("跨专业课程")){
			 					k++;
			 					courses[k] = temp[i];
			 				}				
			 			}
			 
			 			String [] columnTitle = {"课程类别","编号"};
			 			JTable selectTable = new JTable(courses,columnTitle);
			 			makeFace(selectTable);
			 			TableColumn column = selectTable .getColumnModel().getColumn(0);
				  	     column.setPreferredWidth(105);//设置列宽的函数
				  	     column = selectTable .getColumnModel().getColumn(1);
					     column.setPreferredWidth(50);//设置列宽的函数
					     
			 			selectScrollPane2=new JScrollPane(selectTable);
			 		    selectScrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			 		    selectScrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			 		    selectScrollPane2.setBounds(37,230, 200, 90);
			 		    selectScrollPane2.setBorder(new LineBorder(new Color(0, 0, 0)));
			 		    selectScrollPane2.setVisible(true);
			 			panelNow.add(selectScrollPane2);
			 			StudentFrame.repaint();
						
					}else{
						JDialog infoDialog = new JDialog();
						infoDialog.setSize(300,200);
						infoDialog.setLocation(600,300);
						infoDialog.setVisible(true);
						JLabel infoLabel = new JLabel("课程号输入不正确请查证或您已选该课");
						infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
						infoLabel.setVisible(true);
						infoDialog.add(infoLabel);
					}
				}
			}
	    }
    }


    class LogoutListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			StudentFrame.dispose();
			new LoginFrame(new LoginBL());
		}
    }
    
    class ChangePasswordListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			StudentFrame.remove(panelNow);
	    	StudentFrame.setTitle("学生——更改密码");
			JPanel Panel = new YPanel();
			Panel.setBounds(170, 70, 614, 400);
			Panel.setBackground(Color.white);
//			Panel.setBackground(new Color(255 ,255, 224 ));
//			Panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			Panel.setVisible(true);
 			Panel.setLayout(null);
 			
			JLabel label = new JLabel("新密码");
			label.setFont(new Font("楷体", Font.BOLD, 16));
 			label.setBounds(10, 10, 100, 30);
 			Panel.add(label);
 			label.setVisible(true);
 			
 			newPasswordField = new JTextField();
 			newPasswordField.setBounds(130,10,160,30);
 			Panel.add(newPasswordField);
 			newPasswordField.setVisible(true);
 			
 			StudentFrame.setLayout(null);
			panelNow=Panel;
			StudentFrame.add(panelNow);
			StudentFrame.repaint();
			
			JButton OkButton = new JButton("确定");
 			OkButton.setFont(new Font("楷体", Font.BOLD, 12));
 			OkButton.setBounds(450, 10, 70, 30);
 			OkButton.addActionListener(new changePasswordOkButtonListener());
 			Panel.add(OkButton);
 			OkButton.setVisible(true);
		}
		class changePasswordOkButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if(!newPasswordField.getText().equals("")){
					studentBL.changePassword(ID, newPasswordField.getText());
					JDialog infoDialog = new JDialog();
					infoDialog.setSize(200,100);
					infoDialog.setLocation(600,300);
					infoDialog.setVisible(true);
					JLabel infoLabel = new JLabel("密码已更新！");
					infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
					infoLabel.setVisible(true);
					infoDialog.add(infoLabel);
				}else{
					JDialog infoDialog = new JDialog();
					infoDialog.setSize(200,100);
					infoDialog.setLocation(600,300);
					infoDialog.setVisible(true);
					JLabel infoLabel = new JLabel("密码不能为空！");
					infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
					infoLabel.setVisible(true);
					infoDialog.add(infoLabel);
				}
			}
				
			}
    }

    //设置表格颜色并居中
    public static void makeFace(JTable table) {
    	table.getTableHeader().setReorderingAllowed(false);// 设置JTable每个字段的顺序不可以改变
    	   try {
    	    DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
    	     public Component getTableCellRendererComponent(JTable table,
    	       Object value, boolean isSelected, boolean hasFocus,
    	       int row, int column) {
    	      if (row % 2 == 0)
    	       setBackground(Color.white); // 设置奇数行底色
    	      else if (row % 2 == 1)
    	       setBackground(new Color(206, 231, 255)); // 设置偶数行底色
    	      return super.getTableCellRendererComponent(table, value,
    	        isSelected, hasFocus, row, column);
    	     }
    	    };
    	    for (int i = 0; i < table.getColumnCount(); i++) {
    	     table.getColumn(table.getColumnName(i)).setCellRenderer(tcr);
    	    }
    	    tcr.setHorizontalAlignment(JLabel.CENTER);
    	    table.setDefaultRenderer(Object.class,tcr);
    	    
    	   } catch (Exception ex) {
    	    ex.printStackTrace();
    	   }

    	

}
    
}
