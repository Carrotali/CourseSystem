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
import java.util.ArrayList;
import java.util.Arrays;

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
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.table.DefaultTableCellRenderer;

import sun.swing.DefaultLookup;
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
//	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private MyButton btnNewButton;
	private MyButton btnNewButton_1;
	private MyButton btnNewButton_2;
	private MyButton btnNewButton_3;
	private MyButton btnNewButton_4;
	private MyButton btnNewButton_5;
	private MyButton btnNewButton_6;
//	private MyButton btnNewButton_7;
	private JPanel panelNow;
	private MyTable courseTable;
	private JTextField newPasswordField;
	private JTextField newPasswordField1;
	private JTextField newPasswordField2;
	private JScrollPane scrollPane;
	public static InstituteTeacherBLService instituteTeacherBL;
	private AdminBLService adminBLService;
    private String ID;
    private String password;
    MyTable studentTable;
    JComboBox<String> courseNoBox;
	
    //����main����
	public static void main(String[] args){
		new InstituteTeacherMainFrame("20001","111111",new InstituteTeacherBL(),new AdminBL());
	}
	
	/* 
	 * Ժϵ������ʦ�����湹�캯��
	 */
	@SuppressWarnings("static-access")
	public InstituteTeacherMainFrame(String ID,String password,InstituteTeacherBLService instituteTeacherBL,AdminBLService adminBLService) {
		this.instituteTeacherBL = instituteTeacherBL;
		this.adminBLService = adminBLService;
		this.ID = ID;
    	//this.password = password;
    	
		InstituteTeacherFrame = new JFrame();
		InstituteTeacherFrame.setSize(800,500);
		InstituteTeacherFrame.setLocation(300,100);
		InstituteTeacherFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("����Ա.jpg"));
		InstituteTeacherFrame.setTitle("Ժϵ��ʦ������");
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
		
		
		
		
		JLabel lblNewLabel = new JLabel("��ӭ" + instituteTeacherBL.getSelfInfor(ID)[3] + instituteTeacherBL.getSelfInfor(ID)[1] + "����Ա��");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(Color.white);
		lblNewLabel.setFont(new Font("�±�ֱ������ֿ�", Font.BOLD, 24));
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
		
		btnNewButton = new MyButton("�ƶ�ѧԺ��ѧ�ƻ�");
		btnNewButton.setFont(new Font("΢���ź�", Font.BOLD, 16));
		btnNewButton.setBounds(10, 25, 150, 35);
		btnNewButton.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton.setBackground(new Color(199, 0, 133 ));
		btnNewButton.setForeground(Color.white);
		btnNewButton.setVisible(true);
		btnNewButton.addActionListener(new MakeplanListener());
		panel_1.add(btnNewButton);
	
		
		btnNewButton_1 = new MyButton("�鿴��Ժ���пγ�");
		btnNewButton_1.setFont(new Font("΢���ź�", Font.BOLD, 16));
		btnNewButton_1.setBounds(10, 75, 150, 35);
		btnNewButton_1.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton_1.setBackground(new Color(199, 0, 133 ));
		btnNewButton_1.setForeground(Color.white);
		btnNewButton_1.addActionListener(new CheckAllCourseListener());
		panel_1.add(btnNewButton_1);
		btnNewButton_1.setVisible(true);
		
		btnNewButton_2 = new MyButton("�鿴��Ժѧ���б�");
		btnNewButton_2.setFont(new Font("΢���ź�", Font.BOLD, 16));
		btnNewButton_2.setBounds(10, 125, 150, 35);
		btnNewButton_2.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton_2.setBackground(new Color(199, 0, 133 ));
		btnNewButton_2.setForeground(Color.white);
		btnNewButton_2.setVisible(true);
		btnNewButton_2.addActionListener(new InputGradeListener());
		panel_1.add(btnNewButton_2);
		
		btnNewButton_3 = new MyButton("�Ǽ�ѧ���ɼ�");
		btnNewButton_3.setFont(new Font("΢���ź�", Font.BOLD, 16));
		btnNewButton_3.setBounds(10, 175, 150, 35);
		btnNewButton_3.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton_3.setBackground(new Color(199, 0, 133 ));
		btnNewButton_3.setForeground(Color.white);
		btnNewButton_3.addActionListener(new CheckStlistListener());
		panel_1.add(btnNewButton_3);
		btnNewButton_3.setVisible(true);
		
		btnNewButton_4 = new MyButton("�����γ�");
		btnNewButton_4.setFont(new Font("΢���ź�", Font.BOLD, 16));
		btnNewButton_4.setBounds(10, 225, 150, 35);
		btnNewButton_4.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton_4.setBackground(new Color(199, 0, 133 ));
		btnNewButton_4.setForeground(Color.white);
		btnNewButton_4.setVisible(true);
		btnNewButton_4.addActionListener(new PublishCourseListener());
		panel_1.add(btnNewButton_4);
		
//		btnNewButton_7 = new MyButton("����Ժ�γ�");
//		btnNewButton_7.setFont(new Font("΢���ź�", Font.BOLD, 16));
//		btnNewButton_7.setBounds(10, 275, 150, 35);
//		btnNewButton_7.setBorder(new LineBorder(new Color(199, 0, 133 )));
//		btnNewButton_7.setBackground(new Color(199, 0, 133 ));
//		btnNewButton_7.setForeground(Color.white);
//		btnNewButton_7.setVisible(true);
//		btnNewButton_7.addActionListener(new ManageCourseListener());
//		panel_1.add(btnNewButton_7);
		
		btnNewButton_5 = new MyButton("�޸�����");
		btnNewButton_5.setFont(new Font("΢���ź�", Font.BOLD, 16));
		btnNewButton_5.setBounds(10, 275, 150, 35);
		btnNewButton_5.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton_5.setBackground(new Color(199, 0, 133 ));
		btnNewButton_5.setForeground(Color.white);
		btnNewButton_5.setVisible(true);
		btnNewButton_5.addActionListener(new ChangePasswordListener());
		panel_1.add(btnNewButton_5);
		
		btnNewButton_6 = new MyButton("ע��");
		btnNewButton_6.setFont(new Font("΢���ź�", Font.BOLD, 16));
		btnNewButton_6.setBounds(10, 325, 150, 35);
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
	 * �����ѧ�ƻ��¼�����
	 */
	class MakeplanListener implements ActionListener{
	    public void actionPerformed(ActionEvent e){
	    	if(adminBLService.getAbleToChangePlan()){
	    		InstituteTeacherFrame.remove(panelNow);
		    	InstituteTeacherFrame.setTitle("Ժϵ������ʦ�����ƶ���ѧ�ƻ�");
				Panel = new JPanel();
				Panel.setSize(614, 400);
				Panel.setLocation(170, 70);
				Panel.setBackground(Color.white);
				Panel.setVisible(true);
	 			Panel.setLayout(null);
				
				JLabel lblNewLabel_1 = new JLabel("\u7B2C\u4E00\u5B66\u5E74\u6240\u9700\u5B66\u5206");
				lblNewLabel_1.setFont(new Font("΢���ź�", Font.BOLD, 14));
				lblNewLabel_1.setBounds(60, 90, 130, 30);
				lblNewLabel_1.setVisible(true);
				Panel.add(lblNewLabel_1);
				
				JLabel lblNewLabel_2 = new JLabel("\u7B2C\u4E8C\u5B66\u5E74\u6240\u9700\u5B66\u5206\r\n");
				lblNewLabel_2.setFont(new Font("΢���ź�", Font.BOLD, 14));
				lblNewLabel_2.setBounds(60, 135, 130, 30);
				lblNewLabel_2.setVisible(true);
				Panel.add(lblNewLabel_2);
				
				JLabel lblNewLabel_3 = new JLabel("\u7B2C\u4E09\u5B66\u5E74\u6240\u9700\u5B66\u5206");
				lblNewLabel_3.setFont(new Font("΢���ź�", Font.BOLD, 14));
				lblNewLabel_3.setBounds(60, 180, 130, 30);
				lblNewLabel_3.setVisible(true);
				Panel.add(lblNewLabel_3);
				
				JLabel lblNewLabel_4 = new JLabel("\u7B2C\u56DB\u5B66\u5E74\u6240\u9700\u5B66\u5206");
				lblNewLabel_4.setFont(new Font("΢���ź�", Font.BOLD, 14));
				lblNewLabel_4.setBounds(60, 225, 130, 30);
				lblNewLabel_4.setVisible(true);
				Panel.add(lblNewLabel_4);
				
				textField_3 = new JTextField();
				textField_3.setBounds(200, 95, 76, 21);
				textField_3.setColumns(10);
				textField_3.setVisible(true);
				Panel.add(textField_3);
				
				textField_4 = new JTextField();
				textField_4.setBounds(200, 140, 76, 21);
				Panel.add(textField_4);
				textField_4.setColumns(10);
				textField_4.setVisible(true);

				
				textField_5 = new JTextField();
				textField_5.setBounds(200, 185, 76, 21);
				textField_5.setColumns(10);
				textField_5.setVisible(true);
				Panel.add(textField_5);
				
				textField_6 = new JTextField();
				textField_6.setBounds(200, 230, 76, 21);
				textField_6.setColumns(10);
				textField_6.setVisible(true);
				Panel.add(textField_6);
				
				JLabel label_2 = new JLabel("\u51C6\u5165\u6240\u9700\u5B66\u5206");
				label_2.setFont(new Font("΢���ź�", Font.BOLD, 14));
				label_2.setBounds(329, 135, 130, 30);
				label_2.setVisible(true);
				Panel.add(label_2);
				
				JLabel lblNewLabel_5 = new JLabel("\u51C6\u51FA\u6240\u9700\u5B66\u5206\r\n");
				lblNewLabel_5.setFont(new Font("΢���ź�", Font.BOLD, 14));
				lblNewLabel_5.setBounds(329, 180, 130, 30);
				lblNewLabel_5.setVisible(true);
				Panel.add(lblNewLabel_5);
				
				textField_7 = new JTextField();
				textField_7.setBounds(430, 140, 76, 21);
				textField_7.setColumns(10);
				textField_7.setVisible(true);
				Panel.add(textField_7);

				textField_8 = new JTextField();
				textField_8.setBounds(430, 185, 76, 21);
				textField_8.setColumns(10);
				textField_8.setVisible(true);
				Panel.add(textField_8);
				
				MyButton button = new MyButton("\u786E\u5B9A");
				button.setFont(new Font("΢���ź�", Font.BOLD, 12));
				button.setBounds(267, 275, 70, 30);
				button.setVisible(true);
				button.addActionListener(new MakePlanOkListener());
				Panel.add(button);
				
				InstituteTeacherFrame.setLayout(null);
				panelNow = Panel;
				InstituteTeacherFrame.add(panelNow);
				InstituteTeacherFrame.repaint();
				
	    	}else{
	    		new NoticePanel(new String[]{"���ɸ��ģ�"},null,InstituteTeacherFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
	    	}
	    	
	    }
	    /*
	     * �����ѧ�ƻ�ȷ����ť�¼�����
	     */
	    class MakePlanOkListener implements ActionListener{
		    public void actionPerformed(ActionEvent e){
		    	if(textField_3.getText().equals("")||textField_4.getText().equals("")||textField_5.getText().equals("")||
		                  textField_6.getText().equals("")||textField_7.getText().equals("")||textField_8.getText().equals("")){
		    		new NoticePanel(new String[]{"����δ��д����Ϣ��"},null,InstituteTeacherFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());  		
		    	}else{
		    		Boolean isSet = instituteTeacherBL.makePlan(instituteTeacherBL.getSelfInfor(ID)[3]
		    			             ,textField_3.getText(),textField_4.getText(),textField_5.getText(),
		    			                  textField_6.getText(),textField_7.getText(),textField_8.getText());
		    	    if(isSet){
		    	    	new NoticePanel(new String[]{"�ƶ��ɹ���"},null,InstituteTeacherFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
		    	    }else{
		    	    	new NoticePanel(new String[]{"�ƶ�ʧ�ܣ�"},null,InstituteTeacherFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
		    	    }
		    	}	
		    }  	
	    }
    }
    
	/*
     *�鿴ȫУ�γ��¼����� 
     */
    class CheckAllCourseListener implements ActionListener{
    	JTextArea textArea = new JTextArea();
	    public void actionPerformed(ActionEvent e){
	    	InstituteTeacherFrame.remove(panelNow);
	    	InstituteTeacherFrame.setTitle("Ժϵ������ʦ�����鿴ѧԺ�γ�");
			Panel = new JPanel();
			Panel.setSize(614, 400);
			Panel.setLocation(170, 70);
			Panel.setBackground(Color.white);
			Panel.setVisible(true);
 			Panel.setLayout(null);
	    	
 			JLabel label = new JLabel("��ע��");
 			label.setFont(new Font("΢���ź�", Font.PLAIN, 14));
 			label.setBounds(37, 270, 100, 30);
 			Panel.add(label);
 			label.setVisible(true);
 			
 			JLabel label2 = new JLabel("˫�������Բ鿴������Ϣ��");
 			label2.setFont(new Font("΢���ź�", Font.PLAIN, 14));
 			label2.setHorizontalAlignment(JLabel.RIGHT);
 			label2.setForeground(new Color(199, 0, 133 ));
 			label2.setBounds(400, 270, 170, 30);
 			Panel.add(label2);
 			label2.setVisible(true);

			textArea = new JTextArea();
			textArea.setBounds(37,300,530,70);
			textArea.setLineWrap(true);
			textArea.setEditable(false);
			textArea.setFont(new Font("΢���ź�", Font.PLAIN, 14));
			textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
			Panel.add(textArea);
			textArea.setVisible(true);

 			String [] columnNames = {"�γ����","�γ̺�","�γ���","ѧ��","����ѧ��","ʱ��","����","��ʦ��������"};
  
  			
  			String[][]temp=instituteTeacherBL.checkColist(instituteTeacherBL.getSelfInfor(ID)[3]);
			for(int i=0;i<temp.length;i++)
				for(int j=2;j<8;j++){
					temp[i][j] = temp[i][j+1];
				}
			courseTable  = new MyTable(temp,columnNames,InstituteTeacherFrame,544,250,false);	
			courseTable.setComponent(textArea, 2);
  			
  		    scrollPane = courseTable.getScrollPane();
  		    scrollPane.setBounds(37,10, 544, 250);
  		    scrollPane.setVisible(true);
  			Panel.add(scrollPane);
			
			InstituteTeacherFrame.setLayout(null);
			panelNow = Panel;
			InstituteTeacherFrame.add(panelNow);
			InstituteTeacherFrame.repaint();
	    }
	    
	    /*
	     * �鿴Ժϵ�γ�ȷ����ť�¼�����
	     */
	    class CheckInstituteCourseOKButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				
				String[]temp=instituteTeacherBL.checkCoInfro((String)textField.getText());
				
				if(temp==null){
					new NoticePanel(new String[]{"�ÿγ̲����ڣ�"},null,InstituteTeacherFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
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

//    /*
//     * �鿴�γ���Ϣ�¼�����
//     */
//    class CheckCourseInferListener implements ActionListener{
//	    public void actionPerformed(ActionEvent e){
//	    	InstituteTeacherFrame.remove(panelNow);
//	    	InstituteTeacherFrame.setTitle("Ժϵ������ʦ�����鿴�γ���Ϣ");
//			Panel = new JPanel();
//			Panel.setSize(614, 400);
//			Panel.setLocation(170, 70);
//			Panel.setBackground(Color.white);
//			Panel.setVisible(true);
// 			Panel.setLayout(null);
// 			
// 			JLabel label = new JLabel("\u8F93\u5165\u8BFE\u7A0B\u53F7");
// 			label.setFont(new Font("΢���ź�", Font.BOLD, 15));
// 			label.setBounds(10, 10, 100, 30);
// 			label.setVisible(true);
//			Panel.add(label);
// 			
// 			textField_2 = new JTextField();
// 			textField_2.setBounds(150, 10, 100, 35);
// 			textField_2.setVisible(true);
//			Panel.add(textField_2);
//			textField_2.setColumns(10);
// 			
// 			MyButton button = new MyButton("\u786E\u5B9A");
// 			button.setFont(new Font("΢���ź�", Font.BOLD, 12));
// 			button.setBounds(335, 14, 93, 23);
// 			button.setVisible(true);
//			button.addActionListener(new CheckCoInfroOkListener());
//			Panel.add(button);
//			
//			InstituteTeacherFrame.setLayout(null);
//			panelNow=Panel;
//			InstituteTeacherFrame.add(panelNow);
//			InstituteTeacherFrame.repaint();
//	    }
//	    
//	    /*
//	     * �鿴�γ���Ϣȷ����ť�¼�����
//	     */
//	    class CheckCoInfroOkListener implements ActionListener{
//		    public void actionPerformed(ActionEvent e){
//		    	String[] findCourseInfro = instituteTeacherBL.checkCoInfro(textField_2.getText());
//		    	String[][] note = new String [1][11];
//
//		    	if(findCourseInfro == null){
//		    		new NoticePanel(new String[]{"�γ̺�δ����ߴ���"},null,InstituteTeacherFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
//		    	}else{
//		    		
//			    	for(int i=0;i < 11;i++){
//			    		note[0][i] = findCourseInfro[i];
//			    	}
//			    	
//		    		String [] columnNames = {"�γ����","�γ̺�","ѧԺ","�γ���","ѧ��","����ѧ��","ʱ��","����","��ʦ��������","�̲���","�ο���Ŀ"};
//		  			courseTable = new MyTable(note,columnNames,InstituteTeacherFrame,544,250,false);
//		  			
//		  		    scrollPane = courseTable.getScrollPane();
//		  		    scrollPane.setBounds(37,100, 544, 250);
//		  		    scrollPane.setVisible(true);
//		  			Panel.add(scrollPane);
//		    	}
//		    }
//		}
//    }
    
    // ¼��ɼ�
    class InputGradeListener implements ActionListener{
	    public void actionPerformed(ActionEvent e){
	    	InstituteTeacherFrame.remove(panelNow);
	    	InstituteTeacherFrame.setTitle("Ժϵ������ʦ�����鿴��Ժѧ����Ϣ");
			Panel = new JPanel();
			Panel.setSize(614, 400);
			Panel.setLocation(170, 70);
			Panel.setBackground(Color.white);
			Panel.setVisible(true);
 			Panel.setLayout(null);

 			JLabel labelName = new JLabel();
 			String[][] courses = instituteTeacherBL.checkColist(instituteTeacherBL.getSelfInfor(ID)[3]);
 			String[] courseNos = new String[courses.length];
 			for (int i = 0; i < courses.length; i++) {
 				courseNos[i] = courses[i][1];
 			}
 			courseNoBox= new JComboBox<String>(courseNos);
 			courseNoBox.setBounds(210,286,110,20);
 			courseNoBox.addItemListener(new CourseSelectedShow(labelName));
 			courseNoBox.setUI(new MyComboBoxUI());
 			Panel.add(courseNoBox);
 			courseNoBox.setVisible(true);
 			
 			String[][] note = instituteTeacherBL.checkStlist((String)courseNoBox.getItemAt(0));
 			String [] columnNames = {"ѧ��","����","�γ̺�","ѧԺ","ѧ�ּ�","��ҵ�ʸ�","��ѧ�ʸ�"};
  		  
 			studentTable = new MyTable(note,columnNames,InstituteTeacherFrame,544,250,false);
 			
 		    scrollPane= studentTable.getScrollPane();
 		    scrollPane.setBounds(37,10, 544, 250);
 		    scrollPane.setVisible(true);
 			Panel.add(scrollPane);
 			
 			JLabel label = new JLabel("�γ̺�");
 			label.setFont(new Font("΢���ź�", Font.PLAIN, 16));
 			label.setBounds(120, 280, 100, 30);
 			Panel.add(label);
 			
 			JLabel label2 = new JLabel("�γ���");
 			label2.setFont(new Font("΢���ź�", Font.PLAIN, 16));
 			label2.setBounds(120, 330, 100, 30);
 			Panel.add(label2);
 			
 			labelName.setBounds(210,330,140,30);
 			labelName.setFont(new Font("΢���ź�", Font.PLAIN, 14));
 			labelName.setText(instituteTeacherBL.checkCoInfro((String)courseNoBox.getItemAt(0))[3]);
 			Panel.add(labelName);
 			
 			MyButton OkButton_3 = new MyButton("ȷ��");
 			OkButton_3.setFont(new Font("΢���ź�", Font.PLAIN, 12));
 			OkButton_3.setBounds(380, 300, 100, 30);
 			OkButton_3.addActionListener(new CheckStudentOKButtonListener());
 			Panel.add(OkButton_3);
 			OkButton_3.setVisible(true);
			
			InstituteTeacherFrame.setLayout(null);
			panelNow=Panel;
			InstituteTeacherFrame.add(panelNow);
			InstituteTeacherFrame.repaint();
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
					label.setText(instituteTeacherBL.checkCoInfro((String) courseNoBox.getSelectedItem())[3]);
				}
			}
	    }
	    
	    /*
	     * �鿴ѧ���б�ȷ����ť
	     */
	    class CheckStudentOKButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				panelNow.remove(scrollPane);
	 			String [] columnNames = {"ѧ��","����","�γ̺�","ѧԺ","ѧ�ּ�","��ҵ�ʸ�","��ѧ�ʸ�"};
				studentTable = new MyTable(instituteTeacherBL.checkStlist((String) courseNoBox.getSelectedItem()),columnNames,InstituteTeacherFrame,544,250,false);
				
				scrollPane=studentTable.getScrollPane();
	 		    scrollPane.setBounds(37,10, 544, 250);
	 		    scrollPane.setVisible(true);
	 		    panelNow.add(scrollPane);
				InstituteTeacherFrame.repaint();
			}
	    	
	    }
    }
   
    /*
     * �鿴ѧ���б��¼�����
     */
    class CheckStlistListener implements ActionListener{
	    public void actionPerformed(ActionEvent e){
	    	InstituteTeacherFrame.remove(panelNow);
	    	InstituteTeacherFrame.setTitle("Ժϵ������ʦ�����鿴��Ժѧ����Ϣ");
			Panel = new JPanel();
			Panel.setSize(614, 400);
			Panel.setLocation(170, 70);
			Panel.setBackground(Color.white);
			Panel.setVisible(true);
 			Panel.setLayout(null);

 			JLabel labelName = new JLabel();
 			String[][] courses = instituteTeacherBL.checkColist(instituteTeacherBL.getSelfInfor(ID)[3]);
 			String[] courseNos = new String[courses.length];
 			for (int i = 0; i < courses.length; i++) {
 				courseNos[i] = courses[i][1];
 			}
 			courseNoBox= new JComboBox<String>(courseNos);
 			courseNoBox.setBounds(137,286,110,20);
 			courseNoBox.addItemListener(new CourseSelectedShow(labelName));
 			courseNoBox.setUI(new MyComboBoxUI());
 			Panel.add(courseNoBox);
 			courseNoBox.setVisible(true);
 			
 			String[][] note = instituteTeacherBL.checkStlist((String)courseNoBox.getItemAt(0));
 			String[][] newNote = new String[note.length][];
 			// ����ɼ�
 			if (note.length != 0) {
 				ArrayList<String> scores = instituteTeacherBL.getScoreList();
 				newNote = new String[note.length][note[0].length + 1];
 				for (int i = 0; i < note.length; i++) {
 					for (int j = 0; j < note[0].length; j++) {
 						newNote[i][j] = note[i][j];
 					}
 					// ���һ��
 					newNote[i][note[0].length] = newNote[i][3];
 					newNote[i][3] = getScore(note[i][2],note[i][0],scores);
 				}
 			}
 			String [] columnNames = {"ѧ��","����","�γ̺�","�ɼ�","ѧ�ּ�","��ҵ�ʸ�","��ѧ�ʸ�","ѧԺ"};
  		  
 			studentTable = new MyTable(newNote,columnNames,InstituteTeacherFrame,544,250,true);
 			
 		    scrollPane= studentTable.getScrollPane();
 		    scrollPane.setBounds(37,10, 544, 250);
 		    scrollPane.setVisible(true);
 			Panel.add(scrollPane);
 			
 			JLabel label = new JLabel("�γ̺�");
 			label.setFont(new Font("΢���ź�", Font.PLAIN, 16));
 			label.setBounds(37, 280, 100, 30);
 			Panel.add(label);
 			
 			JLabel label2 = new JLabel("�γ���");
 			label2.setFont(new Font("΢���ź�", Font.PLAIN, 16));
 			label2.setBounds(37, 330, 100, 30);
 			Panel.add(label2);
 			
 			labelName.setBounds(137,330,140,30);
 			labelName.setFont(new Font("΢���ź�", Font.PLAIN, 14));
 			labelName.setText(instituteTeacherBL.checkCoInfro((String)courseNoBox.getItemAt(0))[3]);
 			Panel.add(labelName);
 			
 			MyButton OkButton_3 = new MyButton("�鿴");
 			OkButton_3.setFont(new Font("΢���ź�", Font.PLAIN, 12));
 			OkButton_3.setBounds(250, 300, 100, 30);
 			OkButton_3.addActionListener(new CheckStudentOKButtonListener());
 			Panel.add(OkButton_3);
 			OkButton_3.setVisible(true);
 			
 			MyButton OkButton_4 = new MyButton("¼��ɼ�");
 			OkButton_4.setFont(new Font("΢���ź�", Font.PLAIN, 12));
 			OkButton_4.setBounds(464, 300, 100, 30);
 			OkButton_4.addActionListener(new ScoreOKButtonListener());
 			Panel.add(OkButton_4);
 			OkButton_4.setVisible(true);
			
			InstituteTeacherFrame.setLayout(null);
			panelNow=Panel;
			InstituteTeacherFrame.add(panelNow);
			InstituteTeacherFrame.repaint();
	    }
	    
	    // ��õ�ǰѧ���ÿγ̵ĵ÷�
	    private String getScore(String cid, String sid, ArrayList<String> scores) {
	    	for (String s : scores) {
	    		String[] temp = s.split(";");
	    		if (temp[0].equals(sid) && temp[1].equals(cid)) {
	    			// �ҵ���ѧ��
	    			return temp[2];
	    		}
	    	}
	    	return "0";
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
					label.setText(instituteTeacherBL.checkCoInfro((String) courseNoBox.getSelectedItem())[3]);
				}
			}
	    }
	    
	    /*
	     * �鿴ѧ���б�ȷ����ť
	     */
	    class CheckStudentOKButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				panelNow.remove(scrollPane);
	 			String [] columnNames = {"ѧ��","����","�γ̺�","�ɼ�","ѧ�ּ�","��ҵ�ʸ�","��ѧ�ʸ�","ѧԺ"};
	 			String[][] note = instituteTeacherBL.checkStlist((String) courseNoBox.getSelectedItem());
	 			String[][] newNote = new String[note.length][];
	 			// ����ɼ�
	 			if (note.length != 0) {
	 				ArrayList<String> scores = instituteTeacherBL.getScoreList();
	 				newNote = new String[note.length][note[0].length + 1];
	 				for (int i = 0; i < note.length; i++) {
	 					for (int j = 0; j < note[0].length; j++) {
	 						newNote[i][j] = note[i][j];
	 					}
	 					// ���һ��
	 					newNote[i][note[0].length] = newNote[i][3];
	 					newNote[i][3] = getScore(note[i][2],note[i][0],scores);
	 				}
	 			}
				studentTable = new MyTable(newNote,columnNames,InstituteTeacherFrame,544,250,true);
				
				scrollPane=studentTable.getScrollPane();
	 		    scrollPane.setBounds(37,10, 544, 250);
	 		    scrollPane.setVisible(true);
	 		    panelNow.add(scrollPane);
				InstituteTeacherFrame.repaint();
			}
	    }
	    
	    class ScoreOKButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				// ����ȫ��¼��
				for (int row = 0; row < studentTable.getRowCount(); row++) {
					String s = (String) studentTable.getModel().getValueAt(row, 3);
					String sid = (String) studentTable.getModel().getValueAt(row, 0);
					String cid = (String) studentTable.getModel().getValueAt(row, 2);
					instituteTeacherBL.publishScore(sid, cid, s);
				}
				new NoticePanel(new String[]{"¼��ɼ��ɹ���"},null,InstituteTeacherFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
				
				// �ٴ���ʾ����
				panelNow.remove(scrollPane);
	 			String [] columnNames = {"ѧ��","����","�γ̺�","�ɼ�","ѧ�ּ�","��ҵ�ʸ�","��ѧ�ʸ�","ѧԺ"};
	 			String[][] note = instituteTeacherBL.checkStlist((String) courseNoBox.getSelectedItem());
	 			String[][] newNote = new String[note.length][];
	 			// ����ɼ�
	 			if (note.length != 0) {
	 				ArrayList<String> scores = instituteTeacherBL.getScoreList();
	 				newNote = new String[note.length][note[0].length + 1];
	 				for (int i = 0; i < note.length; i++) {
	 					for (int j = 0; j < note[0].length; j++) {
	 						newNote[i][j] = note[i][j];
	 					}
	 					// ���һ��
	 					newNote[i][note[0].length] = newNote[i][3];
	 					newNote[i][3] = getScore(note[i][2],note[i][0],scores);
	 				}
	 			}
				studentTable = new MyTable(newNote,columnNames,InstituteTeacherFrame,544,250,true);
				
				scrollPane=studentTable.getScrollPane();
	 		    scrollPane.setBounds(37,10, 544, 250);
	 		    scrollPane.setVisible(true);
	 		    panelNow.add(scrollPane);
				InstituteTeacherFrame.repaint();
			}  	
	    }
    }
    
    /*
     * ����γ��¼�����
     */
    class ManageCourseListener implements ActionListener{
	    public void actionPerformed(ActionEvent e){
	    	InstituteTeacherFrame.remove(panelNow);
	    	InstituteTeacherFrame.setTitle("Ժϵ������ʦ��������γ���Ϣ");
			Panel = new JPanel();
			Panel.setSize(614, 400);
			Panel.setLocation(170, 70);
			Panel.setBackground(Color.white);
			Panel.setVisible(true);
 			Panel.setLayout(null);
	    	
			JLabel label = new JLabel("�γ̺�");
			label.setFont(new Font("΢���ź�", Font.BOLD, 15));
			label.setBounds(10, 10, 100, 30);
			Panel.add(label);
			
			JLabel label_1 = new JLabel("��ʦ����");
			label_1.setFont(new Font("΢���ź�", Font.BOLD, 15));
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
			
			MyButton button = new MyButton("\u786E\u5B9A");
			button.setFont(new Font("΢���ź�", Font.BOLD, 12));
			button.setBounds(339, 35, 93, 23);
			button.addActionListener(new ManageCourseOkListener());
			Panel.add(button);
			
			InstituteTeacherFrame.setLayout(null);
			panelNow=Panel;
			InstituteTeacherFrame.add(panelNow);
			InstituteTeacherFrame.repaint();
	    }
	    
	    /*
	     * ����γ�ȷ����ť�¼�����
	     */
	    class ManageCourseOkListener implements ActionListener{
		    public void actionPerformed(ActionEvent e){
				Boolean isSet = instituteTeacherBL.manageCourse(textField_1.getText(),textField.getText());
				if(isSet){
					new NoticePanel(new String[]{"����ɹ���"},null,InstituteTeacherFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
				}else{
					new NoticePanel(new String[]{"�γ̺š���ʦ����δ������"},null,InstituteTeacherFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
				}
		    }
		}
    }
    
    class ChangePasswordListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			InstituteTeacherFrame.remove(panelNow);
			InstituteTeacherFrame.setTitle("ѧ��������������");
			JPanel Panel = new YPanel();
			Panel.setBounds(170, 70, 614, 400);
			Panel.setBackground(Color.white);
//			Panel.setBackground(new Color(255 ,255, 224 ));
//			Panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			Panel.setVisible(true);
 			Panel.setLayout(null);
 			
 			JLabel labelOld = new JLabel("������");
			labelOld.setFont(new Font("΢���ź�", Font.PLAIN, 16));
 			labelOld.setBounds(0, 90, 210, 30);
 			labelOld.setForeground(new Color(199, 0, 133));
 			labelOld.setHorizontalAlignment(JLabel.RIGHT);
 			Panel.add(labelOld);
 			labelOld.setVisible(true);
 			
 			JLabel labelOld2 = new JLabel("������");
			labelOld2.setFont(new Font("΢���ź�", Font.PLAIN, 16));
 			labelOld2.setBounds(0, 130, 210, 30);
 			labelOld2.setForeground(new Color(199, 0, 133));
 			labelOld2.setHorizontalAlignment(JLabel.RIGHT);
 			Panel.add(labelOld2);
 			labelOld2.setVisible(true);
 			
			JLabel label = new JLabel("���ٴ����룩������");
			label.setFont(new Font("΢���ź�", Font.PLAIN, 16));
 			label.setBounds(0, 170, 210, 30);
 			label.setForeground(new Color(199, 0, 133));
 			label.setHorizontalAlignment(JLabel.RIGHT);
 			Panel.add(label);
 			label.setVisible(true);
 			
 			
 			
 			newPasswordField = new JPasswordField();
 			newPasswordField.setBounds(230,170,200,30);
 			newPasswordField.setFont(new Font("΢���ź�", Font.PLAIN, 16));
 			newPasswordField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
 			newPasswordField.setOpaque(false);
 			Panel.add(newPasswordField);
 			newPasswordField.setVisible(true);

 			newPasswordField1 = new JPasswordField();
 			newPasswordField1.setBounds(230,130,200,30);
 			newPasswordField1.setFont(new Font("΢���ź�", Font.PLAIN, 16));
 			newPasswordField1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
 			newPasswordField1.setOpaque(false);
 			Panel.add(newPasswordField1);
 			newPasswordField1.setVisible(true);
 			
 			newPasswordField2 = new JPasswordField();
 			newPasswordField2.setBounds(230,90,200,30);
 			newPasswordField2.setFont(new Font("΢���ź�", Font.PLAIN, 16));
 			newPasswordField2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
 			newPasswordField2.setOpaque(false);
 			Panel.add(newPasswordField2);
 			newPasswordField2.setVisible(true);
 			
 			InstituteTeacherFrame.setLayout(null);
			panelNow=Panel;
			InstituteTeacherFrame.add(panelNow);
			InstituteTeacherFrame.repaint();
			
			MyButton OkButton = new MyButton("ȷ��");
 			OkButton.setFont(new Font("΢���ź�", Font.PLAIN, 12));
 			OkButton.setBounds(460, 170, 70, 30);
 			OkButton.addActionListener(new changePasswordOkButtonListener());
 			Panel.add(OkButton);
 			OkButton.setVisible(true);
		}
		class changePasswordOkButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if (!newPasswordField2.getText().equals(password)) {
					// ԭ�������
					new NoticePanel(new String[]{"ԭ�����������"},null,InstituteTeacherFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
					newPasswordField.setText("");
					newPasswordField1.setText("");
					newPasswordField2.setText("");
					return;
				}
				if (!newPasswordField.getText().equals(newPasswordField1.getText())) {
					// �������벻ͬ
					new NoticePanel(new String[]{"�������벻��ͬ��"},null,InstituteTeacherFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
					newPasswordField.setText("");
					newPasswordField1.setText("");
					newPasswordField2.setText("");
					return;
				}
				if(!newPasswordField.getText().equals("") && !newPasswordField1.getText().equals("") && !newPasswordField2.getText().equals("")){
					instituteTeacherBL.changePassword(ID, newPasswordField.getText());
					new NoticePanel(new String[]{"�����Ѹ��£�"},null,InstituteTeacherFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
					newPasswordField.setText("");
					newPasswordField1.setText("");
					newPasswordField2.setText("");
				}else{
					new NoticePanel(new String[]{"���벻��Ϊ�գ�"},null,InstituteTeacherFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
					newPasswordField.setText("");
					newPasswordField1.setText("");
					newPasswordField2.setText("");
				}
			}
				
			}
    }
    
    
    /*
     * ע���¼�����
     */
    class LogoutListener implements ActionListener{
 		public void actionPerformed(ActionEvent e) {
 			InstituteTeacherFrame.dispose();
 			new LoginFrame(new LoginBL());
 		}
     }
    
    /*
     * �����γ��¼�����
     */
    class PublishCourseListener implements ActionListener{
	    public void actionPerformed(ActionEvent e){
	    	InstituteTeacherFrame.remove(panelNow);
			InstituteTeacherFrame.setTitle("Ժϵ������ʦ���������γ�");
			JPanel Panel = new JPanel();
			Panel.setSize(614, 400);
			Panel.setLocation(170, 70);
			Panel.setBackground(Color.LIGHT_GRAY);
			Panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			Panel.setBackground(Color.white);
			Panel.setVisible(true);
 			Panel.setLayout(null);
 			
 			JLabel label = new JLabel("\u8BFE\u7A0B\u53F7");
 			label.setFont(new Font("΢���ź�", Font.BOLD, 15));
 			label.setBounds(10, 10, 100, 35);
 			Panel.add(label);
 			label.setVisible(true);
 			
 			JLabel lblNewLabel_1 = new JLabel("\u8BFE\u7A0B\u540D");
 			lblNewLabel_1.setFont(new Font("΢���ź�", Font.BOLD, 15));
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
 			lblNewLabel_2.setFont(new Font("΢���ź�", Font.BOLD, 15));
 			lblNewLabel_2.setBounds(10, 100, 100, 35);
 			Panel.add(lblNewLabel_2);
 			lblNewLabel_2.setVisible(true);
 			
 			JLabel label_1 = new JLabel("\u8BFE\u7A0B\u5B66\u5206");
 			label_1.setFont(new Font("΢���ź�", Font.BOLD, 15));
 			label_1.setBounds(10, 145, 100, 35);
 			Panel.add(label_1);
 			label_1.setVisible(true);
 			
 			JLabel label_2 = new JLabel("\u5F00\u8BBE\u5B66\u671F");
 			label_2.setFont(new Font("΢���ź�", Font.BOLD, 15));
 			label_2.setBounds(10, 195, 100, 35);
 			Panel.add(label_2);
 			label_2.setVisible(true);
 			
 			JLabel lblNewLabel_3 = new JLabel("\u5F00\u8BBE\u5B66\u9662");
 			lblNewLabel_3.setFont(new Font("΢���ź�", Font.BOLD, 15));
 			lblNewLabel_3.setBounds(10, 240, 100, 35);
 			Panel.add(lblNewLabel_3);
 			lblNewLabel_3.setVisible(true);
 			
 			JLabel label_3 = new JLabel("\u4E0A\u8BFE\u65F6\u95F4");
 			label_3.setFont(new Font("΢���ź�", Font.BOLD, 15));
 			label_3.setBounds(10, 285, 100, 35);
 			Panel.add(label_3);
 			label_3.setVisible(true);
 			
 			JLabel label_4 = new JLabel("\u4E0A\u8BFE\u5730\u70B9");
 			label_4.setFont(new Font("΢���ź�", Font.BOLD, 15));
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
 			
 			MyButton button = new MyButton("\u786E\u5B9A");
 			button.setFont(new Font("΢���ź�", Font.BOLD, 12));
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
	     * �����γ�ȷ����ť�¼�����
	     */
	    class PublishCourseOkButtonListener implements ActionListener{
		    public void actionPerformed(ActionEvent e){
		    	boolean isExist = false;
		    	
		    	if(textField_10.getText().equals("")||textField_10.getText().equals("")||textField_11.getText().equals("")||textField_12.getText().equals("")||textField_13.getText().equals("")||textField_14.getText().equals("")||textField_15.getText().equals("")||textField_16.getText().equals("")||textField_17.getText().equals("")){
		    		new NoticePanel(new String[]{"����δ�����Ϣ��"},null,InstituteTeacherFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
				}else{
					isExist = instituteTeacherBL.PublishCourse(textField_10.getText(),textField_11.getText(),textField_12.getText(),textField_13.getText(),textField_14.getText(),textField_15.getText(),textField_16.getText(),textField_17.getText());
					if(isExist == true){
						new NoticePanel(new String[]{"�����ɹ���"},null,InstituteTeacherFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
				    }else {
				    	new NoticePanel(new String[]{"����ʧ�ܻ�γ��Ѿ����ڣ�"},null,InstituteTeacherFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
				    }				
				}  
		    }
	    }
   }   
    
    //���ñ����ɫ������
    public static void makeFace(JTable table) {
    	table.getTableHeader().setReorderingAllowed(false);// ����JTableÿ���ֶε�˳�򲻿��Ըı�
    	   try {
    	    DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
				private static final long serialVersionUID = 1L;

			public Component getTableCellRendererComponent(JTable table,
    	       Object value, boolean isSelected, boolean hasFocus,
    	       int row, int column) {
    	      if (row % 2 == 0)
    	       setBackground(Color.white); // ���������е�ɫ
    	      else if (row % 2 == 1)
    	       setBackground(new Color(206, 231, 255)); // ����ż���е�ɫ
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
