package frame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.table.DefaultTableCellRenderer;

import sun.swing.DefaultLookup;
import busninesslogic.LoginBL;
import busninesslogic.TeacherBL;
import busninesslogic.TeacherBLService;

public class TeacherMainFrame {
	private JFrame TeacherFrame;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JPanel panel_1;
	private JPanel panel_2;
	private MyButton btnNewButton;
	private MyButton btnNewButton_1;
//	private MyButton btnNewButton_2;
	private MyButton btnNewButton_3;
	private MyButton btnNewButton_4;
	
	private JPanel panelNow;
	private JTextField courseNoField;
	private JTextArea textArea;
	private JTextArea textArea_1;
	private MyTable studentTable;
	private JComboBox<String> courseNoBox;
	private JScrollPane scrollPane;
	private JTextField studentNoField;
	private JTextField scoreField;
	private JTextField newPasswordField;
	private JTextField newPasswordField1;
	private JTextField newPasswordField2;
	public static TeacherBLService teacherBL;
    private String ID;
    private String password;
    public static String selectedNo;
    private JPanel formerPanel = null;
    
	public static void main(String[] args){
        new TeacherMainFrame("10001","111111",new TeacherBL());
	}
	
    @SuppressWarnings("static-access")
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
		lblNewLabel.setFont(new Font("德彪钢笔行书字库", Font.PLAIN, 24));
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
		
		btnNewButton = new MyButton("完善课程信息");
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		btnNewButton.setBounds(10, 30, 150, 35);
		btnNewButton.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton.setBackground(new Color(199, 0, 133 ));
		btnNewButton.setForeground(Color.white);
		btnNewButton.addActionListener(new CompleteCourseInfroListener());
		panel_1.add(btnNewButton);
		btnNewButton.setVisible(true);
		
		btnNewButton_1 = new MyButton("查看学生列表");
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		btnNewButton_1.setBounds(10, 100, 150, 35);
		btnNewButton_1.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton_1.setBackground(new Color(199, 0, 133 ));
		btnNewButton_1.setForeground(Color.white);
		btnNewButton_1.addActionListener(new CheckStlistListener());
		panel_1.add(btnNewButton_1);
		btnNewButton_1.setVisible(true);
		
		btnNewButton_3 = new MyButton("修改密码");
		btnNewButton_3.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		btnNewButton_3.setBounds(10, 170, 150, 40);
		btnNewButton_3.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton_3.setBackground(new Color(199, 0, 133 ));
		btnNewButton_3.setForeground(Color.white);
		btnNewButton_3.addActionListener(new ChangePasswordListener());
		panel_1.add(btnNewButton_3);
		btnNewButton_3.setVisible(true);
		
		btnNewButton_4 = new MyButton("注销");
		btnNewButton_4.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		btnNewButton_4.setBounds(10, 240, 150, 40);
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
			Panel.setBackground(Color.WHITE);
			Panel.setVisible(true);
 			Panel.setLayout(null);
    		
 			JLabel label = new JLabel("备注：");
 			label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
 			label.setBounds(37, 270, 100, 30);
 			Panel.add(label);
 			label.setVisible(true);
 			
 			JLabel label2 = new JLabel("双击表项以查看额外信息！");
 			label2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
 			label2.setHorizontalAlignment(JLabel.RIGHT);
 			label2.setForeground(new Color(199, 0, 133 ));
 			label2.setBounds(400, 270, 170, 30);
 			Panel.add(label2);
 			label2.setVisible(true);

			textArea = new JTextArea();
			textArea.setBounds(37,300,463,70);
			textArea.setLineWrap(true);
			textArea.setEditable(false);
			textArea.setFont(new Font("微软雅黑", Font.PLAIN, 14));
			textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
			Panel.add(textArea);
			textArea.setVisible(true);

  			String[] columnTitle=new String[] {"类别","编号","院系","名称","学分","学期","时间","地点","wsda"};
  			
  			String[] nos = teacherBL.getCourseNo(ID);
  			String[][] temp = new String[nos.length][];
  			for (int i = 0; i < nos.length; i++) {
  				temp[i] = teacherBL.getCourseInfor(nos[i]);
  			}
  			MyTable schoolCourseTable = new MyTable(temp,columnTitle,TeacherFrame,550,250,false);
  			schoolCourseTable.setComponent(textArea,3);
  		  
  			JScrollPane schoolCourseScrollPane = schoolCourseTable.getScrollPane();//带滚动条的面板
  			schoolCourseScrollPane.setLocation(37,10);
  			schoolCourseScrollPane.setVisible(true);
			Panel.add(schoolCourseScrollPane);
		
			JLabel labelNotice = new JLabel("(补充了教师、教材、参考书目信息)");
			labelNotice.setFont(new Font("微软雅黑", Font.PLAIN, 14));
			labelNotice.setHorizontalAlignment(JLabel.CENTER);
			labelNotice.setBounds(0,368,554,20);
			Panel.add(labelNotice);
			
			MyButton btnNewButton_3 = new MyButton("修改");
 			btnNewButton_3.setFont(new Font("微软雅黑", Font.PLAIN, 12));
 			btnNewButton_3.setBounds(510, 340, 60, 30);
 			btnNewButton_3.addActionListener(new ToCompleteCourseInforOKButtonListener());
 			Panel.add(btnNewButton_3);
 			btnNewButton_3.setVisible(true);
 			
			TeacherFrame.setLayout(null);
			panelNow=Panel;
			TeacherFrame.add(panelNow);
			TeacherFrame.repaint();
	    }
	    
	    class ToCompleteCourseInforOKButtonListener implements ActionListener { 	
	    	public void actionPerformed(ActionEvent e) {
				TeacherFrame.remove(panelNow);
				formerPanel = panelNow;
				TeacherFrame.setTitle("任课老师——完善课程信息");
				
				JPanel Panel = new JPanel();
				Panel.setBounds(170, 70, 614, 400);
				Panel.setBackground(Color.white);
//				Panel.setBackground(new Color(255 ,255, 224 ));
//				Panel.setBorder(new LineBorder(new Color(0, 0, 0)));
				Panel.setVisible(true);
	 			Panel.setLayout(null);
	 			
	 			JLabel courseNoLabel = new JLabel("课程号");
	 			courseNoLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
	 			courseNoLabel.setHorizontalAlignment(JLabel.RIGHT);
	 			courseNoLabel.setBounds(10, 80, 100, 30);
	 			Panel.add(courseNoLabel);
	 			courseNoLabel.setVisible(true);
	 			
	 			JLabel lblNewLabel_1 = new JLabel("教材");
	 			lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
	 			lblNewLabel_1.setBounds(10, 130, 100, 30);
	 			lblNewLabel_1.setHorizontalAlignment(JLabel.RIGHT);
	 			Panel.add(lblNewLabel_1);
	 			lblNewLabel_1.setVisible(true);
	 			
	 			JLabel lblNewLabel_2 = new JLabel("参考书目");
	 			lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
	 			lblNewLabel_2.setBounds(10, 210, 100, 30);
	 			lblNewLabel_2.setHorizontalAlignment(JLabel.RIGHT);
	 			Panel.add(lblNewLabel_2);
	 			lblNewLabel_2.setVisible(true);
	
	 			courseNoField = new JTextField();
	 			courseNoField.setBounds(130,80,160,30);
	 			courseNoField.setBorder(new LineBorder(new Color(0, 0, 0)));
	 			if (selectedNo == null) {
	 				selectedNo = teacherBL.getCourseNo(ID)[0];
	 			}
	 			courseNoField.setText(selectedNo);
	 			Panel.add(courseNoField);
	 			courseNoField.setVisible(true);
	 			
	 			textArea = new JTextArea();
	 			textArea.setBounds(130, 130, 400, 60);
	 			textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
	 			Panel.add(textArea);
	 			//textArea.setColumns(10);
	 			textArea.setVisible(true);
	 			
	 			textArea_1 = new JTextArea();
	 			textArea_1.setBounds(130, 210, 400, 60);
	 			textArea_1.setBorder(new LineBorder(new Color(0, 0, 0)));
	 			Panel.add(textArea_1);
	 			//textField_1.setColumns(10);
	 			textArea_1.setVisible(true);
	 			
	 			MyButton btnNewButton_3 = new MyButton("确定");
	 			btnNewButton_3.setFont(new Font("微软雅黑", Font.PLAIN, 12));
	 			btnNewButton_3.setBounds(460, 290, 70, 30);
	 			btnNewButton_3.addActionListener(new CompleteCourseInfroOKButtonListener());
	 			Panel.add(btnNewButton_3);
	 			btnNewButton_3.setVisible(true);
	 			
	 			TeacherFrame.setLayout(null);
				panelNow=Panel;
				TeacherFrame.add(panelNow);
				TeacherFrame.repaint();
			}
	    }
	    
	    class CompleteCourseInfroOKButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String [] courseInfor = {textArea.getText(),textArea_1.getText()};
			Boolean isSet = teacherBL.setCourseInfor(courseNoField.getText(),ID,courseInfor);
			if(isSet){
				new NoticePanel(new String[]{"课程信息已录入！"},null,TeacherFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
			}else{
				new NoticePanel(new String[]{"课程号输入错误！"},null,TeacherFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
			}
			TeacherFrame.remove(panelNow);
			panelNow=formerPanel;
			TeacherFrame.add(panelNow);
			TeacherFrame.repaint();
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
 			JLabel labelName = new JLabel();
 			
 			courseNoBox= new JComboBox<String>(teacherBL.getCourseNo(ID));
 			courseNoBox.setBounds(210,286,110,20);
 			courseNoBox.addItemListener(new CourseSelectedShow(labelName));
 			courseNoBox.setUI(new MyComboBoxUI());
 			Panel.add(courseNoBox);
 			courseNoBox.setVisible(true);
 			
 			String[][] note = teacherBL.checkStudents((String)courseNoBox.getItemAt(0));
 			String [] columnNames = {"课程号","学号","姓名","学院","学分绩","毕业资格","退学资格","成绩"};
  		  
 			studentTable = new MyTable(note,columnNames,TeacherFrame,544,250,false);
 			
 		    scrollPane= studentTable.getScrollPane();
 		    scrollPane.setBounds(37,10, 544, 250);
 		    scrollPane.setVisible(true);
 			Panel.add(scrollPane);
 			
 			JLabel label = new JLabel("课程号");
 			label.setFont(new Font("微软雅黑", Font.PLAIN, 16));
 			label.setBounds(120, 280, 100, 30);
 			Panel.add(label);
 			
 			JLabel label2 = new JLabel("课程名");
 			label2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
 			label2.setBounds(120, 330, 100, 30);
 			Panel.add(label2);
 			
 			labelName.setBounds(210,330,140,30);
 			labelName.setFont(new Font("微软雅黑", Font.PLAIN, 14));
 			labelName.setText(teacherBL.getCourseInfor((String)courseNoBox.getItemAt(0))[3]);
 			Panel.add(labelName);
 			
 			MyButton OkButton_3 = new MyButton("确定");
 			OkButton_3.setFont(new Font("微软雅黑", Font.PLAIN, 12));
 			OkButton_3.setBounds(380, 300, 100, 30);
 			OkButton_3.addActionListener(new CheckStudentOKButtonListener());
 			Panel.add(OkButton_3);
 			OkButton_3.setVisible(true);
 			
 			
			TeacherFrame.setLayout(null);
			panelNow=Panel;
			TeacherFrame.add(panelNow);
			TeacherFrame.repaint();
	    }
	    
	    class MyComboBoxUI extends BasicComboBoxUI {
	    	/**
	         * Paints the currently selected item.
	         */
	        @SuppressWarnings({ "rawtypes", "unchecked" })
			public void paintCurrentValue(Graphics g,Rectangle bounds,boolean hasFocus) {
	            ListCellRenderer renderer = comboBox.getRenderer();
	            Component c;

	            if ( hasFocus && !isPopupVisible(comboBox) ) {
	                c = renderer.getListCellRendererComponent( listBox,
	                                                           comboBox.getSelectedItem(),
	                                                           -1,
	                                                           true,
	                                                           false );
	            }
	            else {
	                c = renderer.getListCellRendererComponent( listBox,
	                                                           comboBox.getSelectedItem(),
	                                                           -1,
	                                                           false,
	                                                           false );
	                c.setBackground(UIManager.getColor("ComboBox.background"));
	            }
	            c.setFont(comboBox.getFont());
	            if ( hasFocus && !isPopupVisible(comboBox) ) {
	                c.setForeground(new Color(199,0,133));
	                c.setBackground(Color.WHITE);
	            }
	            else {
	                if ( comboBox.isEnabled() ) {
	                    c.setForeground(Color.BLACK);
	                    c.setBackground(Color.WHITE);
	                }
	                else {
	                    c.setForeground(DefaultLookup.getColor(
	                             comboBox, this, "ComboBox.disabledForeground", null));
	                    c.setBackground(DefaultLookup.getColor(
	                             comboBox, this, "ComboBox.disabledBackground", null));
	                }
	            }

	            // Fix for 4238829: should lay out the JPanel.
	            boolean shouldValidate = false;
	            if (c instanceof JPanel)  {
	                shouldValidate = true;
	            }

	            int x = bounds.x, y = bounds.y, w = bounds.width, h = bounds.height;
	            if (padding != null) {
	                x = bounds.x + padding.left;
	                y = bounds.y + padding.top;
	                w = bounds.width - (padding.left + padding.right);
	                h = bounds.height - (padding.top + padding.bottom);
	            }

	            currentValuePane.paintComponent(g,c,comboBox,x,y,w,h,shouldValidate);
	        }
	    
	    }
	    
	    class CourseSelectedShow implements ItemListener {
	    	JLabel label;
	    	
	    	public CourseSelectedShow(JLabel l) {
	    		super();
	    		label = l;
	    	}
	    	@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == ItemEvent.SELECTED) {
					label.setText(teacherBL.getCourseInfor((String) courseNoBox.getSelectedItem())[3]);
				}
			}
	    }
	    
	    class CheckStudentOKButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				panelNow.remove(scrollPane);
				String [] columnNames = {"课程号","学号","姓名","学院","学分绩","毕业资格","有无被退学","成绩"};
				studentTable = new MyTable(teacherBL.checkStudents( (String) courseNoBox.getSelectedItem(),ID),columnNames,TeacherFrame,544,250,false);
				
				scrollPane=studentTable.getScrollPane();
	 		    scrollPane.setBounds(37,10, 544, 250);
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
 			
 			courseNoBox= new JComboBox<String>(teacherBL.getCourseNo(ID));
 			courseNoBox.setBounds(80,280,70,30);
 			Panel.add(courseNoBox);
 			courseNoBox.setVisible(true);
	    	
 			String [] columnNames = {"课程号","学号","姓名","学院","学分绩","毕业资格","有无被退学","成绩"};
 			studentTable = new MyTable(teacherBL.checkStudents((String)courseNoBox.getItemAt(0)),columnNames,TeacherFrame,544,250,false);

 		    scrollPane=studentTable.getScrollPane();
 		    scrollPane.setBounds(37,10, 544, 250);
 		    scrollPane.setVisible(true);
 			Panel.add(scrollPane);
 			
 			JLabel label = new JLabel("课程号");
 			label.setFont(new Font("微软雅黑", Font.PLAIN, 16));
 			label.setBounds(10, 280, 70, 30);
 			Panel.add(label);
 			label.setVisible(true);
 			
 			JLabel label1 = new JLabel("学号");
 			label1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
 			label1.setBounds(160,280, 70, 30);
 			Panel.add(label1);
 			label1.setVisible(true);

 			JLabel label2 = new JLabel("分数");
 			label2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
 			label2.setBounds(310, 280, 70, 30);
 			Panel.add(label2);
 			label2.setVisible(true);
 			
 			studentNoField = new JTextField();
 			studentNoField.setBounds(230,280,70,30);
 			Panel.add(studentNoField);
 			studentNoField.setVisible(true);
 			
 			scoreField = new JTextField();
 			scoreField.setBounds(380,280,70,30);
 			Panel.add(scoreField);
 			scoreField.setVisible(true);
 			
 			MyButton OkButton_3 = new MyButton("确定");
 			OkButton_3.setFont(new Font("微软雅黑", Font.PLAIN, 12));
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
				    studentTable = new MyTable(tableData,columnNames,TeacherFrame,544,250,false);
				    
				    scrollPane=studentTable.getScrollPane();
	 		        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	 		        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	 		        scrollPane.setBounds(37,10, 544, 250);
	 		        scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
	 		        scrollPane.setVisible(true);
	 		        panelNow.add(scrollPane);
				    TeacherFrame.repaint();
	    		}else{
	    			new NoticePanel(new String[]{"学号输入错误！"},null,TeacherFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
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
	    	TeacherFrame.setTitle("学生——更改密码");
			JPanel Panel = new YPanel();
			Panel.setBounds(170, 70, 614, 400);
			Panel.setBackground(Color.white);
//			Panel.setBackground(new Color(255 ,255, 224 ));
//			Panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			Panel.setVisible(true);
 			Panel.setLayout(null);
 			
 			JLabel labelOld = new JLabel("旧密码");
			labelOld.setFont(new Font("微软雅黑", Font.PLAIN, 16));
 			labelOld.setBounds(0, 90, 210, 30);
 			labelOld.setForeground(new Color(199, 0, 133));
 			labelOld.setHorizontalAlignment(JLabel.RIGHT);
 			Panel.add(labelOld);
 			labelOld.setVisible(true);
 			
 			JLabel labelOld2 = new JLabel("新密码");
			labelOld2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
 			labelOld2.setBounds(0, 130, 210, 30);
 			labelOld2.setForeground(new Color(199, 0, 133));
 			labelOld2.setHorizontalAlignment(JLabel.RIGHT);
 			Panel.add(labelOld2);
 			labelOld2.setVisible(true);
 			
			JLabel label = new JLabel("（再次输入）新密码");
			label.setFont(new Font("微软雅黑", Font.PLAIN, 16));
 			label.setBounds(0, 170, 210, 30);
 			label.setForeground(new Color(199, 0, 133));
 			label.setHorizontalAlignment(JLabel.RIGHT);
 			Panel.add(label);
 			label.setVisible(true);
 			
 			
 			
 			newPasswordField = new JPasswordField();
 			newPasswordField.setBounds(230,170,200,30);
 			newPasswordField.setFont(new Font("微软雅黑", Font.PLAIN, 16));
 			newPasswordField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
 			newPasswordField.setOpaque(false);
 			Panel.add(newPasswordField);
 			newPasswordField.setVisible(true);

 			newPasswordField1 = new JPasswordField();
 			newPasswordField1.setBounds(230,130,200,30);
 			newPasswordField1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
 			newPasswordField1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
 			newPasswordField1.setOpaque(false);
 			Panel.add(newPasswordField1);
 			newPasswordField1.setVisible(true);
 			
 			newPasswordField2 = new JPasswordField();
 			newPasswordField2.setBounds(230,90,200,30);
 			newPasswordField2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
 			newPasswordField2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
 			newPasswordField2.setOpaque(false);
 			Panel.add(newPasswordField2);
 			newPasswordField2.setVisible(true);
 			
 			TeacherFrame.setLayout(null);
			panelNow=Panel;
			TeacherFrame.add(panelNow);
			TeacherFrame.repaint();
			
			MyButton OkButton = new MyButton("确定");
 			OkButton.setFont(new Font("微软雅黑", Font.PLAIN, 12));
 			OkButton.setBounds(460, 170, 70, 30);
 			OkButton.addActionListener(new changePasswordOkButtonListener());
 			Panel.add(OkButton);
 			OkButton.setVisible(true);
		}
		class changePasswordOkButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if (!newPasswordField2.getText().equals(password)) {
					// 原密码错误
					new NoticePanel(new String[]{"原来的密码错误！"},null,TeacherFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
					newPasswordField.setText("");
					newPasswordField1.setText("");
					newPasswordField2.setText("");
					return;
				}
				if (!newPasswordField.getText().equals(newPasswordField1.getText())) {
					// 两次密码不同
					new NoticePanel(new String[]{"两次密码不相同！"},null,TeacherFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
					newPasswordField.setText("");
					newPasswordField1.setText("");
					newPasswordField2.setText("");
					return;
				}
				if(!newPasswordField.getText().equals("") && !newPasswordField1.getText().equals("") && !newPasswordField2.getText().equals("")){
					teacherBL.changePassword(ID, newPasswordField.getText());
					new NoticePanel(new String[]{"密码已更新！"},null,TeacherFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
					newPasswordField.setText("");
					newPasswordField1.setText("");
					newPasswordField2.setText("");
				}else{
					new NoticePanel(new String[]{"密码不能为空！"},null,TeacherFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
					newPasswordField.setText("");
					newPasswordField1.setText("");
					newPasswordField2.setText("");
				}
			}
				
			}
    }
    
    //设置表格颜色并居中
    public static void makeFace(JTable table) {
    	table.getTableHeader().setReorderingAllowed(false);// 设置JTable每个字段的顺序不可以改变
    	   try {
    	    DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
				private static final long serialVersionUID = 1L;

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
