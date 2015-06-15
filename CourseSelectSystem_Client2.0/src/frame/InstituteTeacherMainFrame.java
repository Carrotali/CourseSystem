package frame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import frame.SchoolTeacherMainFrame.ChangePasswordListener;
import frame.SchoolTeacherMainFrame.CheckCoInfroListener;
import frame.SchoolTeacherMainFrame.CheckStInfroListener;
import frame.SchoolTeacherMainFrame.CheckThInfroListener;
import frame.SchoolTeacherMainFrame.LogoutListener;
import frame.SchoolTeacherMainFrame.PublishCourseListener;
import frame.SchoolTeacherMainFrame.CheckCoInfroListener.CheckSchoolCourseOKButtonListener;

import busninesslogic.AdminBL;
import busninesslogic.AdminBLService;
import busninesslogic.InstituteTeacherBL;
import busninesslogic.InstituteTeacherBLService;
import busninesslogic.LoginBL;

public class InstituteTeacherMainFrame{
	private JFrame InstituteTeacherFrame;
	private JPanel panel;
	private JPanel Panel;
	private JPanel panel_2;
	private JPanel panel_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private JButton btnNewButton_7;
	private JPanel panelNow;
	private JTable courseTable;
	private JTextField newPasswordField;
	private JScrollPane scrollPane;
	private InstituteTeacherBLService instituteTeacherBL;
	private AdminBLService adminBLService;
    private String ID;
    //private String password;
	
    //测试main方法
	public static void main(String[] args){
		new InstituteTeacherMainFrame("20001","111111",new InstituteTeacherBL(),new AdminBL());
	}
	
	/* 
	 * 院系教务处老师主界面构造函数
	 */
	public InstituteTeacherMainFrame(String ID,String password,InstituteTeacherBLService instituteTeacherBL,AdminBLService adminBLService) {
		this.instituteTeacherBL = instituteTeacherBL;
		this.adminBLService = adminBLService;
		this.ID = ID;
    	//this.password = password;
    	
		InstituteTeacherFrame = new JFrame();
		InstituteTeacherFrame.setSize(800,500);
		InstituteTeacherFrame.setLocation(300,100);
		InstituteTeacherFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("教务员.jpg"));
		InstituteTeacherFrame.setTitle("院系老师主界面");
		InstituteTeacherFrame.getContentPane().setLayout(null);
		InstituteTeacherFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		InstituteTeacherFrame.setVisible(true);
		
		panel_2 = new MyPanel();
		panel_2.setBackground(Color.white);
		panel_2.setBounds(0, 0, 80, 80);
		InstituteTeacherFrame.getContentPane().add(panel_2);
		
		panel = new JPanel();
		panel.setBackground(new Color(199, 0, 133 ));
//		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 0, 820, 70);
		InstituteTeacherFrame.getContentPane().add(panel);
		panel.setVisible(true);
		panel.setLayout(null);
		
		
		
		
		JLabel lblNewLabel = new JLabel("欢迎" + instituteTeacherBL.getSelfInfor(ID)[3] + instituteTeacherBL.getSelfInfor(ID)[1] + "教务员！");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(Color.white);
		lblNewLabel.setFont(new Font("德彪钢笔行书字库", Font.BOLD, 24));
		lblNewLabel.setBounds(80, 10, 425, 45);
		panel.add(lblNewLabel);
		lblNewLabel.setVisible(true);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(199, 0, 133 ));
		panel_1.setForeground(Color.WHITE);
//		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(0, 70, 170, 400);
		InstituteTeacherFrame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(true);
		
		btnNewButton = new JButton("制定学院教学计划");
		btnNewButton.setFont(new Font("楷体", Font.BOLD, 16));
		btnNewButton.setBounds(10, 25, 150, 35);
		btnNewButton.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton.setBackground(new Color(199, 0, 133 ));
		btnNewButton.setForeground(Color.white);
		btnNewButton.setVisible(true);
		btnNewButton.addActionListener(new MakeplanListener());
		panel_1.add(btnNewButton);
	
		
		btnNewButton_1 = new JButton("查看本院所有课程");
		btnNewButton_1.setFont(new Font("楷体", Font.BOLD, 16));
		btnNewButton_1.setBounds(10, 75, 150, 35);
		btnNewButton_1.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton_1.setBackground(new Color(199, 0, 133 ));
		btnNewButton_1.setForeground(Color.white);
		btnNewButton_1.addActionListener(new CheckAllCourseListener());
		panel_1.add(btnNewButton_1);
		btnNewButton_1.setVisible(true);
		
		btnNewButton_2 = new JButton("查看本院学生列表");
		btnNewButton_2.setFont(new Font("楷体", Font.BOLD, 16));
		btnNewButton_2.setBounds(10, 125, 150, 35);
		btnNewButton_2.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton_2.setBackground(new Color(199, 0, 133 ));
		btnNewButton_2.setForeground(Color.white);
		btnNewButton_2.setVisible(true);
		btnNewButton_2.addActionListener(new CheckStlistListener());
		panel_1.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("查看课程详细信息");
		btnNewButton_3.setFont(new Font("楷体", Font.BOLD, 16));
		btnNewButton_3.setBounds(10, 175, 150, 35);
		btnNewButton_3.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton_3.setBackground(new Color(199, 0, 133 ));
		btnNewButton_3.setForeground(Color.white);
		btnNewButton_3.setVisible(true);
		btnNewButton_3.addActionListener(new CheckCourseInferListener());
		panel_1.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("发布课程");
		btnNewButton_4.setFont(new Font("楷体", Font.BOLD, 16));
		btnNewButton_4.setBounds(10, 225, 150, 35);
		btnNewButton_4.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton_4.setBackground(new Color(199, 0, 133 ));
		btnNewButton_4.setForeground(Color.white);
		btnNewButton_4.setVisible(true);
		btnNewButton_4.addActionListener(new PublishCourseListener());
		panel_1.add(btnNewButton_4);
		
		btnNewButton_7 = new JButton("管理本院课程");
		btnNewButton_7.setFont(new Font("楷体", Font.BOLD, 16));
		btnNewButton_7.setBounds(10, 275, 150, 35);
		btnNewButton_7.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton_7.setBackground(new Color(199, 0, 133 ));
		btnNewButton_7.setForeground(Color.white);
		btnNewButton_7.setVisible(true);
		btnNewButton_7.addActionListener(new ManageCourseListener());
		panel_1.add(btnNewButton_7);
		
		btnNewButton_5 = new JButton("修改密码");
		btnNewButton_5.setFont(new Font("楷体", Font.BOLD, 16));
		btnNewButton_5.setBounds(10, 325, 150, 35);
		btnNewButton_5.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton_5.setBackground(new Color(199, 0, 133 ));
		btnNewButton_5.setForeground(Color.white);
		btnNewButton_5.setVisible(true);
		btnNewButton_5.addActionListener(new ChangePasswordListener());
		panel_1.add(btnNewButton_5);
		
		btnNewButton_6 = new JButton("注销");
		btnNewButton_6.setFont(new Font("楷体", Font.BOLD, 16));
		btnNewButton_6.setBounds(10, 365, 150, 35);
		btnNewButton_6.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton_6.setBackground(new Color(199, 0, 133 ));
		btnNewButton_6.setForeground(Color.white);
		btnNewButton_6.setVisible(true);
		btnNewButton_6.addActionListener(new LogoutListener());
		panel_1.add(btnNewButton_6);
		
		

		panelNow = new XPanel();
		panelNow.setBackground(Color.white);
//		panelNow.setBackground(new Color(255 ,255, 224 ));
//		panelNow.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelNow.setBounds(170, 70, 614, 400);
		InstituteTeacherFrame.getContentPane().add(panelNow);
		panelNow.setVisible(true);
		
		InstituteTeacherFrame.repaint();
	}
	
	/*
	 * 管理教学计划事件监听
	 */
	class MakeplanListener implements ActionListener{
	    public void actionPerformed(ActionEvent e){
	    	if(adminBLService.getAbleToChangePlan()){
	    		InstituteTeacherFrame.remove(panelNow);
		    	InstituteTeacherFrame.setTitle("院系教务老师——制定教学计划");
				Panel = new JPanel();
				Panel.setSize(614, 400);
				Panel.setLocation(170, 70);
				Panel.setBackground(Color.white);
				Panel.setVisible(true);
	 			Panel.setLayout(null);
				
				JLabel lblNewLabel_1 = new JLabel("\u7B2C\u4E00\u5B66\u5E74\u6240\u9700\u5B66\u5206");
				lblNewLabel_1.setFont(new Font("楷体", Font.BOLD, 14));
				lblNewLabel_1.setBounds(10, 30, 130, 30);
				lblNewLabel_1.setVisible(true);
				Panel.add(lblNewLabel_1);
				
				JLabel lblNewLabel_2 = new JLabel("\u7B2C\u4E8C\u5B66\u5E74\u6240\u9700\u5B66\u5206\r\n");
				lblNewLabel_2.setFont(new Font("楷体", Font.BOLD, 14));
				lblNewLabel_2.setBounds(10, 75, 130, 30);
				lblNewLabel_2.setVisible(true);
				Panel.add(lblNewLabel_2);
				
				JLabel lblNewLabel_3 = new JLabel("\u7B2C\u4E09\u5B66\u5E74\u6240\u9700\u5B66\u5206");
				lblNewLabel_3.setFont(new Font("楷体", Font.BOLD, 14));
				lblNewLabel_3.setBounds(10, 120, 130, 30);
				lblNewLabel_3.setVisible(true);
				Panel.add(lblNewLabel_3);
				
				JLabel lblNewLabel_4 = new JLabel("\u7B2C\u56DB\u5B66\u5E74\u6240\u9700\u5B66\u5206");
				lblNewLabel_4.setFont(new Font("楷体", Font.BOLD, 14));
				lblNewLabel_4.setBounds(10, 165, 130, 30);
				lblNewLabel_4.setVisible(true);
				Panel.add(lblNewLabel_4);
				
				textField_3 = new JTextField();
				textField_3.setBounds(150, 35, 76, 21);
				textField_3.setColumns(10);
				textField_3.setVisible(true);
				Panel.add(textField_3);
				
				textField_4 = new JTextField();
				textField_4.setBounds(150, 80, 76, 21);
				Panel.add(textField_4);
				textField_4.setColumns(10);
				textField_4.setVisible(true);

				
				textField_5 = new JTextField();
				textField_5.setBounds(150, 125, 76, 21);
				textField_5.setColumns(10);
				textField_5.setVisible(true);
				Panel.add(textField_5);
				
				textField_6 = new JTextField();
				textField_6.setBounds(150, 170, 76, 21);
				textField_6.setColumns(10);
				textField_6.setVisible(true);
				Panel.add(textField_6);
				
				JLabel label_2 = new JLabel("\u51C6\u5165\u6240\u9700\u5B66\u5206");
				label_2.setFont(new Font("楷体", Font.BOLD, 14));
				label_2.setBounds(269, 30, 130, 30);
				label_2.setVisible(true);
				Panel.add(label_2);
				
				JLabel lblNewLabel_5 = new JLabel("\u51C6\u51FA\u6240\u9700\u5B66\u5206\r\n");
				lblNewLabel_5.setFont(new Font("楷体", Font.BOLD, 14));
				lblNewLabel_5.setBounds(269, 75, 130, 30);
				lblNewLabel_5.setVisible(true);
				Panel.add(lblNewLabel_5);
				
				textField_7 = new JTextField();
				textField_7.setBounds(380, 35, 76, 21);
				textField_7.setColumns(10);
				textField_7.setVisible(true);
				Panel.add(textField_7);

				textField_8 = new JTextField();
				textField_8.setBounds(380, 80, 76, 21);
				textField_8.setColumns(10);
				textField_8.setVisible(true);
				Panel.add(textField_8);
				
				JButton button = new JButton("\u786E\u5B9A");
				button.setFont(new Font("楷体", Font.BOLD, 12));
				button.setBounds(430, 335, 93, 23);
				button.setVisible(true);
				button.addActionListener(new MakePlanOkListener());
				Panel.add(button);
				
				InstituteTeacherFrame.setLayout(null);
				panelNow = Panel;
				InstituteTeacherFrame.add(panelNow);
				InstituteTeacherFrame.repaint();
				
	    	}else{
	    		 JOptionPane.showMessageDialog(null, "不可更改！");
	    	}
	    	
	    }
	    /*
	     * 管理教学计划确定按钮事件监听
	     */
	    class MakePlanOkListener implements ActionListener{
		    public void actionPerformed(ActionEvent e){
		    	if(textField_3.getText().equals("")||textField_4.getText().equals("")||textField_5.getText().equals("")||
		                  textField_6.getText().equals("")||textField_7.getText().equals("")||textField_8.getText().equals("")){
		    		JOptionPane.showMessageDialog(null, "尚有未填写信息！");  		
		    	}else{
		    		Boolean isSet = instituteTeacherBL.makePlan(instituteTeacherBL.getSelfInfor(ID)[3]
		    			             ,textField_3.getText(),textField_4.getText(),textField_5.getText(),
		    			                  textField_6.getText(),textField_7.getText(),textField_8.getText());
		    	    if(isSet){
	  			         JOptionPane.showMessageDialog(null, "制定成功！");  		
		    	    }else{
		    		     JOptionPane.showMessageDialog(null, "制定出现问题！");  
		    	    }
		    	}	
		    }  	
	    }
    }
    
	/*
     *查看全校课程事件监听 
     */
    class CheckAllCourseListener implements ActionListener{
    	JTextArea textArea = new JTextArea();
	    public void actionPerformed(ActionEvent e){
	    	InstituteTeacherFrame.remove(panelNow);
	    	InstituteTeacherFrame.setTitle("院系教务老师——查看学院课程");
			Panel = new JPanel();
			Panel.setSize(614, 400);
			Panel.setLocation(170, 70);
			Panel.setBackground(Color.white);
			Panel.setVisible(true);
 			Panel.setLayout(null);
	    	
 			JLabel label = new JLabel("课程号");
 			label.setFont(new Font("楷体", Font.BOLD, 16));
 			label.setBounds(50, 270, 100, 30);
 			Panel.add(label);
 			label.setVisible(true);
 			
 			JLabel label2 = new JLabel("(补充了教材、参考书目信息)");
 			label2.setFont(new Font("楷体", Font.BOLD, 14));
 			label2.setBounds(360, 270, 250, 30);
 			Panel.add(label2);
 			label2.setVisible(true);
			
			JButton button = new JButton("确认");
			button.setFont(new Font("楷体", Font.BOLD, 12));
			button.setBounds(282, 272, 60, 25);
			Panel.add(button);
			button.setVisible(true);
			button.addActionListener(new CheckInstituteCourseOKButtonListener());
			
			textField = new JTextField();
			textField.setBounds(150,270,100,30);
			Panel.add(textField);
			textField.setColumns(10);

			textArea = new JTextArea();
			textArea.setBounds(50,320,530,50);
			textArea.setLineWrap(true);
			textArea.setEditable(false);
			textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
			Panel.add(textArea);
			textArea.setVisible(true);

 			String [] columnNames = {"课程类别","课程号","课程名","学分","开设学期","时间","教室","教师名、工号"};
  
  			
  			String[][]temp=instituteTeacherBL.checkColist(instituteTeacherBL.getSelfInfor(ID)[3]);
			for(int i=0;i<temp.length;i++)
				for(int j=2;j<8;j++){
					temp[i][j] = temp[i][j+1];
				}
			courseTable  = new JTable(temp,columnNames);		
			makeFace(courseTable);
  		  TableColumn column = courseTable .getColumnModel().getColumn(0);
  	      column.setPreferredWidth(110);//设置列宽的函数
  	      column = courseTable .getColumnModel().getColumn(1);
	      column.setPreferredWidth(50);//设置列宽的函数
	      column = courseTable .getColumnModel().getColumn(2);
  	      column.setPreferredWidth(130);//设置列宽的函数
  	      column = courseTable .getColumnModel().getColumn(3);
	      column.setPreferredWidth(35);//设置列宽的函数
	      column = courseTable .getColumnModel().getColumn(4);
  	      column.setPreferredWidth(70);//设置列宽的函数
  	      column = courseTable .getColumnModel().getColumn(5);
	      column.setPreferredWidth(100);//设置列宽的函数
	      column = courseTable .getColumnModel().getColumn(6);
  	      column.setPreferredWidth(100);//设置列宽的函数
  	      column = courseTable .getColumnModel().getColumn(7);
	      column.setPreferredWidth(120);

  			
  		    scrollPane = new JScrollPane(courseTable);
  		    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
  		    scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
  		    scrollPane.setBounds(37,10, 544, 250);
  		    scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
  		    scrollPane.setVisible(true);
  			Panel.add(scrollPane);
			
			InstituteTeacherFrame.setLayout(null);
			panelNow = Panel;
			InstituteTeacherFrame.add(panelNow);
			InstituteTeacherFrame.repaint();
	    }
	    
	    /*
	     * 查看院系课程确定按钮事件监听
	     */
	    class CheckInstituteCourseOKButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				
				String[]temp=instituteTeacherBL.checkCoInfro((String)textField.getText());
				
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
					String infor = Arrays.toString(instituteTeacherBL.checkCoInfro((String)textField.getText()));
					textArea = new JTextArea(infor);
					textArea.setBounds(50,320,530,50);
					textArea.setLineWrap(true);
					textArea.setEditable(false);
					textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
					panelNow.add(textArea);
					InstituteTeacherFrame.repaint();
				}
			}
	    }
    } 

    /*
     * 查看课程信息事件监听
     */
    class CheckCourseInferListener implements ActionListener{
	    public void actionPerformed(ActionEvent e){
	    	InstituteTeacherFrame.remove(panelNow);
	    	InstituteTeacherFrame.setTitle("院系教务老师——查看课程信息");
			Panel = new JPanel();
			Panel.setSize(614, 400);
			Panel.setLocation(170, 70);
			Panel.setBackground(Color.white);
			Panel.setVisible(true);
 			Panel.setLayout(null);
 			
 			JLabel label = new JLabel("\u8F93\u5165\u8BFE\u7A0B\u53F7");
 			label.setFont(new Font("楷体", Font.BOLD, 15));
 			label.setBounds(10, 10, 100, 30);
 			label.setVisible(true);
			Panel.add(label);
 			
 			textField_2 = new JTextField();
 			textField_2.setBounds(150, 10, 100, 35);
 			textField_2.setVisible(true);
			Panel.add(textField_2);
			textField_2.setColumns(10);
 			
 			JButton button = new JButton("\u786E\u5B9A");
 			button.setFont(new Font("楷体", Font.BOLD, 12));
 			button.setBounds(335, 14, 93, 23);
 			button.setVisible(true);
			button.addActionListener(new CheckCoInfroOkListener());
			Panel.add(button);
			
			InstituteTeacherFrame.setLayout(null);
			panelNow=Panel;
			InstituteTeacherFrame.add(panelNow);
			InstituteTeacherFrame.repaint();
	    }
	    
	    /*
	     * 查看课程信息确定按钮事件监听
	     */
	    class CheckCoInfroOkListener implements ActionListener{
		    public void actionPerformed(ActionEvent e){
		    	String[] findCourseInfro = instituteTeacherBL.checkCoInfro(textField_2.getText());
		    	String[][] note = new String [1][11];

		    	if(findCourseInfro == null){
	  			    JOptionPane.showMessageDialog(null, "课程号未填或错误！");  		
		    	}else{
		    		
			    	for(int i=0;i < 11;i++){
			    		note[0][i] = findCourseInfro[i];
			    	}
			    	
		    		String [] columnNames = {"课程类别","课程号","学院","课程名","学分","开设学期","时间","教室","教师名、工号","教材名","参考书目"};
		  			courseTable = new JTable(note,columnNames);
		  			makeFace(courseTable);
		  			
		  		    scrollPane = new JScrollPane(courseTable);
		  		    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		  		    scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		  		    scrollPane.setBounds(37,100, 544, 250);
		  		    scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		  		    scrollPane.setVisible(true);
		  			Panel.add(scrollPane);
		    	}
		    }
		}
    }
   
    /*
     * 查看学生列表事件监听
     */
    class CheckStlistListener implements ActionListener{
	    public void actionPerformed(ActionEvent e){
	    	InstituteTeacherFrame.remove(panelNow);
	    	InstituteTeacherFrame.setTitle("院系教务老师——查看本院学生信息");
			Panel = new JPanel();
			Panel.setSize(614, 400);
			Panel.setLocation(170, 70);
			Panel.setBackground(Color.white);
			Panel.setVisible(true);
 			Panel.setLayout(null);
	    	
			JLabel label = new JLabel("\u8F93\u5165\u8BFE\u7A0B\u53F7");
			label.setFont(new Font("楷体", Font.BOLD, 15));
			label.setBounds(10, 10, 100, 30);
 			label.setVisible(true);
			Panel.add(label);
			
			textField_9 = new JTextField();
			textField_9.setBounds(150, 10, 100, 30);
			textField_9.setVisible(true);
			Panel.add(textField_9);
			textField_9.setColumns(10);
			
			JButton button = new JButton("\u786E\u5B9A");
			button.setFont(new Font("楷体", Font.BOLD, 12));
			button.setBounds(351, 14, 93, 23);
 			button.setVisible(true);
			button.addActionListener(new CheckStlistOkListener());
			Panel.add(button);
			
			InstituteTeacherFrame.setLayout(null);
			panelNow=Panel;
			InstituteTeacherFrame.add(panelNow);
			InstituteTeacherFrame.repaint();
	    }
	    
	    /*
	     * 查看学生列表确定按钮
	     */
	    class CheckStlistOkListener implements ActionListener{
		    public void actionPerformed(ActionEvent e){
		    	String[][] note = instituteTeacherBL.checkStlist(textField_9.getText());
		    	if(note == null){
	  			    JOptionPane.showMessageDialog(null, "课程号未填或错误！");  		
		    	}else{
		    		String [] columnNames = {"学号","学生姓名","课程号","学院","学分绩","毕业资格","退学资格"};
		  			courseTable = new JTable(note,columnNames);
		  			makeFace(courseTable);
		  			 TableColumn column = courseTable .getColumnModel().getColumn(0);
		  	  	      column.setPreferredWidth(110);//设置列宽的函数
		  	  	      column = courseTable .getColumnModel().getColumn(1);
		  		      column.setPreferredWidth(80);//设置列宽的函数
		  		      column = courseTable .getColumnModel().getColumn(2);
		  	  	      column.setPreferredWidth(60);//设置列宽的函数
		  	  	      column = courseTable .getColumnModel().getColumn(3);
		  		      column.setPreferredWidth(80);//设置列宽的函数
		  		      column = courseTable .getColumnModel().getColumn(4);
		  	  	      column.setPreferredWidth(55);//设置列宽的函数
		  	  	      column = courseTable .getColumnModel().getColumn(5);
		  		      column.setPreferredWidth(130);//设置列宽的函数
		  		      column = courseTable .getColumnModel().getColumn(6);
		  	  	      column.setPreferredWidth(100);//设置列宽的函数
		  	  	     
		  		    scrollPane = new JScrollPane(courseTable);
		  		    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		  		    scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		  		    scrollPane.setBounds(37,100, 544, 250);
		  		    scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		  		    scrollPane.setVisible(true);
		  			Panel.add(scrollPane);
		    	}
		    }
		}
    }
    
    /*
     * 管理课程事件监听
     */
    class ManageCourseListener implements ActionListener{
	    public void actionPerformed(ActionEvent e){
	    	InstituteTeacherFrame.remove(panelNow);
	    	InstituteTeacherFrame.setTitle("院系教务老师——管理课程信息");
			Panel = new JPanel();
			Panel.setSize(614, 400);
			Panel.setLocation(170, 70);
			Panel.setBackground(Color.white);
			Panel.setVisible(true);
 			Panel.setLayout(null);
	    	
			JLabel label = new JLabel("课程号");
			label.setFont(new Font("楷体", Font.BOLD, 15));
			label.setBounds(10, 10, 100, 30);
			Panel.add(label);
			
			JLabel label_1 = new JLabel("教师工号");
			label_1.setFont(new Font("楷体", Font.BOLD, 15));
			label_1.setBounds(10, 50, 100, 30);
			Panel.add(label_1);
			
			textField = new JTextField();
			textField.setBounds(150, 10, 100, 30);
			Panel.add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setBounds(150, 50, 100, 30);
			Panel.add(textField_1);
			textField_1.setColumns(10);
			
			JButton button = new JButton("\u786E\u5B9A");
			button.setFont(new Font("楷体", Font.BOLD, 12));
			button.setBounds(339, 35, 93, 23);
			button.addActionListener(new ManageCourseOkListener());
			Panel.add(button);
			
			InstituteTeacherFrame.setLayout(null);
			panelNow=Panel;
			InstituteTeacherFrame.add(panelNow);
			InstituteTeacherFrame.repaint();
	    }
	    
	    /*
	     * 管理课程确定按钮事件监听
	     */
	    class ManageCourseOkListener implements ActionListener{
		    public void actionPerformed(ActionEvent e){
				Boolean isSet = instituteTeacherBL.manageCourse(textField_1.getText(),textField.getText());
				if(isSet){
					 JOptionPane.showMessageDialog(null, "管理成功！"); 
				}else{
					 JOptionPane.showMessageDialog(null, "课程号、教师工号未填或错误！"); 
				}
		    }
		}
    }
    
    /*
     * 修改密码事件监听
     */
    class ChangePasswordListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			InstituteTeacherFrame.remove(panelNow);
			InstituteTeacherFrame.setTitle("院系教务老师——更改密码");
			JPanel Panel = new YPanel();
			Panel.setSize(614, 400);
			Panel.setLocation(170, 70);
			Panel.setBackground(Color.white);
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
 			
 			InstituteTeacherFrame.setLayout(null);
			panelNow=Panel;
			InstituteTeacherFrame.add(panelNow);
			InstituteTeacherFrame.repaint();
			
			JButton OkButton = new JButton("确定");
 			OkButton.setFont(new Font("楷体", Font.BOLD, 12));
 			OkButton.setBounds(450, 10, 70, 30);
 			OkButton.addActionListener(new changePasswordOkButtonListener());
 			Panel.add(OkButton);
 			OkButton.setVisible(true);
		}
		
		/*
		 * 修改密码确定按钮事件监听
		 */
		class changePasswordOkButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if(!newPasswordField.getText().equals("")){
					instituteTeacherBL.changePassword(ID, newPasswordField.getText());
					JOptionPane.showMessageDialog(null, "更改成功！"); 
				}else{
					JOptionPane.showMessageDialog(null, "密码不能为空！"); 
				}
			}
				
		}
    }
    
    /*
     * 注销事件监听
     */
    class LogoutListener implements ActionListener{
 		public void actionPerformed(ActionEvent e) {
 			InstituteTeacherFrame.dispose();
 			new LoginFrame(new LoginBL());
 		}
     }
    
    /*
     * 发布课程事件监听
     */
    class PublishCourseListener implements ActionListener{
	    public void actionPerformed(ActionEvent e){
	    	InstituteTeacherFrame.remove(panelNow);
			InstituteTeacherFrame.setTitle("院系教务老师——发布课程");
			JPanel Panel = new JPanel();
			Panel.setSize(614, 400);
			Panel.setLocation(170, 70);
			Panel.setBackground(Color.LIGHT_GRAY);
			Panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			Panel.setBackground(Color.white);
			Panel.setVisible(true);
 			Panel.setLayout(null);
 			
 			JLabel label = new JLabel("\u8BFE\u7A0B\u53F7");
 			label.setFont(new Font("楷体", Font.BOLD, 15));
 			label.setBounds(10, 10, 100, 35);
 			Panel.add(label);
 			label.setVisible(true);
 			
 			JLabel lblNewLabel_1 = new JLabel("\u8BFE\u7A0B\u540D");
 			lblNewLabel_1.setFont(new Font("楷体", Font.BOLD, 15));
 			lblNewLabel_1.setBounds(10, 55, 100, 35);
 			Panel.add(lblNewLabel_1);
 			lblNewLabel_1.setVisible(true);
 			
 			textField_10 = new JTextField();
 			textField_10.setBounds(165, 10, 125, 35);
 			Panel.add(textField_10);
 			textField_10.setColumns(10);
 			textField_10.setVisible(true);
 			
 			textField_11 = new JTextField();
 			textField_11.setBounds(165, 55, 125, 35);
 			Panel.add(textField_11);
 			textField_11.setColumns(10);
 			textField_11.setVisible(true);
 			
 			JLabel lblNewLabel_2 = new JLabel("\u8BFE\u7A0B\u5C5E\u6027");
 			lblNewLabel_2.setFont(new Font("楷体", Font.BOLD, 15));
 			lblNewLabel_2.setBounds(10, 100, 100, 35);
 			Panel.add(lblNewLabel_2);
 			lblNewLabel_2.setVisible(true);
 			
 			JLabel label_1 = new JLabel("\u8BFE\u7A0B\u5B66\u5206");
 			label_1.setFont(new Font("楷体", Font.BOLD, 15));
 			label_1.setBounds(10, 145, 100, 35);
 			Panel.add(label_1);
 			label_1.setVisible(true);
 			
 			JLabel label_2 = new JLabel("\u5F00\u8BBE\u5B66\u671F");
 			label_2.setFont(new Font("楷体", Font.BOLD, 15));
 			label_2.setBounds(10, 195, 100, 35);
 			Panel.add(label_2);
 			label_2.setVisible(true);
 			
 			JLabel lblNewLabel_3 = new JLabel("\u5F00\u8BBE\u5B66\u9662");
 			lblNewLabel_3.setFont(new Font("楷体", Font.BOLD, 15));
 			lblNewLabel_3.setBounds(10, 240, 100, 35);
 			Panel.add(lblNewLabel_3);
 			lblNewLabel_3.setVisible(true);
 			
 			JLabel label_3 = new JLabel("\u4E0A\u8BFE\u65F6\u95F4");
 			label_3.setFont(new Font("楷体", Font.BOLD, 15));
 			label_3.setBounds(10, 285, 100, 35);
 			Panel.add(label_3);
 			label_3.setVisible(true);
 			
 			JLabel label_4 = new JLabel("\u4E0A\u8BFE\u5730\u70B9");
 			label_4.setFont(new Font("楷体", Font.BOLD, 15));
 			label_4.setBounds(10, 330, 100, 35);
 			Panel.add(label_4);
 			label_4.setVisible(true);
 			
 			textField_12 = new JTextField();
 			textField_12.setBounds(165, 100, 125, 35);
 			Panel.add(textField_12);
 			textField_12.setColumns(10);
 			textField_12.setVisible(true);
 			
 			textField_13 = new JTextField();
 			textField_13.setBounds(165, 145, 125, 35);
 			Panel.add(textField_13);
 			textField_13.setColumns(10);
 			textField_13.setVisible(true);
 			
 			textField_14 = new JTextField();
 			textField_14.setBounds(165, 195, 125, 35);
 			Panel.add(textField_14);
 			textField_14.setColumns(10);
 			textField_14.setVisible(true);
 			
 			textField_15 = new JTextField();
 			textField_15.setBounds(165, 240, 125, 35);
 			Panel.add(textField_15);
 			textField_15.setColumns(10);
 			textField_15.setVisible(true);
 			
 			textField_16 = new JTextField();
 			textField_16.setBounds(165, 285, 125, 35);
 			Panel.add(textField_16);
 			textField_16.setColumns(10);
 			textField_16.setVisible(true);
 			
 			textField_17 = new JTextField();
 			textField_17.setBounds(165, 330, 125, 35);
 			Panel.add(textField_17);
 			textField_17.setColumns(10);
 			textField_17.setVisible(true);
 			
 			JButton button = new JButton("\u786E\u5B9A");
 			button.setFont(new Font("楷体", Font.BOLD, 12));
 			button.setBounds(431, 297, 93, 23);
 			Panel.add(button);
 			button.addActionListener(new PublishCourseOkButtonListener());
 			button.setVisible(true);
 			
 			InstituteTeacherFrame.setLayout(null);
			panelNow=Panel;
			InstituteTeacherFrame.add(panelNow);
			InstituteTeacherFrame.repaint();
	    }
	    
	    /*
	     * 发布课程确定按钮事件监听
	     */
	    class PublishCourseOkButtonListener implements ActionListener{
		    public void actionPerformed(ActionEvent e){
		    	boolean isExist = false;
		    	
		    	if(textField_10.getText().equals("")||textField_10.getText().equals("")||textField_11.getText().equals("")||textField_12.getText().equals("")||textField_13.getText().equals("")||textField_14.getText().equals("")||textField_15.getText().equals("")||textField_16.getText().equals("")||textField_17.getText().equals("")){
					JOptionPane.showMessageDialog(null, "尚有未填！"); 
				}else{
					isExist = instituteTeacherBL.PublishCourse(textField_10.getText(),textField_11.getText(),textField_12.getText(),textField_13.getText(),textField_14.getText(),textField_15.getText(),textField_16.getText(),textField_17.getText());
					if(isExist == true){
					    JOptionPane.showMessageDialog(null, "发布成功！"); 
				    }else {
					JOptionPane.showMessageDialog(null, "发布失败或课程已存在！"); 
				    }				
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
