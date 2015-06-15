package frame;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import busninesslogic.LoginBL;
import busninesslogic.TeacherBL;
import busninesslogic.TeacherBLService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherMainFrame {
	private JFrame TeacherFrame;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	
	private JPanel panelNow;
	private JTextField courseNoField;
	private JTextArea textArea;
	private JTextArea textArea_1;
	private JTable studentTable;
	private JComboBox courseNoBox;
	private JScrollPane scrollPane;
	private JTextField studentNoField;
	private JTextField scoreField;
	private JTextField newPasswordField;
	private TeacherBLService teacherBL;
    private String ID;
    private String password;
    
	public static void main(String[] args){
        new TeacherMainFrame("10001","111111",new TeacherBL());
	}
	
    public TeacherMainFrame(String ID,String password,TeacherBLService teacherBL) {
    	this.teacherBL = teacherBL;
    	this.ID = ID;
    	this.password = password;
    	TeacherFrame = new JFrame();
		TeacherFrame.setSize(800,500);
		TeacherFrame.setLocation(300,100);
		TeacherFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("任课老师.jpg"));
    	TeacherFrame.setTitle("\u4EFB\u8BFE\u8001\u5E08\u4E3B\u754C\u9762");
    	TeacherFrame.getContentPane().setLayout(null);
    	TeacherFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TeacherFrame.setVisible(true);
		
		panel_2 = new MyPanel();
		panel_2.setBackground(Color.white);
		panel_2.setBounds(0, 0, 80, 80);
		TeacherFrame.getContentPane().add(panel_2);
		
		panel = new JPanel();
		panel.setBackground(new Color(199, 0, 133 ));
//		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 0, 820, 70);
		TeacherFrame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setVisible(true);
		
		lblNewLabel = new JLabel("欢迎"+teacherBL.getSelfInfor(ID)[3]+teacherBL.getSelfInfor(ID)[1]+"老师!");
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
		TeacherFrame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(true);
		
		btnNewButton = new JButton("完善课程信息");
		btnNewButton.setFont(new Font("楷体", Font.BOLD, 20));
		btnNewButton.setBounds(10, 30, 150, 35);
		btnNewButton.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton.setBackground(new Color(199, 0, 133 ));
		btnNewButton.setForeground(Color.white);
		btnNewButton.addActionListener(new CompleteCourseInfroListener());
		panel_1.add(btnNewButton);
		btnNewButton.setVisible(true);
		
		btnNewButton_1 = new JButton("查看学生列表");
		btnNewButton_1.setFont(new Font("楷体", Font.BOLD, 20));
		btnNewButton_1.setBounds(10, 100, 150, 35);
		btnNewButton_1.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton_1.setBackground(new Color(199, 0, 133 ));
		btnNewButton_1.setForeground(Color.white);
		btnNewButton_1.addActionListener(new CheckStlistListener());
		panel_1.add(btnNewButton_1);
		btnNewButton_1.setVisible(true);
		
		btnNewButton_2 = new JButton("登记学生成绩");
		btnNewButton_2.setFont(new Font("楷体", Font.BOLD, 20));
		btnNewButton_2.setBounds(10, 170, 150, 40);
		btnNewButton_2.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton_2.setBackground(new Color(199, 0, 133 ));
		btnNewButton_2.setForeground(Color.white);
		btnNewButton_2.addActionListener(new InputGradeListener());
		panel_1.add(btnNewButton_2);
		btnNewButton_2.setVisible(true);
		
		btnNewButton_3 = new JButton("修改密码");
		btnNewButton_3.setFont(new Font("楷体", Font.BOLD, 20));
		btnNewButton_3.setBounds(10, 240, 150, 40);
		btnNewButton_3.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton_3.setBackground(new Color(199, 0, 133 ));
		btnNewButton_3.setForeground(Color.white);
		btnNewButton_3.addActionListener(new ChangePasswordListener());
		panel_1.add(btnNewButton_3);
		btnNewButton_3.setVisible(true);
		
		btnNewButton_4 = new JButton("注销");
		btnNewButton_4.setFont(new Font("楷体", Font.BOLD, 20));
		btnNewButton_4.setBounds(10, 310, 150, 40);
		btnNewButton_4.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton_4.setBackground(new Color(199, 0, 133 ));
		btnNewButton_4.setForeground(Color.white);
		btnNewButton_4.addActionListener(new LogoutListener());
		panel_1.add(btnNewButton_4);
		btnNewButton_4.setVisible(true);
		
		panelNow = new XPanel();
//		panelNow.setBackground(new Color(255 ,255, 224 ));
		panelNow.setBackground(Color.white);
//		panelNow.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelNow.setBounds(170, 70, 614, 400);
		TeacherFrame.getContentPane().add(panelNow);		
		panelNow.setVisible(true);
		
		TeacherFrame.repaint();
		
	}

    class CompleteCourseInfroListener implements ActionListener{
	    public void actionPerformed(ActionEvent e){
	    	TeacherFrame.remove(panelNow);
	    	TeacherFrame.setTitle("任课老师——完善课程信息");
			JPanel Panel = new JPanel();
			Panel.setBounds(170, 70, 614, 400);
			Panel.setBackground(Color.white);
//			Panel.setBackground(new Color(255 ,255, 224 ));
//			Panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			Panel.setVisible(true);
 			Panel.setLayout(null);
 			
 			JLabel courseNoLabel = new JLabel("课程号");
 			courseNoLabel.setFont(new Font("楷体", Font.BOLD, 16));
 			courseNoLabel.setBounds(10, 10, 100, 30);
 			Panel.add(courseNoLabel);
 			courseNoLabel.setVisible(true);
 			
 			JLabel lblNewLabel_1 = new JLabel("教材");
 			lblNewLabel_1.setFont(new Font("楷体", Font.BOLD, 16));
 			lblNewLabel_1.setBounds(10, 60, 100, 30);
 			Panel.add(lblNewLabel_1);
 			lblNewLabel_1.setVisible(true);
 			
 			JLabel lblNewLabel_2 = new JLabel("参考书目");
 			lblNewLabel_2.setFont(new Font("楷体", Font.BOLD, 16));
 			lblNewLabel_2.setBounds(10, 140, 100, 30);
 			Panel.add(lblNewLabel_2);
 			lblNewLabel_2.setVisible(true);

 			courseNoField = new JTextField();
 			courseNoField.setBounds(130,10,160,30);
 			courseNoField.setBorder(new LineBorder(new Color(0, 0, 0)));
 			Panel.add(courseNoField);
 			courseNoField.setVisible(true);
 			
 			textArea = new JTextArea();
 			textArea.setBounds(130, 60, 400, 60);
 			textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
 			Panel.add(textArea);
 			//textArea.setColumns(10);
 			textArea.setVisible(true);
 			
 			textArea_1 = new JTextArea();
 			textArea_1.setBounds(130, 140, 400, 60);
 			textArea_1.setBorder(new LineBorder(new Color(0, 0, 0)));
 			Panel.add(textArea_1);
 			//textField_1.setColumns(10);
 			textArea_1.setVisible(true);
 			
 			JButton btnNewButton_3 = new JButton("确定");
 			btnNewButton_3.setFont(new Font("楷体", Font.BOLD, 12));
 			btnNewButton_3.setBounds(440, 300, 93, 23);
 			btnNewButton_3.addActionListener(new CompleteCourseInfroOKButtonListener());
 			Panel.add(btnNewButton_3);
 			btnNewButton_3.setVisible(true);
 			
			TeacherFrame.setLayout(null);
			panelNow=Panel;
			TeacherFrame.add(panelNow);
			TeacherFrame.repaint();
	    }
	    
	    class CompleteCourseInfroOKButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String [] courseInfor = {textArea.getText(),textArea_1.getText()};
			Boolean isSet = teacherBL.setCourseInfor(courseNoField.getText(),ID,courseInfor);
			if(isSet){
				JDialog infoDialog = new JDialog();
				infoDialog.setSize(200,100);
				infoDialog.setLocation(600,300);
				infoDialog.setVisible(true);
				JLabel infoLabel = new JLabel("课程信息已录入！");
				infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
				infoLabel.setVisible(true);
				infoDialog.add(infoLabel);
			}else{
				JDialog infoDialog = new JDialog();
				infoDialog.setSize(200,100);
				infoDialog.setLocation(600,300);
				infoDialog.setVisible(true);
				JLabel infoLabel = new JLabel("课程号输入错误！");
				infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
				infoLabel.setVisible(true);
				infoDialog.add(infoLabel);
			}
			
		}
    	
    }
    }
    
    class CheckStlistListener implements ActionListener{
	    public void actionPerformed(ActionEvent e){
	    	TeacherFrame.remove(panelNow);
	    	TeacherFrame.setTitle("任课老师——查看学生列表");
			JPanel Panel = new JPanel();
			Panel.setBounds(170, 70, 614, 400);
			Panel.setBackground(Color.white);
//			Panel.setBackground(new Color(255 ,255, 224 ));
//			Panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			Panel.setVisible(true);
 			Panel.setLayout(null);
 			
 			String[][] note = teacherBL.checkStudents(ID);
 			String [] columnNames = {"课程号","学号","姓名","学院","学分绩","毕业资格","退学资格","成绩"};
  		  
 			studentTable = new JTable(teacherBL.checkStudents(ID),columnNames);
 			makeFace(studentTable);
 			TableColumn column = studentTable .getColumnModel().getColumn(0);
	  	      column.setPreferredWidth(70);//设置列宽的函数
	  	      column = studentTable .getColumnModel().getColumn(1);
		      column.setPreferredWidth(110);//设置列宽的函数
		      column = studentTable .getColumnModel().getColumn(2);
	  	      column.setPreferredWidth(60);//设置列宽的函数
	  	      column = studentTable .getColumnModel().getColumn(3);
		      column.setPreferredWidth(80);//设置列宽的函数
		      column = studentTable .getColumnModel().getColumn(4);
	  	      column.setPreferredWidth(55);//设置列宽的函数
	  	      column = studentTable .getColumnModel().getColumn(5);
		      column.setPreferredWidth(140);//设置列宽的函数
		      column = studentTable .getColumnModel().getColumn(6);
	  	      column.setPreferredWidth(100);//设置列宽的函数
	  	      column = studentTable .getColumnModel().getColumn(7);
	  	      column.setPreferredWidth(40);
 		    scrollPane=new JScrollPane(studentTable);
 		    
 		    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
 		    scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
 		    scrollPane.setBounds(37,10, 544, 250);
 		    scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
 		    scrollPane.setVisible(true);
 			Panel.add(scrollPane);
 			
 			JLabel label = new JLabel("课程号");
 			label.setFont(new Font("楷体", Font.BOLD, 16));
 			label.setBounds(10, 280, 100, 30);
 			Panel.add(label);
 			label.setVisible(true);
 			
 			courseNoBox= new JComboBox(teacherBL.getCourseNo(ID));
 			courseNoBox.setBounds(120,280,100,30);
 			Panel.add(courseNoBox);
 			courseNoBox.setVisible(true);
 			

 			JButton OkButton_3 = new JButton("确定");
 			OkButton_3.setFont(new Font("楷体", Font.BOLD, 12));
 			OkButton_3.setBounds(450, 280, 100, 30);
 			OkButton_3.addActionListener(new CheckStudentOKButtonListener());
 			Panel.add(OkButton_3);
 			OkButton_3.setVisible(true);
 			
 			
			TeacherFrame.setLayout(null);
			panelNow=Panel;
			TeacherFrame.add(panelNow);
			TeacherFrame.repaint();
	    }
	    
	    class CheckStudentOKButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				panelNow.remove(scrollPane);
				String [] columnNames = {"课程号","学号","姓名","学院","学分绩","毕业资格","有无被退学","成绩"};
				studentTable = new JTable(teacherBL.checkStudents( (String) courseNoBox.getSelectedItem(),ID),columnNames);
				makeFace(studentTable);
				TableColumn column = studentTable .getColumnModel().getColumn(0);
		  	      column.setPreferredWidth(70);//设置列宽的函数
		  	      column = studentTable .getColumnModel().getColumn(1);
			      column.setPreferredWidth(110);//设置列宽的函数
			      column = studentTable .getColumnModel().getColumn(2);
		  	      column.setPreferredWidth(60);//设置列宽的函数
		  	      column = studentTable .getColumnModel().getColumn(3);
			      column.setPreferredWidth(80);//设置列宽的函数
			      column = studentTable .getColumnModel().getColumn(4);
		  	      column.setPreferredWidth(55);//设置列宽的函数
		  	      column = studentTable .getColumnModel().getColumn(5);
			      column.setPreferredWidth(140);//设置列宽的函数
			      column = studentTable .getColumnModel().getColumn(6);
		  	      column.setPreferredWidth(100);//设置列宽的函数
		  	      column = studentTable .getColumnModel().getColumn(7);
		  	      column.setPreferredWidth(40);
				scrollPane=new JScrollPane(studentTable);
	 		    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	 		    scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	 		    scrollPane.setBounds(37,10, 544, 250);
	 		    scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
	 		    scrollPane.setVisible(true);
	 		    panelNow.add(scrollPane);
				TeacherFrame.repaint();
			}
	    	
	    }
    }
    
    class InputGradeListener implements ActionListener{
	    public void actionPerformed(ActionEvent e){
	    	TeacherFrame.remove(panelNow);
	    	TeacherFrame.setTitle("任课老师——登记学生成绩");
			JPanel Panel = new JPanel();
			Panel.setBounds(170, 70, 614, 400);
			Panel.setBackground(Color.white);
//			Panel.setBackground(new Color(255 ,255, 224 ));
//			Panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			Panel.setVisible(true);
 			Panel.setLayout(null);
	    	
 			String [] columnNames = {"课程号","学号","姓名","学院","学分绩","毕业资格","有无被退学","成绩"};
 			studentTable = new JTable(teacherBL.checkStudents(ID),columnNames);
 			makeFace(studentTable);
 			TableColumn column = studentTable .getColumnModel().getColumn(0);
 			  column.setPreferredWidth(70);//设置列宽的函数
	  	      column = studentTable .getColumnModel().getColumn(1);
		      column.setPreferredWidth(110);//设置列宽的函数
		      column = studentTable .getColumnModel().getColumn(2);
	  	      column.setPreferredWidth(60);//设置列宽的函数
	  	      column = studentTable .getColumnModel().getColumn(3);
		      column.setPreferredWidth(80);//设置列宽的函数
		      column = studentTable .getColumnModel().getColumn(4);
	  	      column.setPreferredWidth(55);//设置列宽的函数
	  	      column = studentTable .getColumnModel().getColumn(5);
		      column.setPreferredWidth(140);//设置列宽的函数
		      column = studentTable .getColumnModel().getColumn(6);
	  	      column.setPreferredWidth(100);//设置列宽的函数
	  	      column = studentTable .getColumnModel().getColumn(7);
	  	      column.setPreferredWidth(40);
 		    scrollPane=new JScrollPane(studentTable);
 		    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
 		    scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
 		    scrollPane.setBounds(37,10, 544, 250);
 		    scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
 		    scrollPane.setVisible(true);
 			Panel.add(scrollPane);
 			
 			JLabel label = new JLabel("课程号");
 			label.setFont(new Font("楷体", Font.BOLD, 16));
 			label.setBounds(10, 280, 70, 30);
 			Panel.add(label);
 			label.setVisible(true);
 			
 			JLabel label1 = new JLabel("学号");
 			label1.setFont(new Font("楷体", Font.BOLD, 16));
 			label1.setBounds(160,280, 70, 30);
 			Panel.add(label1);
 			label1.setVisible(true);

 			JLabel label2 = new JLabel("分数");
 			label2.setFont(new Font("楷体", Font.BOLD, 16));
 			label2.setBounds(310, 280, 70, 30);
 			Panel.add(label2);
 			label2.setVisible(true);
 			
 			courseNoBox= new JComboBox(teacherBL.getCourseNo(ID));
 			courseNoBox.setBounds(80,280,70,30);
 			Panel.add(courseNoBox);
 			courseNoBox.setVisible(true);
 			
 			studentNoField = new JTextField();
 			studentNoField.setBounds(230,280,70,30);
 			Panel.add(studentNoField);
 			studentNoField.setVisible(true);
 			
 			scoreField = new JTextField();
 			scoreField.setBounds(380,280,70,30);
 			Panel.add(scoreField);
 			scoreField.setVisible(true);
 			
 			JButton OkButton_3 = new JButton("确定");
 			OkButton_3.setFont(new Font("楷体", Font.BOLD, 12));
 			OkButton_3.setBounds(490, 280, 70, 30);
 			OkButton_3.addActionListener(new scoreOkButtonListener());
 			Panel.add(OkButton_3);
 			OkButton_3.setVisible(true);
			
 			//JTextField field1 = new JTextField();
			TeacherFrame.setLayout(null);
			panelNow=Panel;
			TeacherFrame.add(panelNow);
			TeacherFrame.repaint();
	    }

        class scoreOkButtonListener implements ActionListener{
	    	public void actionPerformed(ActionEvent e) {
	    		String[][] tableData = teacherBL.publishScore(studentNoField.getText(),(String) courseNoBox.getSelectedItem(),scoreField.getText(),ID);
	    		if(tableData!=null){
	    			panelNow.remove(scrollPane);
				    String [] columnNames = {"课程号","学号","姓名","学院","学分绩","毕业资格","有无被退学","成绩"};
				    studentTable = new JTable(tableData,columnNames);
				    makeFace(studentTable);
				    TableColumn column = studentTable .getColumnModel().getColumn(0);
		 			  column.setPreferredWidth(70);//设置列宽的函数
			  	      column = studentTable .getColumnModel().getColumn(1);
				      column.setPreferredWidth(110);//设置列宽的函数
				      column = studentTable .getColumnModel().getColumn(2);
			  	      column.setPreferredWidth(60);//设置列宽的函数
			  	      column = studentTable .getColumnModel().getColumn(3);
				      column.setPreferredWidth(80);//设置列宽的函数
				      column = studentTable .getColumnModel().getColumn(4);
			  	      column.setPreferredWidth(55);//设置列宽的函数
			  	      column = studentTable .getColumnModel().getColumn(5);
				      column.setPreferredWidth(140);//设置列宽的函数
				      column = studentTable .getColumnModel().getColumn(6);
			  	      column.setPreferredWidth(100);//设置列宽的函数
			  	      column = studentTable .getColumnModel().getColumn(7);
			  	      column.setPreferredWidth(40);
				    scrollPane=new JScrollPane(studentTable);
	 		        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	 		        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	 		        scrollPane.setBounds(37,10, 544, 250);
	 		        scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
	 		        scrollPane.setVisible(true);
	 		        panelNow.add(scrollPane);
				    TeacherFrame.repaint();
	    		}else{
	    			JDialog infoDialog = new JDialog();
					infoDialog.setSize(200,100);
					infoDialog.setLocation(600,300);
					infoDialog.setVisible(true);
					JLabel infoLabel = new JLabel("学号输入错误！");
					infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
					infoLabel.setVisible(true);
					infoDialog.add(infoLabel);
	    		}
	    		
		    }
	    }
		
    }    

    class LogoutListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			TeacherFrame.dispose();
			new LoginFrame(new LoginBL());
		}
    }
    
    class ChangePasswordListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			TeacherFrame.remove(panelNow);
	    	TeacherFrame.setTitle("任课老师——更改密码");
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
 			
 			TeacherFrame.setLayout(null);
			panelNow=Panel;
			TeacherFrame.add(panelNow);
			TeacherFrame.repaint();
			
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
					teacherBL.changePassword(ID, newPasswordField.getText());
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
