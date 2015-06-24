package frame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.table.TableColumn;

import sun.swing.DefaultLookup;
import busninesslogic.AdminBL;
import busninesslogic.AdminBLService;
import busninesslogic.LoginBL;
import busninesslogic.StudentBL;
import busninesslogic.StudentBLService;

public class StudentMainFrame /*extends JFrame*/{
	private JFrame StudentFrame;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JPanel panel_1;
	private JPanel panel_2;
	private MyButton btnNewButton;
	private MyButton btnNewButton_1;
	private MyButton btnNewButton_2;
	private MyButton btnNewButton_3;
	private MyButton btnNewButton_4;
	private MyButton btnNewButton_5;	
	private MyButton btnNewButton_6;	
	private MyButton btnNewButton_7;	
	private JPanel panelNow;
	private JTextArea textArea;
	private MyTable schoolCourseTable;
	private JScrollPane schoolCourseScrollPane;
	private MyTable myCourseTable;
	private JScrollPane myCourseScrollPane;
	private JTextField courseNoField;
	private JTextField newPasswordField;
	private JTextField newPasswordField1;
	private JTextField newPasswordField2;
	private JTextField field_8;
	private JTextField field_7;
	private JComboBox<String> comboBox;
	public static StudentBLService studentBL;
	private String ID;
	private String password;
	private AdminBLService adminBL;
	
	public static void main(String[] args) {
        new StudentMainFrame("121200002","111111",new StudentBL(),new AdminBL());
	}
	
	@SuppressWarnings("static-access")
	public StudentMainFrame(String ID,String password,StudentBLService studentBL,AdminBLService adminBL) {
		this.studentBL=studentBL;
		this.adminBL = adminBL;
		this.password = password;
		this.ID = ID;
		StudentFrame = new JFrame();
		StudentFrame.setSize(800,500);
		StudentFrame.setLocation(300,100);
		StudentFrame.setTitle("ѧ��������");
		StudentFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("ѧ��.jpg"));
		StudentFrame.getContentPane().setLayout(null);
		StudentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		StudentFrame.setVisible(true);
		
		//JumpPanel panel_3 = new JumpPanel(new String[]{"1","2","3"},new String[]{"name","family","call"},StudentFrame,null,false);
		//StudentFrame.getContentPane().add(panel_3);
		
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
		
		
		lblNewLabel = new JLabel("��ӭ"+studentBL.checkSelfInfor(ID)[3]+studentBL.checkSelfInfor(ID)[1]+"ͬѧ!");
		lblNewLabel.setForeground(Color.white);
		lblNewLabel.setFont(new Font("΢���ź�", Font.PLAIN, 24));
		lblNewLabel.setBounds(80, 10, 500, 45);
		panel.add(lblNewLabel);
		lblNewLabel.setVisible(true); 
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(199, 0, 133));
		panel_1.setForeground(Color.WHITE);
		panel_1.setBounds(0, 70, 170, 400);
		StudentFrame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(true);
		
		btnNewButton = new MyButton("�鿴ȫУ�γ�");
		btnNewButton.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		btnNewButton.setBounds(10, 10, 135, 35);
		btnNewButton.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton.setBackground(new Color(199, 0, 133 ));
		btnNewButton.setForeground(Color.white);
		btnNewButton.setVisible(true);
		btnNewButton.addActionListener(new CheckAllCourseListener());
		panel_1.add(btnNewButton);
		
		
		btnNewButton_1 = new MyButton("�鿴�ҵĿγ�");
		btnNewButton_1.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		btnNewButton_1.setBounds(10, 55, 135, 30);
		btnNewButton_1.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton_1.setBackground(new Color(199, 0, 133 ));
		btnNewButton_1.setForeground(Color.white);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new CheckMyCourseListener());
		btnNewButton_1.setVisible(true);
		
		btnNewButton_2 = new MyButton("�鿴������Ϣ");
		btnNewButton_2.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		btnNewButton_2.setBounds(10, 100, 135, 30);
		btnNewButton_2.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton_2.setBackground(new Color(199, 0, 133 ));
		btnNewButton_2.setForeground(Color.white);
		panel_1.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new CheckMyInfroListener());
		btnNewButton_2.setVisible(true);
	
		btnNewButton_3 = new MyButton("ѡ��γ�");
		btnNewButton_3.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		btnNewButton_3.setBounds(10, 145, 135, 30);
		btnNewButton_3.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton_3.setBackground(new Color(199, 0, 133 ));
		btnNewButton_3.setForeground(Color.white);
		panel_1.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ChooseCourseListener());
		btnNewButton_3.setVisible(true);
		
		btnNewButton_4 = new MyButton("��ѡ�γ�");
		btnNewButton_4.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		btnNewButton_4.setBounds(10, 190, 135, 30);
		btnNewButton_4.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton_4.setBackground(new Color(199, 0, 133 ));
		btnNewButton_4.setForeground(Color.white);
		panel_1.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new QuitCourseListener());
		btnNewButton_4.setVisible(true);
		
		btnNewButton_5 = new MyButton("��ѡ�γ�");
		btnNewButton_5.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		btnNewButton_5.setBounds(10, 235, 135, 30);
		btnNewButton_5.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton_5.setBackground(new Color(199, 0, 133 ));
		btnNewButton_5.setForeground(Color.white);
		panel_1.add(btnNewButton_5);
		btnNewButton_5.addActionListener(new RechooseCourseListener());
		btnNewButton_5.setVisible(true);
		
		btnNewButton_6 = new MyButton("�޸�����");
		btnNewButton_6.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		btnNewButton_6.setBounds(10, 280, 135, 30);
		btnNewButton_6.setBorder(new LineBorder(new Color(199, 0, 133 )));
		btnNewButton_6.setBackground(new Color(199, 0, 133 ));
		btnNewButton_6.setForeground(Color.white);
		panel_1.add(btnNewButton_6);
		btnNewButton_6.addActionListener(new ChangePasswordListener());
		btnNewButton_6.setVisible(true);
		
		btnNewButton_7 = new MyButton("ע��");
		btnNewButton_7.setFont(new Font("΢���ź�", Font.PLAIN, 16));
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
	    	StudentFrame.setTitle("ѧ�������鿴ȫУ�γ�");
			JPanel Panel = new JPanel();
			Panel.setBounds(170, 70, 614, 400);
			Panel.setBackground(Color.WHITE);
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

  			String[] columnTitle=new String[] {"���","���","Ժϵ","����","ѧ��","ѧ��","ʱ��","�ص�"};
  			
  			String[][]temp=studentBL.checkSchoolCourse();
  			schoolCourseTable = new MyTable(temp,columnTitle,StudentFrame,550,250,false);
  			schoolCourseTable.setComponent(textArea,0);
  		  
  			schoolCourseScrollPane = schoolCourseTable.getScrollPane();//�������������
  			schoolCourseScrollPane.setLocation(37,10);
  			schoolCourseScrollPane.setVisible(true);
			Panel.add(schoolCourseScrollPane);
		
			JLabel labelNotice = new JLabel("(�����˽�ʦ���̲ġ��ο���Ŀ��Ϣ)");
			labelNotice.setFont(new Font("΢���ź�", Font.PLAIN, 14));
			labelNotice.setHorizontalAlignment(JLabel.CENTER);
			labelNotice.setBounds(0,368,614,20);
			Panel.add(labelNotice);
			
			StudentFrame.setLayout(null);
			panelNow=Panel;
			StudentFrame.add(panelNow);
			
			StudentFrame.repaint();	
	    }
    } 

    class ChooseCourseListener implements ActionListener{
    	JScrollPane selectScrollPane;
    	JScrollPane selectScrollPane2;
    	int courseNum = 0;
	    public void actionPerformed(ActionEvent e){
	    	if(adminBL.getAbleToSelectCourse()){
	    		StudentFrame.remove(panelNow);
		    	StudentFrame.setTitle("ѧ������ѡ��");
				JPanel Panel = new JPanel();
				Panel.setBounds(170, 70, 614, 400);
				Panel.setBackground(Color.white);
//				Panel.setBackground(new Color(255 ,255, 224 ));
//				Panel.setBorder(new LineBorder(new Color(0, 0, 0)));
				Panel.setVisible(true);
	 			Panel.setLayout(null);
	 			
	 			JLabel label = new JLabel("��ѡ�γ�");
	 			label.setFont(new Font("΢���ź�", Font.PLAIN, 15));
	 			label.setBounds(37, 10, 100, 30);
	 			Panel.add(label);
	 			label.setVisible(true);
	 			
	 			JLabel label2 = new JLabel("��ѡ�γ�");
	 			label2.setFont(new Font("΢���ź�", Font.PLAIN, 15));
	 			label2.setBounds(37, 200, 100, 30);
	 			Panel.add(label2);
	 			label2.setVisible(true);
	 			
	 			JLabel label3 = new JLabel("��������");
	 			label3.setFont(new Font("΢���ź�", Font.PLAIN, 15));
	 			label3.setBounds(300, 210, 100, 30);
	 			Panel.add(label3);
	 			label3.setVisible(true);
	 			
	 			JLabel label4 = new JLabel("1.ѡ���������ó���4��");
	 			label4.setFont(new Font("΢���ź�", Font.PLAIN, 15));
	 			label4.setBounds(300, 240, 200, 30);
	 			Panel.add(label4);
	 			label4.setVisible(true);
	 			
	 			JLabel label5 = new JLabel("2.ѡ�β���ֱѡʽ���ȵ��ȵ�");
	 			label5.setFont(new Font("΢���ź�", Font.PLAIN, 15));
	 			label5.setBounds(300, 270, 250, 30);
	 			Panel.add(label5);
	 			label5.setVisible(true);
	 			
	 			//"�γ����","�γ̱��","����Ժϵ","�γ�����","ѧ��","����ѧ��","�Ͽ�ʱ��","�Ͽεص�","�ο���ʦ","�̲�","�ο���Ŀ"
	 			String [] columnNames = {"�γ����","���","����Ժϵ","�γ�����","ѧ��","�Ͽ�ʱ��","�Ͽεص�"};
	 			
	 			String[][]temp = studentBL.showSelectList();
	 			for(int i=0;i<temp.length;i++){
	 			for(int j=5;j<7;j++){
	 				temp[i][j] = temp[i][j+1];				
	 			}
	 			}
	 			MyTable selectTable = new MyTable(temp,columnNames,StudentFrame,544,150,false);
	 			
	 		    selectScrollPane=selectTable.getScrollPane();
	 		    selectScrollPane.setBounds(37,40, 544, 150);
	 		    selectScrollPane.setVisible(true);
	 			Panel.add(selectScrollPane);
	 		
	 			//�õ���ѡ�γ�
	 			temp = studentBL.showScore(ID);
	 			int j=0;
	 			int k=-1;
	 			for(int i = 0 ; i < temp.length ; i++){ 				
	 				if(temp[i][0].equals("ͨʶͨ�޿γ�")||temp[i][0].equals("��רҵ�γ�")){
	 					j++;		
	 				}
	 			}
	 			courseNum = j ;
	 			String[][] courses = new String[j][];		
	 			for(int i = 0 ; i < temp.length ; i++){				
	 				if(temp[i][0].equals("ͨʶͨ�޿γ�")||temp[i][0].equals("��רҵ�γ�")){
	 					k++;
	 					courses[k] = temp[i];
	 				}				
	 			}
	 
	 			String [] columnTitle = {"�γ����","���"};
	 			selectTable = new MyTable(courses,columnTitle,StudentFrame,200,90,false);

	 			selectScrollPane2= selectTable.getScrollPane();
	 		    selectScrollPane2.setBounds(37,230, 200, 90);
	 		    selectScrollPane2.setVisible(true);
	 			Panel.add(selectScrollPane2);
	 			
				JLabel lblNewLabel_1 = new JLabel("ѡ�ογ̺�");
				lblNewLabel_1.setFont(new Font("΢���ź�", Font.PLAIN, 15));
				lblNewLabel_1.setBounds(37, 330, 100, 30);
				Panel.add(lblNewLabel_1);
				lblNewLabel_1.setVisible(true);
				
				courseNoField = new JTextField();
				courseNoField.setBounds(140, 330, 100, 30);
				Panel.add(courseNoField);
				courseNoField.setColumns(10);
				courseNoField.setVisible(true);
				
				MyButton btnNewButton_6 = new MyButton("ȷ��");
				btnNewButton_6.setFont(new Font("΢���ź�", Font.PLAIN, 12));
				btnNewButton_6.addActionListener(new OkButtonListener());
				btnNewButton_6.setBounds(400, 330, 90, 30);
				Panel.add(btnNewButton_6);
				btnNewButton_6.setVisible(true);

				StudentFrame.setLayout(null);
				panelNow=Panel;
				StudentFrame.add(panelNow);
				StudentFrame.repaint();
	    	}else{
	    		new NoticePanel(new String[]{"ѡ����δ��ʼ��"},null,StudentFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
	    	}
	    	
	    }
	    class OkButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if(courseNoField.getText().equals("")){
					new NoticePanel(new String[]{"�γ̺Ų���Ϊ�գ�"},null,StudentFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
				}else{
					if(courseNum==4){
						new NoticePanel(new String[]{"��ѡ��Ŀγ���������"},null,StudentFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
					}
					else if(studentBL.selectCourse(ID, courseNoField.getText())){
						new NoticePanel(new String[]{"ѡ�γɹ���"},null,StudentFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
						panelNow.remove(selectScrollPane2);
						//�õ���ѡ�γ�
			 			String[][] temp = studentBL.showScore(ID);
			 			int j=0;
			 			int k=-1;
			 			for(int i = 0 ; i < temp.length ; i++){ 				
			 				if(temp[i][0].equals("ͨʶͨ�޿γ�")||temp[i][0].equals("��רҵ�γ�")){
			 					j++;		
			 				}
			 			}
			 			courseNum = j ;
			 			String[][] courses = new String[j][];		
			 			for(int i = 0 ; i < temp.length ; i++){				
			 				if(temp[i][0].equals("ͨʶͨ�޿γ�")||temp[i][0].equals("��רҵ�γ�")){
			 					k++;
			 					courses[k] = temp[i];
			 				}				
			 			}
			 
			 			String [] columnTitle = {"�γ����","���"};
			 			MyTable selectTable = new MyTable(courses,columnTitle,StudentFrame,200,90,false);
					     
			 			selectScrollPane2=selectTable.getScrollPane();
			 		    selectScrollPane2.setBounds(37,230, 200, 90);
			 		    selectScrollPane2.setVisible(true);
			 			panelNow.add(selectScrollPane2);
			 			StudentFrame.repaint();
						
					}else{
						new NoticePanel(new String[]{"�γ̺����벻��ȷ���֤������ѡ�ÿΣ�"},null,StudentFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
					}
				}
			}
	    }
    }
    
    class CheckMyCourseListener implements ActionListener{
	    public void actionPerformed(ActionEvent e){
	    	StudentFrame.remove(panelNow);
	    	StudentFrame.setTitle("ѧ�������鿴���˿γ�");
			JPanel Panel = new JPanel();
			Panel.setBounds(170, 70, 614, 400);
			Panel.setBackground(Color.white);
//			Panel.setBackground(new Color(255 ,255, 224 ));
//			Panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			Panel.setVisible(true);
 			Panel.setLayout(null);
    		
 			JLabel label = new JLabel("�ҵĿγ�");
 			label.setFont(new Font("΢���ź�", Font.PLAIN, 15));
 			label.setBounds(37, 10, 100, 30);
 			Panel.add(label);
 			label.setVisible(true);
 			
 			String [] columnNames = {"�γ����","�γ̱��","����Ժϵ","�γ�����","ѧ��","����ѧ��","�Ͽ�ʱ��","�Ͽεص�","�ɼ�"};
 			String[][]temp = studentBL.showScore(ID);
 			for(int i=0;i<temp.length;i++)
 				temp[i][8] = temp[i][11];
 			myCourseTable = new MyTable(temp,columnNames,StudentFrame,544,300,false);	
 			
 		    myCourseScrollPane=myCourseTable.getScrollPane();
 		    myCourseScrollPane.setBounds(37,50, 544, 300);
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
	    	StudentFrame.setTitle("ѧ�������鿴������Ϣ");
			JPanel Panel = new JPanel();
			Panel.setBounds(170, 70, 614, 400);
			Panel.setBackground(Color.white);
//			Panel.setBackground(new Color(255 ,255, 224 ));
//			Panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			Panel.setVisible(true);
 			Panel.setLayout(null);
    		
 			String [] infor = studentBL.checkSelfInfor(ID);
 			
 			JLabel label = new JLabel("ѧ��");
 			label.setFont(new Font("΢���ź�", Font.PLAIN, 15));
 			label.setForeground(new Color(199,0,133));
 			label.setHorizontalAlignment(JLabel.CENTER);
 			label.setBounds(50, 80, 50, 30);
 			Panel.add(label);
 			label.setVisible(true);
 			
 			JTextField field = new JTextField(infor[0]);
 			field.setBounds(100,81,100,30);
 			field.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
 			field.setBackground(Color.WHITE);
 			field.setFont(new Font("΢���ź�", Font.PLAIN, 13));
 			field.setHorizontalAlignment(JTextField.CENTER);
 			Panel.add(field);
 			field.setEditable(false);
 			field.setVisible(true);
 			
 			JLabel label_1 = new JLabel("����");
 			label_1.setFont(new Font("΢���ź�", Font.PLAIN, 15));
 			label_1.setForeground(new Color(199,0,133));
 			label_1.setHorizontalAlignment(JLabel.CENTER);
 			label_1.setBounds(210, 80, 50, 30);
 			Panel.add(label_1);
 			label_1.setVisible(true);
 			
 			JTextField field_1 = new JTextField(infor[1]);
 			field_1.setBounds(260,81,100,30);
 			field_1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
 			field_1.setBackground(Color.WHITE);
 			field_1.setFont(new Font("΢���ź�", Font.PLAIN, 13));
 			field_1.setHorizontalAlignment(JTextField.CENTER);
 			Panel.add(field_1);
 			field_1.setEditable(false);
 			field_1.setVisible(true);
 			
 			JLabel label_2 = new JLabel("��ѧ���");
 			label_2.setFont(new Font("΢���ź�", Font.PLAIN, 15));
 			label_2.setForeground(new Color(199,0,133));
 			label_2.setHorizontalAlignment(JLabel.CENTER);
 			label_2.setBounds(380, 80, 70, 30);
 			Panel.add(label_2);
 			label_2.setVisible(true);
 			
 			JTextField field_2 = new JTextField(infor[6]);
 			field_2.setBounds(450,81,100,30);
 			field_2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
 			field_2.setBackground(Color.WHITE);
 			field_2.setFont(new Font("΢���ź�", Font.PLAIN, 13));
 			field_2.setHorizontalAlignment(JTextField.CENTER);
 			Panel.add(field_2);
 			field_2.setEditable(false);
 			field_2.setVisible(true);
 			
 			JLabel label_3 = new JLabel("ѧԺ");
 			label_3.setFont(new Font("΢���ź�", Font.PLAIN, 15));
 			label_3.setForeground(new Color(199,0,133));
 			label_3.setHorizontalAlignment(JLabel.CENTER);
 			label_3.setBounds(50, 120, 50, 30);
 			Panel.add(label_3);
 			label_3.setVisible(true);
 			
 			JTextField field_3 = new JTextField(infor[3]);
 			field_3.setBounds(100,121,100,30);
 			field_3.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
 			field_3.setBackground(Color.WHITE);
 			field_3.setFont(new Font("΢���ź�", Font.PLAIN, 13));
 			field_3.setHorizontalAlignment(JTextField.CENTER);
 			Panel.add(field_3);
 			field_3.setEditable(false);
 			field_3.setVisible(true);
 			
 			JLabel label_4 = new JLabel("ѧ�ּ�");
 			label_4.setFont(new Font("΢���ź�", Font.PLAIN, 15));
 			label_4.setForeground(new Color(199,0,133));
 			label_4.setHorizontalAlignment(JLabel.CENTER);
 			label_4.setBounds(210, 120, 50, 30);
 			Panel.add(label_4);
 			label_4.setVisible(true);
 			
 			JTextField field_4 = new JTextField(infor[4]);
 			field_4.setBounds(260,121,100,30);
 			field_4.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
 			field_4.setBackground(Color.WHITE);
 			field_4.setFont(new Font("΢���ź�", Font.PLAIN, 13));
 			field_4.setHorizontalAlignment(JTextField.CENTER);
 			Panel.add(field_4);
 			field_4.setEditable(false);
 			field_4.setVisible(true);
 			
 			JLabel label_5 = new JLabel("��ҵ�ʸ�");
 			label_5.setFont(new Font("΢���ź�", Font.PLAIN, 15));
 			label_5.setForeground(new Color(199,0,133));
 			label_5.setHorizontalAlignment(JLabel.CENTER);
 			label_5.setBounds(380, 120, 70, 30);
 			Panel.add(label_5);
 			label_5.setVisible(true);
 			
 			JTextField field_5 = new JTextField(infor[5]);
 			field_5.setBounds(450,121,100,30);
 			field_5.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
 			field_5.setBackground(Color.WHITE);
 			field_5.setFont(new Font("΢���ź�", Font.PLAIN, 13));
 			field_5.setHorizontalAlignment(JTextField.CENTER);
 			Panel.add(field_5);
 			field_5.setEditable(false);
 			field_5.setVisible(true);
 			
 			JLabel label_6 = new JLabel("׼��׼����ѯѧԺ");
 			label_6.setFont(new Font("΢���ź�", Font.PLAIN, 15));
 			label_6.setHorizontalAlignment(JLabel.RIGHT);
 			label_6.setBounds(0, 190, 200, 30);
 			Panel.add(label_6);
 			label_6.setVisible(true);
 			
 			String [] instituteName = {"���ѧԺ","��ѧԺ","������ѧѧԺ","�����뺣���ѧѧԺ","��ʷѧԺ","��ѧϵ"
 					                       ,"��ѧϵ","����ϵ","��ѧϵ","��������ѧԺ","ҽѧԺ","����"};
 			comboBox = new JComboBox<String>(instituteName);
 			comboBox.setBounds(230,190,100,30);
 			comboBox.setUI(new MyComboBoxUI());
 			comboBox.setFont(new Font("΢���ź�", Font.PLAIN, 15));
 			Panel.add(comboBox);
 			comboBox.setVisible(true);
 			
 			MyButton OkButton = new MyButton("ȷ��");
 			OkButton.setFont(new Font("΢���ź�", Font.PLAIN, 15));
 			OkButton.setBounds(410, 290, 80, 30);
 			OkButton.addActionListener(new CheckIOOKButtonListener());
 			Panel.add(OkButton);
 			OkButton.setVisible(true);
 			
 			JLabel label_7 = new JLabel("׼��ѧ��");
 			label_7.setForeground(new Color(199,0,133));
 			label_7.setFont(new Font("΢���ź�", Font.PLAIN, 15));
 			label_7.setHorizontalAlignment(JLabel.RIGHT);
 			label_7.setBounds(0, 240, 200, 30);
 			Panel.add(label_7);
 			label_7.setVisible(true);
 			
 			field_7 = new JTextField();
 			field_7.setBounds(230,240,150,30);
 			field_7.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
 			field_7.setBackground(Color.WHITE);
 			field_7.setFont(new Font("΢���ź�", Font.PLAIN, 13));
 			field_7.setHorizontalAlignment(JTextField.CENTER);
 			Panel.add(field_7);
 			field_7.setEditable(false);
 			field_7.setVisible(true);
 			
 			JLabel label_8 = new JLabel("׼��ѧ��");
 			label_8.setForeground(new Color(199,0,133));
 			label_8.setFont(new Font("΢���ź�", Font.PLAIN, 15));
 			label_8.setHorizontalAlignment(JLabel.RIGHT);
 			label_8.setBounds(0, 290, 200, 30);
 			Panel.add(label_8);
 			label_8.setVisible(true);
 			
 			field_8 = new JTextField();
 			field_8.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
 			field_8.setBackground(Color.WHITE);
 			field_8.setFont(new Font("΢���ź�", Font.PLAIN, 13));
 			field_8.setHorizontalAlignment(JTextField.CENTER);
 			field_8.setBounds(230,290,150,30);
 			Panel.add(field_8);
 			field_8.setEditable(false);
 			field_8.setVisible(true);
 			
			StudentFrame.setLayout(null);
			panelNow=Panel;
			StudentFrame.add(panelNow);
			StudentFrame.repaint();
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
	    
	    class  CheckIOOKButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				panelNow.remove(field_7);
				panelNow.remove(field_8);
				field_7 =  new JTextField(studentBL.getInScore((String) comboBox.getSelectedItem()));
				field_7.setBounds(230,240,150,30);
	 			field_7.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
	 			field_7.setBackground(Color.WHITE);
	 			field_7.setFont(new Font("΢���ź�", Font.PLAIN, 13));
	 			field_7.setHorizontalAlignment(JTextField.CENTER);
	 			panelNow.add(field_7);
	 			field_7.setEditable(false);
	 			field_7.setVisible(true);
	 			
	 			field_8 = new JTextField(studentBL.getOutScore((String) comboBox.getSelectedItem()));
	 			field_8.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
	 			field_8.setBackground(Color.WHITE);
	 			field_8.setFont(new Font("΢���ź�", Font.PLAIN, 13));
	 			field_8.setHorizontalAlignment(JTextField.CENTER);
	 			field_8.setBounds(230,290,150,30);
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
		    	StudentFrame.setTitle("ѧ�������˿�");
				JPanel Panel = new JPanel();
				Panel.setBounds(170, 70, 614, 400);
				Panel.setBackground(Color.white);
//				Panel.setBackground(new Color(255 ,255, 224 ));
//				Panel.setBorder(new LineBorder(new Color(0, 0, 0)));
				Panel.setVisible(true);
	 			Panel.setLayout(null);
		    	
	 			JLabel label = new JLabel("��ѡ�γ�");
	 			label.setFont(new Font("΢���ź�", Font.PLAIN, 15));
	 			label.setBounds(37, 10, 100, 30);
	 			Panel.add(label);
	 			label.setVisible(true);
	 			
	           String [] columnNames = {"�γ����","���","����Ժϵ","�γ�����","ѧ��","�Ͽ�ʱ��","�Ͽεص�"};
	 			
	           String[][] temp = studentBL.checkMyCourse(ID);
	 			int j=0;
	 			int k=-1;
	 			for(int i = 0 ; i < temp.length ; i++){ 				
	 				if(temp[i][0].equals("ͨʶͨ�޿γ�")||temp[i][0].equals("��רҵ�γ�")){
	 					j++;		
	 				}
	 			}
	 	//		courseNum = j ;
	 			String[][] courses = new String[j][];		
	 			for(int i = 0 ; i < temp.length ; i++){				
	 				if(temp[i][0].equals("ͨʶͨ�޿γ�")||temp[i][0].equals("��רҵ�γ�")){
	 					k++;
	 					courses[k] = temp[i];
	 				}				
	 			}
	 
	 			MyTable selectTable = new MyTable(courses,columnNames,StudentFrame,544,270,false);
	    
	 			myCourseScrollPane = selectTable.getScrollPane();
	 			myCourseScrollPane.setBounds(37,40, 544, 270);
	 			myCourseScrollPane.setVisible(true);
	 			Panel.add(myCourseScrollPane);
	 			
				JLabel lblNewLabel_1 = new JLabel("ѡ�ογ̺�");
				lblNewLabel_1.setFont(new Font("΢���ź�", Font.PLAIN, 15));
				lblNewLabel_1.setBounds(30, 320, 100, 30);
				lblNewLabel_1.setHorizontalAlignment(JLabel.RIGHT);
				Panel.add(lblNewLabel_1);
				lblNewLabel_1.setVisible(true);
				
				courseNoField = new JTextField();
				courseNoField.setBounds(160, 320, 100, 30);
				Panel.add(courseNoField);
				courseNoField.setColumns(10);
				courseNoField.setVisible(true);
				
				MyButton btnNewButton_6 = new MyButton("ȷ��");
				btnNewButton_6.setFont(new Font("΢���ź�", Font.PLAIN, 12));
				btnNewButton_6.addActionListener(new OkButtonListener());
				btnNewButton_6.setBounds(440, 320, 90, 30);
				Panel.add(btnNewButton_6);
				btnNewButton_6.setVisible(true);

				StudentFrame.setLayout(null);
				panelNow=Panel;
				StudentFrame.add(panelNow);
				StudentFrame.repaint();
	    	}else{
	    		new NoticePanel(new String[]{"�����˿Σ�"},null,StudentFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
	    	}
	    	
	    }
	    class OkButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if(courseNoField.getText().equals("")){
					new NoticePanel(new String[]{"�γ̺Ų���Ϊ�գ�"},null,StudentFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
				}else{
					if(studentBL.quitCourse(ID, courseNoField.getText())){
						new NoticePanel(new String[]{"��ѡ�ɹ���"},null,StudentFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
						
						panelNow.remove(myCourseScrollPane);
						
						 String [] columnNames = {"�γ����","���","����Ժϵ","�γ�����","ѧ��","�Ͽ�ʱ��","�Ͽεص�"};
				 			
				           String[][] temp = studentBL.checkMyCourse(ID);
				 			int j=0;
				 			int k=-1;
				 			for(int i = 0 ; i < temp.length ; i++){ 				
				 				if(temp[i][0].equals("ͨʶͨ�޿γ�")||temp[i][0].equals("��רҵ�γ�")){
				 					j++;		
				 				}
				 			}
				 	//		courseNum = j ;
				 			String[][] courses = new String[j][];		
				 			for(int i = 0 ; i < temp.length ; i++){				
				 				if(temp[i][0].equals("ͨʶͨ�޿γ�")||temp[i][0].equals("��רҵ�γ�")){
				 					k++;
				 					courses[k] = temp[i];
				 				}				
				 			}
				 
			 			MyTable selectTable = new MyTable(courses,columnNames,StudentFrame,544,250,false);
			 		    
			 			myCourseScrollPane = selectTable.getScrollPane();
			 			myCourseScrollPane.setBounds(37,40, 544, 250);
			 			myCourseScrollPane.setVisible(true);
			 			panelNow.add(myCourseScrollPane);
			 			StudentFrame.repaint();
						
					}else{
						new NoticePanel(new String[]{"�γ̺����벻��ȷ���֤������ѡ�ÿΣ�"},null,StudentFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
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
		    	StudentFrame.setTitle("ѧ��������ѡ�γ�");
				JPanel Panel = new JPanel();
				Panel.setBounds(170, 70, 614, 400);
				Panel.setBackground(Color.white);
//				Panel.setBackground(new Color(255 ,255, 224 ));
//				Panel.setBorder(new LineBorder(new Color(0, 0, 0)));
				Panel.setVisible(true);
	 			Panel.setLayout(null);
		    	
	 			JLabel label = new JLabel("��ѡ�γ�");
	 			label.setFont(new Font("΢���ź�", Font.PLAIN, 15));
	 			label.setBounds(10, 10, 100, 30);
	 			Panel.add(label);
	 			label.setVisible(true);
	 			
	 			JLabel label2 = new JLabel("��ѡ�γ�");
	 			label2.setFont(new Font("΢���ź�", Font.PLAIN, 15));
	 			label2.setBounds(10, 200, 100, 30);
	 			Panel.add(label2);
	 			label2.setVisible(true);
	 			
	 			JLabel label3 = new JLabel("��������");
	 			label3.setFont(new Font("΢���ź�", Font.PLAIN, 15));
	 			label3.setBounds(300, 210, 100, 30);
	 			Panel.add(label3);
	 			label3.setVisible(true);
	 			
	 			JLabel label4 = new JLabel("1.ѡ���������ó���4��");
	 			label4.setFont(new Font("΢���ź�", Font.PLAIN, 15));
	 			label4.setBounds(300, 240, 200, 30);
	 			Panel.add(label4);
	 			label4.setVisible(true);
	 			
	 			JLabel label5 = new JLabel("2.ѡ�β���ֱѡʽ���ȵ��ȵ�");
	 			label5.setFont(new Font("΢���ź�", Font.PLAIN, 15));
	 			label5.setBounds(300, 270, 250, 30);
	 			Panel.add(label5);
	 			label5.setVisible(true);
	 			
	 			//"�γ����","�γ̱��","����Ժϵ","�γ�����","ѧ��","����ѧ��","�Ͽ�ʱ��","�Ͽεص�","�ο���ʦ","�̲�","�ο���Ŀ"
	 			String [] columnNames = {"�γ����","���","����Ժϵ","�γ�����","ѧ��","�Ͽ�ʱ��","�Ͽεص�"};
	 			
	 			String[][]temp = studentBL.showSelectList();
	 			for(int i=0;i<temp.length;i++){
	 			for(int j=5;j<7;j++){
	 				temp[i][j] = temp[i][j+1];				
	 			}
	 			}
	 			JTable selectTable = new JTable(temp,columnNames);
	 			makeFace(selectTable);
	 			TableColumn column = selectTable .getColumnModel().getColumn(0);
	 	  	      column.setPreferredWidth(105);//�����п�ĺ���
	 	  	      column = selectTable .getColumnModel().getColumn(1);
	 		      column.setPreferredWidth(50);//�����п�ĺ���
	 		      column = selectTable .getColumnModel().getColumn(2);
	 	  	      column.setPreferredWidth(107);//�����п�ĺ���
	 	  	      column = selectTable .getColumnModel().getColumn(3);
	 		      column.setPreferredWidth(130);//�����п�ĺ���
	 		      column = selectTable .getColumnModel().getColumn(4);
	 	  	      column.setPreferredWidth(35);//�����п�ĺ���
	 	  	      column = selectTable .getColumnModel().getColumn(5);
	 		      column.setPreferredWidth(100);//�����п�ĺ���
	 		      column = selectTable .getColumnModel().getColumn(6);
			      column.setPreferredWidth(100);//�����п�ĺ���
	 		     
	 	  	      
	 			
	 		    selectScrollPane=new JScrollPane(selectTable);
	 		    selectScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	 		    selectScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	 		    selectScrollPane.setBounds(37,40, 544, 150);
	 		    selectScrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
	 		    selectScrollPane.setVisible(true);
	 			Panel.add(selectScrollPane);
	 		
	 			//�õ���ѡ�γ�
	 			temp = studentBL.showScore(ID);
	 			int j=0;
	 			int k=-1;
	 			for(int i = 0 ; i < temp.length ; i++){ 				
	 				if(temp[i][0].equals("ͨʶͨ�޿γ�")||temp[i][0].equals("��רҵ�γ�")){
	 					j++;		
	 				}
	 			}
	 			courseNum = j ;
	 			String[][] courses = new String[j][];		
	 			for(int i = 0 ; i < temp.length ; i++){				
	 				if(temp[i][0].equals("ͨʶͨ�޿γ�")||temp[i][0].equals("��רҵ�γ�")){
	 					k++;
	 					courses[k] = temp[i];
	 				}				
	 			}
	 
	 			String [] columnTitle = {"�γ����","���"};
	 			selectTable = new JTable(courses,columnTitle);
	 			makeFace(selectTable);
	 			column= selectTable .getColumnModel().getColumn(0);
		  	     column.setPreferredWidth(105);//�����п�ĺ���
		  	     column = selectTable .getColumnModel().getColumn(1);
			     column.setPreferredWidth(50);//�����п�ĺ���
			     
	 			selectScrollPane2=new JScrollPane(selectTable);
	 		    selectScrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	 		    selectScrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	 		    selectScrollPane2.setBounds(37,230, 200, 90);
	 		    selectScrollPane2.setBorder(new LineBorder(new Color(0, 0, 0)));
	 		    selectScrollPane2.setVisible(true);
	 			Panel.add(selectScrollPane2);
	 			
				JLabel lblNewLabel_1 = new JLabel("ѡ�ογ̺�");
				lblNewLabel_1.setFont(new Font("΢���ź�", Font.PLAIN, 15));
				lblNewLabel_1.setBounds(10, 330, 100, 30);
				Panel.add(lblNewLabel_1);
				lblNewLabel_1.setVisible(true);
				
				courseNoField = new JTextField();
				courseNoField.setBounds(140, 330, 100, 30);
				Panel.add(courseNoField);
				courseNoField.setColumns(10);
				courseNoField.setVisible(true);
				
				MyButton btnNewButton_6 = new MyButton("ȷ��");
				btnNewButton_6.setFont(new Font("΢���ź�", Font.PLAIN, 12));
				btnNewButton_6.addActionListener(new OkButtonListener());
				btnNewButton_6.setBounds(400, 330, 90, 30);
				Panel.add(btnNewButton_6);
				btnNewButton_6.setVisible(true);

				StudentFrame.setLayout(null);
				panelNow=Panel;
				StudentFrame.add(panelNow);
				StudentFrame.repaint();
	    	}else{
	    		new NoticePanel(new String[]{"��ѡ��δ��ʼ��"},null,StudentFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
	    	}
	    	
	    }
	    class OkButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if(courseNoField.getText().equals("")){
					new NoticePanel(new String[]{"�γ̺Ų���Ϊ�գ�"},null,StudentFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
				}else{
					if(courseNum==4){
						new NoticePanel(new String[]{"��ѡ��Ŀγ���������"},null,StudentFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
					}
					else if(studentBL.selectCourse(ID, courseNoField.getText())){
						new NoticePanel(new String[]{"ѡ�γɹ���"},null,StudentFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
						
						panelNow.remove(selectScrollPane2);
						//�õ���ѡ�γ�
			 			String[][] temp = studentBL.showScore(ID);
			 			int j=0;
			 			int k=-1;
			 			for(int i = 0 ; i < temp.length ; i++){ 				
			 				if(temp[i][0].equals("ͨʶͨ�޿γ�")||temp[i][0].equals("��רҵ�γ�")){
			 					j++;		
			 				}
			 			}
			 			courseNum = j ;
			 			String[][] courses = new String[j][];		
			 			for(int i = 0 ; i < temp.length ; i++){				
			 				if(temp[i][0].equals("ͨʶͨ�޿γ�")||temp[i][0].equals("��רҵ�γ�")){
			 					k++;
			 					courses[k] = temp[i];
			 				}				
			 			}
			 
			 			String [] columnTitle = {"�γ����","���"};
			 			JTable selectTable = new JTable(courses,columnTitle);
			 			makeFace(selectTable);
			 			TableColumn column = selectTable .getColumnModel().getColumn(0);
				  	     column.setPreferredWidth(105);//�����п�ĺ���
				  	     column = selectTable .getColumnModel().getColumn(1);
					     column.setPreferredWidth(50);//�����п�ĺ���
					     
			 			selectScrollPane2=new JScrollPane(selectTable);
			 		    selectScrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			 		    selectScrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			 		    selectScrollPane2.setBounds(37,230, 200, 90);
			 		    selectScrollPane2.setBorder(new LineBorder(new Color(0, 0, 0)));
			 		    selectScrollPane2.setVisible(true);
			 			panelNow.add(selectScrollPane2);
			 			StudentFrame.repaint();
						
					}else{
						new NoticePanel(new String[]{"�γ̺����벻��ȷ���֤������ѡ�ÿΣ�"},null,StudentFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
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
	    	StudentFrame.setTitle("ѧ��������������");
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
 			
 			StudentFrame.setLayout(null);
			panelNow=Panel;
			StudentFrame.add(panelNow);
			StudentFrame.repaint();
			
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
					new NoticePanel(new String[]{"ԭ�����������"},null,StudentFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
					newPasswordField.setText("");
					newPasswordField1.setText("");
					newPasswordField2.setText("");
					return;
				}
				if (!newPasswordField.getText().equals(newPasswordField1.getText())) {
					// �������벻ͬ
					new NoticePanel(new String[]{"���������벻��ͬ��"},null,StudentFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
					newPasswordField.setText("");
					newPasswordField1.setText("");
					newPasswordField2.setText("");
					return;
				}
				if(!newPasswordField.getText().equals("") && !newPasswordField1.getText().equals("") && !newPasswordField2.getText().equals("")){
					studentBL.changePassword(ID, newPasswordField.getText());
					new NoticePanel(new String[]{"�����Ѹ��£�"},null,StudentFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
					newPasswordField.setText("");
					newPasswordField1.setText("");
					newPasswordField2.setText("");
				}else{
					new NoticePanel(new String[]{"���벻��Ϊ�գ�"},null,StudentFrame,panelNow,panelNow.getWidth(),panelNow.getHeight());
					newPasswordField.setText("");
					newPasswordField1.setText("");
					newPasswordField2.setText("");
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
