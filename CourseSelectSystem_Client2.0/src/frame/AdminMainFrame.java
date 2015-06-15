package frame;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import busninesslogic.AdminBL;
import busninesslogic.AdminBLService;
import busninesslogic.LoginBL;

/*
 * 类名：管理员主界面
 * 功能：展示管理员界面
 */
public class AdminMainFrame {
	private JFrame AdminFrame;
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
	private JButton btnNewButton_8;
	private JPanel panelNow;
	private JPanel Panel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private AdminBLService adminBL;	
	private JTable table;
	private JScrollPane scrollPane;
	
	//测试用例方法
	public static void main(String[] args){
        new AdminMainFrame(new AdminBL());
	}
	
	/*
	 * 界面构造函数
	 */
	public AdminMainFrame(AdminBLService adminBL) {
		this.adminBL = adminBL;
		AdminFrame = new JFrame();
		AdminFrame.setSize(800,500);
		AdminFrame.setLocation(300,100);
		AdminFrame.setTitle("管理员主界面");
		AdminFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("管理员.png"));
		AdminFrame.getContentPane().setLayout(null);
		AdminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AdminFrame.setVisible(true);
		
		panel_2 = new MyPanel();
		panel_2.setBackground(Color.white);
		panel_2.setBounds(0, 0, 80, 80);
		AdminFrame.getContentPane().add(panel_2);
		
		panel = new JPanel();
		panel.setBackground(new Color(199, 0, 133 ));
		panel.setBounds(0, 0, 820, 70);
		AdminFrame.getContentPane().add(panel);
		panel.setVisible(true);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("欢迎，管理员！");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("德彪钢笔行书字库", Font.BOLD, 24));
		lblNewLabel.setBounds(80, 10, 425, 45);
		panel.add(lblNewLabel);
		lblNewLabel.setVisible(true); 
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(199, 0, 133 ));
		panel_1.setForeground(Color.WHITE);
		panel_1.setBounds(0, 70, 170, 400);
		AdminFrame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(true);
		
		btnNewButton = new JButton("删除学校教务员");
		btnNewButton.setFont(new Font("楷体", Font.BOLD, 16));
		btnNewButton.setBounds(10, 10, 150, 35);
		btnNewButton.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton.setBackground(new Color(199, 0, 133 ));
		btnNewButton.setForeground(Color.white);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new DeleteSchoolTeacherListener());
		btnNewButton.setVisible(true);
		
		btnNewButton_1 = new JButton("删除院系教务员");
		btnNewButton_1.setFont(new Font("楷体", Font.BOLD, 16));
		btnNewButton_1.setBounds(10, 50, 150, 35);
		btnNewButton_1.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton_1.setBackground(new Color(199, 0, 133 ));
		btnNewButton_1.setForeground(Color.white);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new DeleteInstituteTeacherListener());
		btnNewButton_1.setVisible(true);
		
		btnNewButton_2 = new JButton("删除任课教师");
		btnNewButton_2.setFont(new Font("楷体", Font.BOLD, 16));
		btnNewButton_2.setBounds(10, 90, 150, 35);
		btnNewButton_2.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton_2.setBackground(new Color(199, 0, 133 ));
		btnNewButton_2.setForeground(Color.white);
		panel_1.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new DeleteTeacherListener());
		btnNewButton_2.setVisible(true);
	
		btnNewButton_3 = new JButton("删除学生");
		btnNewButton_3.setFont(new Font("楷体", Font.BOLD, 16));
		btnNewButton_3.setBounds(10, 130, 150, 35);
		btnNewButton_3.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton_3.setBackground(new Color(199, 0, 133 ));
		btnNewButton_3.setForeground(Color.white);
		panel_1.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new DeleteStudentListener());
		btnNewButton_3.setVisible(true);
		
		btnNewButton_4 = new JButton("设置选课时间");
		btnNewButton_4.setFont(new Font("楷体", Font.BOLD, 16));
		btnNewButton_4.setBounds(10,170, 150, 35);
		btnNewButton_4.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton_4.setBackground(new Color(199, 0, 133 ));
		btnNewButton_4.setForeground(Color.white);
		panel_1.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new TimeToSelectCourseListener());
		btnNewButton_4.setVisible(true);
		
		btnNewButton_5 = new JButton("设置补选时间");
		btnNewButton_5.setFont(new Font("楷体", Font.BOLD, 16));
		btnNewButton_5.setBounds(10, 210, 150, 35);
		btnNewButton_5.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton_5.setBackground(new Color(199, 0, 133 ));
		btnNewButton_5.setForeground(Color.white);
		panel_1.add(btnNewButton_5);
		btnNewButton_5.addActionListener(new TimeToRechooseCourseListener());
		btnNewButton_5.setVisible(true);
		
		btnNewButton_6 = new JButton("设置整体策略可改");
		btnNewButton_6.setFont(new Font("楷体", Font.BOLD, 16));
		btnNewButton_6.setBounds(10, 250, 150, 35);
		btnNewButton_6.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton_6.setBackground(new Color(199, 0, 133 ));
		btnNewButton_6.setForeground(Color.white);
		panel_1.add(btnNewButton_6);
		btnNewButton_6.addActionListener(new RightToChangePolicyListener());
		btnNewButton_6.setVisible(true);
		
		btnNewButton_7 = new JButton("设置学院计划可改");
		btnNewButton_7.setFont(new Font("楷体", Font.BOLD, 16));
		btnNewButton_7.setBounds(10,290, 150, 35);
		btnNewButton_7.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton_7.setBackground(new Color(199, 0, 133 ));
		btnNewButton_7.setForeground(Color.white);
		panel_1.add(btnNewButton_7);
		btnNewButton_7.addActionListener(new RightToChangePlanListener());
		btnNewButton_7.setVisible(true);
		
		btnNewButton_8 = new JButton("注销");
		btnNewButton_8.setFont(new Font("楷体", Font.BOLD, 16));
		btnNewButton_8.setBounds(10, 330, 150, 35);
		btnNewButton_8.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton_8.setBackground(new Color(199, 0, 133 ));
		btnNewButton_8.setForeground(Color.white);
		panel_1.add(btnNewButton_8);
		btnNewButton_8.addActionListener(new LogoutListener());
		btnNewButton_8.setVisible(true);
		
		panelNow = new XPanel();
		panelNow.setBackground(new Color(255 ,255, 224 ));
		panelNow.setBackground(Color.white);
		panelNow.setBounds(170, 70, 614, 400);
		AdminFrame.getContentPane().add(panelNow);
		panelNow.setVisible(true);
		AdminFrame.repaint();
	}
	
	/*
	 * 删除学校教务处老师事件处理
	 */
	class DeleteSchoolTeacherListener implements ActionListener{
	    public void actionPerformed(ActionEvent e){
	    	AdminFrame.remove(panelNow);
	    	AdminFrame.setTitle("管理员——删除学校教务员");
			Panel = new YPanel();
			Panel.setSize(614, 400);
			Panel.setLocation(170, 70);
			Panel.setBackground(Color.white);
			Panel.setVisible(true);
 			Panel.setLayout(null);
 			
 			JLabel label = new JLabel("要删除的学校教务员工号");
 			label.setFont(new Font("楷体", Font.BOLD, 15));
 			label.setBounds(10, 10, 200, 30);
 			label.setVisible(true);
			Panel.add(label);
 			
 			textField = new JTextField();
 			textField.setBounds(250, 10, 100, 35);
 			textField.setVisible(true);
			Panel.add(textField);
			textField.setColumns(10);
			
			JButton button = new JButton("\u786E\u5B9A");
			button.setFont(new Font("楷体", Font.BOLD, 12));
			button.setBounds(430, 335, 93, 23);
			button.setVisible(true);
			button.addActionListener(new DeleteSchoolTeacherOkListener());
			Panel.add(button);
			
			//添加表格
			String[] columnTitle=new String[] {"工号","姓名","密码"};   
  		    table = new JTable(adminBL.checkSchoolTeacherInfor(),columnTitle);	
  		    makeFace(table);//使表格内容居中并设置背景色
			scrollPane = new JScrollPane(table);//带滚动条的面板	
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);//设置滚动条
            scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(37, 55, 524, 250);
			scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
 		    scrollPane.setVisible(true);
			Panel.add(scrollPane);
			
			AdminFrame.setLayout(null);
			panelNow = Panel;
			AdminFrame.add(panelNow);
			AdminFrame.repaint();
	    }
	    
	    /*
		 * 删除学校教务处老师确定按钮事件处理
		 */
	    class DeleteSchoolTeacherOkListener implements ActionListener{
		    public void actionPerformed(ActionEvent e){
		    	if(textField.getText().equals("")){
					JDialog infoDialog = new JDialog();
					infoDialog.setSize(300,200);
					infoDialog.setLocation(600,300);
					infoDialog.setVisible(true);
					JLabel infoLabel = new JLabel("教务员工号不能为空！");
					infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
					infoLabel.setVisible(true);
					infoDialog.add(infoLabel);
				}else{
					if(adminBL.DeleteSchoolTeacher( (String) textField.getText())){
			
						panelNow.remove(scrollPane);
						
						String[] columnTitle=new String[] {"工号","姓名","密码"};   
			  		    table = new JTable(adminBL.checkSchoolTeacherInfor(),columnTitle);	
			  		    makeFace(table);//使表格内容居中并设置背景色
						scrollPane = new JScrollPane(table);//带滚动条的面板	
						scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);//设置滚动条
			            scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
						scrollPane.setBounds(37, 55, 524, 250);
						scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
			 		    scrollPane.setVisible(true);
						panelNow.add(scrollPane);
			 			
			 		    AdminFrame.repaint();
						
					}else{
						JDialog infoDialog = new JDialog();
						infoDialog.setSize(300,200);
						infoDialog.setLocation(600,300);
						infoDialog.setVisible(true);
						JLabel infoLabel = new JLabel("该教师不存在，删除失败");
						infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
						infoLabel.setVisible(true);
						infoDialog.add(infoLabel);
					}
				}
			}
	    }
    }
	
	/*
	 * 删除院系教务处老师事件处理
	 */
	
	class DeleteInstituteTeacherListener implements ActionListener{
	    public void actionPerformed(ActionEvent e){
	    	AdminFrame.remove(panelNow);
	    	AdminFrame.setTitle("管理员——删除院系教务员");
			Panel = new YPanel();
			Panel.setSize(614, 400);
			Panel.setLocation(170, 70);
			Panel.setBackground(Color.white);
			Panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			Panel.setVisible(true);
 			Panel.setLayout(null);
 			
 			JLabel label = new JLabel("要删除的院系教务员工号");
 			label.setFont(new Font("楷体", Font.BOLD, 15));
 			label.setBounds(10, 10, 200, 30);
 			label.setVisible(true);
			Panel.add(label);
 			
 			textField_1 = new JTextField();
 			textField_1.setBounds(250, 10, 100, 35);
 			textField_1.setVisible(true);
			Panel.add(textField_1);
			textField_1.setColumns(10);
			
			JButton button = new JButton("\u786E\u5B9A");
			button.setFont(new Font("楷体", Font.BOLD, 12));
			button.setBounds(430, 335, 93, 23);
			button.setVisible(true);
			button.addActionListener(new DeleteInstituteTeacherOkListener());
			Panel.add(button);
			
			//添加表格
			String[] columnTitle=new String[] {"工号","姓名","密码","院系"};   
  		    table = new JTable(adminBL.checkInstituteTeacherInfor(),columnTitle);	
  		    makeFace(table);//使表格内容居中并设置背景色
			scrollPane = new JScrollPane(table);//带滚动条的面板	
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);//设置滚动条
            scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(37, 55, 524, 250);
			scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
 		    scrollPane.setVisible(true);
			Panel.add(scrollPane);
			
			AdminFrame.setLayout(null);
			panelNow = Panel;
			AdminFrame.add(panelNow);
			AdminFrame.repaint();
	    }
	 
	    /*
		 * 删除院系教务处老师确定按钮事件处理
		 */    
    class DeleteInstituteTeacherOkListener implements ActionListener{
		     public void actionPerformed(ActionEvent e){
		    	 if(textField_1.getText().equals("")){
						JDialog infoDialog = new JDialog();
						infoDialog.setSize(300,200);
						infoDialog.setLocation(600,300);
						infoDialog.setVisible(true);
						JLabel infoLabel = new JLabel("教务员工号不能为空！");
						infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
						infoLabel.setVisible(true);
						infoDialog.add(infoLabel);
					}else{
						if(adminBL.DeleteInstituteTeacher( (String) textField_1.getText())){
							panelNow.remove(scrollPane);
							
							String[] columnTitle=new String[] {"工号","姓名","密码","院系"};   
				  		    table = new JTable(adminBL.checkInstituteTeacherInfor(),columnTitle);	
				  		    makeFace(table);//使表格内容居中并设置背景色
							scrollPane = new JScrollPane(table);//带滚动条的面板	
							scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);//设置滚动条
				            scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
							scrollPane.setBounds(37, 55, 524, 250);
							scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
				 		    scrollPane.setVisible(true);
							panelNow.add(scrollPane);

				 			
				 			
				 		    AdminFrame.repaint();
							
						}else{
							JDialog infoDialog = new JDialog();
							infoDialog.setSize(300,200);
							infoDialog.setLocation(600,300);
							infoDialog.setVisible(true);
							JLabel infoLabel = new JLabel("该教师不存在，删除失败");
							infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
							infoLabel.setVisible(true);
							infoDialog.add(infoLabel);
						}
					}
				}
		    }
	}

	/*
	 * 删除任课老师事件处理
	 */
	class DeleteTeacherListener implements ActionListener{
	    public void actionPerformed(ActionEvent e){
	    	AdminFrame.remove(panelNow);
	    	AdminFrame.setTitle("管理员——删除任课教师");
			Panel = new YPanel();
			Panel.setSize(614, 400);
			Panel.setLocation(170, 70);
			Panel.setBackground(Color.white);
			Panel.setVisible(true);
 			Panel.setLayout(null);
 			
 			JLabel label = new JLabel("要删除的任课教师工号");
 			label.setFont(new Font("楷体", Font.BOLD, 15));
 			label.setBounds(10, 10, 200, 30);
 			label.setVisible(true);
			Panel.add(label);
 			
 			textField_6 = new JTextField();
 			textField_6.setBounds(250, 10, 100, 35);
 			textField_6.setVisible(true);
			Panel.add(textField_6);
			textField_6.setColumns(10);
			
			JButton button = new JButton("\u786E\u5B9A");
			button.setFont(new Font("楷体", Font.BOLD, 12));
			button.setBounds(430, 335, 93, 23);
			button.setVisible(true);
			button.addActionListener(new DeleteTeacherOkListener());
			Panel.add(button);
			
			//添加表格
			String[] columnTitle=new String[] {"工号","姓名","密码","院系"};   
  		    table = new JTable(adminBL.checkTeacherInfor(),columnTitle);	
  		    makeFace(table);//使表格内容居中并设置背景色
			scrollPane = new JScrollPane(table);//带滚动条的面板	
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);//设置滚动条
            scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(37, 55, 524, 250);
			scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
 		    scrollPane.setVisible(true);
			Panel.add(scrollPane);
			
			AdminFrame.setLayout(null);
			panelNow = Panel;
			AdminFrame.add(panelNow);
			AdminFrame.repaint();
	    }
	    /*
		 * 删除任课老师确定按钮事件处理
		 */ 
	    class DeleteTeacherOkListener implements ActionListener{
		    public void actionPerformed(ActionEvent e){
		    	 
		    	if(textField_6.getText().equals("")){
					JDialog infoDialog = new JDialog();
					infoDialog.setSize(300,200);
					infoDialog.setLocation(600,300);
					infoDialog.setVisible(true);
					JLabel infoLabel = new JLabel("教师工号不能为空！");
					infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
					infoLabel.setVisible(true);
					infoDialog.add(infoLabel);
				}else{
					if(adminBL.DeleteTeacher( (String) textField_6.getText())){
						
						panelNow.remove(scrollPane);
						
						String[] columnTitle=new String[] {"工号","姓名","密码","院系"};   
			  		    table = new JTable(adminBL.checkTeacherInfor(),columnTitle);	
			  		    makeFace(table);//使表格内容居中并设置背景色
						scrollPane = new JScrollPane(table);//带滚动条的面板	
						scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);//设置滚动条
			            scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
						scrollPane.setBounds(37, 55, 524, 250);
						scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
			 		    scrollPane.setVisible(true);
						panelNow.add(scrollPane);
			 		    AdminFrame.repaint();
						
					}else{
						JDialog infoDialog = new JDialog();
						infoDialog.setSize(300,200);
						infoDialog.setLocation(600,300);
						infoDialog.setVisible(true);
						JLabel infoLabel = new JLabel("该教师不存在，删除失败");
						infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
						infoLabel.setVisible(true);
						infoDialog.add(infoLabel);
					}
				}
			}
	    }
    }

	/*
	 * 删除学生事件处理
	 */
	class DeleteStudentListener implements ActionListener{
	    public void actionPerformed(ActionEvent e){
	    	AdminFrame.remove(panelNow);
	    	AdminFrame.setTitle("管理员——删除学生");
			Panel = new YPanel();
			Panel.setSize(614, 400);
			Panel.setLocation(170, 70);
			Panel.setBackground(Color.white);
			Panel.setVisible(true);
 			Panel.setLayout(null);
 			
 			JLabel label = new JLabel("要删除的学生学号");
 			label.setFont(new Font("楷体", Font.BOLD, 15));
 			label.setBounds(10, 10, 200, 30);
 			label.setVisible(true);
			Panel.add(label);
 			
 			textField_7 = new JTextField();
 			textField_7.setBounds(250, 10, 100, 35);
 			textField_7.setVisible(true);
			Panel.add(textField_7);
			textField_7.setColumns(10);
			
			JButton button = new JButton("\u786E\u5B9A");
			button.setFont(new Font("楷体", Font.BOLD, 12));
			button.setBounds(430, 335, 93, 23);
			button.setVisible(true);
			button.addActionListener(new DeleteStudentOkListener());
			Panel.add(button);
			
			//添加表格
			String[] columnTitle=new String[] {"学号","姓名","密码","院系"};   
  		    table = new JTable(adminBL.checkStudentInfor(),columnTitle);	
  		    makeFace(table);//使表格内容居中并设置背景色
			scrollPane = new JScrollPane(table);//带滚动条的面板	
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);//设置滚动条
            scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(37, 55, 524, 250);
			scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
 		    scrollPane.setVisible(true);
			Panel.add(scrollPane);
			
			AdminFrame.setLayout(null);
			panelNow = Panel;
			AdminFrame.add(panelNow);
			AdminFrame.repaint();
	    }
	    
	    /*
		 * 删除学生确定按钮事件处理
		 */
	    class DeleteStudentOkListener implements ActionListener{
		    public void actionPerformed(ActionEvent e){
		    	if(textField_7.getText().equals("")){
					JDialog infoDialog = new JDialog();
					infoDialog.setSize(300,200);
					infoDialog.setLocation(600,300);
					infoDialog.setVisible(true);
					JLabel infoLabel = new JLabel("学生学号不能为空！");
					infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
					infoLabel.setVisible(true);
					infoDialog.add(infoLabel);
				}else{
					if(adminBL.DeleteStudent( (String) textField_7.getText())){
						
						panelNow.remove(scrollPane);
						
						String[] columnTitle=new String[] {"工号","姓名","密码","院系"};   
			  		    table = new JTable(adminBL.checkStudentInfor(),columnTitle);	
			  		    makeFace(table);//使表格内容居中并设置背景色
						scrollPane = new JScrollPane(table);//带滚动条的面板	
						scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);//设置滚动条
			            scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
						scrollPane.setBounds(37, 55, 524, 250);
						scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
			 		    scrollPane.setVisible(true);
						panelNow.add(scrollPane);
			 		    AdminFrame.repaint();
						
					}else{
						JDialog infoDialog = new JDialog();
						infoDialog.setSize(300,200);
						infoDialog.setLocation(600,300);
						infoDialog.setVisible(true);
						JLabel infoLabel = new JLabel("该学生不存在，删除失败");
						infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
						infoLabel.setVisible(true);
						infoDialog.add(infoLabel);
					}
				}
			}
	    }
    }

	/*
	 * 修改改变院系教学计划开放状态事件监听
	 */
	class RightToChangePlanListener implements ActionListener{
	    public void actionPerformed(ActionEvent e){
	    	AdminFrame.remove(panelNow);
	    	AdminFrame.setTitle("管理员——设置院系计划可改");
			Panel = new YPanel();
			Panel.setSize(614, 400);
			Panel.setLocation(170, 70);
			Panel.setBackground(Color.white);
			Panel.setVisible(true);
 			Panel.setLayout(null);
 			
 			JLabel label = new JLabel("是否可改？（填是或否）");
 			label.setFont(new Font("楷体", Font.BOLD, 15));
 			label.setBounds(10, 10, 200, 30);
 			label.setVisible(true);
			Panel.add(label);
 			
 			textField_2 = new JTextField();
 			textField_2.setBounds(250, 10, 100, 35);
 			textField_2.setVisible(true);
			Panel.add(textField_2);
			textField_2.setColumns(10);
			
			JButton button = new JButton("\u786E\u5B9A");
			button.setFont(new Font("楷体", Font.BOLD, 12));
			button.setBounds(430, 335, 93, 23);
			button.setVisible(true);
			button.addActionListener(new RightToChangePlanOkListener());
			Panel.add(button);
			
			AdminFrame.setLayout(null);
			panelNow = Panel;
			AdminFrame.add(panelNow);
			AdminFrame.repaint();
	    }
	    
		/*
		 * 修改改变院系教学计划开放状态确定按钮事件监听
		 */
	    class RightToChangePlanOkListener implements ActionListener{
		    public void actionPerformed(ActionEvent e){
		    	 int isSet = -1;
			    	
			    	if(textField_2.getText().equals("")){
			    		JOptionPane.showMessageDialog(null, "尚有未填！");	
			    	}else{
			    		isSet = adminBL.setAbleToChangePlan( (String) textField_2.getText());
			    		if(isSet == 1||isSet == 0){  			
			    		    JOptionPane.showMessageDialog(null, "设置成功！");
			    	    }else{
			    		   JOptionPane.showMessageDialog(null, "设置失败或填写错误！");
			    	    }
			       }
		    }
		}
	}
	
	/*
	 * 修改改变整体框架策略开放状态事件监听
	 */
	class RightToChangePolicyListener implements ActionListener{
	    public void actionPerformed(ActionEvent e){
	    	AdminFrame.remove(panelNow);
	    	AdminFrame.setTitle("管理员——设置整体策略可改");
			Panel = new YPanel();
			Panel.setSize(614, 400);
			Panel.setLocation(170, 70);
			Panel.setBackground(Color.white);
			Panel.setVisible(true);
 			Panel.setLayout(null);
 			
 			JLabel label = new JLabel("是否可改？（填是或否）");
 			label.setFont(new Font("楷体", Font.BOLD, 15));
 			label.setBounds(10, 10, 200, 30);
 			label.setVisible(true);
			Panel.add(label);
 			
 			textField_3 = new JTextField();
 			textField_3.setBounds(250, 10, 100, 35);
 			textField_3.setVisible(true);
			Panel.add(textField_3);
			textField_3.setColumns(10);
			
			JButton button = new JButton("\u786E\u5B9A");
			button.setFont(new Font("楷体", Font.BOLD, 12));
			button.setBounds(430, 335, 93, 23);
			button.setVisible(true);
			button.addActionListener(new RightToChangePolicyOkListener());
			Panel.add(button);
			
			AdminFrame.setLayout(null);
			panelNow = Panel;
			AdminFrame.add(panelNow);
			AdminFrame.repaint();
	    }
	    
	    /*
		 * 修改改变整体框架策略开放状态确定按钮事件监听
		 */
	    class RightToChangePolicyOkListener implements ActionListener{
		    public void actionPerformed(ActionEvent e){
                 int isSet = -1;
		    	
		    	if(textField_3.getText().equals("")){
		    		JOptionPane.showMessageDialog(null, "尚有未填！");	
		    	}else{
		    		isSet = adminBL.setAbleToChangePolicy( (String) textField_3.getText());
		    		if(isSet == 1||isSet == 0){  			
		    		    JOptionPane.showMessageDialog(null, "设置成功！");
		    	    }else{
		    		   JOptionPane.showMessageDialog(null, "设置失败或填写错误！");
		    	    }
		       }
		    }
		}
	}
	
	/*
	 * 修改改变补选开放状态事件监听
	 */
	class TimeToRechooseCourseListener implements ActionListener{
	    public void actionPerformed(ActionEvent e){
	 	    	AdminFrame.remove(panelNow);
	 	    	AdminFrame.setTitle("管理员——设置补选时间");
	 			Panel = new YPanel();
	 			Panel.setSize(614, 400);
				Panel.setLocation(170, 70);
				Panel.setBackground(Color.white);
	 			Panel.setVisible(true);
	  			Panel.setLayout(null);
	  			
	  			JLabel label = new JLabel("是否可选？（填是或否）");
	  			label.setFont(new Font("楷体", Font.BOLD, 15));
	  			label.setBounds(10, 10, 200, 30);
	  			label.setVisible(true);
	 			Panel.add(label);
	  			
	  			textField_4 = new JTextField();
	  			textField_4.setBounds(250, 10, 100, 35);
	  			textField_4.setVisible(true);
	 			Panel.add(textField_4);
	 			textField_4.setColumns(10);
	 			
	 			JButton button = new JButton("\u786E\u5B9A");
	 			button.setFont(new Font("楷体", Font.BOLD, 12));
	 			button.setBounds(430, 335, 93, 23);
	 			button.setVisible(true);
	 			button.addActionListener(new TimeToRechooseCourseOkListener());
	 			Panel.add(button);
	 			
	 			AdminFrame.setLayout(null);
	 			panelNow = Panel;
	 			AdminFrame.add(panelNow);
	 			AdminFrame.repaint();
	 	    }
	 	    
	    /*
		 * 修改改变补选开放状态确定按钮事件监听
		 */
	 	    class TimeToRechooseCourseOkListener implements ActionListener{
	 		    public void actionPerformed(ActionEvent e){
	 		    	int isSet = -1;
			    	
			    	if(textField_4.getText().equals("")){
			    		JOptionPane.showMessageDialog(null, "尚有未填！");	
			    	}else{
			    		isSet = adminBL.setAbleToReselectCourse( (String) textField_4.getText());
			    		if(isSet == 1||isSet == 0){  			
			    		    JOptionPane.showMessageDialog(null, "设置成功！");
			    	    }else{
			    		   JOptionPane.showMessageDialog(null, "设置失败或填写错误！");
			    	    }
			       }
	 		    }
	 		}
	    
	}
	
	/*
	 * 修改改变选课开放状态事件监听
	 */
	class TimeToSelectCourseListener implements ActionListener{
	    public void actionPerformed(ActionEvent e){
	    	AdminFrame.remove(panelNow);
 	    	AdminFrame.setTitle("管理员——设置选课时间");
 			Panel = new YPanel();
 			Panel.setSize(614, 400);
			Panel.setLocation(170, 70);
			Panel.setBackground(Color.white);
 			Panel.setVisible(true);
  			Panel.setLayout(null);
  			
  			JLabel label = new JLabel("是否可选？（填是或否）");
  			label.setFont(new Font("楷体", Font.BOLD, 15));
  			label.setBounds(10, 10, 200, 30);
  			label.setVisible(true);
 			Panel.add(label);
  			
  			textField_5 = new JTextField();
  			textField_5.setBounds(250, 10, 100, 35);
  			textField_5.setVisible(true);
 			Panel.add(textField_5);
 			textField_5.setColumns(10);
 			
 			JButton button = new JButton("\u786E\u5B9A");
 			button.setFont(new Font("楷体", Font.BOLD, 12));
 			button.setBounds(430, 335, 93, 23);
 			button.setVisible(true);
 			button.addActionListener(new TimeToSelectCourseOkListener());
 			Panel.add(button);
 			
 			AdminFrame.setLayout(null);
 			panelNow = Panel;
 			AdminFrame.add(panelNow);
 			AdminFrame.repaint();
 	    }
 	    
	    /*
		 * 修改改变选课开放状态确定按钮事件监听
		 */
 	    class TimeToSelectCourseOkListener implements ActionListener{
 		    public void actionPerformed(ActionEvent e){
 		    	int isSet = -1;
		    	
		    	if(textField_5.getText().equals("")){
		    		JOptionPane.showMessageDialog(null, "尚有未填！");	
		    	}else{
		    		isSet = adminBL.setAbleToSelectCourse( (String) textField_5.getText());
		    		if(isSet == 1||isSet == 0){  			
		    		    JOptionPane.showMessageDialog(null, "设置成功！");
		    	    }else{
		    		   JOptionPane.showMessageDialog(null, "设置失败或填写错误！");
		    	    }
		       }
 		    }
	    }
	}
	
	/*
	 * 注销事件监听
	 */
	class LogoutListener implements ActionListener{
	    public void actionPerformed(ActionEvent e){
 			AdminFrame.dispose();
 			new LoginFrame(new LoginBL());
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
